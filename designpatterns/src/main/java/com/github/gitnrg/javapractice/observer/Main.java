package com.github.gitnrg.javapractice.observer;

public class Main {

    public static void main(String[] args) {
        var newsAgency = new SubscriptionManager();

        var john = new EmailCustomer("John");
        var katy = new EmailCustomer("Katy");
        var lukas = new PushNotificationCustomer("Lukas");
        newsAgency.subscribe(EventType.POLITICAL_NEWS, john);
        newsAgency.subscribe(EventType.POLITICAL_NEWS, katy);
        newsAgency.subscribe(EventType.TECH_NEWS, john);
        newsAgency.subscribe(EventType.TECH_NEWS, katy);
        newsAgency.subscribe(EventType.TECH_NEWS, lukas);

        var news1 = new TechNewsEvent("Buy $10 just for $9.99 in AppStore today");
        var news2 = new TechNewsEvent("Google is considering rebranding to Skynet");
        var news3 = new TechNewsEvent("ChatGPT learned bribery and scored 200 on IQ test");
        var news4 = new PoliticalNewsEvent("POTUS to declare war on California and Twitter");
        var news5 = new PoliticalNewsEvent("CCP to adopt voting right for infants who vote for CCP");

        // Sending email to John: Buy $10 just for $9.99 in AppStore today
        // Sending email to Katy: Buy $10 just for $9.99 in AppStore today
        // Sending push notification to Lukas: Buy $10 just for $9.99 in AppStore today
        newsAgency.notify(news1);
        System.out.println();

        // Sending email to John: Google is considering rebranding to Skynet
        // Sending push notification to Lukas: Google is considering rebranding to Skynet
        newsAgency.unsubscribe(EventType.TECH_NEWS, katy);
        newsAgency.notify(news2);
        System.out.println();

        // Sending email to John: ChatGPT learned bribery and scored 200 on IQ test
        newsAgency.unsubscribe(EventType.TECH_NEWS, lukas);
        newsAgency.notify(news3);
        System.out.println();

        // Sending email to John: POTUS to declare war on California and Twitter
        // Sending email to Katy: POTUS to declare war on California and Twitter
        newsAgency.notify(news4);
        System.out.println();

        // Sending email to Katy: CCP to adopt voting right for infants who vote for CCP
        newsAgency.unsubscribe(EventType.POLITICAL_NEWS, john);
        newsAgency.notify(news5);
    }

}
