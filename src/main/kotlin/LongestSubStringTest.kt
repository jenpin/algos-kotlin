class LongestSubStringTest {


}

fun main(args: Array<String>) {
    var testOnly = LongestSubString()

    println(testOnly.lengthOfLongestSubstring("abcabcbb") == 3)
    println(" subject" + testOnly.lengthOfLongestSubstring("pwwwkew") )
    println(testOnly.lengthOfLongestSubstring("bbbb").equals(1))
    println(testOnly.lengthOfLongestSubstring("pwwwkew") == 2)


//    assert(testOnly.returnMax("abc","abc").equals("abc"))
//    assert(testOnly.returnMax("bb","abc").equals("abc"))
//    assert(testOnly.returnMax("bb","").equals("bb"))

}