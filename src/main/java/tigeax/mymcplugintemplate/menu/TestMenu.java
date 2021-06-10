package tigeax.mymcplugintemplate.menu;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import tigeax.mymcplugintemplate.menu.items.SubMenuItem;
import tigeax.mymcplugintemplate.menu.items.TestItem;
import tigeax.mymcplugintemplate.util.menu.ItemMenu;

public class TestMenu extends ItemMenu {

    public TestMenu(String name, Rows rows) {
        super(name, rows);

        TestMenu2 testMenu2 = new TestMenu2();

        setItem(0, new TestItem("Test", new ItemStack(Material.ACACIA_LOG), ""));
        setItem(1, new SubMenuItem("Other menu", new ItemStack(Material.CRAFTING_TABLE), testMenu2, "", "2"));
    }


    
}
