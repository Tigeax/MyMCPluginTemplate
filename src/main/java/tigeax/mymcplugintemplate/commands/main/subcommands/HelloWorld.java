package tigeax.mymcplugintemplate.commands.main.subcommands;

import java.util.ArrayList;

import org.bukkit.entity.Player;

import tigeax.mymcplugintemplate.util.Util;
import tigeax.mymcplugintemplate.util.commands.SubCommand;

public class HelloWorld extends SubCommand {

    
    public HelloWorld(String name) {
        super(name);
        setPermission("myplugin.maincommand.helloworld");
    }

    @Override
    public void onCommandHasPermAndIsPlayer(Player player, ArrayList<String> args) {
        Util.sendMessage(player, plugin.getMessages().helloPlayer(player));
    }
}
