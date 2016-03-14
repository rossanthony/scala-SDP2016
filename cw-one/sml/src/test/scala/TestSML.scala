import sml._

import org.scalatest._

class TestSML extends FunSuite with ShouldMatchers {
  
  test("addition") {
    val filePath = getClass.getResource("test-addition.sml").toString.replaceAll("file:", "")
    val m = Translator(filePath).readAndTranslate(new Machine(Labels(), Vector()))
    m.execute(0)
    m.regs.toString should equal("0 2 3 5 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0")
  }

  test("subtraction") {
    val filePath = getClass.getResource("test-subtraction.sml").toString.replaceAll("file:", "")
    val m = Translator(filePath).readAndTranslate(new Machine(Labels(), Vector()))
    m.execute(0)
    m.regs.toString should equal("0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 10 7 -3 0 0 0 0 0 0 0 0 0")
  }

  test("division") {
    val filePath = getClass.getResource("test-division.sml").toString.replaceAll("file:", "")
    val m = Translator(filePath).readAndTranslate(new Machine(Labels(), Vector()))
    m.execute(0)
    m.regs.toString should equal("6 2 3 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0")
  }

  test("multiplication") {
    val filePath = getClass.getResource("test-multiplication.sml").toString.replaceAll("file:", "")
    val m = Translator(filePath).readAndTranslate(new Machine(Labels(), Vector()))
    m.execute(0)
    m.regs.toString should equal("0 6 0 0 0 2 0 0 0 0 12 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0")
  }

  test("bnz/factoral") {
    val filePath = getClass.getResource("test-factoral.sml").toString.replaceAll("file:", "")
    val m = Translator(filePath).readAndTranslate(new Machine(Labels(), Vector()))
    m.execute(0)
    m.regs.toString should equal("0 720 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0")
  }
}