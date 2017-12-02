/*

  second DP

   a a a a a a a.  ["aaaa", "aaa"];
       t t     t 
  
  first DP
   
   a a a a a a a.  ["aaaa", "aaa"];
       t t     t 


*/

public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        
        boolean[] f = new boolean[s.length() + 1];
        
        f[0] = true;
        
        
        /* First DP
        for(int i = 1; i <= s.length(); i++){
            for(String str: dict){
                if(str.length() <= i){
                    if(f[i - str.length()]){
                        if(s.substring(i-str.length(), i).equals(str)){
                            f[i] = true;
                            break;
                        }
                    }
                }
            }
        }*/
        

        //Second DP
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && dict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }
        
        return f[s.length()];
    }
}

public boolean wordBreak(String s, List<String> wordDict) {   
        boolean[] f = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (String str : wordDict) {
                if (i - str.length() == -1 || (i >= str.length() && f[i - str.length()])) {
                    if (s.substring(i - str.length() + 1, i + 1).equals(str)) {
                        f[i] = true;
                        break;
                    }
                }
            }
        }
        return f[s.length() - 1];
    }






