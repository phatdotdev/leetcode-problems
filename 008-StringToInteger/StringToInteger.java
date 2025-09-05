
public class StringToInteger {
    public int myAtoi(String s) {
        int current = 0, length = s.length();
        while(current < length && s.charAt(current) == ' '){
            current++;
        }
        if(current >= length) return 0;
        int sign = 0;
        if(s.charAt(current) == '+'){
            sign = 1;
            current++;
        } else if(s.charAt(current) == '-'){
            sign = -1;
            current++;
        }
        int result = 0, negativeLimit = Integer.MIN_VALUE, positiveLimit = Integer.MAX_VALUE;
        while(current < length && s.charAt(current) >= '0' && s.charAt(current) <= '9'){
            int digit = s.charAt(current) - '0';
            if(result > positiveLimit / 10) return sign == -1 ? negativeLimit : positiveLimit;
            if(result == positiveLimit / 10 && digit >= (sign == -1 ? 8: 7)) return sign == -1 ? negativeLimit : positiveLimit;
            result = result * 10 + digit;
            current++;
        }

        return sign == -1 ? -result: result;
    }
    public static void main(String[] args){
        StringToInteger sti = new StringToInteger();
        int value = sti.myAtoi("\" + 431\"");
        System.out.println("value: "+value);
    }
}
