package de.bacherik;

import org.apache.log4j.Logger;

import java.io.File;
import java.util.Arrays;

public class Main {
    public static Logger logger = Logger.getRootLogger();

    public static void main(String[] args) {

        if (args.length == 0 || args.length > 1) {
            logger.error("You MUST specify as the first argument a valid JSON file created like the example-config" +
                    ".json.");
            return;
        }

        String path = args[0];
        File configFile = new File(path);

        // Check if the path is a valid JSON file
        if (!path.endsWith(".json")) {
            logger.error("You must specify as the first argument a valid JSON file created like the example-config" +
                    ".json.");
            return;
        } else if (!(configFile.exists())) {
            logger.error("You must specify as the first argument a VALID JSON FILE created like the example-config" +
                    ".json.");
            return;
        }

        // Here you can read and process the content of the JSON file
        logger.debug(Arrays.toString(args));
        logger.debug(configFile);
        new Bot().init(configFile);
    }
}