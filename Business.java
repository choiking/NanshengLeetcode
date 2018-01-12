import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Business {
    String id;
    int value;

    public Business(String id, int value) {
        this.id = id;
        this.value = value;
    }

    //1. Find median value in business info
    public int findMedian(List<Business> list) {
        sortListByValue(list);
        if (list.size() % 2 == 0)
            return (list.get(list.size() / 2 - 1).value + list.get(list.size() / 2).value) / 2;

        else
            return list.get(list.size() / 2 + 1).value;
    }

    //3. descending rating of business info
    public List<Business> sortListByValue(List<Business> list) {
        Collections.sort(list, new Comparator<Business>() {
            @Override
            public int compare(Business o1, Business o2) {
                return o1.value - o2.value;
            }
        });
        return list;

    }

    //4. Merge two Sorted(Value) List of Business Info
    public List<Business> mergeList(List<Business> l1, List<Business> l2) {
        List<Business> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < l1.size() && j < l2.size()) {
            if (l1.get(i).value < l2.get(j).value) {
                res.add(l1.get(i));
                i++;
            }
            else {
                res.add(l2.get(j));
                j++;
            }
        }
        while (i < l1.size()) {
            res.add(l1.get(i));
            i++;
        }
        while (j < l2.size()) {
            res.add(l2.get(j));
            j++;
        }
        return res;
    }
    void show(List<Business> l) {
        for (int i = 0; i < l.size(); i++) {
            System.out.print(l.get(i).value + " ");
        }
    }

    public static void main(String args[]) {
        Business b1 = new Business("0000", 900);
        Business b2 = new Business("0001", 850);
        Business b3 = new Business("0001", 870);
        Business b4 = new Business("0000", 830);
        Business b5 = new Business("0001", 820);
        Business b6 = new Business("0001", 790);

        List<Business> l1 = new ArrayList<>();
        l1.add(b1);
        l1.add(b2);
        l1.add(b3);
        l1.add(b4);
        List<Business> l2 = new ArrayList<>();
        l2.add(b4);
        l2.add(b5);
        l2.add(b6);

        int b = b1.findMedian(l1);//should be 860

        System.out.println(b);
        b1.sortListByValue(l1);
        b1.sortListByValue(l2);
        b1.show(b1.mergeList(l1, l2));

    }



}
