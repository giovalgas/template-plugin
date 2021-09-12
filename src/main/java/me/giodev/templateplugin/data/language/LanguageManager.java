package me.giodev.templateplugin.data.language;

import me.giodev.multiversion.MultiVersionSound;
import me.giodev.templateplugin.TemplatePlugin;
import me.giodev.templateplugin.utils.FileManager;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class LanguageManager {

  TemplatePlugin plugin;
  YamlConfiguration langFileConfig;

  //Messages
  private String helloWorld;
  private String chatPrefix;

  //Sounds
  private MultiVersionSound testSound;

  public LanguageManager(TemplatePlugin plugin) throws InvalidConfigurationException {
    this.plugin = plugin;
    load();
  }

  private void load() throws InvalidConfigurationException {
    File langFile = new File(plugin.getDataFolder(), "language.yml");
    this.langFileConfig = new YamlConfiguration();

    if (!langFile.exists()) {
      FileManager.loadResource(plugin, "language.yml");
    }

    try {
      langFileConfig.load(langFile);
    } catch (IOException | InvalidConfigurationException e) {
      e.printStackTrace();
    }

    loadValues();

  }

  private void loadValues() throws InvalidConfigurationException {
    //Messages
    this.helloWorld = getString(LanguageKeys.HELLO_WORLD, LanguageDefaults.HELLO_WORLD);
    this.chatPrefix = getString(LanguageKeys.MESSAGE_PREFIX, LanguageDefaults.MESSAGE_PREFIX);

    //Sounds
    this.testSound = getSound(LanguageKeys.TEST_SOUND, LanguageDefaults.TEST_SOUND);

  }

  private String getString(String p, String defaultString) throws InvalidConfigurationException {
    if(langFileConfig.isString(p)) {
      return langFileConfig.getString(p).replace('&', '§');
    } else if(langFileConfig.contains(p)){
      throw new InvalidConfigurationException("'language.yml' at path:" + p + "' is not a string");
    }else {
      langFileConfig.set(p, defaultString);
      return defaultString;
    }
  }

  private MultiVersionSound getSound(String p, MultiVersionSound defaultSound) throws InvalidConfigurationException {
    try{
      MultiVersionSound mvSound = MultiVersionSound.valueOf(langFileConfig.getString(p));
      return mvSound;
    }catch (IllegalArgumentException e){
      throw new InvalidConfigurationException("'Language.yml' the value specified in " + p + "is not a sound", e);
    }
  }

  public String getHelloWorld() {
    return helloWorld;
  }

  public String getChatPrefix() {
    return chatPrefix;
  }

  public MultiVersionSound getTestSound(){
    return testSound;
  }

}
