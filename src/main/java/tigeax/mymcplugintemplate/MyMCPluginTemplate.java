package tigeax.mymcplugintemplate;

import java.util.ArrayList;
import java.util.Iterator;

import org.bukkit.plugin.java.JavaPlugin;

import tigeax.mymcplugintemplate.commands.Command;
import tigeax.mymcplugintemplate.commands.main.MainCommand;
import tigeax.mymcplugintemplate.commands.menu.MenuCommand;
import tigeax.mymcplugintemplate.configuration.Config;
import tigeax.mymcplugintemplate.configuration.Messages;
import tigeax.mymcplugintemplate.eventlisteners.OnTabComplete;

public class MyMCPluginTemplate extends JavaPlugin {

    private static MyMCPluginTemplate instance;

    private Config config;
    private Messages messages;

    private ArrayList<Command> commands = new ArrayList<Command>();

    @Override
    public void onEnable() {

        // Set instance
        setInstance(this);

        // Setup config files
        config = new Config(this);
        messages = new Messages(this);

        // Setup commands
        registerCommand(new MainCommand(config.mainCommandName, config.mainCommandAliases, "myplugin.maincommand"));
        registerCommand(new MenuCommand(config.guiCommandName, config.guiCommandAliases, "myplugin.menucommand"));

        // Register events
        getServer().getPluginManager().registerEvents(new OnTabComplete(), this);

        // Log successful enabled message
        getLogger().info("Successfully enabled");
    }

    @Override
    public void onDisable() {
        getLogger().info("Successfully disabled");
    }

    public void reload() {
        getLogger().info("Reloading!");
        onDisable();
        onEnable();
    }

    private static void setInstance(MyMCPluginTemplate instance) {
        MyMCPluginTemplate.instance = instance;
    }

    public static MyMCPluginTemplate getInstance() {
        return instance;
    }

    private void registerCommand(Command commandObj) {
        commands.add(commandObj);
    }

    public Config getConfig() {
        return config;
    }

    public Messages getMessages() {
        return messages;
    }

    public Command getPluginCommand(String name) {
        Iterator<Command> commandsIterator = commands.iterator();

        while (commandsIterator.hasNext()) {
            Command command = (Command) commandsIterator.next();

            if (command.getName().equalsIgnoreCase(name)) {
                return command;
            }

            for (String alias : command.getAliases()) {
                if (name.equalsIgnoreCase(alias)) {
                    return command;
                }
            }

        }
        return null;
    }

}
