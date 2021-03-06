package tigeax.mymcplugintemplate;

import java.util.ArrayList;
import java.util.Iterator;

import org.bukkit.plugin.java.JavaPlugin;

import tigeax.mymcplugintemplate.commands.main.MainCmd;
import tigeax.mymcplugintemplate.commands.menu.Menu;
import tigeax.mymcplugintemplate.configuration.Config;
import tigeax.mymcplugintemplate.configuration.Messages;
import tigeax.mymcplugintemplate.eventlisteners.InventoryClickEventListener;
import tigeax.mymcplugintemplate.eventlisteners.TabCompleteEventListener;
import tigeax.mymcplugintemplate.menu.TestMenu;
import tigeax.mymcplugintemplate.util.commands.Command;

public class MyMCPluginTemplate extends JavaPlugin {

    private static MyMCPluginTemplate instance;

    private Config config;
    private Messages messages;

    public TestMenu testMenu;

    private ArrayList<Command> commands = new ArrayList<Command>();

    @Override
    public void onEnable() {

        // Set instance
        setInstance(this);

        // Setup config files
        config = new Config(this);
        messages = new Messages(this);

        // Setup commands
        registerCommand(new MainCmd(config.mainCommandName, config.mainCommandAliases, "myplugin.maincommand"));
        registerCommand(new Menu(config.guiCommandName, config.guiCommandAliases, "myplugin.menucommand"));

        // Register events
        getServer().getPluginManager().registerEvents(new TabCompleteEventListener(), this);
        getServer().getPluginManager().registerEvents(new InventoryClickEventListener(), this);

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

    /** Get the plugin's {@link Config} */
    public Config getConfig() {
        return config;
    }

    /** Get the plugin's {@link Messages} */
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
