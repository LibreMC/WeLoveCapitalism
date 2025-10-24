package org.libremc.weLoveCapitalism;

import java.util.HashMap;

public class ConfigManager {

    public static HashMap<CONFIG, Integer> ConfigMap = new HashMap<>();

    public enum CONFIG {
        EMBARGO_DIVISOR("embargo_divisor"),
        EMBARGO_BASE("embargo_base"),
        TARIFF_DIVISOR("tariff_divisor"),
        TARIFF_BASE("tariff_base");


        private final String path;

        CONFIG(String path){
            this.path = path;
        }

    }


    public static void init(){
        WeLoveCapitalism.getInstance().getConfig().addDefault(CONFIG.EMBARGO_DIVISOR.path, 2);
        WeLoveCapitalism.getInstance().getConfig().addDefault(CONFIG.EMBARGO_BASE.path, 15);
        WeLoveCapitalism.getInstance().getConfig().addDefault(CONFIG.TARIFF_DIVISOR.path, 20);
        WeLoveCapitalism.getInstance().getConfig().addDefault(CONFIG.TARIFF_BASE.path, 5);

        int em_div = WeLoveCapitalism.getInstance().getConfig().getInt(CONFIG.EMBARGO_DIVISOR.path);
        int em_base = WeLoveCapitalism.getInstance().getConfig().getInt(CONFIG.EMBARGO_BASE.path);
        int tar_div = WeLoveCapitalism.getInstance().getConfig().getInt(CONFIG.TARIFF_DIVISOR.path);
        int tar_base = WeLoveCapitalism.getInstance().getConfig().getInt(CONFIG.TARIFF_BASE.path);

        ConfigMap.put(CONFIG.EMBARGO_DIVISOR, em_div);
        ConfigMap.put(CONFIG.EMBARGO_BASE, em_base);
        ConfigMap.put(CONFIG.TARIFF_DIVISOR, tar_div);
        ConfigMap.put(CONFIG.TARIFF_BASE, tar_base);

        WeLoveCapitalism.getInstance().getConfig().options().copyDefaults(true);
        WeLoveCapitalism.getInstance().saveConfig();
    }
}
