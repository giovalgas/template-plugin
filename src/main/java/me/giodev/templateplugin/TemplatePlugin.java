package me.giodev.templateplugin;

import me.giodev.templateplugin.commands.TemplatePluginCommand;
import me.giodev.templateplugin.data.config.ConfigManager;
import me.giodev.templateplugin.data.language.LanguageManager;
import org.bukkit.Bukkit;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.plugin.java.JavaPlugin;


public final class TemplatePlugin extends JavaPlugin {

  private ConfigManager configManager;
  private LanguageManager languageManager;

  @Override
  public void onEnable(){

    //Load config & language
    loadConfig();
    loadLang();

    //Commands & Events
    getCommand("tpcommand").setExecutor(new TemplatePluginCommand(this));

    Bukkit.getConsoleSender().sendMessage(configManager.getConsolePrefix() + "Plugin fully started");
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

  public ConfigManager getConfigManager() {
    return configManager;
  }

  public LanguageManager getLanguageManager() {
    return languageManager;
  }

}
