package me.giodev.templateplugin.commands.templatecommand.subcommands;

import me.giodev.templateplugin.TemplatePlugin;
import me.giodev.templateplugin.commands.SubCommand;
import me.giodev.templateplugin.data.gui.menus.TestMenu;
import me.giodev.templateplugin.data.permissions.Permission;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TestSubCommand implements SubCommand {
  @Override
  public void executeCommand(CommandSender sender, String[] args, TemplatePlugin plugin) {
    sender.sendMessage(plugin.getLanguageManager().getHelloWorld());

    Player player = (Player) sender;
    new TestMenu(player).open();

    if(sender instanceof Player){
      plugin.getLanguageManager().getClickSound().playSound((Player) sender);
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
