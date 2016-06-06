
def f(xs: List[Int], g: (Int, Int) => Boolean) = {

  def h(x: Int, xs: List[Int]): List[Int] =
    xs match {
      case List() => List(x)
      case y :: ys =>
        if (!g(x, y)) // x is not greater than y
          x :: xs //
        else
          y :: h(x, ys)
    }

  // foldRight

  xs.foldRight(List[Int]())(h)

  //(xs :\ List[Int]())(h)
}


f(List(3, 6, 1, 3, 8, 7, 9, 1), (_ > _))

/*
  Trace (through helper func)

  1  x = 1, xs = List() => List(1)
  2  x = 9, xs = List(1) => !g(9, 1)



*/