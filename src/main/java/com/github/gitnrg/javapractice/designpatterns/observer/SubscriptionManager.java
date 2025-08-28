package com.github.gitnrg.javapractice.designpatterns.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubscriptionManager {
    private final Map<EventType, List<EventListener>> subscriptions = new HashMap<>();

    public void subscribe(EventType eventType, EventListener eventListener) {
        var typeSubscription = subscriptions.computeIfAbsent(eventType, k -> new ArrayList<>());
        if (!typeSubscription.contains(eventListener)) {
            typeSubscription.add(eventListener);
        }
    }

    public void unsubscribe(EventType eventType, EventListener eventListener) {
        var typeSubscription = subscriptions.get(eventType);
        if (typeSubscription == null) {
            return;
        }
        typeSubscription.remove(eventListener);
    }

    public void notify(Event event) {
        var typeSubscription = subscriptions.get(event.getEventType());
        if (typeSubscription != null) {
            for (var eventListener : typeSubscription) {
                eventListener.process(event);
            }
        }
    }

}
