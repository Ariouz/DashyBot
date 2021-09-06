package fr.ariouz.dashy.bot.time;

public enum TimeUtil {

    MILLIS(1,0),
    SECOND(1000, 1),
    MINUTE(60, 2),
    HOUR(60, 3),
    DAY(24, 4),
    MONTH(30, 5),
    YEAR(365, 6),

    ;

    private final long time;
    private final int power;

    TimeUtil(long time, int power){
        this.time = time;
        this.power = power;
    }

    public long getTime() {
        return time;
    }

    public int getPower() {
        return power;
    }
}
