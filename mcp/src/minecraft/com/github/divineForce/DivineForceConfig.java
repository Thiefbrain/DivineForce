package com.github.divineForce;

import java.util.HashMap;
import java.util.Map;

import net.minecraftforge.common.ConfigCategory;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;

public final class DivineForceConfig
{

    private static DivineForceConfig instance;

    private final Map<String, Map<String, Property>> configuration = new HashMap<>();

    private DivineForceConfig(final Configuration config)
    {
        for (final String configurationGroup : config.getCategoryNames())
        {
            final ConfigCategory category = config.getCategory(configurationGroup);

            configuration.put(configurationGroup, category.getValues());
        }
    }

    public static DivineForceConfig init(final Configuration config)
    {
        instance = new DivineForceConfig(config);
        return instance;
    }

    public static DivineForceConfig getInstance()
    {
        return instance;
    }

    public String getValueAsString(final String key, final String group, final String defaultValue)
    {
        String value = defaultValue;

        try
        {
            value = configuration.get(group).get(key).getString();
        }
        catch (final NullPointerException nullPointerException)
        {
            DivineForce.getLogger().warning("Failed to get config value " + key + " in group " + group);
        }

        return value;
    }

}
