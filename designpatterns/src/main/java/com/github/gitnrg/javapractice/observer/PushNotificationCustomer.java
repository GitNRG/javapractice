package com.github.gitnrg.javapractice.observer;

import java.util.Objects;

public class PushNotificationCustomer implements EventListener {
    private final String customerName;

    public PushNotificationCustomer(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public void process(Event event) {
        System.out.println("Sending push notification to " + customerName + ": " + event.getSubject());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PushNotificationCustomer that = (PushNotificationCustomer) o;
        return Objects.equals(customerName, that.customerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerName);
    }
}
