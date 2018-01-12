import java.util.*;

public class Restaurant {





    private int id;
    private List<String> category;

    public Restaurant() {}
    public Restaurant(int id, String[] category) {
        this.id = id;
        this.category = Arrays.asList(category);
    }


    //2. Minimum Index Sum of Two Lists
    public String findR2(List<String> s1, List<String> s2) {
        if (s1.size() == 0 || s2.size() == 0) {
            return "yelpwhich";
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s2.size(); i++) {
            map.put(s2.get(i), i);
        }
        List<Integer> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < s1.size(); i++) {
            if (map.containsKey(s1.get(i))) {
                int j = map.get(s1.get(i));
                if (i + j < min) {
                    min = i + j;
                    list.clear();
                    list.add(i);
                }
                else if (i + j == min) {
                    list.add(i);
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            res.append(s1.get(list.get(i)));
        }
        if (res.equals("")) {
            return "yelpwhich";
        }
        return res.toString();
    }

    //5. Find Common contain both A and B in Business Info
    public List<Restaurant> findR5(List<Restaurant> restaurants, String A, String B) {
        if (restaurants.size() == 0) {
            return restaurants;
        }
        List<Restaurant> res = new ArrayList<>();
        for (int i = 0; i < restaurants.size(); i++) {
            List<String> cate = restaurants.get(i).category;
            if (cate.contains(A) && cate.contains(B)) {
                res.add(restaurants.get(i));
            }
        }
        return res;
    }

    public static void main(String args[]) {
        //2
        String ss1[] = {"EI", "Japa", "Eatsa"};
        String ss2[] = {"Japa", "Eatsa", "Ayola", "Work"};
        List<String> s1 = Arrays.asList(ss1);
        List<String> s2 = Arrays.asList(ss2);
        Restaurant r = new Restaurant();
        String result = r.findR2(s1, s2);
        System.out.println(result);

        //5
        String ca1[] = {"japanese", "sushi", "restaurant"};
        String ca2[] = {"japanese", "seafood"};
        String ca3[] = {"japanese", "ramen", "restaurant"};
        Restaurant ra[] = {new Restaurant(101, ca1), new Restaurant(102, ca2), new Restaurant(103, ca3)};
        List<Restaurant> restaurants = Arrays.asList(ra);
        String A = "japanese";
        String B = "restaurant";
        List<Restaurant> result5 = r.findR5(restaurants, A, B);
        for(int i = 0; i < result5.size(); i++) {
            System.out.println(result5.get(i).id);
        }
    }


}
