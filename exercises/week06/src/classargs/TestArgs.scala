package classargs

case class Family(familyMembers: String*) {
  def familySize(): Int = familyMembers.length
}


object TestArgs extends App {
  val family1 = new Family("Mum", "Dad", "Sally", "Dick")
  println(
    family1.familySize() // is 4
  )

  val family2 = new Family("Dad", "Mom", "Harry")
  println(
    family2.familySize() // is 3
  )
}
