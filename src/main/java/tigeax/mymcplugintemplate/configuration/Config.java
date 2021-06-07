package tigeax.mymcplugintemplate.configuration;

import java.util.List;

import tigeax.mymcplugintemplate.MyMCPluginTemplate;
import tigeax.mymcplugintemplate.util.YamlFile;

public class Config extends YamlFile {

    public Boolean debug;
    public String mainCommandName;
    public List<String> mainCommandAliases;
    public String guiCommandName;
    public List<String> guiCommandAliases;

    public Config(MyMCPluginTemplate plugin) {
        super(plugin, "config.yml");
        loadConfigFromFile();
    }

    /** Reload the config file and get the settings again */
    public void update() {
        super.updateFile();
        loadConfigFromFile();
    }

    /** Load settings from config. If not found, use the default value */
    private void loadConfigFromFile() {

        // Debug
        debug = getBoolean("debug", true);

        // Main command
        mainCommandName = getString("mainCommandName", "main");
        mainCommandAliases = getStringList("mainCommandAliases");

        // GUI command
        guiCommandName = getString("guiCommandName", "menu");
        guiCommandAliases = getStringList("guiCommandAliases");

    }

}
