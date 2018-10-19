public String alienOrder(String[] words) {
        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            adj.add(new HashSet<Integer>());
        }
        int[] inDegree = new int[26];//how many nodes in
        Arrays.fill(inDegree, -1);

        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {//set indegree as 0 for node which is contains in this words;
                if (inDegree[c - 'a'] < 0) {
                    inDegree[c - 'a'] = 0;
                }
            }

            if (i > 0) {
                String curr = words[i - 1], next = words[i];
                int len = Math.min(curr.length(), next.length());
                for (int j = 0; j < len; j++) {
                    int c1 = curr.charAt(j) - 'a';
                    int c2 = next.charAt(j) - 'a';
                    if (c1 != c2) {//wrt  ert  ->  w - e
                        if (!adj.get(c1).contains(c2)) {
                            adj.get(c1).add(c2);
                            inDegree[c2]++;
                        }
                        break;
                    } else {//c1 == c2
                        //baa ba is not valid
                        if (j == curr.length() - 1 && curr.length() > next.length()) {
                            return "";
                        }
                    }
                }
            }
        }
        //collects all nodes which inDegree is 0
        Queue<Integer> q = new LinkedList<> ();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int i = q.poll();
            sb.append((char) ('a' + i));//append all nodes with inDegree = 0;
            for (int j : adj.get(i)) {
                inDegree[j]--;
                if (inDegree[j] == 0) {
                    q.add(j);
                }
            }
        }

        for (int d : inDegree) {
            if (d > 0) {
                return "";
            }
        }

        return sb.toString();

    }
