package click.mevi.dev.kitpvp.api.objects.impl;

import click.mevi.dev.kitpvp.mc.items.PluginItem;
import click.mevi.dev.kitpvp.mc.items.impl.KitSelectorItem;
import click.mevi.dev.kitpvp.api.objects.LobbyKit;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.plugin.Plugin;

import java.util.Arrays;
import java.util.List;

public class DefaultLobbyKit extends LobbyKit {
    private final Plugin plugin;
    public DefaultLobbyKit(Plugin plugin) {
        super("default_lobby", Component.text("Lobby", NamedTextColor.GREEN), Material.COMPASS);
        this.plugin = plugin;
    }

    @Override
    public List<PluginItem> getItems() {
        KitSelectorItem kitSelectorItem = new KitSelectorItem(plugin);
        return Arrays.asList(kitSelectorItem);
    }

    @Override
    public List<Component> getDescription() {
        return List.of();
    }
}
