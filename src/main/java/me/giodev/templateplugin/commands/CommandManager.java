package me.giodev.templateplugin.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.SimpleCommandMap;

import java.lang.reflect.Field;
import java.util.HashMap;

public class CommandManager {

  SimpleCommandMap commandMap;

  public void loadCommand(BaseCommand command) {
    try {
      commandMap = (SimpleCommandMap) getPrivateField(Bukkit.getServer().getPluginManager(), "commandMap");
      unloadCommand(command);

      commandMap.register(command.getName(), command);
    } catch(Exception e) {
      e.printStackTrace();
    }
  }

  @SuppressWarnings("unchecked")
  private void unloadCommand(BaseCommand command) {
    try {
      Object map = getPrivateField(commandMap, "knownCommands");
      HashMap<String, Command> knownCommands = (HashMap<String, Command>) map;
      knownCommands.remove(command.getName());
      for (String alias : command.getAliases()){
        if(knownCommands.containsKey(alias) && knownCommands.get(alias).toString().contains(command.getName())){
          knownCommands.remove(alias);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private Object getPrivateField(Object object, String field) throws NoSuchFieldException, IllegalAccessException {
    Integer v = Integer.parseInt(Bukkit.getVersion().split(" ")[2].replaceAll("\\D+",""));
    Class<?> clazz = object.getClass();
    Field objectField = field.equals("commandMap") ? clazz.getDeclaredField(field) : field.equals("knownCommands") ? v >= 1131 ? clazz.getSuperclass().getDeclaredField(field) : clazz.getDeclaredField(field) : null;
    objectField.setAccessible(true);
    Object result = objectField.get(object);
    objectField.setAccessible(false);
    return result;
  }

}
