import java.util.*;

public class Brackets {

    public boolean isValid(String inputString) {
        Map<String,String> fixed = new HashMap<String,String>();
        fixed = Collections.synchronizedMap(fixed);
        fixed.putIfAbsent("}","{");
        fixed.put("}","{");
        fixed.put(")","(");
        fixed.put("]","[");

        Stack<String> input = new Stack<>();
        for (int i = 0; i <inputString.length() ; i++) {
            String element = Character.toString(inputString.charAt(i));
            //System.out.println("current " + element);

            if(Arrays.asList("{","(","[").contains(element)){
                input.push(element);
            }else{
               // System.out.println("input.peek() " + input.peek() + " fixed.get(element) " + fixed.get(element));
                if(input.size()!=0 && fixed.get(element).equals(input.peek())) {
                    //System.out.println(" input.peek " + input.peek() + " input.size " + input.size());
                    input.pop();
                }
                else return false;
            }

        }

        return input.size() ==0 ;
    }

    public static void main(String[] args) {
        //map key value  }=>{
        //if (,{,[ push onto stack
        //else if stack.pop.value matches element continue else return false

        Brackets testSubject = new Brackets();
        //System.out.println(Arrays.asList("{","(","[").contains("("));
        System.out.println(testSubject.isValid("()[]") == true);
        System.out.println(testSubject.isValid("(]") == false);
        System.out.println(testSubject.isValid("(") == false);
        System.out.println(testSubject.isValid(")") == false);

    }
}
