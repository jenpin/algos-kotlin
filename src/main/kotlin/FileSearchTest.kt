class FileSearchTest {

}

fun main(args: Array<String>) {
    val testSubject: FileSearch = FileSearch()

    var inputOne = Input("file1.txt",100)
    var inputTwo = Input("file2.txt",200, "collection1")
    var inputThree = Input("file3.txt",200, "collection1")
    var inputFour = Input("file4.txt",300, "collection3")
    var inputs = listOf<Input>(inputOne,inputTwo,inputThree,inputFour)
    val expected = listOf<String>("collection1","collection3")
    println(testSubject.topNCollection(inputs,2).equals(expected))

    var inputFive = Input("file1.txt",-100)
    var inputSix = Input("file1.txt",100)
    inputs = listOf<Input>(inputFive,inputSix)
    println(testSubject.totalSize(inputs).equals(0))

}