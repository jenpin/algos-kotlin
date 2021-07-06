
import java.util.*


class SetMismatch(val age:Int) {

    private val theThingToBeEditedInternally = mutableListOf<String>()

    fun theThingToBeAccessedPublicly(): List<String> = theThingToBeEditedInternally


    init {
        theThingToBeEditedInternally.add(0, "something")
    }
    //val input = 0
    fun detect( input : IntArray): IntArray{

        var count = mutableMapOf<Int,Int>()
        var missing:Int = 0
        for (x in 1..input.size){
            if(!input.contains(x)){
                missing = x

            }
        }
        input.forEach {
            if(count.containsKey(it)){
                val a = count.getOrDefault(it,0)
                count.put(it,a+1)
            }else{
                count.put(it,1)
            }
        }
        var dup = count.filterValues { it ==2 }.keys.toList().first()
        return intArrayOf(dup, missing)

    }

}

fun main(args: Array<String>) {
    var testSubject: SetMismatch = SetMismatch(2)
    println(testSubject.detect(intArrayOf(1,2,2,4)).toList()) //[2,3]
   println( testSubject.detect(intArrayOf(1,1)).toList())//[1,2]
    println( testSubject.detect(intArrayOf(3,2,2)).toList()) //[2,1]
    println( testSubject.detect(intArrayOf(3,2,3,4,6,5)).toList()) //[3,1]
}