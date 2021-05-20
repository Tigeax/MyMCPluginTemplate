package tigeax.mymcplugintemplate.util;

import tigeax.mymcplugintemplate.MyMCPluginTemplate;


public class Config extends YamlFile {

    private Boolean debug;

    public Config(MyMCPluginTemplate plugin) {
        super(plugin, "config.yml");

        loadConfigFromFile();
    }


    @Override
    public void update() {
        super.update();
        loadConfigFromFile();
    }

    private void loadConfigFromFile() {
        debug = getBoolean("debug");
    }


    public Boolean debug() {
        return this.debug;
    }
    
}
