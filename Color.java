import java.util.*;

public class Color {


    //6. Top Color (most frequently number)
    public List<String> mostColor(List<String> s) {
        Map<String, Integer> map = new HashMap<>();
        for (String item : s) {
            map.put(item, map.getOrDefault(item, 0) + 1);
        }
        int max = 0;
        for (String color : map.keySet()) {
            max = Math.max(max, map.get(color));
        }

        List<String> res = new ArrayList<>();
        for (String color : map.keySet()) {
            if (map.get(color) == max) {
                res.add(color);
            }
        }
        Collections.sort(res);
        return res;

    }



    public static void main(String args[]) {
        String s1[] = {"red", "black", "green", "white", "red", "black", "black", "red"};
        String s2[] = {"red", "black", "green", "white", "red", "black", "black", "red", "green", "red"};
        List<String> l1 = Arrays.asList(s1);
        List<String> l2 = Arrays.asList(s2);

        Color a = new Color();
        List<String> r1 = a.mostColor(l1);
        List<String> r2 = a.mostColor(l2);

        System.out.println(r1);
        System.out.println(r2);


    }
}
