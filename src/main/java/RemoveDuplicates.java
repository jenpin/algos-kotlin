import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {

        List<Integer> inputlist = new ArrayList<>(nums.length);
        for (int val : nums) {
            inputlist.add(val);
        }
        Collections.sort(inputlist);
        int limit = inputlist.size();
        for (int i = 0; i < limit ; i++) {
            if(i+1<limit){
                if(inputlist.get(i) == inputlist.get(i+1)){
                    inputlist.set(i,-1);
                }
            }

        }
        List<Integer> result = inputlist.stream().filter(i->i !=-1).collect(Collectors.toList());
        inputlist = result;
        inputlist.forEach(System.out::println);

        return inputlist.size();
    }

    public static void main(String[] args) {
        RemoveDuplicates testSubject = new RemoveDuplicates();
        System.out.println(testSubject.removeDuplicates(new int[]{2,1,2,2}) == 2);
        System.out.println(testSubject.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}) == 5);
        System.out.println(testSubject.removeDuplicates(new int[]{1,1,2}) == 2);

    }
}
