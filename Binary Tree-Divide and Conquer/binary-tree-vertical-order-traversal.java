/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//two treemap solution
public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<> ();
        if (root == null) return res;
        //use treeMap so keys(col) and values(row) can be sorted automatically (<col, <row, list>>)
        Map<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
        helper(root, map, 0, 0);//treat root node as position (0, 0)


        for (int i : map.keySet()) {
            List<Integer> list = new ArrayList<>();
            TreeMap<Integer, List<Integer>> colMap = map.get(i);
            for (List<Integer> j : colMap.values()) {
                list.addAll(j);
            }
            res.add(list);
        }

        return res;
    }


    //whatever Traversal is OK as long as left goes before right

    public void helper(TreeNode root, Map<Integer, TreeMap<Integer, List<Integer>>> map, int row, int col) {
        if (root == null) return;
        //store value
        TreeMap<Integer, List<Integer>> colMap = map.getOrDefault(col, new TreeMap<> ());
        List<Integer> list = colMap.getOrDefault(row, new ArrayList<> ());
        list.add(root.val);
        colMap.put(row, list);
        map.put(col, colMap);

        helper(root.right, map, row + 1, col + 1);
        helper(root.left, map, row + 1, col - 1);
    }


















    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> q = new LinkedList<> ();
        Queue<Integer> cols = new LinkedList<> ();
        Map<Integer, ArrayList<Integer>> map = new HashMap<> ();
        q.offer(root);
        cols.offer(0);
        int min = 0, max = 0;
        //When q is doing BFS (from top to down,maintain cols and map at the same time)
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            int col = cols.poll();
            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<Integer> ());
            }
            map.get(col).add(node.val);
            if (node.left != null) {
                q.offer(node.left);
                cols.offer(col - 1);
                min = Math.min(min, col - 1);
            }
            if (node.right != null) {
                q.offer(node.right);
                cols.offer(col + 1);
                max = Math.max(max, col + 1);
            }
        }
        for (int i = min; i <= max; i++) {
            res.add(map.get(i));
        }
        return res;





    //There is no difference when using HashMap. Since by using HashMap it need keep track of min and max as well, I’d rather directly insert into list by computing min and max in advance.
    private int min = 0, max = 0;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null)    return list;
        computeRange(root, 0);
        for(int i = min; i <= max; i++) list.add(new ArrayList<>());
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> idx = new LinkedList<>();
        idx.add(-min);
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            int i = idx.poll();
            list.get(i).add(node.val);
            if(node.left != null){
                q.add(node.left);
                idx.add(i - 1);
            }
            if(node.right != null){
                q.add(node.right);
                idx.add(i + 1);
            }
        }
        return list;
    }
    private void computeRange(TreeNode root, int idx){
        if(root == null)    return;
        min = Math.min(min, idx);
        max = Math.max(max, idx);
        computeRange(root.left, idx - 1);
        computeRange(root.right, idx + 1);
    }







    /*
    DFS preorder just record every node's depth and col, and then print it out
    */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        //edge case
        List<List<Integer>> res = new ArrayList<> ();
        if (root == null) return res;
        //compute range
        int[] minmax = new int[3];
        computeRange(root, 0, 1, minmax);
        //we use arraylist because there may be more than one node in same position
        ArrayList<Integer>[][] map = new ArrayList[minmax[2]][minmax[1] - minmax[0] + 1];
        for (int i = 0; i < map.length; i++)
            for (int j = 0; j < map[0].length; j++)
                map[i][j] = new ArrayList<>();
        //record every node's depth and col
        dfs(root, minmax[0], 1, 0, map);
        //print it out
        for (int i = 0; i < map[0].length; i++) {//every col
            res.add(new ArrayList<>());
            for (int j = 0; j < map.length; j++) {//every depth
                if (!map[j][i].isEmpty())
                    res.get(i).addAll(map[j][i]);
            }
        }
        return res;
    }
    private void computeRange(TreeNode root, int col, int depth, int[] minmax){
        if(root == null)    return;
        minmax[0] = Math.min(col, minmax[0]);
        minmax[1] = Math.max(col, minmax[1]);
        minmax[2] = Math.max(depth, minmax[2]);
        computeRange(root.left, col - 1, depth + 1, minmax);
        computeRange(root.right, col + 1, depth + 1, minmax);
    }
    void dfs(TreeNode node, int l, int depth, int col, ArrayList<Integer>[][] map) {
        if (node == null) return;
        map[depth - 1][col - l].add(node.val);
        dfs(node.left, l, depth + 1, col - 1, map);
        dfs(node.right, l, depth + 1, col + 1, map);
    }
}
