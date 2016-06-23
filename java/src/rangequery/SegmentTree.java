package rangequery;

/**
 * Created by ravibol on 6/22/16.
 */
public class SegmentTree {

    private int[] segmentArray;
    int length;
    public SegmentTree(int[] elementsArray) {
        this.length = 2*elementsArray.length;
        this.segmentArray = new int[this.length];
        buildSegment(elementsArray, 1, this.length/2, 1);
    }

    public int buildSegment(int[] elementsArray, int segStart, int segEnd, int segIndex) {
        if(segStart == segEnd) {
            this.segmentArray[segIndex] = elementsArray[segStart-1];
            return this.segmentArray[segIndex];
        }
        int mid = (segStart + segEnd) /2;
        int leftSum = buildSegment(elementsArray, segStart, mid, segIndex *2);
        int rightSum = buildSegment(elementsArray, mid+1, segEnd, (segIndex *2) + 1);
        this.segmentArray[segIndex] = leftSum + rightSum;
        return this.segmentArray[segIndex];
    }

    public void update(int index, int value) {
        int diff = value - query(index, index);
        updateArray(index, diff, 1, this.length/2);

    }

    private void updateArray(int index, int diff, int segIndex, int segLength) {
        if(segIndex < this.length) {
            this.segmentArray[segIndex] += diff;
            segLength = segLength - (segLength/2);
            if (index <= segLength) {
                updateArray(index, diff, segIndex * 2, segLength);
            } else {
                updateArray(index, diff, (segIndex * 2) + 1, segLength);
            }
        }
    }

    public void display() {
        for(int a: segmentArray) {
            System.out.print(a + ", ");
        }
    }

    public int query(int start, int end) {
        if(start <1 || end > this.length/2 || start > end) {
            throw new IllegalArgumentException("invalid input");
        }
        return getSum(start, end, 1, this.length/2, 1);
    }

    private int getSum(int start, int end, int segStart, int segEnd, int segIndex) {
        if(start <= segStart && end >= segEnd) {
            return this.segmentArray[segIndex];
        }
        if(start > segEnd || end < segStart) {
            return 0;
        }

        int mid = (segStart + segEnd)/2;
        return getSum(start, end, segStart, mid, segIndex*2) + getSum(start, end, mid+1, segEnd, (segIndex*2)+1);
    }

    public static void main(String args[]) {
        int[] elementsArray = {4, 3, 8, 9, 12};
        SegmentTree segmentTree = new SegmentTree(elementsArray);
        segmentTree.update(1, 8);
        segmentTree.display();
    }
}

