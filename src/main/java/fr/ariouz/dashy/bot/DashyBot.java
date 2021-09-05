package fr.ariouz.dashy.bot;

import fr.ariouz.dashy.bot.run.DashyStarter;

public class DashyBot {

    private static DashyStarter dashyStarter;

    public static void main(String[] args) {
        dashyStarter = new DashyStarter(args);
    }

    public static DashyStarter getDashyStarter() {
        return dashyStarter;
    }
}
