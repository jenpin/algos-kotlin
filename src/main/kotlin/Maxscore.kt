


class Maxscore {
    fun maxScore(cardPoints: IntArray, k: Int): Int {
        var start = 0 ;
        var end = cardPoints.size -1
        cardPoints.slice(0..1)
        var frontset = cardPoints.take(k)
        var rearSet = cardPoints.takeLast(k)
        var max = cardPoints.take(k).sumBy { it }
        var endSum = cardPoints.takeLast(k).sumBy { it }

        var score =0
        for (i in k-1..0) {

            score = frontset[i] + score

            //maxScore = Math.max(maxScore, currentScore)
        }
        if(endSum >= max)
            max= endSum

        for(i in k downTo 0){
            max= max + cardPoints [i]
        }
        return max
    }
}

fun main(args: Array<String>) {
    var testSubject = Maxscore()
    println(testSubject.maxScore(intArrayOf(1,2,3,4,5,6,1),3)) //[2,3]
}