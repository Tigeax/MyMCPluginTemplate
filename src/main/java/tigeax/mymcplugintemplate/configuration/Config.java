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
        loadDataFromFile();
    }

    protected void loadDataFromFile() {

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
