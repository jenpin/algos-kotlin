class Palindrome {

    fun optimisedPalindrome(input:String): Boolean{
        val filteredInput= filterInput(input)

     if(filteredInput.length == 1) return true
        var arrayLength = filteredInput.length / 2
        var array1 = filteredInput.substring(0,arrayLength).reversed()
        var array2 =  filteredInput.substring(arrayLength)
        if(filteredInput.length % 2 != 0){
             array2 = filteredInput.substring(arrayLength+1)
        }

        //println("arraylength " + arrayLength+ " array1 " + array1 + " array2 " +array2)

        for(i in 0 until arrayLength){
            //println("index" + i )
            if(array1[i].equals(array2[i],true))
                return true
        }
        return false
    }

    fun isAPalindrome(input: String) : Boolean{
       val clear = filterInput(input)
        var start = 0
        var end = input.length-1

        while (start < end) {
            println("start " + start + " end "+ end)
            if(input[start].equals(input[end],true)){
                start = start + 1
                end = end -1
            }else{
                return false
            }
        }
        return true
    }

    fun filterInput(input: String): String{
        var pattern = "[A-Za-z+|0-9+]".toRegex()
        var filteredInput = input.filter { pattern.matches(it.toString()) }
        //println("a"+ filteredInput)
        return filteredInput
    }
}

fun main(args: Array<String>) {
    val testSubject = Palindrome()

    println(testSubject.isAPalindrome("Noon").equals(true))
//    println(testSubject.isAPalindrome("Hannah").equals(true))
//    println(testSubject.isAPalindrome("Racecar").equals(true))
//    println(testSubject.isAPalindrome("My gym").equals(true))
  // println(testSubject.filterInput("0p"))

//    println(testSubject.filterInput("Eva, can I see bees in a cave?").equals("EvacanIseebeesinacave"))
//    println(testSubject.filterInput("Don't nod.").equals("Dontnod"))
//    println(testSubject.isAPalindrome("Don't nod.").equals(true))
//    println(testSubject.isAPalindrome("Eva, can I see bees in a cave?").equals(true))

    println(testSubject.isAPalindrome("0p"))
    println(testSubject.isAPalindrome("a"))
}