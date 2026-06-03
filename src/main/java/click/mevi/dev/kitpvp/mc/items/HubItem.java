package click.mevi.dev.kitpvp.items;

import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public abstract class HubItem extends PluginItem{
    public HubItem(Plugin plugin, String identifier, int customModelDataId) {
        super(plugin, identifier, customModelDataId);
    }
}
