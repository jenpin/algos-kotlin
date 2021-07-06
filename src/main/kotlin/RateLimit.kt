import java.util.*

data class UserRequest(var count: Int,
                       var lastRequesttime: Long)
class RateLimit {

    var startTime = 0L
    var customerToRequestsRecieved : MutableMap<Int, UserRequest> = mutableMapOf<Int, UserRequest>()

    //fun daemon , startTime
    //when ratelimit startTime


    fun rateLimit(customerId:Int,startTime: Long): Boolean {

        var currentTime = Calendar.getInstance().time.time
        //println("currenTime" + currentTime)
        var window  = Math.round( (currentTime-startTime )/ 5000.toDouble()) //Rounding to bottom

        var decider = currentTime >= startTime + (window+1 * 5000)
       // println("window" + window + " decider" + startTime + (window * 5000) + "currentTime > startTime + (window * 5000)" + decider)
        if (decider) {

            customerToRequestsRecieved = mutableMapOf()
        }

        if (customerToRequestsRecieved.containsKey(customerId)) {
            var a = customerToRequestsRecieved.get(customerId)?.count
            var timeStamp  = customerToRequestsRecieved.get(customerId)?.lastRequesttime
            println(a)
            if (a != null && a <= 10 || currentTime < timeStamp!! + 5000) {
                customerToRequestsRecieved.put(customerId, UserRequest(a!! + 1,timeStamp!!))
            } else {
                customerToRequestsRecieved = mutableMapOf()
                return false
            }
        } else {
            customerToRequestsRecieved.put(customerId, UserRequest(1,Calendar.getInstance().time.time))
        }
        return true
    }



}

fun main(args: Array<String>) {

    val s = RateLimit()
    val startTime = Calendar.getInstance().time.time
    println(startTime)
    s.rateLimit(1,startTime)
    s.rateLimit(1,startTime)
    s.rateLimit(1,startTime)
    s.rateLimit(1,startTime)
    s.rateLimit(1,startTime)
    s.rateLimit(1,startTime)
    s.rateLimit(1,startTime)
    s.rateLimit(1,startTime)
    s.rateLimit(1,startTime)
    s.rateLimit(1,startTime)
    s.rateLimit(1,startTime)
    println(s.rateLimit(1,startTime))
    Thread.sleep(5000)

    println(s.rateLimit(1,startTime))
    s.rateLimit(1,startTime)
    s.rateLimit(1,startTime)
    s.rateLimit(1,startTime)
    s.rateLimit(1,startTime)
    s.rateLimit(1,startTime)
    s.rateLimit(1,startTime)
    s.rateLimit(1,startTime)
    s.rateLimit(1,startTime)
    s.rateLimit(1,startTime)
    s.rateLimit(1,startTime)
    println(s.rateLimit(1,startTime))

    //println(s.maxSatisfaction(intArrayOf(5,-2,-3,4,1,9)))
}