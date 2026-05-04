# ============================================================================
# Vivado Non-Project Mode: Full Build & Program Script
# Flow: Synthesis -> Implementation -> Bitstream -> Program FPGA
# ============================================================================

# ----------------------------------------------------------------------------
# USER CONFIGURATION - Edit these variables for your project
# ----------------------------------------------------------------------------

# Directory containing your SystemVerilog source files (.sv)
set SRC_DIR         "../build/sv"

# Path to your board constraint file (.xdc)
set CONSTRAINTS     "./constraints.xdc"

# Target FPGA part (e.g., xc7a35tcpg236-1 for Arty A7-35, xc7a100tcsg324-1 for Nexys A7)
set FPGA_PART       "xc7a35tcpg236-1"

# Top module name (must match the name of your top-level SystemVerilog module)
set TOP_MODULE      "Top"

# Output directory for build artifacts (bitstream, reports, checkpoints)
set OUTPUT_DIR      "../build/vivado"

# ----------------------------------------------------------------------------
# SETUP
# ----------------------------------------------------------------------------

puts "============================================================"
puts " Vivado Automated Build & Program Script"
puts "============================================================"
puts " Source directory : $SRC_DIR"
puts " Constraints file : $CONSTRAINTS"
puts " FPGA part        : $FPGA_PART"
puts " Top module       : $TOP_MODULE"
puts " Output directory : $OUTPUT_DIR"
puts "============================================================"

# Create output directory if it doesn't exist
file mkdir $OUTPUT_DIR

# Create an in-memory project (no .xpr file generated)
puts "\n\[INFO\] Creating in-memory project..."
create_project -in_memory -part $FPGA_PART

# ----------------------------------------------------------------------------
# READ SOURCE FILES
# ----------------------------------------------------------------------------

puts "\n\[INFO\] Reading SystemVerilog source files from $SRC_DIR..."
set sv_files [glob -nocomplain -directory $SRC_DIR "*.sv"]

if {[llength $sv_files] == 0} {
    puts "\[ERROR\] No SystemVerilog files found in $SRC_DIR!"
    exit 1
}

foreach f $sv_files {
    puts "   -> $f"
    read_verilog -sv $f
}

puts "\[INFO\] Reading constraints file: $CONSTRAINTS"
if {![file exists $CONSTRAINTS]} {
    puts "\[ERROR\] Constraints file not found: $CONSTRAINTS"
    exit 1
}
read_xdc $CONSTRAINTS

# ----------------------------------------------------------------------------
# SYNTHESIS
# ----------------------------------------------------------------------------

puts "\n============================================================"
puts " STEP 1/4: Running Synthesis..."
puts "============================================================"
synth_design -top $TOP_MODULE -part $FPGA_PART
write_checkpoint -force $OUTPUT_DIR/post_synth.dcp
report_utilization -file $OUTPUT_DIR/post_synth_util.rpt
puts "\[INFO\] Synthesis complete. Checkpoint: $OUTPUT_DIR/post_synth.dcp"

# ----------------------------------------------------------------------------
# IMPLEMENTATION (Opt -> Place -> Route)
# ----------------------------------------------------------------------------

puts "\n============================================================"
puts " STEP 2/4: Running Implementation..."
puts "============================================================"

puts "\[INFO\] Optimizing design..."
opt_design

puts "\[INFO\] Placing design..."
place_design

puts "\[INFO\] Routing design..."
route_design

write_checkpoint -force $OUTPUT_DIR/post_route.dcp
report_timing_summary -file $OUTPUT_DIR/post_route_timing.rpt
report_utilization -file $OUTPUT_DIR/post_route_util.rpt
puts "\[INFO\] Implementation complete. Checkpoint: $OUTPUT_DIR/post_route.dcp"

# Check for timing violations
set wns [get_property SLACK [get_timing_paths -max_paths 1 -nworst 1 -setup]]
if {$wns < 0} {
    puts "\[WARNING\] Timing NOT met! Worst Negative Slack: $wns ns"
} else {
    puts "\[INFO\] Timing met. Worst Negative Slack: $wns ns"
}

# ----------------------------------------------------------------------------
# BITSTREAM GENERATION
# ----------------------------------------------------------------------------

puts "\n============================================================"
puts " STEP 3/4: Generating Bitstream..."
puts "============================================================"
set BITSTREAM "$OUTPUT_DIR/$TOP_MODULE.bit"
write_bitstream -force $BITSTREAM
puts "\[INFO\] Bitstream generated: $BITSTREAM"

# ----------------------------------------------------------------------------
# PROGRAM FPGA DEVICE
# ----------------------------------------------------------------------------

puts "\n============================================================"
puts " STEP 4/4: Programming FPGA..."
puts "============================================================"

puts "\[INFO\] Opening hardware manager and connecting to hw_server..."
open_hw_manager
connect_hw_server -allow_non_jtag

puts "\[INFO\] Searching for hardware targets..."
open_hw_target

# Get the first device on the JTAG chain
set hw_device [lindex [get_hw_devices] 0]
if {$hw_device eq ""} {
    puts "\[ERROR\] No hardware device found. Check JTAG connection and power."
    close_hw_manager
    exit 1
}
puts "\[INFO\] Found device: [get_property NAME $hw_device]"

current_hw_device $hw_device
refresh_hw_device -update_hw_probes false $hw_device

# Associate bitstream with the device and program
puts "\[INFO\] Uploading bitstream to device..."
set_property PROGRAM.FILE $BITSTREAM $hw_device
program_hw_devices $hw_device
refresh_hw_device $hw_device

puts "\[INFO\] Programming complete!"

# Cleanup
close_hw_target
disconnect_hw_server
close_hw_manager

puts "\n============================================================"
puts " BUILD & PROGRAM SUCCESSFUL"
puts "============================================================"
puts " Bitstream : $BITSTREAM"
puts " Reports   : $OUTPUT_DIR/*.rpt"
puts "============================================================"
