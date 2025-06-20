public class Logger {
    // private static instance of Logger
    private static Logger instance;

    // makingthe constructor private
    private Logger() {
        System.out.println("Logger initialized");
    }

    // public static method to return the single instance
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();  // Lazy initialization
        }
        return instance;
    }

    // method for logging
    public void log(String message) {
        System.out.println("LOG: " + message);
    }
}
