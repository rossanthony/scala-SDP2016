package strategy

object TestStrategyPattern extends App {
  var formatter: TextFormatter = new CapTextFormatter
  var editor: TextEditor = new TextEditor(formatter)
  editor.publishText("Testing text in caps formatter")
  formatter = new LowerTextFormatter
  editor = new TextEditor(formatter)
  editor.publishText("Testing text in lower formatter")
}