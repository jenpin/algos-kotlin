class FindDups {
    fun findDuplicate(nums: IntArray): Int {
        val sorted:MutableList<Int> =  nums.toMutableList()
        val max = sorted.sortedDescending()[0]

       for( i in 1..max){
           val index = sorted.indexOf(i)
          if(index != -1){
              sorted.set(index,-1)
          }
       }
        return sorted.filter{i-> i!=-1 }[0]
    }
}

fun main() {
    val testSubject: FindDups = FindDups()
    println(testSubject.findDuplicate(intArrayOf(1,3,4,2,2)))
    println(testSubject.findDuplicate(intArrayOf(1,1)))
    println(testSubject.findDuplicate(intArrayOf(1,1,2)))
}