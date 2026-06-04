package click.mevi.dev.kitpvp.api.objects;

import click.mevi.dev.kitpvp.mc.items.PluginItem;
import click.mevi.dev.kitpvp.mc.items.PluginItemListener;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

import java.util.List;

public abstract class Kit {
    private final String identifier;
    private final Component displayName;
    private final Material showItemMaterial;

    public Kit(String identifier, Component displayName, Material showItemMaterial) {
        this.identifier = identifier;
        this.displayName = displayName;
        this.showItemMaterial = showItemMaterial;
    }

    public String getIdentifier() {
        return identifier;
    }

    public Component getDisplayName() {
        return displayName;
    }

    public Material getShowItemMaterial() {
        return showItemMaterial;
    }

    public abstract List<PluginItem> getItems();

    public abstract List<Component> getDescription();

    public void apply(Player player) {
        for (PluginItem pluginItem : getItems()) {
            pluginItem.give(player);
        }
    }
}
