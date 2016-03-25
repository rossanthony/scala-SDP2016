package sml

/**
  * This class outputs the content of a given register
  *
  * @author Ross Anthony [http://github.com/rossanthony]
  */
class OutInstruction(label: String, op: String, register: Int) extends Instruction(label, op) {

  var fin: Boolean = _

  override def execute(m: Machine) {
    // Prevent out from running prematurely when jumping back with bnz
    if (!fin) println(m.regs(register))
    fin = ((m.prog.length - 1) == m.labels.labels.indexOf(label))
  }

  override def toString(): String =
    super.toString + s" outputting contents of r$register\n"
}

object OutInstruction {
  def apply(label: String, register: Int) =
    new OutInstruction(label, "out", register)
}