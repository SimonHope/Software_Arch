package com.company;

import java.util.concurrent.Flow;

public class StringSubscription implements Flow.Subscription{
    private long NumOfRequest;
    public Flow.Subscriber subscriber;
    public StringSubscription(Flow.Subscriber subscriber){
        this.subscriber = subscriber;
    }

    public void request(long n){
        this.NumOfRequest += n;
    }
    public void cancel(){
        this.NumOfRequest = 0;
    }

    public void get(String x){
        subscriber.onNext(x);
    }

    public void onSubscribe(StringSubscription stringSubscription) {
    }
}
