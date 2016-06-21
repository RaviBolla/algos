package puzzles;

import java.util.*;

/**
 * Created by ravibol on 4/20/16.
 */
public class PairMatrix {

    public static void main(String args[]) {
        char[] mems = {'A', 'B', 'C', 'D', 'E', 'F'};
        int noOfPairs = ((mems.length - 1) * mems.length) / 2;
        ArrayList<Pair> pairs = new ArrayList<Pair>();
        for(int i=0; i < mems.length -1; i++) {
            for(int j=i+1; j <mems.length; j++) {
                if(i != j) {
                    pairs.add(new Pair(mems[i], mems[j]));
                }
            }
        }
//        System.out.println(pairs);

        Pair[][] pairMatrix = new Pair[mems.length/2][mems.length-1];
        for(Pair pair: pairs) {
            boolean inserted = false;
//            for(int i=0; i < mems.length -1; i++) {
//                for(int j=0; j< mems.length/2; j++) {
//                    System.out.print(pairMatrix[j][i] + " ");
//                }
//                System.out.println("");
//            }
            while(!inserted) {
                for(int i=0; i< mems.length/2; i++) {
                        for(int j=0; j< mems.length-1; j++) {
                            if(pairMatrix[i][j] == null) {
                                pairMatrix[i][j] = pair;
                                Pair currentPair = pair;
                                inserted = true;
                                boolean br = false;
                                for(int k=i-1; k>=0; k--) {
//                                    if(currentPair.equals(new Pair('B', 'C'))) {
//                                        System.out.print("s " + pairMatrix[k][j]);
//                                    }
                                    if(currentPair.equals(pairMatrix[k][j]) ) {
                                        pairMatrix[i][j] = null;
                                        inserted = false;
//                                        System.out.print("y " + inserted);
                                        br = true;
                                        break;
                                    }
                                }
                                if(inserted) break;
                            }
                        }
                        if(inserted) break;
                    }
            }

        }


//        Pair[][] pairMatrix = new Pair[mems.length-1][mems.length/2];
//        for(int i=0; i< mems.length-1; i++) {
//            pairMatrix[i][0] = new Pair(mems[0], mems[i+1]);
//        }
//        int size = mems.length -1;
//
//        for(int x=1; x<mems.length-1; x++) {
//            for(int y=2; y<mems.length; y++) {
//                Pair pair = new Pair(mems[x], mems[y]);
//                for(int j=1; j< mems.length/2; j++) {
//                    for(int i=0; i< mems.length -1; i++) {
//                        Pair currentPair = pairMatrix[i][j];
//                        if(currentPair != null) {
//                            for(int k=j-1; k>0; k--) {
//                                if(! currentPair.equals(pairMatrix[i][k])) {
//                                    pairMatrix[j][i] = pair;
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        int length = 0;
//        ArrayList<Set<Pair>> pairMatrix = new ArrayList<>();
//        while(pairMatrix.size() < mems.length - 1) {
//            Set<Pair> day = new HashSet<Pair>();
//            pairMatrix.add(day);
//        }
//        int size = 0;
//        while(size < noOfPairs) {
//            for(Set<Pair> day: pairMatrix) {
//                for(int i=0; i<pairs.size(); i++) {
//                    Pair pair = pairs.get(i);
//                    if(pair != null) {
//                        if(day.add(pair)) {
//                            pairs.set(i, null);
//                            size++;
//                            break;
//                        }
//                    }
//                }
//            }
//            System.out.println(pairMatrix);
//        }
        for(int i=0; i < mems.length -1; i++) {
            for(int j=0; j< mems.length/2; j++) {
                System.out.print(pairMatrix[j][i] + " ");
            }
            System.out.println("");
        }
//        System.out.println(pairMatrix);

    }

//    public static void main(String[] args)
//    {
//        new PairMatrix().generate(6);
//    }
//
//    public void generate (int n) {
//        int[] covered = new int[n];
//        int[] list = new int[n];
//        for (int i = 0; i < n; i++) {
//            covered[i] = 0;
//        }
//        this.generate(n, covered, 0, list);
//    }
//    private void generate (int n, int[] covered, int i, int[] list) {
//        int j = 0;
//        while ((j < n) && (covered[j] == 1)) {
//            j++;
//        }
//        if (j == n) {
//            System.out.println(Arrays.toString(list));
//            return;
//        }
//        covered[j] = 1;
//        for (int k = 0; k < n; k++) {
//            if (covered[k] == 0) {
//                covered[k] = 1;
//                list[i++] = j;
//                list[i++] = k;
//                this.generate(n, covered, i, list);
//                i -= 2;
//                covered[k] = 0;
//            }
//        }
//        covered[j] = 0;
//    }


}
