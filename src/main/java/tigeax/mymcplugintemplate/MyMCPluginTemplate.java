package tigeax.mymcplugintemplate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.plugin.java.JavaPlugin;

import tigeax.mymcplugintemplate.commands.Command;
import tigeax.mymcplugintemplate.commands.main.MainCommand;
import tigeax.mymcplugintemplate.commands.menu.MenuCommand;
import tigeax.mymcplugintemplate.configuration.Config;
import tigeax.mymcplugintemplate.configuration.Messages;
import tigeax.mymcplugintemplate.eventlisteners.OnTabComplete;


public class MyMCPluginTemplate extends JavaPlugin {

    private static MyMCPluginTemplate instance;

    public Config config;
    public Messages messages;

    private ArrayList<Command> commands = new ArrayList<Command>();

    @Override
    public void onEnable() {

        setInstance(this);

        config = new Config(this);
        messages = new Messages(this);

        // Setup commands
        registerCommand(new MainCommand(config.mainCommandName, config.mainCommandAliases));
        registerCommand(new MenuCommand(config.guiCommandName, config.guiCommandAliases));

        // Register events
        getServer().getPluginManager().registerEvents(new OnTabComplete(), this);


        if (config.debug) {
            try {
                throw new NotImplementedException("Try catch");
            } catch (Exception e) {
                e.printStackTrace();
            }

            getLogger().info("getLogger().info()");
            getLogger().warning("getLogger().warning()");
            getLogger().severe("getLogger().severe()");

        }



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


    public static MyMCPluginTemplate getInstance() {
        return instance;
    }

    private static void setInstance(MyMCPluginTemplate instance) {
        MyMCPluginTemplate.instance = instance;
    }

    private void registerCommand(Command commandObj) {
        commands.add(commandObj);
    }
    

    public Command getPluginCommand(String name) {
        Iterator<Command> commandsIterator = commands.iterator();

        while (commandsIterator.hasNext()) {
            Command command = (Command) commandsIterator.next();

            if (command.getName().equalsIgnoreCase(name)) {
                return command;
            }

            List<String> aliases = command.getAliases();
            int length = aliases.size();

            for (int i = 0; i < length; ++i) {
                String alias = aliases.get(i);
                if (name.equalsIgnoreCase(alias)) {
                    return command;
                }

            }
        }
        return null;
    }


}
