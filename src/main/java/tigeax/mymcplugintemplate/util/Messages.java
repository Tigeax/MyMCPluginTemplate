package tigeax.mymcplugintemplate.util;

import org.bukkit.entity.Player;

import tigeax.mymcplugintemplate.MyMCPluginTemplate;


public class Messages extends YamlFile {


    private String test, commandSenderNotAPlayer;

    
    public Messages(MyMCPluginTemplate plugin) {
        super(plugin, "messages.yml");

        loadMessagesFromFile();
    }


    @Override
    public void update() {
        super.update();
        loadMessagesFromFile();
    }

    private void loadMessagesFromFile() {
        test                    = Util.parseChatColors(getString("test"));
        commandSenderNotAPlayer = Util.parseChatColors(getString("commandSenderNotAPlayer"));
    }


    public String test(Player player) {
        return test.replaceAll("{PLAYER}", player.getDisplayName());
    }

    public String commandSenderNotAPlayer() {
        return commandSenderNotAPlayer;
    }
        

    
}
