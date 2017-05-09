/**
  * Created by yardman on 5/8/17.
  */

object Lexer extends App {


  val p1 = """11 22 + 2 * print"""
  val p2 = """1 2 + 3 + 6 * print"""
  val p3 = """compile 5 * end "quintuple" define 2 quintuple print"""
  val p4 = """compile 2 * 1 + end "oneplusdouble" define 2 oneplusdouble print"""


  val tokens = tokenize(p4)
  println(tokens)


  val types = parse(tokens)

  def parse(tokens: List[String]): List[Object] = {


    val numberPattern = raw"(\d+)".r
    val keywordPattern = raw"(compile|end|define|print)".r
    val operatorPattern = raw"(-|\+|\*)".r
    val functionPattern = raw"(\w+)".r
    val stringPattern = raw"""("\w+")""".r

    val lexemes = tokens.map(token => {

      token match {
        case numberPattern(number) => NumberLexeme(number)
        case keywordPattern(keyword) => KeywordLexeme(keyword)
        case operatorPattern(op) => OperatorLexeme(op)
        case stringPattern(string) => StringLexeme(string)
        case functionPattern(functionName) => FunctionNameLexeme(functionName)
        case _ => NotRecognizedLexeme
      }

    })

    lexemes

  }

  def interpret(): Unit = {

    print("implement me please")
  }


  def tokenize(input: String): List[String] = {

    input.split("\\s").toList


  }

}


abstract class Lexeme

case class NumberLexeme(value:String) extends Lexeme

case class KeywordLexeme(value: String) extends Lexeme

case class StringLexeme(value: String) extends Lexeme

case class OperatorLexeme(value: String) extends Lexeme

case class NotRecognizedLexeme() extends Lexeme

case class FunctionNameLexeme(name: String) extends Lexeme






