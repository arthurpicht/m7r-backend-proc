package org.mentalizr.backend.proc.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DummyEvent extends Event {

    private static Logger logger = LoggerFactory.getLogger(DummyEvent.class);

    private String payload;

    public DummyEvent(String payload) {
        super();
        this.payload = payload;
    }

    @Override
    public void process() {
        logger.info("Verarbeite " + DummyEvent.class.getSimpleName() + " mit ID: " + this.id + " Payload: " + this.payload);
    }

}
