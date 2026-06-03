package click.mevi.dev.kitpvp.items.impl;

import click.mevi.dev.kitpvp.items.HubItem;
import click.mevi.dev.kitpvp.items.PluginItemListener;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.components.CustomModelDataComponent;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

import javax.naming.Name;
import java.util.Arrays;

public class KitSelectorItem extends HubItem {
    public KitSelectorItem(Plugin plugin) {
        super(plugin, "kit_selector", 1);

        ItemStack itemStack = ItemStack.of(Material.COMPASS);
        ItemMeta itemMeta = itemStack.getItemMeta();

        itemMeta.displayName(Component.text("Selector de items",  NamedTextColor.YELLOW));
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        itemMeta.lore(Arrays.asList(
                Component.text("Empieza a jugar", NamedTextColor.WHITE)
        ));
        NamespacedKey identifier_key = new NamespacedKey(plugin, "item_identifier");
        itemMeta.getPersistentDataContainer().set(identifier_key, PersistentDataType.STRING, getIdentifier());
        itemStack.setItemMeta(itemMeta);
        setItem(itemStack);
    }
}
