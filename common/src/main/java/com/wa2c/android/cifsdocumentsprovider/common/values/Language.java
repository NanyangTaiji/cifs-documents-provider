package com.wa2c.android.cifsdocumentsprovider.common.values;

import java.util.Locale;

public enum Language {
    /** English */
    ENGLISH("en"),
    /** Japanese */
    JAPANESE("ja"),
    /** Arabic */
    ARABIC("ar"),
    /** Slovak */
    SLOVAK("sk"),
    /** Chinese */
    CHINESE("zh");

    /** Language code */
    private final String code;
    /** Index */
    private final int index;

    Language(String code) {
        this.code = code;
        this.index = this.ordinal();
    }

    public String getCode() {
        return code;
    }

    public int getIndex() {
        return index;
    }

    public static Language getDefault() {
        return Language.findByCodeOrDefault(Locale.getDefault().getLanguage());
    }

    /**
     * Find value or default by code.
     */
    public static Language findByCodeOrDefault(String code) {
        for (Language language : Language.values()) {
            if (language.code.equals(code)) {
                return language;
            }
        }
        return ENGLISH;
    }

    /**
     * Find value or default by index.
     */
    public static Language findByIndexOrDefault(Integer index) {
        if (index != null) {
            for (Language language : Language.values()) {
                if (language.index == index) {
                    return language;
                }
            }
        }
        return ENGLISH;
    }
}
