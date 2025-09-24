package com.github.gitnrg.javapractice.observer;

public class TechNewsEvent implements Event {
    private final String subject;

    public TechNewsEvent(String subject) {
        this.subject = subject;
    }

    @Override
    public String getSubject() {
        return subject;
    }

    @Override
    public EventType getEventType() {
        return EventType.TECH_NEWS;
    }
}
