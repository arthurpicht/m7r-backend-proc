package org.mentalizr.backend.proc.eventProcessor;

import org.mentalizr.backend.proc.event.Event;
import org.mentalizr.backend.proc.eventQueue.EventQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EventProcessorWorker extends Thread {

    private static Logger logger = LoggerFactory.getLogger(EventProcessorWorker.class);

    private static long sleepTimeMillis = 1000;

    public EventProcessorWorker() {
        this.setName(EventProcessorWorker.class.getSimpleName());
    }

    @Override
    public void run() {

        logger.info(EventProcessorWorker.class.getName() + " starts working.");

        while (!this.isInterrupted()) {

            // logger.debug("nächste Runde ...");

            Event event = EventQueue.poll();

            while (event != null) {
                processEvent(event);
                event = EventQueue.poll();
            }

            sleep();
        }

        logger.info(EventProcessorWorker.class.getName() + " received interrupt signal and stopped working.");
    }

    private void processEvent(Event event) {
        try {
            event.process();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    private void sleep() {
        try {
            Thread.sleep(sleepTimeMillis);
        } catch (InterruptedException e) {
            this.interrupt();
        }
    }

}
