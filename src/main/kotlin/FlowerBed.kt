class FlowerBed {

    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        var noFlowerBeds = populateNoFlowerBeds(flowerbed).toMutableList()
        var result = 0
        val size= flowerbed.size
        flowerbed.toList().forEachIndexed { index, element ->
            var validNext = if(index != size-1) index+1 <= flowerbed.size -1 && flowerbed[index+1] == 0 else true
            var validCurrentElement = element == 0 && !noFlowerBeds.contains(index)

            println("validNext " + validNext + " validCurrentElement " + validCurrentElement )
            if(validNext && validCurrentElement){
                result = result + 1
                if(addIndex(index-1, size)) noFlowerBeds.add(index-1)
                if(addIndex(index+1, size)) noFlowerBeds.add(index+ 1)
            }
        }
        println("result " + result)
        return n <= result
    }

    fun populateNoFlowerBeds(flowerbed: IntArray): List<Int> {
        var noFlowerBeds = mutableListOf<Int>()
        val size= flowerbed.size
        flowerbed.forEachIndexed { index, i ->
            if(i==1) {
                noFlowerBeds.add(index)
                if(addIndex(index-1, size)) noFlowerBeds.add(index-1)
                if(addIndex(index+1, size)) noFlowerBeds.add(index+ 1)
            }
        }
        println(noFlowerBeds)
            return noFlowerBeds
        }


    fun addIndex(index:Int, flowerbedSize: Int): Boolean = index >=0 && index <= flowerbedSize -1

}

fun main(args: Array<String>) {
    var testSubject = FlowerBed()
    println(testSubject.populateNoFlowerBeds(intArrayOf(1,0,0,0,1)).equals(listOf(0,1,4,3)))
    println(testSubject.canPlaceFlowers(intArrayOf(1,0,0,0,1),2).equals(true)) //[2,3]
//    println(testSubject.canPlaceFlowers(intArrayOf(0,0,0,1,0),1).equals(true))
//    println(testSubject.canPlaceFlowers(intArrayOf(0,0,1,0,0),2).equals(true))
}
