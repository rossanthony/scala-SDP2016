package AppendixApi

/**
  * Why is this a sealed trait?
  */
sealed trait Expr

final case class Number(num: Double) extends Expr

final case class Var(name: String) extends Expr

final case class Plus(left: Expr, right: Expr) extends Expr

final case class Fun(param: String, body: Expr) extends Expr

final case class App(fun: Expr, arg: Expr) extends Expr

final case class Let(name: String, expr: Expr, body: Expr) extends Expr

/**
  * Regular trait (not sealed)
  */
trait Value

case class NumValue(num: Double) extends Value

case class ClosureValue(param: String, body: Expr, env: Evaluation.Env) extends Value

/**
  *
  */
object Operations {
  def reduce(expr: Expr) =
    expr match {
      case Plus(Number(i), Number(j)) => Number(i + j)
      case Plus(Number(0), e) => e
      case App(Fun(param, body), e) => Let(param, e, body)
      case Let(x, e, Var(y)) if x == y => e
      case _ => expr
    }

  def simplify(expr: Expr): Expr =
    expr match {
      case Number(d) => Number(d)
      case Var(name) => Var(name)
      case Plus(left, right) => reduce(Plus(simplify(left), simplify(right)))
      case Let(name, expr, body) => Let(name, simplify(expr), simplify(body))
      case Fun(param, body) => Fun(param, simplify(body))
      case App(fun, arg) => reduce(App(simplify(fun), simplify(arg)))
    }
}

/**
  *
  */
object Evaluation {
  type Env = Map[String, Value]

  def makeEnv(): Env = Map()

  val num: Value => Double = {case NumValue(num) => num}

  def plus(x: Value, y: Value) = NumValue(num(x) + num(y))

  def eval(expr: Expr): Value = eval(expr, makeEnv())

  def eval(expr: Expr, env: Env): Value = {
    expr match {
      case Number(d) => NumValue(d)
      case Var(name) => env(name)
      case Plus(left, right) => plus(eval(left, env), eval(right, env))
      case Let(name, expr, body) => {
        // recursive call
        eval(body, env + (name -> eval(expr, env)))
      }
      case Fun(param, body) => ClosureValue(param, body, env)
      case App(fun, arg) => {
        val ClosureValue(param, body, env2) = eval(fun, env)
        val v = eval(arg, env)
        // recursive call
        eval(body, env2 + (param -> v))
      }
    }
  }
}

/**
  *
  */
//object AMain {
//  def main(args: Array[String]): Unit = {
//    println(
//      Evaluation.eval {
//        Let("y", Number(3),
//          Let("f", Fun("x", Plus(Var("x"), Var("y"))),
//            Var("f")))
//        }
//    )
//    // Output:
//    // ClosureValue(x,Plus(Var(x),Var(y)),Map(y -> NumValue(3.0)))
//  }
//}

