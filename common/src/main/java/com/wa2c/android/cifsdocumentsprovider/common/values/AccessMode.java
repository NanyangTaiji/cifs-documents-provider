package com.wa2c.android.cifsdocumentsprovider.common.values;

/**
 * Access Mode
 */
public enum AccessMode {
    /** Read */
    R("r", "r"),
    /** Write */
    W("rw", "w");

    private final String smbMode;
    private final String safMode;

    AccessMode(String smbMode, String safMode) {
        this.smbMode = smbMode;
        this.safMode = safMode;
    }

    public static AccessMode fromSafMode(String mode) {
        return mode != null && mode.toLowerCase().contains(W.safMode) ? W : R;
    }

    public String getSmbMode() {
        return smbMode;
    }

    public String getSafMode() {
        return safMode;
    }
}

