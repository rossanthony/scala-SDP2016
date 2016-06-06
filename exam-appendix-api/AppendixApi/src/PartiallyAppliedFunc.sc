
def add(i: Int, j: Int) = i + j

val add5 = add(_: Int, 5)

// 'add5' is now a partially applied version of the function 'add'

add5(2) // = 7