package me.giodev.templateplugin.data.gui.menus;

import me.giodev.templateplugin.data.gui.BaseGUI;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

public class TestMenu extends BaseGUI {

  public TestMenu(Player player) {
    super(player);
  }

  @Override
  public void handleClick(InventoryClickEvent event) {
    player.sendMessage("Testing");
  }

  @Override
  public void setupInventoryItems() {
    fillInventory();
  }

  @Override
  public String getName() {
    return "Test menu";
  }

  @Override
  public int getSize() {
    return 9;
  }
}
