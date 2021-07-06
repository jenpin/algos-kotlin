import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddTwoNumbers {
    public int[] twoSum(int[] nums, int target) {

        int[] result = new int[]{-1};
        for(int index = 0; index< nums.length; index++){
            if(target == nums[index])
                result[0]=index;
        }
        return result;
    }

    public static void main(String[] args) {
        AddTwoNumbers testSubject = new AddTwoNumbers();
        int arrayInt[] = new int [] {1,2,3};
       // testSubject.twoSum(arrayInt,6);
        System.out.println(testSubject.twoSum(arrayInt,3)[0] == 2);
        System.out.println(testSubject.twoSum(arrayInt,4)[0] == -1);
        System.out.println(testSubject.twoSum(new int[0],4)[0] == -1);
    }
}