package click.mevi.dev.kitpvp.objects;

import click.mevi.dev.kitpvp.mc.items.PluginItem;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.List;

public abstract class Kit {
    private final String identifier;
    private final Component displayName;
    private final Material showItemMaterial;
    private List<PluginItem> items;
    private List<Component> description;

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

    public List<PluginItem> getItems() {
        return items;
    }

    public List<Component> getDescription() {
        return description;
    }


    public void setItems(List<PluginItem> items) {
        this.items = items;
    }

    public void setDescription(List<Component> description) {
        this.description = description;
    }
}
