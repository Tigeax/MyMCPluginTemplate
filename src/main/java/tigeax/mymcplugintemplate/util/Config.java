package tigeax.mymcplugintemplate.util;

import tigeax.mymcplugintemplate.MyMCPluginTemplate;


public class Config extends YamlFile {

    private Boolean debug;
    private String mainCommandName;

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
        mainCommandName = getString("main_command_name");
    }


    public Boolean debug() {
        return this.debug;
    }
    
    public String mainCommandName() {
        return this.mainCommandName;
    }

    
}
