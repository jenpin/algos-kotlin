import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class NumberPalindrome {

    public boolean isPalindrome(int x) {
        String a = String.valueOf(x);
        int length = a.length()/2;
        System.out.println("quotient " + length);
        if(length == 0) return true;

        String side1 = a.substring(0,length-1);
        String side2 = a.substring(length);
        System.out.println("side1 " + side1 + "side2 "+ side2);
        String expected = new StringBuilder(side2).reverse().toString();
        return side1.equals(expected);
    }

    public static void main(String[] args) {
        NumberPalindrome testSubject = new NumberPalindrome();
        //System.out.println(testSubject.isPalindrome(12) == false);
        System.out.println(testSubject.isPalindrome(121) == true);
//        System.out.println(testSubject.isPalindrome(-121) == false);
//        System.out.println(testSubject.isPalindrome(0) == false);
//
//        System.out.println(testSubject.isPalindrome(123321) == true);
    }

    public boolean isPalindrome2(int x) {
        String a = String.valueOf(x);
        for (int i = 0; i < a.length(); i++) {
            int end = a.length()-i-1;
            // System.out.println("a.charAt(i) == a.charAt(end)" + a.charAt(i) + a.charAt(end));
            if( a.charAt(i) == a.charAt(end)) return true;
        }
        return false;
    }

    public boolean isPalindrome1(int x) {
        Stack<String> input = new Stack();

        if(x<0) {
            input.push("-");
        }
        int number = Math.abs(x);
        while (number > 0) {
            System.out.println("x%10 "+ number%10);
            input.push(String.valueOf(number % 10));
            number = number / 10;
        }
        System.out.println(input.toArray());

//        int b = input.size();
//        List<String> sb = new ArrayList<String>();
//        for(int i = 0; i< b;i++){
//            String a = input.pop();
//            sb.add(a);
//        }
        String numberString = input.stream().map(String::valueOf)
                .collect(Collectors.joining(""));

        System.out.println("string buffer "+ numberString + " x"+ x);

        //if(isNegative) numberString = numberString+"-";
        System.out.println("number String " + numberString);
        System.out.println("numberString.equals(String.valueOf(x))" + numberString.equals(String.valueOf(x)));

        return numberString.equals(String.valueOf(x));
    }
}
