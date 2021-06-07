package tigeax.mymcplugintemplate.commands.menu;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

import tigeax.mymcplugintemplate.commands.Command;
import tigeax.mymcplugintemplate.util.Util;

public class Menu extends Command {
    
    public Menu(String name, List<String> aliases, String permission) {
        super(name, aliases);
        setPermission(permission);
    }

    @Override
    public void onCommandHasPermAndIsPlayer(Player player, ArrayList<String> args) {

        Util.sendMessage(player, "Open GUI");
        return;
    }
}
