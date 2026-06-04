package click.mevi.dev.kitpvp.mc.handlers;

import click.mevi.dev.kitpvp.Kitpvp;
import click.mevi.dev.kitpvp.mc.items.PluginItem;
import click.mevi.dev.kitpvp.mc.items.PluginItemListener;
import click.mevi.dev.kitpvp.mc.items.impl.KitSelectorItemListener;
import click.mevi.dev.kitpvp.mc.items.impl.TestingKitItemListener;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.HashMap;

public class ItemEventHandler implements Listener {
    private final HashMap<String, PluginItemListener> listeners = new HashMap<>();
    private final Kitpvp plugin;

    public ItemEventHandler(Kitpvp plugin) {
        this.plugin = plugin;

        addListener(new KitSelectorItemListener(plugin));
        addListener(new TestingKitItemListener());

        for (String key : listeners.keySet()) {
            plugin.getLogger().info(key);
        }
    }
    private void addListener(PluginItemListener listener) {
        listeners.put(listener.itemIdentifier(), listener);
    }
    @EventHandler
    public void onItemClick(PlayerInteractEvent event) {
        ItemStack itemStack = event.getItem();
        Player player = event.getPlayer();
        if (itemStack == null) {
            return;
        }
        ItemMeta itemMeta = itemStack.getItemMeta();

        if (itemMeta == null) {
            return;
        }

        PluginItemListener pluginItemListener = getListener(itemStack);
        if (pluginItemListener == null) {
            return;
        }
        pluginItemListener.onClickEvent(event);
    }

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event) {
        Player player = (Player) event.getDamager();
        ItemStack itemStack = player.getInventory().getItemInMainHand();

        ItemMeta itemMeta = itemStack.getItemMeta();

        if (itemMeta == null) {
            return;
        }

        PluginItemListener pluginItemListener = getListener(itemStack);
        if (pluginItemListener == null) {
            return;
        }
        pluginItemListener.onPlayerDamageAtEntity(event);
    }

    private PluginItemListener getListener(ItemStack itemStack) {
        if (itemStack == null) return null;

        ItemMeta meta = itemStack.getItemMeta();

        NamespacedKey key = new NamespacedKey(plugin, "item_identifier");

        if (!meta.getPersistentDataContainer().has(key)) {
            return null;
        }
        String identifier = meta.getPersistentDataContainer()
                .get(key, PersistentDataType.STRING);

        if (identifier == null) return null;

        return listeners.get(identifier);
    }
}
