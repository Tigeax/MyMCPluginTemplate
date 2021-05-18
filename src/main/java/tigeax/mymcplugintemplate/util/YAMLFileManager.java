package tigeax.mymcplugintemplate.util;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import tigeax.mymcplugintemplate.MyMCPluginTemplate;


public class YAMLFileManager extends YamlConfiguration {


    private final MyMCPluginTemplate plugin;
    private final String filename;
    private final File file;


    public YAMLFileManager(MyMCPluginTemplate plugin, String filename) {

        this.plugin = plugin;
        this.filename = filename;
        this.file = new File(plugin.getDataFolder(), filename);
        
        update();
    }

    /**
    * Reload/update the file, for when it was externally edited.
    * Check if it exists, and if not create it by calling createIfNotExists().
    */
    public void update() {
        createIfNotExists();

        try {
            load(file);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    /**
    * Check if the file exists, if not create it by calling createFile().
    */
    private void createIfNotExists() {
        if (!file.exists()) {
            createFile();
        }
    }

    /**
    * Create the specified file, overwriting it if it already exists.
    */
    private void createFile() {
        plugin.getLogger().info(filename + " file does not exists. Creating it...");
        file.getParentFile().mkdirs();
        plugin.saveResource(filename, false);
    }
}
