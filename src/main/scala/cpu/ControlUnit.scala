package cpu

import chisel3._
import chisel3.util._
import _root_.circt.stage.ChiselStage

class ControlUnit extends Module {
  val io = IO(new Bundle {
    val i_inst = Input(UInt(32.W))
    val i_zero = Input(Bool())

    val o_pc_src = Input(Bool())
    val o_result_src = Input(Bool())
    val o_mem_write = Input(Bool())
    val o_alu_src = Input(Bool())
    val o_imm_src = Input(UInt(2.W))
    val o_reg_write = Input(Bool())

    val o_alu_control = Input(UInt(3.W))
  })

  // add,sub,and,or,lw,sw,beq
  val op = Wire(UInt(7.W))
  op := io.i_inst(6, 0)

  val branch = Wire(Bool())
  val alu_op = Wire(UInt(2.W))
  switch(op) {
    is("0b0110011".U) {
      // R-type instruction (add, sub, etc.)
      branch := false.B
      io.o_result_src := false.B
      io.o_mem_write := false.B
      io.o_alu_src := false.B
      io.o_reg_write := true.B
      alu_op := "0b10".U
    }
    is("0b0000011".U) {
      // I-type instruction (lw, lb, etc.)
      branch := false.B
      io.o_result_src := true.B
      io.o_mem_write := false.B
      io.o_alu_src := true.B
      io.o_imm_src := 0.U
      io.o_reg_write := true.B
      alu_op := "0b00".U
    }
    is("0b0100011".U) {
      // S-type instruction (sw, sb, etc.)
      branch := false.B
      io.o_mem_write := true.B
      io.o_alu_src := true.B
      io.o_imm_src := 1.U
      io.o_reg_write := false.B
      alu_op := "0b00".U
    }
    is("0b1100011".U) {
      // B-type instruction (beq, bge, etc.)
      branch := true.B
      io.o_mem_write := false.B
      io.o_alu_src := false.B
      io.o_imm_src := 3.U
      io.o_reg_write := false.B
      alu_op := "0b01".U
    }
  }

  // ALU decoding
  val funct3 = Wire(UInt(3.W))
  val funct7 = Wire(UInt(7.W))

  funct3 := io.i_inst(14, 12)
  funct7 := io.i_inst(31, 25)

  val r_alu_op = Wire(UInt(3.W))
  val weird_imm = Wire(
    UInt(2.W)
  ) // todo: pg.18 of chp. 7, dont understand this part
  weird_imm := Cat(op(5), funct7(5))

  when(funct3 === "0b0".U && weird_imm < 3.U) {
    r_alu_op := 0.U // add
  }.elsewhen(funct3 === "0b0".U && weird_imm === 3.U) {
    r_alu_op := 1.U // sub
  }.elsewhen(funct3 === "0b10".U) {
    r_alu_op := 5.U // slt
  }.elsewhen(funct3 === "0b110".U) {
    r_alu_op := 3.U // or
  }.elsewhen(funct3 === "0b111".U) {
    r_alu_op := 2.U // and
  }

  switch(alu_op) {
    is("0b00".U) {
      // add for finding addresses of loads and stores
      io.o_alu_control := "0b000".U
    }
    is("0b01".U) {
      // subtract to compare numbers for branches
      io.o_alu_control := "0b001".U
    }
    is("0b10".U) {
      // R-type alu instruction
      io.o_alu_control := r_alu_op
    }
  }
}
