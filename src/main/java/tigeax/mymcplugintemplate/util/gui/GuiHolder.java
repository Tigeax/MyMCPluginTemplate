package tigeax.mymcplugintemplate.util.gui;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class GuiHolder implements InventoryHolder {

    Inventory inventory;

    public GuiHolder() {
        
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }
    
}
