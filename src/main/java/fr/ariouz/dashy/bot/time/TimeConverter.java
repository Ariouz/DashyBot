package fr.ariouz.dashy.bot.time;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class TimeConverter {

    private long time;

    public TimeConverter fromNow(){
        this.time = Calendar.getInstance().getTime().getTime();
        return this;
    }

    public TimeConverter from(TimeUtil timeUtil, long time){
        this.time = timeUtil.getMillis() * time;
        return this;
    }

    public TimeConverter fromDate(Date date){
        this.time = date.getTime();
        return this;
    }

    public long toMillis(){
        return time;
    }

    public long to(TimeUtil timeUtil,long millis){
        return this.time/timeUtil.getMillis();
    }

    public String parseDateToString(){
        return LocalTime.now().toString();
    }

    public long getMillis(){
        return this.time;
    }

    public long getSeconds(){
        long seconds = 0;
        long t = this.time;
        while(t >= TimeUtil.SECOND.getMillis()){
            t -= TimeUtil.SECOND.getMillis();
            seconds++;
        }
        return seconds;
    }

    public String parse(TimeFormat format){
        return new SimpleDateFormat(format.getFormat()).format(this.time);
    }

}
