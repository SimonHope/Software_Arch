package com.company;

import java.util.ArrayList;
import java.util.concurrent.Flow;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringPublisher implements Flow.Publisher{
    private String Strpublisher;
    private ArrayList<StringSubscription> subs = new ArrayList<StringSubscription>();

    public StringPublisher(String x) {
        Strpublisher = x;
    }

    @Override
    public void subscribe(Flow.Subscriber subscriber) {
        StringSubscription stringSubscription = new StringSubscription(subscriber);
        subs.add(stringSubscription);
        stringSubscription.onSubscribe(stringSubscription);
    }

    public void subscription(){
        Pattern.compile("").matcher(Strpublisher).find();
        for(StringSubscription subscription : subs){
            if(subscription.subscriber instanceof AlphabetSubscriber && Pattern.compile("[a-zA-z]").matcher(Strpublisher).find()) {
                subscription.get(Strpublisher);
            }
            if(subscription.subscriber instanceof NumberSubscriber && Pattern.compile("[0-9]").matcher(Strpublisher).find()) {
                subscription.get(Strpublisher);
            }
            if(subscription.subscriber instanceof SymbolSubscriber && Pattern.compile("[,!@#$%&*()_+=|<>?{}\\\\\\\\[\\\\\\\\]~-]").matcher(Strpublisher).find()) {
                subscription.get(Strpublisher);
            }
            subscription.get(Strpublisher);
        }

    }

}
