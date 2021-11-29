package dev.giovalgas.templateplugin.command.examplecommand;

import dev.giovalgas.templateplugin.command.BaseCommand;
import dev.giovalgas.templateplugin.TemplatePlugin;
import dev.giovalgas.templateplugin.command.examplecommand.subcommands.ExampleSubCommand;
import dev.giovalgas.templateplugin.data.permission.Permission;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import java.util.Arrays;
import java.util.List;

public class ExampleCommand extends BaseCommand {

  public ExampleCommand(TemplatePlugin plugin) {
    super(plugin);
    subCommands.put("TEST", new ExampleSubCommand());
  }


  @Override
  public void executeStockSubCommand(CommandSender sender) {
    plugin.getLog().info("executing stock command!");
  }

  @Override
  public @NotNull String getPermission() {
    return Permission.TPCOMMAND;
  }

  @Override
  public @NotNull String getName() {
    return "excommand";
  }


  @Override
  public @NotNull List<String> getAliases() { return Arrays.asList(new String[]{"excmd"}.clone()); }

  @Override
  public boolean isPlayerOnly() {
    return false;
  }


}
