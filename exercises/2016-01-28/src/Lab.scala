/**
 * Created by rossanthony on 28/01/2016.
 */
class Lab {
    def main(args: Array[String]): Unit = {
      val temp = 81
      val sky = "sunny" //"partly cloudy"

      val exp_one = sky == "sunny" && temp > 80
      val exp_two = (sky == "sunny" || sky == "partly cloudy") && temp > 80
      val exp_three = (sky == "sunny" || sky == "partly cloudy") && (temp > 80 || temp < 20)

      println(exp_one)
      println(exp_two)
      println(exp_three)

      val convFtoC: Double = (temp - 32) * (9.0 / 5.0)
      println(convFtoC)
    }
}




