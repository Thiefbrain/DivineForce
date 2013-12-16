package com.github.divineForce.Internationalization;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import com.github.divineForce.DivineForce;

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
public class LanguageManager
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

    public void init(final String languageCode)
    {
        if (loadedLanguages.contains(languageCode))
        {
            loadLanguage(languageCode);
        }
    }

    /**
     * Loads a language by a language code (RFC 5646).
     * 
     * @param languageCode
     *            A RFC 5646 language code
     */
    public void loadLanguage(final String languageCode)
    {
        loadedLanguages.add(languageCode);
        LanguageRegistry.instance().loadLocalization("config/DivineForce/lang/" + languageCode + ".lang", languageCode, false); // TODO: Language files not
                                                                                                                                // found
    }

}
