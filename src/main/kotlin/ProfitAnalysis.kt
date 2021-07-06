class ProfitAnalysis {

    fun countlongestPeriodProfit(profits: List<Int>) : Int{
        var maxProfitDuration = 0
        var counter = 0
        profits.forEach {
            if(it == 0){
                counter = 0
            }else{
                counter += 1
            }
            if(counter > maxProfitDuration){
                maxProfitDuration = counter
            }
        }
        return maxProfitDuration
    }

    fun findlongestProfitPeriod(profits: List<Int>, months: List<String>) : Output{
        var maxProfitDuration = 0
        var counter = 0

        var endIndex  = 0
        profits.forEachIndexed{index, it ->
            if(it == 0){
                counter = 0
            }else{
                counter += 1
            }
            if(counter > maxProfitDuration){
                maxProfitDuration = counter
                endIndex = index
            }
        }

        var result = Output(maxProfitDuration,"","")
        if(maxProfitDuration != 0){
            result = Output(maxProfitDuration, months[endIndex-maxProfitDuration+1],months[endIndex])
        }
        return result
    }
}

data class Output ( val count: Int, val startMonth: String, val endMonth: String)

fun main(args: Array<String>) {
    var testSubject = ProfitAnalysis()
    var months = listOf("Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct")
    println(testSubject.countlongestPeriodProfit(listOf(1, 0, 1, 1, 0, 1, 1, 1, 0, 1)) == 3)
    println(testSubject.countlongestPeriodProfit(listOf(1,0,1,1,1,1,1,1,0)) == 6)
    println(testSubject.countlongestPeriodProfit(listOf(0,0,0)) == 0)

    println(testSubject.countlongestPeriodProfit(listOf(1,1,1)) == 3)

    println(testSubject.countlongestPeriodProfit(emptyList()) == 0)
    //println(testSubject.countlongestPeriodProfit(listOf(1, 0, 1, 1, 0, 1, 1, 1, 0, 1)) == 0)

    println(testSubject.findlongestProfitPeriod(listOf(1,0,1,1,0,1,1,1,0,1),months).equals(Output(3,"Jun","Aug")))
    println(testSubject.findlongestProfitPeriod(listOf(0,0),months).equals(Output(0,"","")))
    println(testSubject.findlongestProfitPeriod(listOf(1),months).equals(Output(1,"Jan","Jan")))

}