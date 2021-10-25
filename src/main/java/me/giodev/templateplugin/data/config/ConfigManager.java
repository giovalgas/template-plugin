package me.giodev.templateplugin.data.config;

import lombok.AccessLevel;
import lombok.Getter;
import me.giodev.templateplugin.TemplatePlugin;
import org.bukkit.configuration.InvalidConfigurationException;

@Getter
public class ConfigManager {

  //Plugin
  private final @Getter(value = AccessLevel.NONE) TemplatePlugin plugin;

  //Config Values
  private String consolePrefix;

  public ConfigManager(TemplatePlugin plugin) throws InvalidConfigurationException {
    this.plugin = plugin;
    load();
  }

  private void load() throws InvalidConfigurationException {
    ConfigFile config = new ConfigFile(plugin);
    config.load();

    this.consolePrefix = config.getString(ConfigKeys.CONSOLE_PREFIX, ConfigDefaults.CONSOLE_PREFIX);

  }

  public void reload() throws InvalidConfigurationException {
    load();
  }

}
