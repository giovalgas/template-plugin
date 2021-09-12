package me.giodev.templateplugin.commands.templatecommand.subcommands;

import me.giodev.multiversion.MultiVersionSound;
import me.giodev.templateplugin.TemplatePlugin;
import me.giodev.templateplugin.commands.SubCommand;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestSubCommand implements SubCommand {
  @Override
  public void executeCommand(CommandSender sender, String[] args, TemplatePlugin plugin) {
    sender.sendMessage(plugin.getLanguageManager().getHelloWorld());
    if(sender instanceof Player){
      plugin.getLanguageManager().getTestSound().playSound((Player) sender);
    }
  }
}
