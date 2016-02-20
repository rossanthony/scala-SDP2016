package linkedlist

import scala.annotation.tailrec

sealed trait IntList

final case object End extends IntList

final case class Pair(head: Int, tail: IntList) extends IntList

object MyMain extends App {
  Pair(1, Pair(2, Pair(3, End)))

  val d = End
  val c = Pair(3, d)
  val b = Pair(2, c)
  val a = Pair(1, b)

  // @tailrec - not tail recursive
  def sum(list: IntList): Int =
    list match {
      case End => 0
      case Pair(hd, tl) => hd + sum(tl)
    }

  @tailrec
  def sumTailRecursive(list: IntList, total: Int = 0): Int =
    list match {
      case End => total
      case Pair(hd, tl) => sumTailRecursive(tl, total + hd)
    }

  println(sum(a))

  println(sumTailRecursive(a))
}




