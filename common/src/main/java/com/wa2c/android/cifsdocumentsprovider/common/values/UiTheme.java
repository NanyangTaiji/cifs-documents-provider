package com.wa2c.android.cifsdocumentsprovider.common.values;

public enum UiTheme {
    /** Default */
    DEFAULT("default"),
    /** Light */
    LIGHT("light"),
    /** Dark */
    DARK("dark");

    /** Key */
    private final String key;
    /** Index */
    private final int index;

    UiTheme(String key) {
        this.key = key;
        this.index = this.ordinal();
    }

    public String getKey() {
        return key;
    }

    public int getIndex() {
        return index;
    }

    /**
     * Find value or default by key.
     */
    public static UiTheme findByKeyOrDefault(String key) {
        for (UiTheme theme : UiTheme.values()) {
            if (theme.key.equals(key)) {
                return theme;
            }
        }
        return DEFAULT;
    }

    /**
     * Find value or default by index.
     */
    public static UiTheme findByIndexOrDefault(Integer index) {
        if (index != null) {
            for (UiTheme theme : UiTheme.values()) {
                if (theme.index == index) {
                    return theme;
                }
            }
        }
        return DEFAULT;
    }
}

