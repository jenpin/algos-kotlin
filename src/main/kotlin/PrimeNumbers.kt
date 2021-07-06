class PrimeNumbers {

    fun countPrimeNumbers(endRange: Int) : Int{
        var count = 0;

        var primeNumbers = mutableListOf<Int>()
        for(index in 1 until endRange+1 ){

            if(index != 1 && isDivisibleBy(index,primeNumbers)){
                primeNumbers.add(index)
                count = count + 1
            }

        }
        println("primenumbers" + primeNumbers)
        return count;
    }

    fun countPrimeNumbersOptimised(endRange: Int) :Int{

        var nonPrimeSet = mutableSetOf<Int>()
        var twoendRange = endRange/2
        var threeEndRange = endRange/ 3

        for(multiple in 1 until twoendRange){
            nonPrimeSet.add( multiple * 2)
        }

        for( mutliple in 1 until threeEndRange){
            nonPrimeSet.add( mutliple *3)
        }

        for (index in 1 until endRange+1){
            if(!nonPrimeSet.contains(index)){

            }
        }


      return 0
    }

    fun isDivisibleBy(index: Int, primenumbers:List<Int>):Boolean{
        for( number in primenumbers){
            if(index % number == 0)
                return false
        }
        return true
    }
}

fun main(args: Array<String>) {
    var testOnly = PrimeNumbers()

    //println(testOnly.countPrimeNumbers(5))   //[1,2,3,4,5] = 3
    println(testOnly.countPrimeNumbers(5) == 3)

    //println(testOnly.countPrimeNumbers(10))   //[1,2,3,4,5,6,7,8,9,10] = 4
    println(testOnly.countPrimeNumbers(10) == 4)

    //println(testOnly.countPrimeNumbers(15))   //[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17] = 4
    println(testOnly.countPrimeNumbers(17) == 7)

}