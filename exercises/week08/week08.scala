package week08

import atomicscala.AtomicTest._


object week08 extends App {

  sealed trait LinkedList{
    def length: Int
    def contains(t : Int): Boolean
  }

  case object End extends LinkedList{
    def apply(): LinkedList = new LinkedList {
      override def length: Int = 0

      override def contains(t : Int): Boolean = false
    }

    override def length: Int = 0

    override def contains(t: Int): Boolean = false
  }


  case object Empty extends LinkedList{
    def apply(): LinkedList = new LinkedList {
      override def length: Int = 0

      override def contains(t: Int): Boolean = false
    }

    override def length: Int = 0

    override def contains(t: Int): Boolean = false
  }

  final case class Pair(head: Int, tail: LinkedList) extends LinkedList {

    override def length: Int = {
      var length = 1
      if (tail == null) return 0
      else{
        length = length + tail.length
      }
      length
    }

    override def contains(t:Int): Boolean = {
      var contains = false
      if(head == t) {
        contains =  true}
      else{
        contains = tail.contains(t)
      }
      contains
    }
  }

  val example = Pair(1, Pair(2, Pair(3, End())))
  assert(example.length == 3)
  assert(example.tail.length == 2)
  assert(End().length == 0)

  val example2 = Pair(1, Pair(2, Pair(3, Empty())))
  assert(example2.contains(3) == true)
  assert(example2.contains(4) == false)
  assert(Empty().contains(0) == false)
  // This should not compile
  // example.contains("not an Int")


}