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

// Q.13
// What are the values of the following expressions?
// a)
Evaluation.eval {
  Operations.simplify {
    App(
      Fun("y", Plus(Number(1), Var("y"))),
      Plus(Number(2), Number(3))
    )
  }
}
/* Trace

 1. resolve 2nd arg passed into App():

 simplify(Plus(Number(2), Number(3))), returns:  reduce(Plus(simplify(Number(2)), simplify(Number(3))))

 reduce(Plus(Number(2), Number(3))), returns: Number(5)


 2. Resolve 1st arg passed into App():

 simplify(Fun("y", Plus(Number(1), Var("y")))), returns:  Fun("y", simplify(Plus(Number(1), Var("y"))))

 simplify(Plus(Number(1), Var("y"))), returns:  reduce(Plus(simplify(Number(1)), simplify(Var("y"))))

 reduce(Plus(Number(1), Var("y"))), returns:  Plus(Number(1), Var("y"))  // NO MATCH IN reduce() for num + str

 output: Fun("y", Plus(Number(1), Var("y")))


 3. Resolve the remainder of the simplify operation:

 reduce(App( Fun("y", Plus(Number(1), Var("y"))), Number(5) )

 output: Let("y", Number(5), Plus(Number(1), Var("y")))


 4. Resolve eval

 eval( Let("y", Number(5), Plus(Number(1), Var("y"))) )

 eval( Plus(Number(1), Var("y")), env + ("y" -> eval(Number(5), env)) )

 eval( Plus(Number(1), Var("y")), env )

 plus( eval(1, env), eval("y", env) )

 plus(1, 5)

 Value = NumValue(6.0)

*/

// (b)
//Evaluation.eval {
  Let("x", Number(11),
    Let("f", Fun("y", Plus(Var("x"), Var("y"))),
      Let("x", Number(20),
        App(Var("f"), Number(12)))))
//}
/* Trace

 Let(name, expr, body)
 eval(body, env + (name -> eval(expr, env))))

 eval(
    Let("f", Fun("y", Plus(Var("x"), Var("y"))), Let("x", Number(20), App(Var("f"), Number(12)))),
    env + ("x" -> eval(Number(11), env))
 )

 env = {
    ["x" -> 11]
 }

 Let(name, expr, body)
 Let(
    "f",
    Fun("y", Plus(Var("x"), Var("y"))),
    Let("x", Number(20), App(Var("f"), Number(12)))
 )


 eval(
    Let("x", Number(20), App(Var("f"), Number(12))),
    env + ("f" -> eval(Fun("y", Plus(Var("x"), Var("y"))), env))
 )

 eval(Fun("y", Plus(Var("x"), Var("y")))

 env = {
    ["x" -> 11],
    ["f" -> ClosureValue("y", Plus(Var("x"), Var("y")), env)]
 }

  Let(
    "x",
     Number(20),
     App(Var("f"), Number(12))
  )

 eval(
    App(Var("f"), Number(12)),
    env + eval("x" -> eval(Number(20), env))
 )

 env = {
    ["x" -> 20],  // x is overwritten!
    ["f" -> ClosureValue("y", Plus(Var("x"), Var("y")), env)]
 }

 eval(App(Var("f"), Number(12)), env)


 App(fun, arg) =>
     val ClosureValue(param, body, env2) = eval(Var("f"), env)
     val v = eval(Number(12), env)

     eval(Plus(Var("x"), Var("y")), env2 + ("y" -> Number(12))

 env = {
    ["x" -> 20],
    ["f" -> ClosureValue("y", Plus(Var("x"), Var("y")), env)]
 }

 env2 = {
    ["x" -> 11],
    ["y" -> 12]
 }

 // x: comes from the old version of 'env' saved in the ClosureValue object inside "f"

 plus(x:11, y:12)

 Value = NumValue(23.0)


 */





// res1: Value = NumValue(23.0)

// (c)
Operations.reduce {
  Operations.simplify {
    Let("y", Number(3),
      Let("f", Fun("x", Plus(Var("x"), Plus(Var("y"), Number(12)))),
        Var("f")))
  }
}

// without .simplify
// Expr = Let(y,Number(3.0),Let(f,Fun(x,Plus(Var(x),Plus(Var(y),Number(12.0)))),Var(f)))

// with .simplify
// Expr = Let(y,Number(3.0),Let(f,Fun(x,Plus(Var(x),Plus(Var(y),Number(12.0)))),Var(f)))
