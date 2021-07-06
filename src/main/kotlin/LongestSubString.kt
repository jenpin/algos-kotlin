class LongestSubString {

    fun lengthOfLongestSubstring(s: String): Int {
        var currentResult = StringBuffer()

        var maxResult = ""
        for(i in s){
            if(currentResult.contains(i)){
                maxResult = returnMax(currentResult.toString(),maxResult)
                currentResult = StringBuffer(currentResult.substring(currentResult.indexOf(i)+1))
            }
            currentResult.append(i)
        }
        return returnMax(currentResult.toString(),maxResult).length
    }

    fun returnMax(currentResult:String, maxResult: String): String = if (currentResult.length > maxResult.length) currentResult else maxResult
    //ababcd

    fun slidingWindow(input: String, k: Int): String{
        var store = mutableMapOf<String, Int>()
        input.forEachIndexed { index, c ->
            store.put(c.toString(), index)
        }
        return  store.entries.sortedBy { it.value }.map { it.key }.take(k).toString()
    }
}

fun main(args: Array<String>) {
    var testSubject = LongestSubString()
    println(testSubject.lengthOfLongestSubstring("abcabcbb")) //[2,3]
    println(testSubject.slidingWindow("abcabcbb",3)) //abc
}