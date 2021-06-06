package tigeax.mymcplugintemplate.commands.main;

import java.util.ArrayList;

import org.bukkit.command.CommandSender;

import tigeax.mymcplugintemplate.MyMCPluginTemplate;
import tigeax.mymcplugintemplate.commands.SubCommand;
import tigeax.mymcplugintemplate.util.Util;

public class Reload extends SubCommand {

    public Reload(String name) {
        super(name);
    }

    @Override
    public void onCommand(CommandSender sender, ArrayList<String> args) {
        Util.sendMessage(sender, plugin.getMessages().reload());
        MyMCPluginTemplate.getInstance().reload();
    }

}
