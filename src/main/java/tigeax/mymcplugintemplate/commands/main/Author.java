package tigeax.mymcplugintemplate.commands.main;

import org.bukkit.command.CommandSender;

import tigeax.mymcplugintemplate.commands.SubCommand;

public class Author extends SubCommand {

    
    public Author(String name) {
        super(name);
    }

    @Override
    public void onCommand(CommandSender sender, String[] args) {
        sender.sendMessage("This plugin is made by Tigeax");
    }

    @Override
    public String info() {
        return null;
    }

    @Override
    public String[] aliases() {
        return new String[0];
    }

}
