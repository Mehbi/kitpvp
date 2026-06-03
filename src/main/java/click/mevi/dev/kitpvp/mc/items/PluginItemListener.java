package click.mevi.dev.kitpvp.items;

import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public interface PluginItemListener {
    void onClickEvent(PlayerInteractEvent e);
    void onPlayerDamageAtEntity(PlayerInteractAtEntityEvent e);
}
