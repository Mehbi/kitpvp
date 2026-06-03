package click.mevi.dev.kitpvp.handlers;

import click.mevi.dev.kitpvp.mc.items.PluginItem;
import click.mevi.dev.kitpvp.mc.items.PluginItemListener;

import java.util.HashMap;

public class ItemEventHandler {
    private final HashMap<String, PluginItemListener> listeners = new HashMap<>();

    public PluginItemListener getById(String identifier) {
       return listeners.get(identifier);
    }
    public void addListener(PluginItem item, PluginItemListener listener) {
        listeners.put(item.getIdentifier(), listener);
    }
}
