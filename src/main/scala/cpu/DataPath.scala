package cpu

import chisel3._
import _root_.circt.stage.ChiselStage
import chisel3.util._

class DataPath extends Module {
  val io = IO(new Bundle {
    val i_reg_write = Input(Bool())
    val i_alu_conrol = Input(UInt(3.W))
    val i_alu_src = Input(Bool())
    val i_result_src = Input(Bool())
    val i_mem_write = Input(Bool())
    val i_imm_src = Input(UInt(2.W))
    val i_pc_src = Input(Bool())
  })

  val pc = Module(new ProgramCounter)
  val inst_memory = Module(new InstructionMemory)
  val data_memory = Module(new DataMemory)
  val register_file = Module(new RegisterFile)
  val alu = Module(new Alu)

  val pc_next = Wire(UInt(32.W))
  switch(io.i_pc_src) {
    is(true.B) { // For branching
      pc_next := pc.io.o_pc + imm_ext
    }
    is(false.B) {
      pc_next := pc.io.o_pc + 4.U
    }
  }
  pc.io.i_pc_next := pc_next

  inst_memory.io.i_addr := pc.io.o_pc

  data_memory.io.i_addr := alu.io.o_result
  data_memory.io.i_wd := register_file.io.o_rd_2
  data_memory.io.i_we := io.i_mem_write

  register_file.io.i_ra_1 := inst_memory.io.o_rd(19, 15)
  register_file.io.i_ra_2 := inst_memory.io.o_rd(24, 20)
  register_file.io.i_wa := inst_memory.io.o_rd(11, 7)

  val result_src = Wire(UInt(32.W))
  result_src := Mux(
    io.i_result_src,
    data_memory.io.o_rd,
    alu.io.o_result
  )

  register_file.io.i_wd := result_src

  alu.io.i_src_a := register_file.io.o_rd_1

  // Selecting between immediate operand
  val imm_ext = Wire(UInt(32.W))
  switch(io.i_imm_src) {
    is("0b00".U) { // I-type instruction
      imm_ext := inst_memory.io.o_rd(31, 20).asSInt
    }
    is("0b11".U) { // S-type instruction
      imm_ext := Cat(
        inst_memory.io.o_rd(31, 25),
        inst_memory.io.o_rd(11, 7)
      ).asSInt
    }
    is("0b10".U) { // B-type instruction
      imm_ext := Cat(
        inst_memory.io.o_rd(31),
        inst_memory.io.o_rd(7),
        inst_memory.io.o_rd(30, 25),
        inst_memory.io.o_rd(11, 8)
      )
    }
  }

  // Selecting between immediate or register as 2nd alu operand
  val alu_src = Wire(UInt(32.W))
  switch(alu_src) {
    is("0b0".U) {
      alu_src := register_file.io.o_rd_2
    }
    is("0b1".U) {
      alu_src := imm_ext
    }
  }

  alu.io.i_src_b := alu_src
}
