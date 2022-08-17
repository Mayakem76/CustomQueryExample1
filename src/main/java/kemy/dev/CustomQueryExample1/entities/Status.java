package kemy.dev.CustomQueryExample1.entities;


import java.util.Random;

public enum Status {
    ONTIME,
    DELAY,
    CANCELLED;

    private static final Random PRNG = new Random();

    public static Status randomStatus()  {
        Status[] statuses = values();
        return statuses[PRNG.nextInt(statuses.length)];
    }
}
