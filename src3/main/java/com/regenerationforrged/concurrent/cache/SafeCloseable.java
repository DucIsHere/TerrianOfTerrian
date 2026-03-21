package com.regenerationforrged.concurrent.cache;

public interface SafeCloseable extends AutoCloseable {
    void close();
}
