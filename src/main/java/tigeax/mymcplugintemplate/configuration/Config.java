package tigeax.mymcplugintemplate.configuration;

import java.util.List;

import tigeax.mymcplugintemplate.MyMCPluginTemplate;

public class Config extends YamlFile {

    private MyMCPluginTemplate plugin;

    public Boolean debug;
    public String mainCommandName;
    public List<String> mainCommandAliases;
    public String guiCommandName;
    public List<String> guiCommandAliases;

    public Config(MyMCPluginTemplate plugin) {
        super(plugin, "config.yml");
        this.plugin = plugin;

        loadConfigFromFile();
    }

    public void update() {
        super.updateFile();
        loadConfigFromFile();
    }

    private void loadConfigFromFile() {

        // Debug
        debug = getBoolean("debug");

        // Main command
        mainCommandName = getString("mainCommandName");
        mainCommandAliases = getStringList("mainCommandAliases");

        // GUI command
        guiCommandName = getString("guiCommandName");
        guiCommandAliases = getStringList("guiCommandAliases");
    }

}
