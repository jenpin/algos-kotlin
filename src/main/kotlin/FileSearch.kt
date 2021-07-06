class FileSearch {
    fun totalSize(inputs: List<Input>) = inputs.sumBy {it.size }

    fun topNCollection(inputs:List<Input>,n:Int): List<String>{
//filter on thelist collectionid => map <collectionId,List<Int>>
        var collectionIdToSize = mutableMapOf<String,Int>()
        inputs.forEach {
            var newSpace = it.size
            if(it.collectionId!= null){
                if(collectionIdToSize.containsKey(it.collectionId!!)){
                    newSpace = collectionIdToSize.getOrDefault(it.collectionId!!,0).plus(it.size)
                }
                collectionIdToSize.put(it.collectionId!!,newSpace)
            }
        }

        return collectionIdToSize.entries.sortedByDescending {
            it.value
        }.map { it.key }.take(n)
    }

}

fun main(args: Array<String>) {
    val s = FileSearch()
    var inputOne = Input("file1.txt",100)
    var inputTwo = Input("file2.txt",200, "collection1")
    var inputThree = Input("file3.txt",200, "collection1")
    var inputFour = Input("file4.txt",300, "collection3")
    var inputs = listOf<Input>(inputOne,inputTwo,inputThree,inputFour)
    //read my file and return List<Input>
    println(s.totalSize(inputs))
    println(s.topNCollection(inputs,2))
}

data class Input(var file: String, var size: Int,var collectionId: String? = null)