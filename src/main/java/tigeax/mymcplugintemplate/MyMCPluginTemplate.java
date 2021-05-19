package tigeax.mymcplugintemplate;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.plugin.java.JavaPlugin;

import tigeax.mymcplugintemplate.util.Config;
import tigeax.mymcplugintemplate.util.Messages;


public class MyMCPluginTemplate extends JavaPlugin {

    private Boolean debug = true;

    public Config config;
    public Messages messages;

    @Override
    public void onEnable() {

        config = new Config(this);
        messages = new Messages(this);

        debug = config.debug();

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

        getLogger().info("Sucessfully enabled");

        this.messages = new Messages(this);

    }

    @Override
    public void onDisable() {
        getLogger().info("Sucessfully disabled");
    }

}
