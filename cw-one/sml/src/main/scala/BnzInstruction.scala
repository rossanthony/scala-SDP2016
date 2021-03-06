package sml

/**
  * This class takes a register number, checks if the contents are zero, and if not, repeats the given instruction
  *
  * @author Ross Anthony [http://github.com/rossanthony]
  */
class BnzInstruction(label: String, op: String, val register: Int, val instruction: String)
  extends Instruction(label, op) {

  override def execute(m: Machine) {
    val jumpTo = m.labels.labels.indexOf(instruction)
    // Only perform the jump if the register hasn't yet reached zero
    if (m.regs(register) != 0) m.execute(jumpTo)
  }

  override def toString(): String = {
    super.toString + s" if r$register != 0 jump to $instruction\n"
  }
}

object BnzInstruction {
  def apply(label: String, register: Int, instruction: String) =
    new BnzInstruction(label, "bnz", register, instruction)
}