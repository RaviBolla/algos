package rangequery;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ravibol on 6/22/16.
 */
public class SegmentTreeTest {
    SegmentTree segmentTree;
    static int[] elementsArray = {3, 7, 9, 2, 15, 93, 45, 12, 20};
    @Before
    public void setup() {
        segmentTree = new SegmentTree(elementsArray);
    }

    public int calculateSum(int start, int end) {
        int sum = 0;
        for(int i=start-1; i<end; i++) {
            sum += elementsArray[i];
        }
        return sum;
    }

    @Test
    public void testFullRange() {
        Assert.assertEquals(calculateSum(1, 9), segmentTree.query(1, 9));
    }

    @Test
    public void testSingleRange() {
        Assert.assertEquals(calculateSum(4, 4), segmentTree.query(4, 4));
    }

    @Test
    public void testRandomRange1() {
        Assert.assertEquals(calculateSum(2, 4), segmentTree.query(2, 4));
    }

    @Test
    public void testRandomRange2() {
        Assert.assertEquals(calculateSum(1, 8), segmentTree.query(1, 8));
    }

    @Test
    public void testRandomRange3() {
        Assert.assertEquals(calculateSum(8, 9), segmentTree.query(8, 9));
    }

    @Test
    public void testRangeWithUpdate1() {
        segmentTree.update(1, 8);
        Assert.assertEquals(calculateSum(1, 5) + 5, segmentTree.query(1, 5));
    }

    @Test
    public void testRangeWithUpdate2() {
        segmentTree.update(1, 8);
        Assert.assertEquals(calculateSum(2, 4), segmentTree.query(2, 4));
    }

    @Test
    public void testRangeWithUpdate3() {
        segmentTree.update(9, 12);
        Assert.assertEquals(calculateSum(3, 9) - 8, segmentTree.query(3, 9));
    }

    @Test(expected=IllegalArgumentException.class)
    public void testRangeStartGTEnd() {
        segmentTree.query(9, 8);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testRangeStartNotInRange() {
        segmentTree.query(0, 8);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testRangeEndNotInRange() {
        segmentTree.query(1, 10);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testRangeNotInRange() {
        segmentTree.query(-1, 10);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testRangeEndNegativeRange() {
        segmentTree.query(5, -1);
    }
}
