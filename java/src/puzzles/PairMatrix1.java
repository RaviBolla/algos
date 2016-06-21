package puzzles;

import java.util.*;

/**
 * Created by ravibol on 4/21/16.
 */
public class PairMatrix1 {
    public static <T> List<Set<List<T>>> roundRobin(List<T> members) {

        int numMems = members.size();

        // For a proper league, we only allow even number of members.
        if ( numMems % 2 != 0 ) {
            throw new IllegalArgumentException("Number of members not even " + numMems);
        }

        List<Set<List<T>>> result = new ArrayList<>(numMems - 1);


        // Implement the round robin by rotating the right side of the list
        // every time, then pairing opposite members. Note that the first
        // item is not part of the rotation.
        for ( int i = 0; i < numMems - 1; i++ ) {
            Collections.rotate(members.subList(1,numMems), 1);
            Set<List<T>> bucket = new HashSet<>();
            for ( int j = 0; j < numMems / 2; j++ ) {
                bucket.add(Arrays.asList(members.get(j), members.get(numMems - j - 1)));
            }
            result.add(bucket);
        }
        return result;
    }
    public static void main(String args[]) {
        List<String> mems = Arrays.asList("A", "B", "C", "D", "E", "F");

        for ( Set<List<String>> bucket : roundRobin(mems)) {
            for ( List<String> pair : bucket) {
                System.out.print(pair);
            }
            System.out.println();
        }
    }
}
