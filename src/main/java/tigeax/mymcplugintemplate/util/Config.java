package tigeax.mymcplugintemplate.util;

import org.bukkit.entity.Player;

import tigeax.mymcplugintemplate.MyMCPluginTemplate;


public class Config extends YamlFile {

    private Boolean debug;

    public Config(MyMCPluginTemplate plugin) {
        super(plugin, "config.yml");

        loadMessagesFromFile();
    }


    @Override
    public void update() {
        super.update();
        loadMessagesFromFile();
    }

    private void loadMessagesFromFile() {
        debug = getBoolean("debug");
    }


    public Boolean debug() {
        return this.debug;
    }
        

    
}
