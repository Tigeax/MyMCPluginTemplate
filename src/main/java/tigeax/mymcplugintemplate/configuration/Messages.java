package tigeax.mymcplugintemplate.configuration;

import org.bukkit.entity.Player;

import tigeax.mymcplugintemplate.MyMCPluginTemplate;
import tigeax.mymcplugintemplate.util.Util;

public class Messages extends YamlFile {

    private MyMCPluginTemplate plugin;
    private String helloPlayer, commandSenderNotAPlayer, notEnoughArguments, reload, invalidSubCommand, noPermissionCommand;

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
        notEnoughArguments = getMessage("notEnoughArguments");
        reload = getMessage("reload");
        invalidSubCommand = getMessage("invalidSubCommand");
        noPermissionCommand = getMessage("noPermissionCommand");

    }

    public String helloPlayer(Player player) {
        return helloPlayer.replace("{PLAYER}", player.getDisplayName());
    }

    public String commandSenderNotAPlayer() {
        return commandSenderNotAPlayer;
    }

    public String reload() {
        return reload;
    }

    public String notEnoughArguments() {
        return notEnoughArguments;
    }

    public String invalidSubCommand() {
        return invalidSubCommand;
    }

    public String noPermissionCommand() {
        return noPermissionCommand;
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
