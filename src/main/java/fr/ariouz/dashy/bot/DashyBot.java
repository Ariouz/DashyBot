package fr.ariouz.dashy.bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

public class DashyBot {

    public static void main(String[] args) {
        try {
            JDA dashy = JDABuilder.createDefault(args[0]).build();

            System.out.println("[DashyLog] Connected");

            dashy.getPresence().setActivity(Activity.watching("dashy-bot.xyz"));
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }

}
