package tigeax.mymcplugintemplate.util;

import org.bukkit.entity.Player;

import tigeax.mymcplugintemplate.MyMCPluginTemplate;


public class Messages extends YamlFile {


    private String test;

    
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
        test = Util.parseChatColors(getString("test"));
    }


    public String test(Player player) {
        return test.replaceAll("{PLAYER}", player.getDisplayName());
    }
        

    
}
