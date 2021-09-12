package me.giodev.templateplugin.commands;

import me.giodev.templateplugin.TemplatePlugin;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TemplatePluginCommand implements @Nullable CommandExecutor {

  TemplatePlugin plugin;

  public TemplatePluginCommand(TemplatePlugin plugin){
    this.plugin = plugin;
  }

  @Override
  public boolean onCommand(@NotNull CommandSender sender, @NotNull Command c, @NotNull String s, String[] args) {

    if(sender instanceof Player){

      plugin.getLog().info("Test command working!");

      Player player = (Player) sender;

      player.sendMessage(plugin.getLanguageManager().getChatPrefix() + plugin.getLanguageManager().getHelloWorld());
      plugin.getLanguageManager().getTestSound().playSound(player);

    }

    return true;
  }
}
