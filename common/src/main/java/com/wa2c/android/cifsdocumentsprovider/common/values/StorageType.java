package com.wa2c.android.cifsdocumentsprovider.common.values;

public enum StorageType {
    /** JCIFS-NG */
    JCIFS("JCIFS", ProtocolType.SMB),
    /** SMBJ */
    SMBJ("SMBJ", ProtocolType.SMB),
    /** JCIFS */
    JCIFS_LEGACY("JCIFS_LEGACY", ProtocolType.SMB),
    /** Apache FTP */
    APACHE_FTP("APACHE_FTP", ProtocolType.FTP),
    /** Apache FTPS */
    APACHE_FTPS("APACHE_FTPS", ProtocolType.FTPS);

    private final String value;
    private final ProtocolType protocol;

    StorageType(String value, ProtocolType protocol) {
        this.value = value;
        this.protocol = protocol;
    }

    public String getValue() {
        return value;
    }

    public ProtocolType getProtocol() {
        return protocol;
    }

    public static StorageType getDefault() {
        return JCIFS;
    }

    /**
     * Find storage type.
     */
    public static StorageType findByValue(String value) {
        for (StorageType type : StorageType.values()) {
            if (type.value.equals(value)) {
                return type;
            }
        }
        return null;
    }
}
