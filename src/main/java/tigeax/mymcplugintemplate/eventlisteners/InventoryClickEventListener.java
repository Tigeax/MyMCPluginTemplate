package tigeax.mymcplugintemplate.eventlisteners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import tigeax.mymcplugintemplate.util.menu.MenuHolder;

public class InventoryClickEventListener implements Listener{

    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onInventoryClick(InventoryClickEvent event) {

        if (event.getWhoClicked() instanceof Player && event.getInventory().getHolder() instanceof MenuHolder) {

            event.setCancelled(true);

            MenuHolder menuHolder = ((MenuHolder) event.getInventory().getHolder());
            
            menuHolder.getMenu().onInventoryClick(event);
        }

    }
    
}
