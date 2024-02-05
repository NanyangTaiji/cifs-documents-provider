package com.wa2c.android.cifsdocumentsprovider.tools.string_converter.model;

/**
 * String item
 */
public class StringItem {
    private final String group;
    private final String resourceId;
    private final String value;

    public StringItem(String group, String resourceId, String value) {
        this.group = group;
        this.resourceId = resourceId;
        this.value = value;
    }

    public String getGroup() {
        return group;
    }

    public String getResourceId() {
        return resourceId;
    }

    public String getValue() {
        return value;
    }
}

