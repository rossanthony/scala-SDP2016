/**
  * Software Design and Programming
  * SAMPLE EXAM PAPER 2016
  * Question 14
  *
  * https://moodle.bbk.ac.uk/pluginfile.php/522913/mod_resource/content/1/sample2016.pdf
  */

class Language {
  override def toString = "Language"
}
trait ObjectOriented extends Language {
  override def toString = "Object-Oriented -> " + super.toString
}
trait Functional extends Language {
  override def toString = "Functional -> " + super.toString
}
trait HigherOrderFunctions extends Functional {
  override def toString = "HO-Functions -> " + super.toString
}
trait Traits extends ObjectOriented {
  override def toString = "Traits -> " + super.toString
}
class Scala extends Language with Traits with HigherOrderFunctions {
  override def toString = "Scala -> " + super.toString
}
val language = new Scala

// language: Scala = Scala -> HO-Functions -> Functional -> Traits -> Object-Oriented -> Language

