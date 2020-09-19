package dev.eeasee.player_tracker.utils;

public class ObjectWithTimestamp<T> {
    public final long timeStamp;
    public final T clazz;

    public ObjectWithTimestamp(long timeStamp, T clazz) {
        this.timeStamp = timeStamp;
        this.clazz = clazz;
    }
}
