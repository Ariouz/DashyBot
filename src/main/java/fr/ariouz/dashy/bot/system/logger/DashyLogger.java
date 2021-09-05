package fr.ariouz.dashy.bot.system.logger;

import fr.ariouz.dashy.bot.system.logger.color.ANSIColor;
import fr.ariouz.dashy.bot.time.TimeConverter;
import fr.ariouz.dashy.bot.time.TimeFormat;
import fr.ariouz.dashy.bot.time.TimeUtil;

import java.io.*;

public class DashyLogger {

    private final String LOG_PREFIX = "[DashyBot]";
    private final File logFile;

    public DashyLogger(String directory, String fileName){
        logFile = new File(fileName);
        File dir = new File(directory);
        if(!dir.exists()) dir.mkdir();

        if(!logFile.exists()){
            try {
                if (logFile.createNewFile()) { log(LogAction.SUCCESS, "Created log file: " + logFile.getName());
                } else { log(LogAction.ERROR, "Failed to create log file: " + logFile.getName()); }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            if(logFile.setWritable(true)) { log(LogAction.SUCCESS, "Log file made writable");
            } else { log(LogAction.ERROR, "Failed to make log file writable."); }
        }
    }

    public void log(LogAction logAction, String... message){
        String dateTimeString = new TimeConverter().from(TimeUtil.MILLIS, System.currentTimeMillis()).parse(TimeFormat.YEAR);
        for(String m : message){
            System.out.println("["+dateTimeString+"]" + " " + LOG_PREFIX + " " + logAction.getColor().getCode() + logAction.getSuffix() + m + ANSIColor.RESET.getCode());

            String toLog = "["+dateTimeString+"]" + " " + LOG_PREFIX + " " + logAction.getSuffix() + m;
            if(!writeToFile(toLog)){
                log(LogAction.ERROR, "Failed to write log in " + logFile.getName());
            }

        }
    }

    public boolean writeToFile(String log){
        try(FileWriter fw = new FileWriter(logFile.getPath(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(log);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String getLogPrefix() {
        return LOG_PREFIX;
    }
}
