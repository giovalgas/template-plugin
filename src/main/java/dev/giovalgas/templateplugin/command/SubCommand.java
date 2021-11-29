package dev.giovalgas.templateplugin.command;


import dev.giovalgas.templateplugin.TemplatePlugin;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface SubCommand {
  void executeCommand(CommandSender sender, String[] args, TemplatePlugin plugin);

  @NotNull String getPermission();

  @Nullable String[] getArguments();

}
