package sml

/**
  * This class calculates the square root of the value held in op1 and saves it into the given register (result)
  *
  * @author Ross Anthony [http://github.com/rossanthony]
  */

class SqrInstruction(label: String, op: String, val result: Int, val op1: Int)
  extends Instruction(label, op) {

  override def execute(m: Machine) {
    val value1 = m.regs(op1)
    m.regs(result) = math.ceil(scala.math.sqrt(value1)).toInt
  }

  override def toString(): String = {
    super.toString + s" √ of r$op1 -> r$result\n"
  }
}

object SqrInstruction {
  def apply(label: String, result: Int, op1: Int) =
    new SqrInstruction(label, "sqr", result, op1)
}