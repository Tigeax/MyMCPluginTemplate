package tigeax.mymcplugintemplate.commands.main.subcommands;

import java.util.ArrayList;

import org.bukkit.command.CommandSender;

import tigeax.mymcplugintemplate.MyMCPluginTemplate;
import tigeax.mymcplugintemplate.commands.SubCommand;
import tigeax.mymcplugintemplate.util.Util;

public class Reload extends SubCommand {

    public Reload(String name) {
        super(name);
        setPermission("myplugin.maincommand.reload");
    }

    @Override
    public void onCommandHasPerm(CommandSender sender, ArrayList<String> args) {
        Util.sendMessage(sender, plugin.getMessages().reload());
        MyMCPluginTemplate.getInstance().reload();
    }

}
