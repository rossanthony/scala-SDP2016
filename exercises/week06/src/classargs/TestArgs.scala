package classargs

// q.3
/*
case class Family(familyMembers: String*) {
  def familySize(): Int = familyMembers.length
}
*/


// q.4 - Adapt the Family class definition to include class arguments for a mother, father,
// and a variable number of children.

case class Family(mother: String, father: String, children: String*) {
  def familySize(): Int = 2 + children.length
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
