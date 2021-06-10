package tigeax.mymcplugintemplate.menu.items;

import org.bukkit.inventory.ItemStack;

import tigeax.mymcplugintemplate.util.menu.ItemClickEvent;
import tigeax.mymcplugintemplate.util.menu.MenuItem;

public class TestItem extends MenuItem {

    public TestItem(String displayName, ItemStack icon, String... lore) {
        super(displayName, icon, lore);
    }

    @Override
    public void onItemClick(ItemClickEvent event) {
        event.getPlayer().closeInventory();
    }
    
}
