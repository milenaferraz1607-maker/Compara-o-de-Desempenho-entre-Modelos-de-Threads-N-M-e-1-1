import java.util.concurrent.*;
import java.util.*;

public class NMModel {
public static void main(String[] args) throws InterruptedException {
if (args.length < 2) {
System.out.println("Uso: java NMModel <num_user_threads> <pool_size_M>");
return;
}
int numUserThreads = Integer.parseInt(args[0]);
int poolSize = Integer.parseInt(args[1]);

int iterationsPerTask = 100; 

ExecutorService pool = Executors.newFixedThreadPool(poolSize);
List<Future<?>> futures = new ArrayList<>();

long start = System.nanoTime();
for (int i = 0; i < numUserThreads; i++) {
futures.add(pool.submit(new Task(iterationsPerTask)));
}

// aguardar conclusão
for (Future<?> f : futures) {
try {
f.get();
} catch (ExecutionException e) {
e.printStackTrace();
}
}

long end = System.nanoTime();
pool.shutdown();

System.out.printf("N:M (N=%d, M=%d) tempo total = %d ms\n", numUserThreads, poolSize, (end - start)/1_000_000);
}
}