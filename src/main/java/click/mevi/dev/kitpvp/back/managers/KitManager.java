package click.mevi.dev.kitpvp.api.managers;

import click.mevi.dev.kitpvp.Kitpvp;
import click.mevi.dev.kitpvp.api.objects.Kit;
import click.mevi.dev.kitpvp.api.objects.impl.DefaultLobbyKit;
import click.mevi.dev.kitpvp.api.objects.impl.TestingKit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class KitManager {
    private final HashMap<String, Kit> kits = new HashMap<>();
    public KitManager(Kitpvp plugin) {
        registerKit(new DefaultLobbyKit(plugin));
        registerKit(new TestingKit(plugin));
    }

    private void registerKit(Kit kit) {
        kits.put(kit.getIdentifier(), kit);
    }

    public <T extends Kit> T get(String identifier) {
        return (T) kits.get(identifier);
    }
    public List<Kit> all() {
        return new ArrayList<>(kits.values());
    }
}
