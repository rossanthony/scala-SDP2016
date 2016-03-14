package sml

/**
  * The machine language interpreter
  */
case class Machine(labels: Labels, prog: Vector[Instruction]) {
  private final val NUMBEROFREGISTERS = 32
  // The registers of the SML machine
  val regs: Registers = new Registers(NUMBEROFREGISTERS)
  var currentLn = 0

  override def toString(): String = {
    prog.foldLeft("")(_ + _)
  }

  // Execute the program in prog, beginning at instruction 0.
  // Precondition: the program and its labels have been store properly.
/*
  def execute(start: Int) =
    start.until(prog.length).foreach(x => prog(x) execute this)
  */

  // The foreach method above has been replaced with a while loop, because it was causing issues with the Bnz jump to
  // line calls, e.g. the following SML...
  //    f0 lin 0 6
  //    f1 lin 1 1
  //    f2 lin 2 1
  //    f3 mul 1 1 0
  //    f4 sub 0 0 2
  //    f5 bnz 0 f3
  //    f6 out 1
  //
  // Results in:
  //    Beginning program execution.
  //    720
  //    720
  //    720
  //    720
  //    720
  //    720
  //    Ending program execution.
  //
  // Although arguably less elegant, I found that using a while loop instead allows jumping to previous points
  // in the loop, without repeating the last func call to `f6 out 1` six times!

  def execute(start: Int): Unit = {
    currentLn = start
    while (currentLn <= prog.length - 1) {
      prog(currentLn) execute this
      currentLn += 1
    }
  }
}

object Machine extends App {
  if (args.length == 0) {
    println("Machine: args should be sml code file to execute")
  } else {
    println("SML interpreter - Scala version")

    val m = Translator(args(0)).readAndTranslate(new Machine(Labels(), Vector()))

    println("Here is the program; it has " + m.prog.size + " instructions.")
    println(m)
    println("Beginning program execution.")
    m.execute(0)
    println("Ending program execution.")
    println("Values of registers at program termination:")
    println(m.regs + ".")
  }
}