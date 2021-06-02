package tigeax.mymcplugintemplate.configuration;

import tigeax.mymcplugintemplate.MyMCPluginTemplate;


public class Config extends YamlFile {

    public Boolean debug;
    public String mainCommandName;

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
        mainCommandName = getString("mainCommandName");
    }
    
}
