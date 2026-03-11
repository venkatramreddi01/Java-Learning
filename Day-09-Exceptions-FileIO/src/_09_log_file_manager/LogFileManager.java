package _09_log_file_manager;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class Logger {
    String logFile;

    Logger(String logFile) {
        this.logFile = logFile;
    }

    public void log(String level, String message) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String logEntry = String.format("[%s], [%s], %s", timestamp, level, message);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logFile, true))) {
            writer.write(logEntry);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Failed to write log: " + e.getMessage());
        }
    }

    public void info(String message) {
        log("INFO", message);
        System.out.println("[INFO] " + message);
    }

    public void warning(String message) {
        log("WARNING", message);
        System.out.println("[WARNING] " + message);
    }

    public void error(String message) {
        log("ERROR", message);
        System.out.println("[ERROR] " + message);
    }

    public void readLogs() {
        try (BufferedReader reader = new BufferedReader(new FileReader(logFile))) {
            System.out.println("\n=== Log File Contents ===");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No log file found!");
        } catch (IOException e) {
            System.out.println("Error reading logs: " + e.getMessage());
        }
    }

    public void clearLogs() {
        try (PrintWriter writer = new PrintWriter(logFile)) {
            // Opening in non-append mode clears file
            System.out.println("Logs cleared!");
        } catch (IOException e) {
            System.out.println("Error clearing logs: " + e.getMessage());
        }
    }
}

public class LogFileManager {
    public static void main(String[] args) {
        Logger logger = new Logger("application.log");

        // Simulate application events
        logger.info("Application started");
        logger.info("User logged in: John");
        logger.warning("Low disk space detected");
        logger.info("Processing transaction #12345");
        logger.error("Failed to connect to database");
        logger.info("Retrying connection...");
        logger.info("Connection successful");
        logger.warning("Session timeout warning");
        logger.info("User logged out");
        logger.info("Application shutdown");;

        // Read all logs
        logger.readLogs();

        // Uncomment to clear logs
        // logger.clearLogs();
    }
}
