package org.mentalizr.backend.proc.event;

import org.mentalizr.backend.proc.eventQueue.EventQueue;

import java.time.Instant;
import java.util.UUID;

public abstract class Event {

    protected String id;
    protected long creationTimestamp;

    public Event() {
        this.id = UUID.randomUUID().toString();
        this.creationTimestamp = Instant.now().toEpochMilli();
    }

    public String getId() {
        return id;
    }

    public long getCreationTimestamp() {
        return creationTimestamp;
    }

    public void fire() {
        EventQueue.offer(this);
    }

    abstract public void process();

}
