package me.giodev.templateplugin;

import lombok.Getter;
import lombok.SneakyThrows;
import me.giodev.templateplugin.commands.BaseCommand;
import me.giodev.templateplugin.commands.examplecommand.ExampleCommand;
import me.giodev.templateplugin.data.config.ConfigManager;
import me.giodev.templateplugin.data.language.LanguageManager;
import me.giodev.templateplugin.listeners.GUIClickListener;
import me.giodev.templateplugin.utils.LoggerUtil;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public final class TemplatePlugin extends JavaPlugin {

  private static TemplatePlugin instance;
  private ConfigManager configManager;
  private LanguageManager languageManager;
  private LoggerUtil log;

  @Override
  public void onEnable(){

    instance = this;

    //Load config, language & logger
    loadConfig();
    loadLang();
    log = new LoggerUtil(this);

    //Commands & Events
    loadCommands();
    loadEvents();

    log.info("Plugin fully started!");
  }

  private void loadEvents() {
    PluginManager pm = getServer().getPluginManager();
    pm.registerEvents(new GUIClickListener(this), this);
  }

  private void loadCommands() {
    loadCommand(new ExampleCommand(this));
  }

  private void loadCommand(BaseCommand command) {
    getCommand(command.getName()).setExecutor(command);
    getCommand(command.getName()).setTabCompleter(command);
    getCommand(command.getName()).setAliases(command.getAliases());
  }

  @SneakyThrows
  private void loadConfig(){
    this.configManager = new ConfigManager(this);
  }

  @SneakyThrows
  private void loadLang(){
    this.languageManager = new LanguageManager(this);
  }

}
