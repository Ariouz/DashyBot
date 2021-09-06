package fr.ariouz.dashy.bot.run;

import fr.ariouz.dashy.bot.managers.BotManager;
import fr.ariouz.dashy.bot.system.logger.DashyLogger;
import fr.ariouz.dashy.bot.system.logger.LogAction;
import fr.ariouz.dashy.bot.time.TimeConverter;
import fr.ariouz.dashy.bot.time.TimeFormat;
import fr.ariouz.dashy.bot.time.TimeUtil;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;

import javax.security.auth.login.LoginException;
import java.util.Calendar;
import java.util.Date;

public class DashyStarter {

    private JDA dashyJDA;
    private final DashyLogger dashyLogger;
    private final BotManager botManager;
    private final long startTime;

    private final String prefix = "d!"; // TODO Edit in dashboard

    public DashyStarter(String[] args){
        this.startTime = System.currentTimeMillis();
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        String dateTimeString = new TimeConverter().fromDate(date).parse(TimeFormat.YEAR_FILE);
        this.dashyLogger = new DashyLogger("logs", "logs/"+dateTimeString+"-logs.txt");
        startBot(args);
        loadPresence();
        this.botManager = new BotManager(this);
    }

    public void startBot(String[] args){
        try {
            getLogger().log(LogAction.INFO, "Loading Discord Bot...");
            dashyJDA = JDABuilder.createDefault(args[0])
                    .setChunkingFilter(ChunkingFilter.ALL)
                    .setMemberCachePolicy(MemberCachePolicy.ALL)
                    .enableIntents(GatewayIntent.GUILD_MEMBERS)
                    .build();
            getLogger().log(LogAction.SUCCESS, "Bot loaded.");
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

    public void loadPresence(){
        getLogger().log(LogAction.INFO, "Loading bot presence...");
        dashyJDA.getPresence().setActivity(Activity.watching("dashy-bot.xyz"));
        getLogger().log(LogAction.SUCCESS, "Bot presence loaded.");
    }

    public JDA getJDA(){
        return dashyJDA;
    }

    public JDA getDashyJDA() {
        return dashyJDA;
    }

    public DashyLogger getLogger() {
        return dashyLogger;
    }

    public String getPrefix() {
        return prefix;
    }

    public BotManager getBotManager() {
        return botManager;
    }

    public long getStartTime() {
        return startTime;
    }
}
