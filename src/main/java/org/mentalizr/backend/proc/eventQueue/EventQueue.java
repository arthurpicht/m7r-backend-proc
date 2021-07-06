package org.mentalizr.backend.proc.eventQueue;

import org.mentalizr.backend.proc.event.Event;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class EventQueue {

    private static Queue<Event> eventQueue = new ConcurrentLinkedQueue<>();

    public static void offer(Event event) {
        eventQueue.offer(event);
    }

    public static Event poll() {
        return eventQueue.poll();
    }

}
