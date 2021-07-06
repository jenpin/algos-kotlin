import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TwoSum{

    public int[] twoSum(int[] nums, int target) {
        int sum =0;
        int startIndex = 0;


        for (int i =0; i< nums.length; i++) {
            int[] remainder = Arrays.copyOfRange(nums, startIndex, nums.length);
            for (int j = 1; j < remainder.length; j++) {
                if(remainder[0] + remainder[j] == target) {
                    System.out.println("hello");
                    return new int[]{startIndex,j+startIndex};
                }

            }
            startIndex++;
        }
        return new int[0];
    }

    public static void main(String[] args) {
        TwoSum testSubject = new TwoSum();
        int[] result = testSubject.twoSum(new int[]{2,7,11,15},9);
        System.out.println(result[0]+ " yes "+result[1]);
        //[3,2,4]
        result = testSubject.twoSum(new int[]{3,2,4},6);
        System.out.println(result[0]+ " yes "+result[1]);
    }
}

