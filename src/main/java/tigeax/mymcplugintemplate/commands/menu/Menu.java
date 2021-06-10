package tigeax.mymcplugintemplate.commands.menu;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

import tigeax.mymcplugintemplate.MyMCPluginTemplate;
import tigeax.mymcplugintemplate.menu.TestMenu;
import tigeax.mymcplugintemplate.util.commands.Command;
import tigeax.mymcplugintemplate.util.menu.ItemMenu.Rows;

public class Menu extends Command {
    
    public Menu(String name, List<String> aliases, String permission) {
        super(name, aliases);
        setPermission(permission);
    }

    @Override
    public void onCommandHasPermAndIsPlayer(Player player, ArrayList<String> args) {

        new TestMenu("test", Rows.ONE, MyMCPluginTemplate.getInstance()).open(player);
        return;
    }
}
