package tigeax.mymcplugintemplate.configuration;

import org.bukkit.entity.Player;

import tigeax.mymcplugintemplate.MyMCPluginTemplate;
import tigeax.mymcplugintemplate.util.Util;

public class Messages extends YamlFile {

    private MyMCPluginTemplate plugin;
    private String helloPlayer, commandSenderNotAPlayer;

    public Messages(MyMCPluginTemplate plugin) {
        super(plugin, "messages.yml");
        this.plugin = plugin;
        loadMessagesFromFile();
    }

    public void update() {
        super.updateFile();
        loadMessagesFromFile();
    }

    private void loadMessagesFromFile() {
        helloPlayer = getMessage("helloPlayer");
        commandSenderNotAPlayer = getMessage("commandSenderNotAPlayer");

    }

    public String helloPlayer(Player player) {
        return helloPlayer.replaceAll("{PLAYER}", player.getDisplayName());
    }

    public String commandSenderNotAPlayer() {
        return commandSenderNotAPlayer;
    }

    private String getMessage(String path) {
        String message;

        try {
            message = Util.parseChatColors(getString(path));
        } catch (IllegalArgumentException e) {
            message = "";
            plugin.getLogger().warning("Failed to get message " + path + " from messages.yml");
        }

        return message;
    }

}
