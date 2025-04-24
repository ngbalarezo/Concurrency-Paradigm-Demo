package CustomClasses;

import java.util.concurrent.Callable;

public class SumTask implements Callable<Long> {
    private int[] array;
    private int start, end;

    // constructor
    public SumTask(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    public Long call() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += array[i];
        }
        return sum;
    }
}
