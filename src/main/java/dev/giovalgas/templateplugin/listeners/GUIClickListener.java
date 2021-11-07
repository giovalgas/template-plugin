package dev.giovalgas.templateplugin.listeners;

import dev.giovalgas.templateplugin.data.gui.BaseGUI;
import dev.giovalgas.templateplugin.TemplatePlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryHolder;

public class GUIClickListener implements Listener {

  private TemplatePlugin plugin;

  public GUIClickListener(TemplatePlugin plugin) {
    this.plugin = plugin;
  }

  @EventHandler
  public void onClick(InventoryClickEvent event) {

    InventoryHolder holder = event.getInventory().getHolder();

    if(holder instanceof BaseGUI) {

      event.setCancelled(true);
      plugin.getLanguageManager().getClickSound().play((Player) event.getWhoClicked());

      if(event.getCurrentItem() == null) return;

      BaseGUI gui = (BaseGUI) holder;

      gui.handleClick(event);

    }

  }


}
