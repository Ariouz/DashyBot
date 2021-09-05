package fr.ariouz.dashy.bot.time;

public enum TimeFormat {

    YEAR("yyyy.MM.dd.HH.mm.ss"),
    MONTH("MM.dd.HH.mm.ss"),
    DAY("dd.HH.mm.ss"),
    HOUR("HH.mm.ss"),
    MINUTE("mm.ss"),
    SECONDS("ss"),

    ;

    private final String format;

    TimeFormat(String format){
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}
