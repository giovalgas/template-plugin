package me.giodev.templateplugin;

import me.giodev.templateplugin.commands.TemplatePluginCommand;
import me.giodev.templateplugin.data.config.ConfigManager;
import me.giodev.templateplugin.data.language.LanguageManager;
import me.giodev.templateplugin.utils.LoggerUtil;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;


public final class TemplatePlugin extends JavaPlugin {

  private ConfigManager configManager;
  private LanguageManager languageManager;
  private LoggerUtil log;

  @Override
  public void onEnable(){

    //Load config, language & logger
    loadConfig();
    loadLang();
    log = new LoggerUtil(this);

    //Commands & Events
    getCommand("tpcommand").setExecutor(new TemplatePluginCommand(this));

    log.info("Plugin fully started!");
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
