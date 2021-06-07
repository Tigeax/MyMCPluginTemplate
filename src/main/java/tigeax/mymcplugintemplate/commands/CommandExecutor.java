package tigeax.mymcplugintemplate.commands;

import java.util.ArrayList;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public interface CommandExecutor {

    public void setPermission(String permission);

    public String getPermision();

    public void onCommand(CommandSender sender, ArrayList<String> args);

    public void onCommandHasPerm(CommandSender sender, ArrayList<String> args);

    public void onCommandHasPermAndIsPlayer(Player player, ArrayList<String> args);

    public void onCommandHasPermAndIsConsole(CommandSender sender, ArrayList<String> args);
    
}
