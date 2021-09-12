package me.giodev.templateplugin.commands.templatecommand;

import me.giodev.templateplugin.TemplatePlugin;
import me.giodev.templateplugin.commands.BaseCommand;
import me.giodev.templateplugin.commands.templatecommand.subcommands.TestCommand;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import java.util.Arrays;
import java.util.List;

public class TemplatePluginCommand extends BaseCommand {

  public TemplatePluginCommand(TemplatePlugin plugin) {
    super("tpcommand", plugin);
    subcommands.put("TEST", new TestCommand());
  }

  @Override
  public void executeStockSubCommand(CommandSender sender) {
    plugin.getLog().info("executing stock command!");
  }

  @Override
  public @NotNull String getUsage() {
    return "/tpcommand <args>";
  }

  @Override
  public @NotNull List<String> getAliases() { return Arrays.asList(new String[]{"tpcmd"}.clone()); }

  @Override
  public @NotNull String getDescription() {
    return "Template Command";
  }

  @Override
  public boolean isPlayerOnly() {
    return false;
  }


}