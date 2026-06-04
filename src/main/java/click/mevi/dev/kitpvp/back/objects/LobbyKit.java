package click.mevi.dev.kitpvp.api.objects;

import net.kyori.adventure.text.Component;
import org.bukkit.Material;

public abstract class LobbyKit extends Kit{
    public LobbyKit(String identifier, Component displayName, Material showItemMaterial) {
        super(identifier, displayName, showItemMaterial);
    }
}
