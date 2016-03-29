package builder

import java.util.Date

object Form extends App {
  val form: Form = new Form.FormBuilder("Dave", "Carter", "DavCarter", "DAvCaEr123",
    passwordHint = "MyName", city = "NY", language = "English").build

  case class FormBuilder(firstName: String = null,
                         lastName: String = null,
                         userName: String = null,
                         password: String = null,
                         address: String = null,
                         dob: Date = null,
                         email: String = null,
                         backupEmail: String = null,
                         spouseName: String = null,
                         city: String = null,
                         state: String = null,
                         country: String = null,
                         language: String = null,
                         passwordHint: String = null,
                         securityQuestion: String = null,
                         securityAnswer: String = null) {


    def build: Form = {
      new Form(this)
    }

    println(form)
  }

}

class Form(private var firstName: String = null,
           private var lastName: String = null,
           private var userName: String = null,
           private var password: String = null,
           private var address: String = null,
           private var dob: Date = null,
           private var email: String = null,
           private var backupEmail: String = null,
           private var spouseName: String = null,
           private var city: String = null,
           private var state: String = null,
           private var country: String = null,
           private var language: String = null,
           private var passwordHint: String = null,
           private var securityQuestion: String = null,
           private var securityAnswer: String = null) {

  def this(formBuilder: Form.FormBuilder) {
    this()
    this.firstName = formBuilder.firstName
    this.lastName = formBuilder.lastName
    this.userName = formBuilder.userName
    this.password = formBuilder.password
    this.address = formBuilder.address
    this.dob = formBuilder.dob
    this.email = formBuilder.email
    this.backupEmail = formBuilder.backupEmail
    this.spouseName = formBuilder.spouseName
    this.city = formBuilder.city
    this.state = formBuilder.state
    this.country = formBuilder.country
    this.language = formBuilder.language
    this.passwordHint = formBuilder.passwordHint
    this.securityQuestion = formBuilder.securityQuestion
    this.securityAnswer = formBuilder.securityAnswer
  }
}