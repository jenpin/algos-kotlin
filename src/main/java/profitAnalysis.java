import java.util.Arrays;
import java.util.List;

public class profitAnalysis {

    int countlongestPeriodProfit(List<Integer> input){
        int max = 0;
        int currentMax =0;
        for(Integer element:input){
             if(element==1){
                 currentMax++;
             }else{
                 if(currentMax>max){
                     System.out.println(" current max "+ currentMax + " max "+ max);
                     max = currentMax;
                     currentMax = 0;
                 }
             }
        }
         if(currentMax>max)return currentMax; else return max;
    }

    List<String> longestMonths(List<Integer> input,List<String> months){
        int start=0,end =input.size();
        int counter =0 ,max =0;
        for(int index=0; index<input.size(); index++){
            if(input.get(index) ==1){
                counter++;
            }else {
                if(counter > max ){
                    max =counter;
                    counter = 0 ;
                    end = index;
                }
            }

        }
        if(counter > max ) max =counter;
        System.out.println(" end "+ end + " max " +max);
        return Arrays.asList(months.get(end-max),months.get(end));
    }

    public static void main(String[] args) {
        profitAnalysis testSubject = new profitAnalysis();
        System.out.println(testSubject.countlongestPeriodProfit(Arrays.asList(1, 0, 1, 1, 0, 1, 1, 1, 0, 1))== 3);
        //(1,0,1,1,1,1,1,1,0))
//        System.out.println(testSubject.countlongestPeriodProfit(Arrays.asList(1,0,1,1,1,1,1,1,0))== 6);
//        System.out.println(testSubject.countlongestPeriodProfit(Arrays.asList(0,0))== 0);
//        System.out.println(testSubject.countlongestPeriodProfit(Arrays.asList(1,1))== 2);

        List<String> months = Arrays.asList("Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct");
        System.out.println(testSubject.longestMonths(Arrays.asList(1, 0, 1, 1, 0, 1, 1, 1, 0, 1),months));
        System.out.println(testSubject.longestMonths(Arrays.asList(1,0,1,1,1,1,1,1,0),months));
        System.out.println(testSubject.longestMonths(Arrays.asList(1,1,1,1,1,1,1),months));
    }
}

