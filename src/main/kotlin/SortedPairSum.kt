class SortedPairSum {

    fun detect(input:List<Int>, target: Int):Int{

        var indexStart = 0
        var indexEnd = input.size-1

        var result = mutableMapOf<Int,Int>()

        while(indexStart !== indexEnd){
            var start = input[indexStart]
            var end = input[indexEnd]

            //println("start " + start + " end "+ end)
            if(start + end > target){
               indexEnd = indexEnd -1
                //println("indexEnd" + indexEnd)
            }else if (start + end < target){
                indexStart = indexStart +1
            }else{
                result.put(start,end)
                indexStart = indexStart +1
            }
        }

        println(result.toList())
        return result.size
    }
}

fun main(args: Array<String>) {
    var testSubject = SortedPairSum()
    println(testSubject.detect(listOf(1,2,3,4,5,6,7), 6)) //[2,3]

}