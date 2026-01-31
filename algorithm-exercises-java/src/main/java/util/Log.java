package util;

/** Log. */
public class Log {

  /**
   * LoggerSingleton.
   *
   * @link https://www.logicbig.com/tutorials/core-java-tutorial/logging/levels.html
   */
  private class LoggerSingleton {

    private LoggerSingleton() {}

    public static final String LOGGER_NAME = "projecteuler";
    private static java.util.logging.Logger log;

    /** Common logger singleton. */
    @SuppressWarnings({"java:S106", "java:S4792"})
    public static java.util.logging.Logger getLogger() {

      // default log level
      String logLevel = System.getenv("LOG_LEVEL");

      if (logLevel == null) {
        logLevel = "INFO";
      }

      logLevel = logLevel.toUpperCase();

      // Singleton initalization
      if (log == null) {
        log = java.util.logging.Logger.getLogger(LoggerSingleton.LOGGER_NAME);

        java.util.logging.Level level;

        switch (logLevel) {
          case "INFO":
            level = java.util.logging.Level.INFO;
            break;
          case "DEBUG":
            level = java.util.logging.Level.FINE;
            break;
          case "FINE":
            level = java.util.logging.Level.FINE;
            break;
          case "WARN":
            level = java.util.logging.Level.WARNING;
            break;
          case "WARNING":
            level = java.util.logging.Level.WARNING;
            break;
          case "ERROR":
            level = java.util.logging.Level.SEVERE;
            break;
          case "SEVERE":
            level = java.util.logging.Level.SEVERE;
            break;
          default:
            level = java.util.logging.Level.INFO;
        }

        System.out.println("Setting LOG_LEVEL: " + level.getName());

        log.setLevel(level);

        log.info("INFO LEVEL ENABLED");
        log.warning("WARNING LEVEL ENABLED");
        log.fine("FINE LEVEL ENABLED");
        log.finest("FINEST LEVEL ENABLED");
      }

      return log;
    }
  }

  public static java.util.logging.Logger getLogger() {
    return LoggerSingleton.getLogger();
  }

  public static void info(String message) {
    LoggerSingleton.getLogger().log(java.util.logging.Level.INFO, message);
  }

  public static void warning(String message) {
    LoggerSingleton.getLogger().log(java.util.logging.Level.WARNING, message);
  }

  public static void error(String message) {
    LoggerSingleton.getLogger().log(java.util.logging.Level.SEVERE, message);
  }

  public static void debug(String message) {
    LoggerSingleton.getLogger().log(java.util.logging.Level.FINE, message);
  }
}
