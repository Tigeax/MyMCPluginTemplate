package tigeax.mymcplugintemplate.menu.items;


import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import tigeax.mymcplugintemplate.MyMCPluginTemplate;
import tigeax.mymcplugintemplate.util.menu.ItemClickEvent;
import tigeax.mymcplugintemplate.util.menu.ItemMenu;
import tigeax.mymcplugintemplate.util.menu.MenuItem;

/**
 * A {@link MenuItem} that opens a sub {@link ItemMenu}.
 */
public class SubMenuItem extends MenuItem {
    private final JavaPlugin plugin;
    private final ItemMenu menu;

    public SubMenuItem(String displayName, ItemStack icon, ItemMenu menu, String... lore) {
        super(displayName, icon, lore);
        this.plugin = MyMCPluginTemplate.getInstance();
        this.menu = menu;
    }

    @Override
    public void onItemClick(ItemClickEvent event) {
        event.setWillClose(true);
        final String playerName = event.getPlayer().getName();
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            public void run() {
                Player p = Bukkit.getPlayerExact(playerName);
                if (p != null) {
                    menu.open(p);
                }
            }
        }, 3);
    }
}
