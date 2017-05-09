/**
  * Created by yardman on 5/9/17.
  */
class StackMachine {


  private var stack: List[Lexeme] = List()


  def push(lexeme: Lexeme): Unit = {

    stack = lexeme :: stack

  }

  def popStack(): Lexeme = {

    stack.head
  }

  def interpret(instructionList:List[Lexeme]):Unit ={

    instructionList.map(lexeme => {

      /**
        * if Number push on stack
        * if operator eval and then push result on stack
        * if print print the top of the stack
        * if compile put stackMachine into compile state
        * if 
        */
      println(lexeme.lexemeType)


    })
  }


  def eval(instructionList:List[Lexeme]): Unit = {

    //get the operator from the stack
    /*
    val operator: String = popStack().asInstanceOf[OperatorLexeme].value
    val op1: Lexeme = popStack().asInstanceOf[NumberLexeme]
    val op2: Lexeme = popStack().asInstanceOf[NumberLexeme]
    val op1_value = op1.asInstanceOf[OperatorLexeme].value.toInt
    val op2_value: Int = op2.asInstanceOf[OperatorLexeme].value.toInt

    val result = operator match {

      case "*" => op1_value * op2_value
      case _ => 0
    }

    //push the result back on the stack

    push(NumberLexeme(result.toString))

    */


  }


}
