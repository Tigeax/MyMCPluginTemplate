package tigeax.mymcplugintemplate.menu.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import tigeax.mymcplugintemplate.util.menu.ItemClickEvent;
import tigeax.mymcplugintemplate.util.menu.StaticMenuItem;

/**
 * A {@link ninja.amp.ampmenus.items.StaticMenuItem} that opens the {@link ninja.amp.ampmenus.menus.ItemMenu}'s parent menu if it exists.
 */
public class BackItem extends StaticMenuItem {

    public BackItem() {
        super(ChatColor.RED + "Back", new ItemStack(Material.RED_BED));
    }

    @Override
    public void onItemClick(ItemClickEvent event) {
        event.setWillGoBack(true);
    }
}
