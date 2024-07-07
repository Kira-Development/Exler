// MAKE SURE TO READ THE TOS / LICENSE AT THE REPOSITORY - https://github.com/Kira-Development/Exler

package xyz.kiradev.exler;

/*
 * Exler is a property of Kira-Development-Team
 * It was created @ 28/10/2023
 * Coded by the founders of Kira-Development-Team
 * EmpireMTR & Vifez
 */

import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.kiradev.exler.loader.ExlerLoader;

import java.io.File;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

@Getter
public final class Exler extends JavaPlugin {

    private static final String PRODUCTS_CONFIG_KEY = "Products";
    private static final String BASE_URL = "kiradev.xyz/loader/get-product/"; // Change to whatever url you want
    private static final Logger LOGGER = Logger.getLogger(Exler.class.getName());

    private ExlerLoader loader;

    @Override
    public void onLoad() {
        try {
            setupConfig();
            loader = new ExlerLoader(this);
            getConfig().getStringList(PRODUCTS_CONFIG_KEY).forEach(this::loadProduct);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Unable to load the plugin fr u gotta get better bud", e);
        }
    }

    private void loadProduct(String product) {
        loader.loadPlugin(product, BASE_URL + product.toLowerCase());
    }

    @Override
    public void onDisable() {
        Optional.ofNullable(loader.getTempFile()).ifPresent(File::delete);
    }

    private void setupConfig() {
        saveDefaultConfig();
    }
}

// MAKE SURE TO READ THE TOS / LICENSE AT THE REPOSITORY - https://github.com/Kira-Development/Exler