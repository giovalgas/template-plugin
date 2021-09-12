package me.giodev.templateplugin.data.language;

import me.giodev.multiversion.MultiVersionSound;
import org.bukkit.ChatColor;

public class LanguageDefaults {

  //messages
  public static final String MESSAGE_PREFIX = ChatColor.RED + "[" + ChatColor.GOLD + "Template Plugin" + ChatColor.RED + "] ";
  public static final String HELLO_WORLD = MESSAGE_PREFIX + ChatColor.GREEN + "Hello World!";

  //sounds
  public static final MultiVersionSound TEST_SOUND = MultiVersionSound.CLICK;

}