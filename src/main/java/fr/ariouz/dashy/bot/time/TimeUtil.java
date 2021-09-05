package fr.ariouz.dashy.bot.time;

public enum TimeUtil {

    MILLIS(1, 0),
    SECOND(1000, 1),
    MINUTE(60, 2),
    HOUR(60, 3),
    DAY(24, 4),
    MONTH(30, 5),
    YEAR(365, 6),

    ;

    private final long millis;
    private final int power;

    TimeUtil(long millis, int power){
        this.millis = millis;
        this.power = power;
    }

    public long getMillis() {
        return millis;
    }

    public int getPower() {
        return power;
    }
}
