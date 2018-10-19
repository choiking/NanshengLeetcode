/*
    time complexity: O (len1 + (len2 - len1) * 26)
    space : O (1)
 .  sliding window, record frequency of every letter
    */
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] win1 = new int[26];
        int[] win2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            win1[s1.charAt(i) - 'a']++;
            win2[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (match(win1, win2))
                return true;
            win2[s2.charAt(i + s1.length()) - 'a']++;
            win2[s2.charAt(i) - 'a']--;
        }
        return match(win1, win2);
    }

    public boolean match(int[] win1, int[] win2) {
        for (int i = 0; i < 26; i++) {
            if (win1[i] != win2[i])
                return false;
        }
        return true;
    }




    public boolean checkInclusion(String s1, String s2) {
        s1 = sort(s1);
        System.out.println(s1);
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            if (s1.equals(sort(s2.substring(i, i + s1.length())))) {
                System.out.println(s2.substring(i, i + s1.length()));
                return true;
            }
        }
        return false;
    }

    public String sort(String s) {
        char[] t = s.toCharArray();
        Arrays.sort(t);
        return new String(t);
    }
