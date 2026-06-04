package click.mevi.dev.kitpvp.api.objects.impl;

import click.mevi.dev.kitpvp.Kitpvp;
import click.mevi.dev.kitpvp.api.objects.Kit;
import click.mevi.dev.kitpvp.mc.inventories.items.KitPreviewItem;
import click.mevi.dev.kitpvp.mc.items.PluginItem;
import click.mevi.dev.kitpvp.mc.items.impl.TestingKitItem;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;

import java.util.List;

public class TestingKit extends Kit {
    private final Kitpvp plugin;
    public TestingKit(Kitpvp plugin) {
        super("testing", Component.text("Testing", NamedTextColor.YELLOW), Material.RABBIT_HIDE);
        this.plugin = plugin;
    }

    @Override
    public List<PluginItem> getItems() {
        TestingKitItem testingKitItem = new TestingKitItem(plugin);
        return List.of(testingKitItem);
    }

    @Override
    public List<Component> getDescription() {
        return List.of();
    }
}
