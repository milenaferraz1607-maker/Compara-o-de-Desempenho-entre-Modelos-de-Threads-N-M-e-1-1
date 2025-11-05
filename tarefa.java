public class Task implements Runnable {
private final int iterations;

public Task(int iterations) {
this.iterations = iterations;
}

private long dummyComputation(int it) {
long s = 0;
for (int i = 0; i < 1000; i++) {
s += (i * (it + 1)) % 97;
}
return s;
}

@Override
public void run() {
try {
for (int i = 0; i < iterations; i++) {
dummyComputation(i);
Thread.sleep(1);
}
} catch (InterruptedException e) {
Thread.currentThread().interrupt();
}
}
}