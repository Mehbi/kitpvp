package click.mevi.dev.kitpvp.objects.impl;

import click.mevi.dev.kitpvp.mc.items.PluginItem;
import click.mevi.dev.kitpvp.mc.items.impl.KitSelectorItem;
import click.mevi.dev.kitpvp.objects.Kit;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.plugin.Plugin;

import java.util.Arrays;
import java.util.List;

public class LobbyKit extends Kit {
    private final Plugin plugin;
    public LobbyKit(Plugin plugin) {
        super("lobby", Component.text("Lobby", NamedTextColor.GREEN), Material.COMPASS);
        this.plugin = plugin;
    }

    @Override
    public List<PluginItem> getItems() {
        KitSelectorItem kitSelectorItem = new KitSelectorItem(plugin);
        return Arrays.asList(kitSelectorItem);
    }
}
