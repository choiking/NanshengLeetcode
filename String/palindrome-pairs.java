/*time O (n * k ^ 2) n the total number of words in the words array and k the average length of each word.
    */
public List<List<Integer>> palindromePairs(String[] words) {
    List<List<Integer>> res = new ArrayList<> ();
    if (words == null || words.length < 2) return res;
    //store all word of words into map
    Map<String, Integer> map = new HashMap<String, Integer> ();
    for (int i = 0; i < words.length; i++) map.put(words[i], i);
    for (int i = 0; i < words.length; i++) {//take n time
        for (int j = 0; j <= words[i].length(); j++) {//take k time
            String s1 = words[i].substring(0, j), s2 = words[i].substring(j);
            if (isPalindrome(s1)) {//case1 "cbc ab" "ba" - > "ba" + "cbc ab"
                String s2Reverse = new StringBuilder(s2).reverse().toString();
                if (map.containsKey(s2Reverse) && map.get(s2Reverse) != i)
                    res.add(new ArrayList<> (Arrays.asList(map.get(s2Reverse), i)));
            }
            if (isPalindrome(s2)) {//case 2 "ab cbc"  "ba" - > "ab cbc" + "ba"
                String s1Reverse = new StringBuilder(s1).reverse().toString();
                if (map.containsKey(s1Reverse) && map.get(s1Reverse) != i && s2.length() != 0)
                    res.add(new ArrayList<> (Arrays.asList(i, map.get(s1Reverse))));
            }
        }
    }
    return res;
}

private boolean isPalindrome(String str) {//take k time
    int left = 0;
    int right = str.length() - 1;
    while (left <= right) {
        if (str.charAt(left++) !=  str.charAt(right--)) return false;
    }
    return true;
}
