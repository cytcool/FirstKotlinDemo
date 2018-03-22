package com.example.cyt.firstkotlindemo.utils;


import rx.Observable;
import rx.subjects.PublishSubject;

/**
 * Created by CYT on 2018/3/22.
 */

public final class RxBus {
    private final PublishSubject<Object> bus = PublishSubject.create();
    private static RxBus instance;

    private RxBus(){}

    public void send(final Object event) {
        bus.onNext(event);
    }

    public Observable<Object> toObservable() {
        return bus;
    }

    public boolean hasObservers() {
        return bus.hasObservers();
    }

    public static RxBus getInstance() {
        if (instance==null){
            instance=new RxBus();
        }
        return instance;
    }
}