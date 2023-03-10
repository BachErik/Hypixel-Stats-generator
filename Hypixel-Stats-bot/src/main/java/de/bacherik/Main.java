package de.bacherik;

import org.apache.log4j.Logger;

public class Main {
    public static Logger logger = Logger.getRootLogger();

    public static void main(String[] args) {
        new Bot().init(args[0]);
    }
}