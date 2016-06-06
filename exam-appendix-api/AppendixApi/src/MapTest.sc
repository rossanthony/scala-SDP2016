type Env = Map[String, Int]

def makeEnv(): Env = Map()

var env = makeEnv()

env = env + ("x" -> 17)
env = env + ("y" -> 12)
env = env + ("x" -> 99)