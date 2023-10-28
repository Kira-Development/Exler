package xyz.kiradev.exler.loader;

/*
 *
 * Exler is a property of Kira-Development-Team
 * It was created @ 28/10/2023
 * Coded by the founders of Kira-Development-Team
 * EmpireMTR & Vifez
 *
 */

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import xyz.kiradev.exler.Exler;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

@Getter
public class ExlerLoader {

    private final Exler exler;
    private File tempFile;

    public ExlerLoader(Exler exler) {
        this.exler = exler;
    }
    public void loadPlugin(String pluginName, String URL) {
        try {
            java.net.URL url = new URL(URL);
            try (InputStream in = url.openStream()) {
                tempFile = File.createTempFile(pluginName, ".jar");
                Files.copy(in, tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                Plugin plugin = Bukkit.getPluginManager().loadPlugin(tempFile);
                Bukkit.getPluginManager().enablePlugin(plugin);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
