public class App {
  public static void main(String[] args) {
    String filePath = "data/tmp.txt";
    KVStore _kvStore = new KVStore(filePath);

    _kvStore.put("1", "1");
    _kvStore.put("2", "1");
    _kvStore.put("3", "1");
    _kvStore.put("4", "1");
    _kvStore.put("5", "1");

    System.out.println(_kvStore.get("1"));
    System.out.println(_kvStore.get("3"));
    System.out.println(_kvStore.get("2"));
  }
}
