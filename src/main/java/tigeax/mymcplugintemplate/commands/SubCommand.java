package tigeax.mymcplugintemplate.commands;

import java.util.ArrayList;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import tigeax.mymcplugintemplate.MyMCPluginTemplate;
import tigeax.mymcplugintemplate.util.Util;

/** 
 * A sub command to be called from {@link Command}.
 * Impementing {@link CommandExecutor}.
 * Extention classes can implement {@link SubCommandManager}.
 */
public abstract class SubCommand implements CommandExecutor {

    protected MyMCPluginTemplate plugin;
    private String name;
    public String permission = "";

    public SubCommand(String name) {
        plugin = MyMCPluginTemplate.getInstance();
        this.name = name.toLowerCase();
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getPermision() {
        return permission;
    }

    public String name() {
        return name;
    }

    public String[] aliases() {
        return new String[0];
    }

    @Override
    public void onCommand(CommandSender sender, ArrayList<String> args) {

        if (!sender.hasPermission(permission)) {
            Util.sendMessage(sender, plugin.getMessages().noPermissionCommand());
            return;
        }

        onCommandHasPerm(sender, args);

    }

    @Override
    public void onCommandHasPerm(CommandSender sender, ArrayList<String> args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            onCommandHasPermAndIsPlayer(player, args);
        } else {
            onCommandHasPermAndIsConsole(sender, args);
        }
    }

    @Override
    public void onCommandHasPermAndIsPlayer(Player player, ArrayList<String> args) {
        Util.sendMessage(player, plugin.getMessages().commandSenderNotConsole());
    }

    @Override
    public void onCommandHasPermAndIsConsole(CommandSender sender, ArrayList<String> args) {
        Util.sendMessage(sender, plugin.getMessages().commandSenderNotAPlayer());
    }
}
