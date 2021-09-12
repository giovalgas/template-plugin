package me.giodev.templateplugin.commands;

import me.giodev.templateplugin.TemplatePlugin;
import me.giodev.templateplugin.commands.templatecommand.TemplatePluginCommand;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.command.TabExecutor;

import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;

public abstract class BaseCommand extends BukkitCommand implements TabCompleter {

  protected HashMap<String, SubCommand> subcommands = new HashMap<>();
  protected TemplatePlugin plugin;

  public BaseCommand(String name, TemplatePlugin plugin) {
    super(name);
    this.plugin = plugin;
    this.description = getDescription();
    this.usageMessage = getUsage();
    this.setAliases(getAliases());
    this.setPermission(getPermission());
  }

  @Override
  public boolean execute(@NotNull CommandSender sender, @NotNull String s, @NotNull String[] args) {

    if(!(isPlayerOnly()) || sender instanceof Player) {
      if(args.length > 0 && subcommands.get(args[0].toUpperCase()) != null) {
        subcommands.get(args[0].toUpperCase()).executeCommand(sender, args, plugin);
      }else{
        executeStockSubCommand(sender);
      }
    }

    return true;
  }

  @Override
  public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
    return null;
  }

  public abstract @NotNull String getPermission();

  public abstract @NotNull String getUsage();

  public abstract @NotNull List<String> getAliases();

  public abstract @NotNull String getDescription();

  public abstract boolean isPlayerOnly();

  public abstract void executeStockSubCommand(CommandSender sender);


}
