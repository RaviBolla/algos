package rangequery;

public class BIT {

    int[] bitArray;
    int length = 0;
    public BIT(int[] elementsArray) {
        this.length = elementsArray.length+1;
        this.bitArray = new int[this.length];
        for(int i=0; i< this.length-1; i++) {
            buildArray(i+1, elementsArray[i]);
        }
    }

    public void update(int index, int value) {
        int prevValue = query(index, index);
        int diff = value - prevValue;
        buildArray(index, diff);
    }

    private void buildArray(int index, int value) {
        while(index < this.length) {
            this.bitArray[index] += value;
            index += (index & -index);
        }
    }

    public int query(int start, int end) {
        if(start <1 || end > this.length -1 || start > end) {
            throw new IllegalArgumentException("invalid input");
        }
        return query(end) - query(start-1);
    }

    private int query(int end) {
        int result = 0;
        while(end > 0) {
            result += bitArray[end];
            end ^= (end & -end);
//            end -= (end & -end);
        }
        return result;
    }

}
