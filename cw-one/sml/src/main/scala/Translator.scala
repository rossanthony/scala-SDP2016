package sml

import scala.io.Source

/*
 * The translator of a <b>S</b><b>M</b>al<b>L</b> program.
 */
class Translator(fileName: String) {
//  private final val ADD = "add"
//  private final val SUB = "sub"
//  private final val DIV = "div"
//  private final val MUL = "mul"
//  private final val BNZ = "bnz"
//  private final val LIN = "lin"
//  private final val OUT = "out"
  // ^ Now we have reflection in place there is no longer any need to hardcode any constants referencing
  // each instruction shortcode.

  // word + line is the part of the current line that's not yet processed
  // word has no whitespace
  // If word and line are not empty, line begins with whitespace

  /**
    * translate the small program in the file into lab (the labels) and prog (the program)
    */
  def readAndTranslate(m: Machine): Machine = {
    val labels = m.labels
    var program = m.prog
    val lines = Source.fromFile(fileName).getLines

    for (line <- lines) {
      val fields = line.split(" ")

      if (fields.length > 1) {
        labels.add(fields(0))
        val args: Array[Object] = new Array[AnyRef](fields.length)

        for (i <- 0 until fields.length) {
          if (fields(i).matches("-?[0-9]*"))
            args(i) = new Integer(fields(i).toInt)
          else
            args(i) = fields(i)
        }

        try {
          val insClass = Class.forName(s"sml.${fields(1).capitalize}Instruction")
          program = program :+ insClass.getConstructors()(0).newInstance(args: _*).asInstanceOf[Instruction]
        } catch {
          case unknownClass@(_: ClassNotFoundException | _: ClassCastException) =>
            println(s"Error on line $line, ${fields(1)} is not a valid instruction\n")
        }

        // Now we have reflection in place there is no longer any need for the matcher below with hardcoded
        // values for the instructions. This allows for easier extension of the SML package by just adding additional
        // Instruction sub classes.

        //        fields(1) match {
        //          case ADD =>
        //            program = program :+ AddInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
        //          case SUB =>
        //            program = program :+ SubInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
        //          case DIV =>
        //            program = program :+ DivInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
        //          case MUL =>
        //            program = program :+ MulInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
        //          case BNZ =>
        //            program = program :+ BnzInstruction(fields(0), fields(2).toInt, fields(3))
        //          case LIN =>
        //            program = program :+ LinInstruction(fields(0), fields(2).toInt, fields(3).toInt)
        //          case OUT =>
        //            program = program :+ OutInstruction(fields(0), fields(2).toInt)
        //          case x =>
        //            println(s"Unknown instruction $x")
        //        }
      }
    }
    new Machine(labels, program)
  }
}

object Translator {
  def apply(file: String) =
    new Translator(file)
}