public class Reverse {

    public int reverse(int x){
        boolean isNegative = false;
        if(x < 0 ) isNegative = true;
        double limit = Math.pow(2,31);
        int result = 0;
        if( x > -limit && x < limit){
            result = Integer.parseInt(new StringBuilder(Math.abs(x)).reverse().toString());
        }
        return  isNegative ? -result : result ;
    }
    public static void main(String[] args) {
        Reverse testSubject = new Reverse();
        char[] a = Integer.toString(123).toCharArray();
        System.out.println(a[0]);
        String sb = new StringBuilder(321).reverse().toString();
        System.out.println(testSubject.reverse(964632435) == 321);

    }
}
