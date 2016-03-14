package sml

import org.scalatest.Funsuite

/**
  * Created by rossanthony on 13/03/2016.
  */
class AddInstruction extends FunSuite {

  test("toString") {
    val addInstruction = new AddInstruction("L1", "add", 4, 2, 2)
    assert(addInstruction.toString == "L1: add " + 1.toString + " + " + 1.toString + " to " + 2.toString)
  }

  test("apply") {
    assert(true)
  }
}