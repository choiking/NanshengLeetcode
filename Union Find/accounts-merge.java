class Solution {
    //it is like a Quick union
    //sites don't include account name
    public List<List<String>> accountsMerge(List<List<String>> acts) {
        Map<String, String> owner = new HashMap<>();
        Map<String, String> parents = new HashMap<>();
        Map<String, TreeSet<String>> unions = new HashMap<>();//store<root, sorted emails list>
        //assign all sites' parent to itself
        //assign all sites' owner to account name
        for (List<String> a : acts) {
            for (int i = 1; i < a.size(); i++) {
                parents.put(a.get(i), a.get(i));
                owner.put(a.get(i), a.get(0));
            }
        }
        //assign all sites' parent to its root.
        for (List<String> a : acts) {
            String root = find(a.get(1), parents);//find the root
            for (int i = 2; i < a.size(); i++)
                 union(a.get(i), root, parents);//assign all emails's parent to first email
        }
        //union
        for(List<String> a : acts) {
            String root = find(a.get(1), parents);//find root
            if (!unions.containsKey(root)) unions.put(root, new TreeSet<>());
            for (int i = 1; i < a.size(); i++)
                unions.get(root).add(a.get(i));
        }
        //store value into res
        List<List<String>> res = new ArrayList<>();
        for (String root : unions.keySet()) {
            List<String> emails = new ArrayList(unions.get(root));
            emails.add(0, owner.get(root));
            res.add(emails);
        }
        return res;
    }
    //union
    public void union(String p, String q, Map<String, String> parents) {
        String rootP = find(p, parents);
        String rootQ = find(q, parents);
        parents.put(rootP, rootQ);
    }
    //find the root.
    private String find(String s, Map<String, String> p) {
        return p.get(s) == s ? s : find(p.get(s), p);
    }
}