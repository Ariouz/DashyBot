package fr.ariouz.dashy.bot.managers;

import fr.ariouz.dashy.bot.run.DashyStarter;

public class MessageManager {

    private final DashyStarter dashyStarter;
    private final DashyEmbed dashyEmbed;

    public MessageManager(DashyStarter dashyStarter) {
        this.dashyStarter = dashyStarter;
        this.dashyEmbed = new DashyEmbed(dashyStarter);
    }

    public DashyStarter getDashyStarter() {
        return dashyStarter;
    }

    public DashyEmbed getDashyEmbed() {
        return dashyEmbed;
    }
}
