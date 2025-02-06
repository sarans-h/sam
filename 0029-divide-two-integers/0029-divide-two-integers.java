class Solution {
    public int divide(int dividend, int divisor) {
          if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE; // Clamp to 2^31 - 1
        }
        if (dividend == Integer.MIN_VALUE && divisor == 1) {
            return Integer.MIN_VALUE; // Clamp to -2^31
        }
         if (dividend == divisor) return 1;
        boolean isNeg = (dividend < 0) ^ (divisor < 0);
        long newdividend=Math.abs((long)dividend);
        long newdivisor=Math.abs((long)divisor);
        int quotient=0;
        while(newdividend>=newdivisor){
            long temp=newdivisor;
            long multiplier=1;
            while(newdividend>=(temp<<1)){
                temp<<=1;
                multiplier<<=1;
            }
            newdividend-=temp;
            quotient+=multiplier;


        }
        return isNeg?-quotient:quotient;
    }
}