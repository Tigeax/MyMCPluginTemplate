package tigeax.mymcplugintemplate.commands.main;

import java.util.ArrayList;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import tigeax.mymcplugintemplate.commands.SubCommand;
import tigeax.mymcplugintemplate.util.Util;

public class HelloWorld extends SubCommand {

    
    public HelloWorld(String name) {
        super(name);
    }

    @Override
    public void onCommand(CommandSender sender, ArrayList<String> args) {
        
        if (!(sender instanceof Player)) {
            Util.sendMessage(sender, plugin.getMessages().commandSenderNotAPlayer());
            return;
        }

        Player player = (Player) sender;

        Util.sendMessage(player, plugin.getMessages().helloPlayer(player));



    }
}
