import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;


public class WriteAheadLog {
  private BufferedWriter wal;

  public WriteAheadLog(String filePath) {
    try {
      this.wal = new BufferedWriter(new FileWriter(filePath, true));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void write(WALEntry walEntry) {
    LOGGER.log(Level.INFO, "Writing in WAL");
    try {
      wal.write(String.valueOf(walEntry));
      wal.write("\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void close() {
    LOGGER.log(Level.INFO, "Closing WAL");
    try {
      wal.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
