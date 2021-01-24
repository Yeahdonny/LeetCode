import java.util.HashMap;

public class Solution {

    public static int lengthOfLongestSubstring(String s) {
/*      HashMap<Character, Integer> map = new HashMap<>();
        if(s.length() == 0)return 0;
        if(s.length() == 1)return 1;
        int result = 0, count = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(map.containsKey(s.charAt(i))){
                i = map.get(s.charAt(i))+1;
                map.clear();
                if(result < count)
                    result = count;

                count = 0;
            }
            if(count == 0 && s.length()-i+1 <= result)break;
            map.put(s.charAt(i),i);
            count++;
        }
        if(result < count) result = count;
        return result;*/

        char [] chars = s.toCharArray();
        if(s.length()<=1)return s.length();
        int start = 0, res = 1;

        for(int end = 1; end < s.length() ; end++){
            for(int j = start ; j < end ; j++){

                if(chars[end]==chars[j]){
                    start = j+1;
                    break;
                }
            }
            res = Math.max(res, end-start+1);
        }

        return res;
    }
    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(str));
    }
}
