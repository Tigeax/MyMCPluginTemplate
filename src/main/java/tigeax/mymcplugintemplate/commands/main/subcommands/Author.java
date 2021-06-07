package tigeax.mymcplugintemplate.commands.main.subcommands;

import java.util.ArrayList;

import org.bukkit.command.CommandSender;

import tigeax.mymcplugintemplate.util.commands.SubCommand;

public class Author extends SubCommand {

    
    public Author(String name) {
        super(name);
        setPermission("myplugin.maincommand.author");
    }

    @Override
    public void onCommandHasPerm(CommandSender sender, ArrayList<String> args) {
        sender.sendMessage("This plugin is made by Tigeax");
    }

}
