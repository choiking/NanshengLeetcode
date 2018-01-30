public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;

        HashMap<Integer, UndirectedGraphNode> visited = new HashMap<>();
        return dfs(node, visited);
    }

    public UndirectedGraphNode dfs(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> visited) {
        if (node == null) return null;
        if (visited.containsKey(node.label)) {
            return visited.get(node.label);//or return null； 这是比较安全的写法。
        }
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        visited.put(clone.label, clone);
        for (UndirectedGraphNode item : node.neighbors) {
            clone.neighbors.add(dfs(item, visited));
        }
        return clone;
    }

