package sml

import scala.io.Source
import scala.reflect._
import scala.reflect.runtime.universe._
//import compat._

/*
 * The translator of a <b>S</b><b>M</b>al<b>L</b> program.
 */
class Translator(fileName: String) {
  private final val ADD = "add"
  private final val SUB = "sub"
  private final val DIV = "div"
  private final val MUL = "mul"
  private final val BNZ = "bnz"
  private final val LIN = "lin"
  private final val OUT = "out"


  def classExistsForInst(name: String) {
    try {
      val meths = Class.forName(name).getMethods
      //println(meths take 10 mkString "\n")
      println(s"Class exists for $name instr")
    }
    catch {
      case e: ClassNotFoundException => println(s"Instruction: `$name` does not have an associated class file.")
    }
  }


  def printMethods(name: String) {
    try {
      val meths = Class.forName(name).getMethods
      //println(meths take 10 mkString "\n")
      println(s"Class exists for $name instr")
    }
    catch {
      case e: ClassNotFoundException => println(s"Instruction: `$name` does not have an associated class file.")
    }
  }

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

//    printMethods("sml.AddInstruction")
//    printMethods("sml.LbzInstruction")

    for (line <- lines) {
      val fields = line.split(" ")
      if (fields.length > 0) {
        labels.add(fields(0))

        // @TODO implement reflection instead of the matcher below

//        typeOf[className].declaration(nme.CONSTRUCTOR).asTerm.alternatives.collect {
//          case m: MethodSymbol => m.paramss.map(_.map(_.name))
//        }

//        val meths = Class.forName(s"sml.${fields(1).capitalize}Instruction").getMethods
//        println(meths take 10 mkString "\n\n")
//
        val className = s"sml.${fields(1).capitalize}Instruction"

        // Class.forName returns a Class[_], not an instance of the class you give it

        // @TODO somehow match the signature of each Instruction with the available fields and their types

        //typeOf[AddInstruction].member(termNames.CONSTRUCTOR)

        //val paramLists = typeOf[AddInstruction].paramLists
        //println(paramLists take 10 mkString "\n\n")

//        val addInst = AddInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
//        val linInst = LinInstruction(fields(0), fields(2).toInt, fields(3).toInt)
//
//        Class.forName(s"sml.${fields(1).capitalize}Instruction") match {
//          case m: Class[addInst] => println("addInst")
//          case p: Class[linInst] => println("linInst")
//          case _ => println("Nothing")
//        }


        fields(1) match {
          case ADD =>
            program = program :+ AddInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
          case SUB =>
            program = program :+ SubInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
          case DIV =>
            program = program :+ DivInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
          case MUL =>
            program = program :+ MulInstruction(fields(0), fields(2).toInt, fields(3).toInt, fields(4).toInt)
          case BNZ =>
            program = program :+ BnzInstruction(fields(0), fields(2).toInt, fields(3))
          case LIN =>
            program = program :+ LinInstruction(fields(0), fields(2).toInt, fields(3).toInt)
          case OUT =>
            program = program :+ OutInstruction(fields(0), fields(2).toInt)
          case x =>
            println(s"Unknown instruction $x")
        }
      }
    }
    new Machine(labels, program)
  }
}

object Translator {
  def apply(file: String) =
    new Translator(file)
}