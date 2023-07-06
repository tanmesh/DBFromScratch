import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class App {
  public static void main(String[] args) {
    String filePath = "data/tmp.txt";
    KVStore _kvStore = new KVStore(filePath);

    int nThreads = 10;
    ExecutorService executorService = Executors.newFixedThreadPool(nThreads);

    // PUT
    for (int i = 0; i < nThreads; ++i) {
      final int index = i;
      executorService.execute(() -> {
        String key = "key" + index;
        String value = "value" + index;
        _kvStore.put(key, value);
      });
    }

    executorService.shutdown();
    while (!executorService.isTerminated()) ;

    // GET
    for (int i = 0; i < nThreads; ++i) {
      System.out.println("Key" + i + " - " + _kvStore.get("key" + i));
    }
  }
}
