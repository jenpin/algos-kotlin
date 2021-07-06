class Satisfaction {
    fun maxSatisfaction(satisfaction: IntArray): Int {

        //sort
        //split arary into positive & negative
        //if negativearray.length > positivearray.length , resize negative array (length- positivearray.length, length)
        //if negativearray<positive or if zero then use the whole array
        //merge(negativearary, positivearray)
        //loop thru and set max
        //reduce one elementfrom negative array , merge and loop thru

        val sortedArray = satisfaction.sortedArray()
        var max = 0;
        var positiveArray = sortedArray.filter {it >= 0 }
        var negativeArray = sortedArray.filter {it < 0 }
        var newArray = listOf<Int>()

        if(positiveArray.size == 0) return max;
        else if( negativeArray.size  == 0 ) return findMax(positiveArray,max)

        while ( negativeArray.size > 0){
            if(negativeArray.size > positiveArray.size){
                negativeArray.slice(negativeArray.size - positiveArray.size downTo  negativeArray.size)
            }
            newArray = negativeArray.plus(positiveArray)
            max = findMax(newArray, max)
            negativeArray = negativeArray.drop(1)
        }

        return max
    }
}
fun findMax(newArray: List<Int>,max:Int): Int{
    var total = 0
    for ( item in newArray.indices){
        total = total + (item+1) * newArray[item]
    }
    if(total > max ){
        return total
    }
    return max;
}
fun main(args: Array<String>) {
    val s = Satisfaction()
    println(s.maxSatisfaction(intArrayOf(4,3,2)))
    //println(s.maxSatisfaction(intArrayOf(5,-2,-3,4,1,9)))
}