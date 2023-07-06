import java.io.IOException;


public interface IKeyValueStore {
  public String get(String key);
  
  public void put(String key, String value)
      throws IOException;
  
  public void remove(String key);
}
