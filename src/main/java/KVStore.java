import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;


public class KVStore implements IKeyValueStore {
  private Map<String, String> map;
  private String path;

  public KVStore(String path) {
    this.map = new HashMap<>();
    this.path = path;
  }

  @Override
  public String get(String key) {
    LOGGER.log(Level.INFO, "GET request on key " + key);
    return map.get(key);
  }

  @Override
  public void put(String key, String value) {
    LOGGER.log(Level.INFO, "PUT request on key " + key + " " + "value " + value);
    appendLog(key, value);
    map.put(key, value);
  }

  @Override
  public void remove(String key) {
    LOGGER.log(Level.INFO, "REMOVE request on key " + key);
    map.remove(key);
  }

  private void appendLog(String key, String value) {
    LOGGER.log(Level.INFO, "Appending latest value in WAL");
    try {
      WALEntry walEntry = new WALEntry(key, value);

      WriteAheadLog _wal = new WriteAheadLog(path);
      _wal.write(walEntry);
      _wal.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
