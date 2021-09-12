package me.giodev.templateplugin.commands;


import me.giodev.templateplugin.TemplatePlugin;
import org.bukkit.command.CommandSender;

public interface SubCommand {
  void executeCommand(CommandSender sender, String[] args, TemplatePlugin plugin);
}
