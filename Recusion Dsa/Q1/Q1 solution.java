class Solution {
    public int myAtoi(String s) {

        int i = 0, n = s.length();
        int sign = 1;
        long num = 0;

        //Skip leading whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        //Handle sign
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        //Convert digits
        while (i < n && Character.isDigit(s.charAt(i))) {
            num = num * 10 + (s.charAt(i) - '0');

            //Clamp on overflow
            if (sign * num >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign * num <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            i++;
        }
