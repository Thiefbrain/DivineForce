package com.github.divineForce;

import java.util.HashMap;
import java.util.Map;

import net.minecraftforge.common.ConfigCategory;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;

/**
 * DivineForce configuration class
 * 
 * @author Thiefbrain
 * 
 */
public final class DivineForceConfig
{

    private static DivineForceConfig instance;

    private final Map<String, Map<String, Property>> configuration = new HashMap<>();

    /**
     * Returns the instance of this config or null if it hasn't be initialized yet
     * 
     * @return An instance or null
     */
    public static DivineForceConfig getInstance()
    {
        return instance;
    }

    /**
     * Reads the configuration of the given {@link Configuration} and returns the initialized class
     * 
     * @param config
     *            The configuration to read
     * @return An instance of this class
     */
    public static DivineForceConfig init(final Configuration config)
    {
        instance = new DivineForceConfig(config);
        return instance;
    }

    private DivineForceConfig(final Configuration config)
    {
        if (config != null)
        {
            for (final String configurationGroup : config.getCategoryNames())
            {
                final ConfigCategory category = config.getCategory(configurationGroup);

                configuration.put(configurationGroup, category.getValues());
            }
        }
    }

    /**
     * Returns a config value as a boolean. Returns either true or false or the default value if the key could not be found
     * 
     * @param key
     *            The key to fetch
     * @param group
     *            The group to look in
     * @param defaultValue
     *            A default value to be returned if fetching the value failed
     * @return boolean value
     */
    public boolean getValueAsBoolean(final String key, final String group, final boolean defaultValue)
    {
        boolean value = defaultValue;

        try
        {
            value = configuration.get(group).get(key).getBoolean(value);
        }
        catch (final NullPointerException nullPointerException)
        {
            DivineForce.getLogger().warning("Failed to get config value " + key + " in group " + group);
        }

        return value;
    }

    /**
     * Returns a config value as a string. Returns the value of the key in the given group or the default value if the key could not be found.
     * 
     * @param key
     *            The key to fetch
     * @param group
     *            The group to look in
     * @param defaultValue
     *            A default value to be returned if fetching the value failed
     * @return String value
     */
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
