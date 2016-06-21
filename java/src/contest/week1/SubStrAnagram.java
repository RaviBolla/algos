package contest.week1;

import java.util.Arrays;

/**
 * Created by ravibol on 4/24/16.
 */
public class SubStrAnagram {
    public static void main(String args[]) {
        String a1 = "abba";
        String a2 = "abcd";
        anagramCount(a2.substring(0, 1), a2.substring(1), 0);
    }
    private static int anagramCount(String first, String second, int count) {
        int cnt = count;
        System.out.println(first);
        System.out.println(second);
        char[] chars = second.toCharArray();
        Arrays.sort(chars);
        return cnt;
    }
}
