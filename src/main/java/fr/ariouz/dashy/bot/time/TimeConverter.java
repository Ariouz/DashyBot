package fr.ariouz.dashy.bot.time;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.*;

public class TimeConverter {

    private long time;

    public TimeConverter fromNow(){
        this.time = Calendar.getInstance().getTime().getTime();
        return this;
    }

    public TimeConverter from(TimeUtil timeUtil, long time){
        this.time = timeUtil.getTime() * time;
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
        return this.time/timeUtil.getTime();
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
        while(t >= TimeUtil.SECOND.getTime()){
            t -= TimeUtil.SECOND.getTime();
            seconds++;
        }
        return seconds;
    }

    public String parse(TimeFormat format){
        return new SimpleDateFormat(format.getFormat()).format(this.time);
    }

    public String parseToStringDays(String separator){
        long seconds = 0;
        long minutes = 0;
        long hours = 0;
        long days = 0;

        while(this.time >= TimeUtil.SECOND.getTime()){
            seconds++;
            this.time -= 1000;
        }

        while(seconds >= TimeUtil.MINUTE.getTime()){
            minutes++;
            seconds -= 60;
        }

        while(minutes >= TimeUtil.HOUR.getTime()){
            hours++;
            minutes -= 60;
        }

        while(hours >= TimeUtil.DAY.getTime()){
            days++;
            hours -= 24;
        }

        return days +"d " + (hours < 10 ? "0" + hours : hours) + separator + (minutes < 10 ? "0" + minutes : minutes) + separator + (seconds < 10 ? "0" + seconds : seconds);

    }

}
