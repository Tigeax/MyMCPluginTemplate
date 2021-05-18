package tigeax.mymcplugintemplate;

import org.apache.commons.lang.NotImplementedException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import tigeax.mymcplugintemplate.util.YAMLFileManager;


public class MyMCPluginTemplate extends JavaPlugin {

    private Boolean debug = true;

    @Override
    public void onEnable() {

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

        getLogger().info("${pom.version} sucessfully enabled");

        YamlConfiguration messagesYAML = new YAMLFileManager(this, "messages.yml");

    }

    @Override
    public void onDisable() {
        getLogger().info("See you again, SpigotMC!");
    }

}
