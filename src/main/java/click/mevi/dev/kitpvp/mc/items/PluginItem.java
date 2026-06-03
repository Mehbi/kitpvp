package click.mevi.dev.kitpvp.items;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public abstract class PluginItem {
    protected final Plugin plugin;
    private final String identifier;
    private ItemStack item;
    public PluginItem(Plugin plugin, String identifier) {
        this.plugin = plugin;
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
    }

    public ItemStack getItem() {
        return item;
    }

    public Plugin getPlugin() {
        return plugin;
    }

    public void setItem(ItemStack item) {
        this.item = item;
    }

    public void give(Player player) {
        player.getInventory().addItem(item);
    }

    public void remove(Player player) {
        player.getInventory().remove(item);
    }
}
