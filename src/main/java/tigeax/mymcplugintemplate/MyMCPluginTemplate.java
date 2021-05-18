package tigeax.mymcplugintemplate;

import org.apache.commons.lang.Validate;
import org.bukkit.plugin.java.JavaPlugin;

public class MyMCPluginTemplate extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Hello, SpigotMC!");
        Validate.isTrue(0==1, "test");
        Test.Level test = Test.Level.HIGH;
    }

    @Override
    public void onDisable() {
        getLogger().info("See you again, SpigotMC!");
    }

}
