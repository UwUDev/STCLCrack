package me.uwu.utils;

public class STCLUtis {
    private static final long shift = 1580908800000L - 7200000L;
    public static long stclTimeStampToEpoch(int minutes) {
        return shift + 60000L * minutes;
    }

    public static int epochToSTCLTimeStamp(long millis) {
        return (int) ((millis - shift) / 60000L);
    }
}
