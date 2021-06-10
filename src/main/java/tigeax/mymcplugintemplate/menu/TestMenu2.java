package tigeax.mymcplugintemplate.menu;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import tigeax.mymcplugintemplate.menu.items.TestItem;
import tigeax.mymcplugintemplate.util.menu.ItemMenu;

public class TestMenu2 extends ItemMenu {

    public TestMenu2() {
        super("test2 menu", Rows.FIVE);

        setItem(0, new TestItem("Test2", new ItemStack(Material.ACACIA_LOG), ""));
    }


    
}
