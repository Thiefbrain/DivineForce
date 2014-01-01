package com.github.divineForce.Internationalization;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import com.github.divineForce.DivineForce;
import com.github.divineForce.Utils.StringUtils;

import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * The language manager class. Required only on client side since rendering is only client-side
 * 
 * @author Thiefbrain
 * 
 */
@SideOnly(Side.CLIENT)
public final class LanguageManager
{

    /** A list of loaded languages */
    private final List<String> loadedLanguages = new ArrayList<String>();
    /** The instance of the language manager */
    private static final LanguageManager INSTANCE = new LanguageManager();

    /**
     * Returns the instance of the language manager.
     * 
     * @return {@link LanguageManager} instance
     */
    public static LanguageManager getInstance()
    {
        return LanguageManager.INSTANCE;
    }

    private LanguageManager()
    {
        final File languageDirectory = new File("config/DivineForce/lang/");
        if (!languageDirectory.exists() && !languageDirectory.mkdirs())
        {
            DivineForce.getLogger().log(Level.SEVERE, "Failed to create language directory");
        }

        loadLanguage("en_US");
    }

    /**
     * Loads a language by a language code (RFC 5646).
     * 
     * @param languageCode
     *            A RFC 5646 language code
     */
    public void loadLanguage(final String languageCode)
    {
        if (loadedLanguages.contains(languageCode))
        {
            loadedLanguages.add(languageCode);
            LanguageRegistry.instance().loadLocalization("config/DivineForce/lang/" + languageCode + ".lang", languageCode, false); // TODO: Language files not
        } // found
    }

    /**
     * Returns a translation for the specific key
     * 
     * @param key
     *            String
     * @return String
     */
    public String getLanguageString(final String key)
    {
        return getLanguageString(key, null);
    }

    /**
     * Returns a translation for the specific key or a fallback if the key could not be found.
     * 
     * @param key
     *            String
     * @param fallback
     *            String
     * @return
     */
    public String getLanguageString(final String key, final String fallback)
    {
        String translation = LanguageRegistry.instance().getStringLocalization(key);

        return StringUtils.nn(translation, fallback);
    }

}
