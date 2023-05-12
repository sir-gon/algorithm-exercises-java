package projecteuler.util;

/**
 * https://www.logicbig.com/tutorials/core-java-tutorial/logging/levels.html
 */
public class CustomLogger {

  public static final String LOGGER_NAME = "projecteuler";
  private static java.util.logging.Logger log;

  /**
   * Common logger singleton.
   */
  public static java.util.logging.Logger getLogger() {

    // default log level
    String logLevel = System.getenv("LOG_LEVEL");

    if (logLevel == null) {
      logLevel = "INFO";
    }

    logLevel.toUpperCase();

    // Singleton initalization
    if (log == null) {
      log = java.util.logging.Logger.getLogger(CustomLogger.LOGGER_NAME);

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
