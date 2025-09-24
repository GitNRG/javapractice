package com.github.gitnrg.javapractice.observer;

public class PoliticalNewsEvent implements Event {
    private final String subject;

    public PoliticalNewsEvent(String subject) {
        this.subject = subject;
    }

    @Override
    public String getSubject() {
        return subject;
    }

    @Override
    public EventType getEventType() {
        return EventType.POLITICAL_NEWS;
    }
}
