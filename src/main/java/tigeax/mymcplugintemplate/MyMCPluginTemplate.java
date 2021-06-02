package tigeax.mymcplugintemplate;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.plugin.java.JavaPlugin;

import tigeax.mymcplugintemplate.commands.main.MainCommand;
import tigeax.mymcplugintemplate.commands.menu.MenuCommand;
import tigeax.mymcplugintemplate.configuration.Config;
import tigeax.mymcplugintemplate.configuration.Messages;


public class MyMCPluginTemplate extends JavaPlugin {

    private static MyMCPluginTemplate instance;

    private Boolean debug = true;

    public Config config;
    public Messages messages;

    @Override
    public void onEnable() {

        setInstance(this);

        config = new Config(this);
        messages = new Messages(this);

        // Setup commands
        new MainCommand(config.mainCommandName, config.mainCommandAliases);
        new MenuCommand(config.guiCommandName, config.guiCommandAliases);


        if (debug) {
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


}
