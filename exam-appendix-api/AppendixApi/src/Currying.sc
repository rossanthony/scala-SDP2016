
// A curried function is one which accepts multiple parameter lists, e.g

def multiply(x: Int)(y: Int): Int = x * y

// The function can be applied by passing in multiple param lists, e.g

multiply(2)(2)

// It can also be run partially by specifying underscores in
// place of some of the param lists, e.g

var timesByFive = multiply(5)_

// timesByFive is now a partial application of the function multiply
// running it again does what it says on the tin...

timesByFive(5) // = 25

timesByFive(9) // = 45

