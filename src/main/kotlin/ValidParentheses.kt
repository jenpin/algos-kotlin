import java.util.*

class ValidParentheses {

    fun isValid(input: String): Boolean {

        var openingBrackets = mutableListOf<String>()
        var closingBrackets = mutableListOf<String>()
        for( bracket in input){
            if("\\{|\\(|\\[".toRegex().matches(bracket.toString())){
                openingBrackets.add(bracket.toString())
            }else{
                closingBrackets.add(bracket.toString())
            }
        }
        println("openingBrackets " + openingBrackets)
        println("closingBrackets reversed " + closingBrackets.reversed())
        return openingBrackets.equals(closingBrackets.reversed())
    }


}

fun main(args: Array<String>) {
    val testSubject = ValidParentheses()
   // println(testSubject.isValid("{[({[]})]}") == true)
    println(testSubject.isValid("[{}]") == true)

    //println("\\}|\\)".toRegex().matches(")"))
}