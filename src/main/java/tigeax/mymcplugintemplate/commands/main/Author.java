package tigeax.mymcplugintemplate.commands.main;

import java.util.ArrayList;

import org.bukkit.command.CommandSender;

import tigeax.mymcplugintemplate.commands.SubCommand;

public class Author extends SubCommand {

    
    public Author(String name) {
        super(name);
    }

    @Override
    public void onCommand(CommandSender sender, ArrayList<String> args) {
        sender.sendMessage("This plugin is made by Tigeax");
    }

}
