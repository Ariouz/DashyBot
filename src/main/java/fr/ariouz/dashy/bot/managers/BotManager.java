package fr.ariouz.dashy.bot.managers;

import fr.ariouz.dashy.bot.run.DashyStarter;
import fr.ariouz.dashy.bot.system.logger.LogAction;

public class BotManager {

    private final DashyStarter dashyStarter;

    private CommandsManager commandsManager;
    private MessageManager messageManager;

    public BotManager(DashyStarter dashyStarter){
        this.dashyStarter = dashyStarter;
        dashyStarter.getLogger().log(LogAction.INFO, "Loading managers...");
        loadManagers();
        dashyStarter.getLogger().log(LogAction.SUCCESS, "Loaded managers.");
    }

    public void loadManagers(){
        this.commandsManager = new CommandsManager(dashyStarter);
        this.messageManager = new MessageManager(dashyStarter);
    }

    public CommandsManager getCommandsManager() {
        return commandsManager;
    }

    public MessageManager getMessageManager() {
        return messageManager;
    }
}
