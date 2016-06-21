package contest.week1;

import java.math.BigInteger;

/**
 * Created by ravibol on 4/24/16.
 */
public class XrSeq {
    public static void main(String args[]) {
        long L = 731964916, R = 832420216;

//        long result = 0;
//        for(long j=L; j<=R; j++) {
//            result ^= getValue(j);
//        }
//        System.out.println(result);
//        System.out.println(30 - (30 % 8));
        long result = 0;
        long a = L;
        while(a % 8 > 0) {
            result ^= getValue(a);
            a++;
        }

        for(long j=R - (R%8); j<=R; j++) {
            result ^= getValue(j);
        }
        System.out.println(result);

    }

//    long result = 0;
//    long a = L;
//    while(a % 8 > 0) {
//        result ^= getValue(a);
//        a++;
//    }

//    for(long j=R - R%8; j<=R; j++) {
//        result ^= getValue(j);
//    }

    private static long getValue(long l) {
        long val = 0;
        if(l %4 == 0) {
            val = l;
        } else if(l %4 == 1) {
            val = 1;
        } else if(l % 4 == 2) {
            val = l+1;
        }
        return val;
    }
}
