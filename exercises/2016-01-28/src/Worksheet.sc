val temp = 81
//val sky = "sunny"
val sky = "partly cloudy"

val exp_one = sky == "sunny" && temp > 80
val exp_two = (sky == "sunny" || sky == "partly cloudy") && temp > 80
val exp_three = (sky == "sunny" || sky == "partly cloudy") && (temp > 80 || temp < 20)

val convFtoC: Double = (temp - 32) / (9.0 / 5.0)
// convFtoC: Double = 27.22222222222222
val convCtoF: Double = temp * (9.0 / 5.0) + 32
// convCtoF: Double = 177.8

def getSquare(x: Int): Int = x * x
getSquare(3)

