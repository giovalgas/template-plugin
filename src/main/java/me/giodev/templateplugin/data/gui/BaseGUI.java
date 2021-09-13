package me.giodev.templateplugin.data.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public abstract class BaseGUI implements InventoryHolder {

  protected Inventory inventory;
  protected Player player;

  public BaseGUI (Player player) {
    this.player = player;
  }

  public void open() {
    inventory = Bukkit.createInventory(this, getSize(), getName());
    this.setupInventoryItems();
    player.openInventory(inventory);

  }

  public void fillInventory() {
    for(int i = 0; i < getSize(); i++) {
      if(inventory.getItem(i) == null) {
        inventory.setItem(i, new ItemStack(Material.BLACK_STAINED_GLASS_PANE)); // Change it later to XMaterial
      }
    }
  }

  public abstract void handleClick(InventoryClickEvent event);

  public abstract void setupInventoryItems();

  public abstract String getName();

  public abstract int getSize();

  @Override
  public @NotNull Inventory getInventory() {
    return inventory;
  }
}
