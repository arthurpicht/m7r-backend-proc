package org.mentalizr.backend.proc.eventProcessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventProcessor {

    private static Logger logger = LoggerFactory.getLogger(EventProcessor.class);

    private static Thread eventProcessorWorker = new EventProcessorWorker();

    synchronized public static void start() {
        logger.info("Starting EventProcessor.");
        eventProcessorWorker.start();
    }

    synchronized public static void stop() {
        logger.info("Stopping EventProcessor by sending interrupt signal.");
        eventProcessorWorker.interrupt();
    }

}
