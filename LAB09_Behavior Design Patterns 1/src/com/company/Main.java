package com.company;

public class Main {

    public static void main(String[] args) {
        StringPublisher stringPublisher = new StringPublisher("Wakanda Forever***8*//*/*/*sdf");

        AlphabetSubscriber alphabetSubscriber = new AlphabetSubscriber();
        stringPublisher.subscribe(alphabetSubscriber);


        NumberSubscriber numberSubscriber = new NumberSubscriber();
        stringPublisher.subscribe(numberSubscriber);

        SymbolSubscriber symbolSubscriber = new SymbolSubscriber();
        stringPublisher.subscribe(symbolSubscriber);

        stringPublisher.subscription();
    }
}
