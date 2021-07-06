package org.mentalizr.backend.proc;

import org.mentalizr.backend.proc.eventProcessor.EventProcessor;
import org.mentalizr.backend.proc.event.DummyEvent;

public class Dummy {

    private static void sleep(long sleepTimeMs) {
        try {
            Thread.sleep(sleepTimeMs);
        } catch (InterruptedException e) {
            // DIN
        }
    }

    public static void main(String[] args) {

        System.out.println("....");

        EventProcessor.start();

        sleep(2000);

        (new DummyEvent("ein erstes Event")).fire();
        (new DummyEvent("ein zweites Event")).fire();
        (new DummyEvent("ein drittes Event")).fire();
        (new DummyEvent("ein viertes Event")).fire();
        (new DummyEvent("ein fünftes Event")).fire();



//        EventQueue.offer(new DummyEvent("ein erstes Event"));
//        EventQueue.offer(new DummyEvent("ein zweites Event"));
//        EventQueue.offer(new DummyEvent("ein drittes Event"));
//        EventQueue.offer(new DummyEvent("ein viertes Event"));
//        EventQueue.offer(new DummyEvent("ein fünftes Event"));

        sleep(5000);

        EventProcessor.stop();

    }

}
