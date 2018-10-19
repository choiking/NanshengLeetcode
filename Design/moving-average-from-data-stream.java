//The idea is to keep the sum so far and update the sum just by replacing the oldest number with the new entry.

public class MovingAverage {
    private int [] window;
    private int n, insert;
    private long sum;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        window = new int[size];
        insert = 0;//the oldest number position
        sum = 0;
    }

    public double next(int val) {
        if (n < window.length)  n++;
        sum -= window[insert];
        sum += val;
        window[insert] = val;
        insert = (insert + 1) % window.length;

        return (double)sum / n;
    }
}
