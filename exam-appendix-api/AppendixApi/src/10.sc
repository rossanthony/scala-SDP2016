// The function flatten has the following signature:

//      def flatten[A](as: List[List[A]]): List[A]

// flatten reduces a list of lists to a single list by concatenating
// the element lists. Provide an implementation of flatten that
// utilises pattern matching.

def flatten[A](as: List[List[A]]): List[A] = as match {
    case Nil => Nil
    case hd :: tl => hd ::: flatten(tl)
  }


val x = List(1,2,3)
val y = List(4,5,6)

flatten(List(x,y))