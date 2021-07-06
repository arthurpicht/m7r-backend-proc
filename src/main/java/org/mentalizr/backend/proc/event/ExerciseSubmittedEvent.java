package org.mentalizr.backend.proc.event;

import org.bson.Document;
import org.mentalizr.persistence.mongo.exerciseStatus.ExerciseStatusSubmitted;
import org.mentalizr.persistence.mongo.exerciseStatus.ExerciseStatusSubmittedConverter;
import org.mentalizr.persistence.mongo.exerciseStatus.ExerciseStatusSubmittedMongoHandler;
import org.mentalizr.persistence.mongo.formData.FormData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExerciseSubmittedEvent extends Event {

    private static Logger logger = LoggerFactory.getLogger(ExerciseSubmittedEvent.class);

    private ExerciseStatusSubmitted exerciseStatusSubmitted;

    public ExerciseSubmittedEvent(FormData formData) {
        super();
        this.exerciseStatusSubmitted = new ExerciseStatusSubmitted(formData.getUserId(), formData.getContentId());
    }

    @Override
    public void process() {
        logger.debug("Process " + ExerciseSubmittedEvent.class.getSimpleName() + ": " + this.exerciseStatusSubmitted.toString());

        notifyTherapistByEmail();

        updatePersistentStatus();
    }

    private void updatePersistentStatus() {
        Document exerciseStatusSubmittedDocument = ExerciseStatusSubmittedConverter.convert(this.exerciseStatusSubmitted);
        ExerciseStatusSubmittedMongoHandler.createOrUpdate(exerciseStatusSubmittedDocument);
    }

    private void notifyTherapistByEmail() {
        // TODO
        logger.debug("TODO: notify Therapist by email.");
        this.exerciseStatusSubmitted.addNotificationTsNow();
    }

}
