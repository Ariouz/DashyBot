package fr.ariouz.dashy.bot.managers;

import fr.ariouz.dashy.bot.entities.commands.CommandParser;
import fr.ariouz.dashy.bot.entities.commands.Commands;
import fr.ariouz.dashy.bot.entities.commands.DashyCommand;
import fr.ariouz.dashy.bot.run.DashyStarter;
import fr.ariouz.dashy.bot.system.logger.LogAction;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class CommandsManager {

    private final DashyStarter dashyStarter;

    private final HashMap<Commands, DashyCommand> commands = new HashMap<>();

    public CommandsManager(DashyStarter dashyStarter){
        this.dashyStarter = dashyStarter;
        dashyStarter.getLogger().log(LogAction.INFO, "Loading commands...");
        registerCommands();
        dashyStarter.getLogger().log(LogAction.SUCCESS, "Loaded commands.");
        dashyStarter.getDashyJDA().addEventListener(new CommandParser(dashyStarter));
    }

    public void registerCommands(){
        for(Commands commands : Commands.values()){
            try {
                Constructor<?> cons = commands.getCommandClass().getConstructor(Commands.class, DashyStarter.class);
                Object object = cons.newInstance(commands, dashyStarter);
                DashyCommand dashyCommand = (DashyCommand) object;
                this.commands.put(commands, dashyCommand);
                dashyStarter.getLogger().log(LogAction.SUCCESS, "Loaded command " + commands.getIdentifier());
            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                StringWriter sw = new StringWriter();
                PrintWriter pw = new PrintWriter(sw);
                e.printStackTrace(pw);
                dashyStarter.getLogger().log(LogAction.ERROR, "Error while loading command " + commands.getIdentifier() +":", sw.toString());
            }
        }
    }

    public HashMap<Commands, DashyCommand> getCommands() {
        return commands;
    }
}
