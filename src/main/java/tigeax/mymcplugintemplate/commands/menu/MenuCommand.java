package tigeax.mymcplugintemplate.commands.menu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import tigeax.mymcplugintemplate.commands.Command;
import tigeax.mymcplugintemplate.commands.SubCommand;
import tigeax.mymcplugintemplate.util.Util;

public class MenuCommand extends Command {
    
    public MenuCommand(String name, List<String> aliases, String permission) {
        super(name, aliases, permission);
        setupSubCommands();
    }

    private void setupSubCommands() {
        super.subCommands.add(new Sub1("sub1"));
    }

    @Override
    public boolean execute(CommandSender sender, String alias, String[] args) {

        if (!sender.hasPermission(permission)) {
            Util.sendMessage(sender, plugin.getMessages().noPermissionCommand());
            return true;
        }

        if (!(sender instanceof Player)) {
            Util.sendMessage(sender, plugin.getMessages().commandSenderNotAPlayer());
            return true;
        }

        Player player = (Player) sender;

        if (args.length == 0) {
            Util.sendMessage(player, "Open GUI");
            return true;
        }

        SubCommand target = this.getSubCommand(args[0]);

        if (target == null) {
            Util.sendMessage(sender, plugin.getMessages().invalidSubCommand());
            return true;
        }

        ArrayList<String> argsList = new ArrayList<String>(Arrays.asList(args));
        argsList.remove(0);

        target.onCommand(sender, argsList);

        return true;
    }


}
