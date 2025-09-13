public class ZigzagConversion {
    public class Solution {
        public String convert(String s, int numRows) {
            if(numRows == 1 || s.length() <= numRows) return s;
            StringBuilder[] lines = new StringBuilder[numRows];
            StringBuilder result = new StringBuilder();
            int cycleLength = 2 * (numRows - 1);
            for(int row = 0; row < numRows; row++){
                lines[row] = new StringBuilder();
                for(int i = 0; row + i < s.length() ; i += cycleLength){
                    lines[row].append(s.charAt(row + i));
                    if(row != 0 && row != numRows - 1 && i + cycleLength - row < s.length()){
                        lines[row].append(s.charAt(i + cycleLength - row));
                    }
                }
                result.append(lines[row]);
            }
            return result.toString();
        }
    }
}