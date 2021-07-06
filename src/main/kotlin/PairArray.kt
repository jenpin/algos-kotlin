class PairArray {

    fun findPairs(nums: IntArray, k: Int): Int {

        var result = mutableSetOf<Any>()
        var input = nums.toList()
        while(input.size > 1){
            val compareTo = input[0]
         //   println("compareTo"+ compareTo)
            input = input.drop(1)

            //input.takeLast(input.size-1)
            for(i in input){
               // println("Math.abs(i - compareTo) " + Math.abs(i - compareTo) + " i "+ i)
                if(Math.abs(i - compareTo) == k){
                    if(!result.contains(listOf(i,compareTo))){
                        result.add(listOf(compareTo,i))
                    }
                }
            }
        }
        return result.size
    }
}

fun main(args: Array<String>) {
    val testSubject: PairArray = PairArray()
    println(testSubject.findPairs(intArrayOf(1,2,3,4,5),1))
    println(testSubject.findPairs(intArrayOf(3,1,4,1,5),2))

    //val a :List<List<String>> = emptyList(emptyList<String>())

    var b = listOf("jessie","james")
    var a = listOf(b)
    a.flatMap{ it.filter { it.contains("Jessie") } }
}