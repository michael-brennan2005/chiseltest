package counter

import chisel3.simulator.scalatest.ChiselSim
import org.scalatest.funsuite.AnyFunSuite
import chisel3.fromStringToLiteral
import chisel3._

class DoubleDabbleTest extends AnyFunSuite with ChiselSim {
  def bcdHelper(n: Int): Seq[Int] = {
    if (n <= 0) {
      Seq(0)
    } else {
      n.toString.map(_.asDigit).toList
    }
  }

  def bcdTestCase(
      input: Int
  ) = {
    simulate(new DoubleDabble) { dut =>
      dut.io.start.poke(0)
      dut.clock.step(1)

      dut.io.in.poke(input)
      dut.io.start.poke(1)

      dut.clock.step(100)

      val expected = bcdHelper(input).reduce((acc, d) => (acc << 4) | d)
      val observed = (0 until 5)
        .map(i => dut.io.out(i).peek().litValue)
        .reverse
        .reduce((acc, d) => (acc << 4) | d)
      assert(observed == expected)
    }
  }

  test("Double dabble - convert 0 works") {
    bcdTestCase(0)
  }

  test("Double dabble - convert 8 works") {
    bcdTestCase(8)
  }
  test("Double dabble - convert 12 works") {
    bcdTestCase(12)
  }

  test("Double dabble - convert 456 works") {
    bcdTestCase(456)
  }

  test("Double dabble - convert 7890 works") {
    bcdTestCase(7890)
  }
}
