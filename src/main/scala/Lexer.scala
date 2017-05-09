/**
  * Created by yardman on 5/8/17.
  */




object Lexer extends App {



  val stackMachine = new StackMachine()

  val p1 = """11 22 + 2 * print"""
  val p2 = """1 2 + 3 + 6 * print"""
  val p3 = """compile 5 * end "quintuple" define 2 quintuple print"""
  val p4 = """compile 2 * 1 + end "oneplusdouble" define 2 oneplusdouble print"""


  val tokens = tokenize(p4)
  println(tokens)


  val instructionList:List[Lexeme] = parse(tokens)

  stackMachine.interpret(instructionList)

  def parse(tokens: List[String]): List[Lexeme] = {


    val numberPattern = raw"(\d+)".r
    val keywordPattern = raw"(compile|end|define|print)".r
    val compilePattern = raw"(compile)".r
    val endPattern = raw"(end)".r
    val definePattern = raw"(define)".r
    val printPattern = raw"(print)".r
    val substractPattern = raw"(-)".r
    val addPattern = raw"(\+)".r
    val multPattern = raw"(\*)".r
    val functionPattern = raw"(\w+)".r
    val stringPattern = raw"""("\w+")""".r

    val lexemes = tokens.map(token => {

      token match {
        case numberPattern(number) => Lexeme(number,LexemeType.NumberType )
        case compilePattern(keyword) => Lexeme(keyword,LexemeType.CompileType)
        case endPattern(keyword) => Lexeme(keyword,LexemeType.EndType)
        case printPattern(keyword)   => Lexeme(keyword, LexemeType.PrintType)
        case definePattern(keyword) => Lexeme(keyword, LexemeType.DefineType)
        case multPattern(op) =>     Lexeme(op, LexemeType.MultiplicationType)
        case substractPattern(op) => Lexeme(op, LexemeType.SubstractionType)
        case addPattern(op)  => Lexeme(op, LexemeType.AdditionType)
        case stringPattern(string) =>    Lexeme(string, LexemeType.StringType)
        case functionPattern(functionName) => Lexeme(functionName,LexemeType.FunctionType)
        case _ =>  Lexeme("error", LexemeType.ErrorType)
      }

    })

    //return the lexemes
    lexemes

  }

  def interpret(): Unit = {

    print("implement me please")
  }


  def tokenize(input: String): List[String] = {

    input.split("\\s").toList


  }

}


case class Lexeme(value:String, lexemeType:LexemeType.Value)




