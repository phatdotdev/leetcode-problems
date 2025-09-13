
public class LongestCommonPrefix {
     public String longestCommonPrefix(String[] strs) {
        if(strs == null) return "";
        StringBuilder prefix = new StringBuilder(strs[0]);
        for(int i = 1; i < strs.length; i++){
            while(prefix.length() > strs[i].length() || strs[i].indexOf(prefix.toString()) != 0){
                prefix.setLength(prefix.length()-1);
            }
            if(prefix.length() == 0) return "";
        }
        return prefix.toString();
    }
}
