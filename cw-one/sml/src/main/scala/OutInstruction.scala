package sml

/**
  * This class outputs the content of a given register
  *
  * @author Ross Anthony [http://github.com/rossanthony]
  */
class OutInstruction(label: String, op: String, register: Int) extends Instruction(label, op) {

  override def execute(m: Machine) {
    println(m.regs(register))
  }

  override def toString(): String =
    super.toString + s" outputting contents of r$register\n"
}

object OutInstruction {
  def apply(label: String, register: Int) =
    new OutInstruction(label, "out", register)
}