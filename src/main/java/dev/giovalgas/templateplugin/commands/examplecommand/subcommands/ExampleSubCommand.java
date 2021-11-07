package dev.giovalgas.templateplugin.commands.examplecommand.subcommands;

import dev.giovalgas.templateplugin.TemplatePlugin;
import dev.giovalgas.templateplugin.data.gui.menus.ExamplePaginatedMenu;
import dev.giovalgas.templateplugin.data.permissions.Permission;
import dev.giovalgas.templateplugin.commands.SubCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ExampleSubCommand implements SubCommand {
  @Override
  public void executeCommand(CommandSender sender, String[] args, TemplatePlugin plugin) {
    sender.sendMessage(plugin.getLanguageManager().getHelloWorld());

    Player player = (Player) sender;
    //new ExampleMenu(player).open();

    new ExamplePaginatedMenu(player).open();

    if(sender instanceof Player){
      plugin.getLanguageManager().getClickSound().play((Player) sender);
    }
  }

  @Override
  public @NotNull String getPermission() {
    return Permission.ADMIN;
  }

  @Override
  public @Nullable String[] getArguments() {
    return null;
  }
}
