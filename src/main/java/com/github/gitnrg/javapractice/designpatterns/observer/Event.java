package com.github.gitnrg.javapractice.designpatterns.observer;

public interface Event {
    String getSubject();

    EventType getEventType();
}
