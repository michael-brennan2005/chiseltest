package counter

import chisel3.simulator.scalatest.ChiselSim
import org.scalatest.funsuite.AnyFunSuite
import chisel3.fromStringToLiteral
import chisel3._

class SevenSegControllerTest extends AnyFunSuite with ChiselSim {
  test("7Seg controller - general case") {
    simulate(new SevenSegController(50)) { dut =>
      dut.io.digits(0).poke("b0010011".U)
      dut.io.digits(1).poke("b1000001".U)
      dut.io.digits(2).poke("b1010101".U)
      dut.io.digits(3).poke("b1111111".U)

      dut.io.en.poke(1)
      for (i <- 0 until 50) {
        dut.io.seg.expect("b0010011".U)
        dut.io.an.expect("b1110".U)
        dut.io.dp.expect(1)
        dut.clock.step(50)

        dut.io.seg.expect("b1000001".U)
        dut.io.an.expect("b1101".U)
        dut.io.dp.expect(1)
        dut.clock.step(50)

        dut.io.seg.expect("b1010101".U)
        dut.io.an.expect("b1011".U)
        dut.io.dp.expect(1)
        dut.clock.step(50)

        dut.io.seg.expect("b1111111".U)
        dut.io.an.expect("b0111".U)
        dut.io.dp.expect(1)
        dut.clock.step(50)
      }
    }
  }
}
