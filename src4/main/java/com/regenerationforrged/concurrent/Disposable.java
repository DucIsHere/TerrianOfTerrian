package com.regenerationforrged.concurrent;

public interface Disposable {
    void dispose();

    public interface Listener<T> {
        void onDispose(t ctx);
    }
}
