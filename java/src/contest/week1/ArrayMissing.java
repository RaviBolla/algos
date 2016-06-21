package contest.week1;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ravibol on 4/24/16.
 */
public class ArrayMissing {
    public static void main(String args[]) {
        int a[] = {101, 103, 102, 104, 101, 102};
        int b[] = {101, 103, 102, 104, 102, 101, 103, 104};
        Map<Integer, Integer> count = new HashMap<>();
        for(int key: a) {
            int value = 1;
            if(count.containsKey(key)) {
                value = count.get(key) + 1;
            }
            count.put(key, value);
        }
        for(int key1: b) {
            if(count.containsKey(key1)) {
                int value = count.get(key1) -1;
                if(value == 0) {
                    count.remove(key1);
                } else {
                    count.put(key1, value);
                }
            } else {
                System.out.print(key1 + " ");
            }
        }
    }
}
