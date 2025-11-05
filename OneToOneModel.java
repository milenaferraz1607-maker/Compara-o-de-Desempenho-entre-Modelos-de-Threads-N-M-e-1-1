// Simula o modelo 1:1 criando uma Thread do sistema para cada thread de usuário.

import java.util.*;

public class OneToOneModel {
public static void main(String[] args) throws InterruptedException {
if (args.length < 1) {
System.out.println("Uso: java OneToOneModel <num_user_threads>");
return;
}
int numUserThreads = Integer.parseInt(args[0]);
int iterationsPerTask = 100; // ajustar se desejar

Thread[] threads = new Thread[numUserThreads];

long start = System.nanoTime();
for (int i = 0; i < numUserThreads; i++) {
threads[i] = new Thread(new Task(iterationsPerTask));
threads[i].start();
}

for (int i = 0; i < numUserThreads; i++) {
threads[i].join();
}
long end = System.nanoTime();

System.out.printf("1:1 (N=%d) tempo total = %d ms\n", numUserThreads, (end - start)/1_000_000);
}
}