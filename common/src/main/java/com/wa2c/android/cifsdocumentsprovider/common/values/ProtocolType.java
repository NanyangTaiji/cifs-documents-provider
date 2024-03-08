package com.wa2c.android.cifsdocumentsprovider.common.values;

public enum ProtocolType {
    /** SMB */
    SMB("smb"),
    /** FTP */
    FTP("ftp"),
    /** FTP over SSL */
    FTPS("ftps");

    private final String schema;

    ProtocolType(String schema) {
        this.schema = schema;
    }

    public String getSchema() {
        return schema;
    }
}

