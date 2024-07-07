// MAKE SURE TO READ THE TOS / LICENSE AT THE REPOSITORY - https://github.com/Kira-Development/Exler

package xyz.kiradev.exler.loader;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import xyz.kiradev.exler.Exler;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;

@Getter
public class ExlerLoader {

    private static final Logger LOGGER = Logger.getLogger(ExlerLoader.class.getName());

    private final Exler exler;
    private File tempFile;

    public ExlerLoader(Exler exler) {
        this.exler = exler;
    }

    public void loadPlugin(String pluginName, String urlString) {
        try {
            URL url = new URL(urlString);
            tempFile = File.createTempFile(pluginName, ".jar");
            try (InputStream in = url.openStream()) {
                Files.copy(in, tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }

            Plugin plugin = Bukkit.getPluginManager().loadPlugin(tempFile);
            if (plugin != null) {
                Bukkit.getPluginManager().enablePlugin(plugin);
                LOGGER.log(Level.INFO, "Successfully loaded: {0}", pluginName);
            } else {
                LOGGER.log(Level.SEVERE, "Failed to load: {0}", pluginName);
            }

        } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "A unexpected error has occured while trying to load: " + pluginName, e);
        }
    }
}
// MAKE SURE TO READ THE TOS / LICENSE AT THE REPOSITORY - https://github.com/Kira-Development/Exler