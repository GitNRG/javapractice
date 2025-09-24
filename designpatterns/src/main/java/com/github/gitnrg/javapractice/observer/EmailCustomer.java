package com.github.gitnrg.javapractice.observer;

import java.util.Objects;

public class EmailCustomer implements EventListener {
    private final String customerName;

    public EmailCustomer(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public void process(Event event) {
        System.out.println("Sending email to " + customerName + ": " + event.getSubject());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmailCustomer that = (EmailCustomer) o;
        return Objects.equals(customerName, that.customerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerName);
    }
}
