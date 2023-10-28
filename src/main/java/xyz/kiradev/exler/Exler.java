package xyz.kiradev.exler;

import lombok.Getter;
import xyz.kiradev.clash.Clash;
import xyz.kiradev.exler.loader.ExlerLoader;

@Getter
public final class Exler extends Clash {

    private ExlerLoader loader;

    @Override
    public void onLoad() {
        setupConfig();
        loader = new ExlerLoader(this);
        for (String str : getConfig().getStringList("Products")) {
            // TODO: Check licenses before loading
            loader.loadPlugin(str, "kiradev.xyz/loader/get-product/" + str.toLowerCase());
        }
    }

    @Override
    public void onDisable() {
        if(loader.getTempFile() != null) loader.getTempFile().delete();
    }
}