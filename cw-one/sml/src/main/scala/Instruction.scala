package sml

/**
  * This class is the supertype for machine instructions
  * This class is abstract, because it should not be instantiated
  *
  * @author Ross Anthony [http://github.com/rossanthony]
  */
abstract class Instruction(label: String, opcode: String) {

  override def toString(): String = label + ": " + opcode

  def execute(m: Machine): Unit
}