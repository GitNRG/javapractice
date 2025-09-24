package com.github.gitnrg.javapractice.observer;

public interface Event {
    String getSubject();

    EventType getEventType();
}
