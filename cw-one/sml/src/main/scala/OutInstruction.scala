package sml

/**
  * This class outputs the content of a given register
  *
  * @author Ross Anthony [http://github.com/rossanthony]
  */
class OutInstruction(label: String, op: String, r: Int) extends Instruction(label, op) {

  override def execute(m: Machine) {
    println(m.regs(r))
  }

  override def toString(): String =
    super.toString + " " + r + "\n"
}

object OutInstruction {
  def apply(label: String, register: Int) =
    new OutInstruction(label, "out", register)
}