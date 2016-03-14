package sml

/**
  * This class takes a register number, checks if the contents are zero, and if not, repeats the given instruction
  *
  * @author Ross Anthony [http://github.com/rossanthony]
  */

class BnzInstruction(label: String, op: String, val register: Int, val instruction: String)
  extends Instruction(label, op) {

  //val registerValue : Int

  override def execute(m: Machine) {
    val regValue = m.regs(register)
    val destLine = m.labels.labels.indexOf(instruction)
    //if (regValue != 0) m.execute(destLine)
  }

  override def toString(): String = {
//    if (registerValue != 0)
//      super.toString + s"Register $register is not equal to 0, therefore executing instruction $instruction\n"
//    else
      super.toString + s"Register $register is 0, therefore doing nothing\n"
  }
}

object BnzInstruction {
  def apply(label: String, register: Int, instruction: String) =
    new BnzInstruction(label, "bnz", register, instruction)
}