class WALEntry {
  private final String key;
  private final String value;
  private final String timestamp;

  public WALEntry(String key, String value) {
    this.key = key;
    this.value = value;
    this.timestamp = "";
  }
}