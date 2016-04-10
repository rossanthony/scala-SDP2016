
/**
  * Generics
  */

// 1. Given the following type:
/*
sealed trait IntList
final case object End extends IntList
final case class Pair(head: Int, tail: IntList) extends IntList
*/

// (a) Change the name to LinkedList and make the type of data stored in the list generic.

sealed trait LinkedList
final case object End extends LinkedList
final case class Pair(head: AnyRef, tail: LinkedList) extends LinkedList

var linkedList = new Pair("hello", new Pair(123, _))