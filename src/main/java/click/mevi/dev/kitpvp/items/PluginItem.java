package click.mevi.dev.kitpvp.objects;

import org.bukkit.inventory.ItemStack;

public abstract class PluginItem {
    private String identifier;
    private ItemStack item;
    public PluginItem(String identifier, ItemStack item) {
        this.identifier = identifier;
        this.item = item;
    }
    

}
