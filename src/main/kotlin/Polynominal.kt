class Polynominal (val coeffeicients: List<Int>){

    fun add(term: Polynominal):Polynominal = performOperation(term, "add")

    fun subtract(term: Polynominal):Polynominal = performOperation(term, "subtract")

    private fun performOperation(term: Polynominal, operation: String): Polynominal{
        val firstParameter = this.coeffeicients
        val secondParameter = term.coeffeicients
        var result = mutableListOf<Int>()

         val maxsize = if (firstParameter.size >= secondParameter.size)
                            firstParameter.size
                        else secondParameter.size

        if(operation.equals("add",ignoreCase = true)) {
            for ( i in 0 until maxsize){
                result.add(firstParameter.getOrElse(i,{0})+secondParameter.getOrElse(i,{0}))
            }
        }else {
            for ( i in 0 until maxsize){
                result.add(firstParameter.getOrElse(i,{0})-secondParameter.getOrElse(i,{0}))
            }
        }
        return Polynominal(result)
    }

}

fun main(args: Array<String>) {
    val poly1 = Polynominal(listOf(1,1))
    val poly2 = Polynominal(listOf(-1,1))
    var testSubject = poly1.add(poly2)
    println(testSubject.coeffeicients.equals(listOf(0,2)))
    testSubject= poly1.subtract(poly2)
    println(testSubject.coeffeicients.equals(listOf(2,0)))

    val poly3 = Polynominal(listOf(1,1))
    val poly4 = Polynominal(listOf(-1,1,1))
    testSubject = poly3.add(poly4)
    println(testSubject.coeffeicients.equals(listOf(0,2,1)))
    testSubject = poly3.subtract(poly4)
    println(testSubject.coeffeicients.equals(listOf(2,0,-1)))

}