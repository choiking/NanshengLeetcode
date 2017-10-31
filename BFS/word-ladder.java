/*
Searching in Set is O(1), while searching in List is O(n);
        h i t                     hit
         /\                        |
        h o t                     hot
       /\                         / \ 
  d o t  l o t                  dot  lot
     /\     /\                   |    |
    d o g  l o g                dog  log
   /\                             \  /
  c o g                           cog
one end BFS. 100ms running time.
this solution uses Queue to store temporary words.
*/


public int ladderLength(String b, String e, List<String> wordList) {
    Set<String> dict = new HashSet<String>(wordList);
        if(!dict.contains(e)){
            return 0;
        }

    if(b.equals(e)) return 1;
    
    Queue<String> q = new LinkedList<String>();
    q.add(b);

    int level = 2;
    
    while(!q.isEmpty()) {
        int sz = q.size();
        
        for(int i = 0; i < sz; i++) {
            String tmp = q.poll();
            //modify each letter of tmp
            for(int j = 0; j< tmp.length(); j++) {
                char[] chars = tmp.toCharArray();
                
                for(char c = 'a'; c <= 'z'; c++) {
                    chars[j] = c;
                    String tmp2 = new String(chars);
                    // Found the end word
                    if(tmp2.equals(e)) return level;
                    // Put it to the queue
                    if(dict.remove(tmp2)) {
                        q.add(tmp2);
                    }
                }
            }
        }
        
        level++;
    }
    
    return 0;
}
