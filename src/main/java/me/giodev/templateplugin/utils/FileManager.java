package me.giodev.templateplugin.utils;

import com.google.common.io.ByteStreams;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;

public class FileManager {

  public static void loadResource(Plugin plugin, String resource) {
    File folder = plugin.getDataFolder();
    if (!folder.exists())
      folder.mkdir();
    File resourceFile = new File(folder, resource);
    try {
      if (!resourceFile.exists()) {
        resourceFile.createNewFile();
        try (InputStream in = plugin.getResource(resource);
             OutputStream out = new FileOutputStream(resourceFile)) {
          ByteStreams.copy(in, out);
        }

      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
