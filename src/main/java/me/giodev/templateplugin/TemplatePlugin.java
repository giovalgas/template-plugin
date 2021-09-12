package me.giodev.templateplugin;

import me.giodev.templateplugin.commands.BaseCommand;
import me.giodev.templateplugin.commands.CommandManager;
import me.giodev.templateplugin.commands.templatecommand.TemplatePluginCommand;
import me.giodev.templateplugin.data.config.ConfigManager;
import me.giodev.templateplugin.data.language.LanguageManager;
import me.giodev.templateplugin.utils.LoggerUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandMap;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;


public final class TemplatePlugin extends JavaPlugin {

  private ConfigManager configManager;
  private LanguageManager languageManager;
  private LoggerUtil log;
  private CommandManager cm;

  @Override
  public void onEnable(){

    //Load config, language & logger
    loadConfig();
    loadLang();
    log = new LoggerUtil(this);

    //Commands & Events
    loadCommands();

    log.info("Plugin fully started!");
  }

  private void loadCommand(BaseCommand command) {
    try {
      final Field bukkitCommandMap = Bukkit.getServer().getClass().getDeclaredField("commandMap");

      bukkitCommandMap.setAccessible(true);
      CommandMap commandMap = (CommandMap) bukkitCommandMap.get(Bukkit.getServer());

      commandMap.getKnownCommands().remove(command.getName());

      commandMap.register(command.getName(), command);
    } catch(Exception e) {
      e.printStackTrace();
    }

  }

  private void loadCommands() {
    cm = new CommandManager();
    cm.loadCommand(new TemplatePluginCommand(this));
  }

  private void loadConfig(){
    try {
      this.configManager = new ConfigManager(this);
    } catch (InvalidConfigurationException e) {
      e.printStackTrace();
    }
  }

  private void loadLang(){
    try {
      this.languageManager = new LanguageManager(this);
    } catch (InvalidConfigurationException e) {
      e.printStackTrace();
    }
  }

  public LoggerUtil getLog() { return log; }
  public ConfigManager getConfigManager() { return configManager; }
  public LanguageManager getLanguageManager() { return languageManager; }

}
