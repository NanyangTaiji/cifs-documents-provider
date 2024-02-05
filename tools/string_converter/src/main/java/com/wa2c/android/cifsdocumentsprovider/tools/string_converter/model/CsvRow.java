package com.wa2c.android.cifsdocumentsprovider.tools.string_converter.model;

import java.util.Map;

/**
 * CSV Row
 */
public class CsvRow {
    /** Title */
    private final String title;
    /** String resource ID */
    private final String resourceId;
    /** Language text map (key: lang code, value: text) */
    private final Map<String, String> langText;

    public CsvRow(String title, String resourceId, Map<String, String> langText) {
        this.title = title;
        this.resourceId = resourceId;
        this.langText = langText;
    }

    public String getTitle() {
        return title;
    }

    public String getResourceId() {
        return resourceId;
    }

    public Map<String, String> getLangText() {
        return langText;
    }
}

