package tigeax.mymcplugintemplate.command;

import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;

public class mainCommand extends BukkitCommand {

    public mainCommand(String cmdName) {
        super(cmdName);
    }

    @Override
    public boolean execute(CommandSender sender, String commandLabel, String[] args) {
        sender.sendMessage("hello"));
        return false;
    }
    
}
