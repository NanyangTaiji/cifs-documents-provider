package com.wa2c.android.cifsdocumentsprovider.common.values;

public class Constants {

    public static final String URI_AUTHORITY = "com.wa2c.android.cifsdocumentsprovider.documents";

    public static final String URI_START = "://";
    public static final char URI_SEPARATOR = '/';
    public static final String UNC_START = "\\\\";
    public static final String UNC_SEPARATOR = "\\";

    public static final String DOCUMENT_ID_DELIMITER = ":";

    public static final String USER_GUEST = "guest";
    public static final String DEFAULT_ENCODING = "UTF-8";

    public static final int CONNECTION_TIMEOUT = 10000;
    public static final int READ_TIMEOUT = 10000;
    public static final int BUFFER_SIZE = 1024 * 1024;
    public static final int CACHE_TIMEOUT = 300 * 1000;
    public static final int OPEN_FILE_LIMIT_DEFAULT = 30;

    public static final String NOTIFICATION_CHANNEL_ID_SEND = "notification_channel_send";
    public static final int NOTIFICATION_ID_SEND = 100;
    public static final String NOTIFICATION_CHANNEL_ID_PROVIDER = "notification_channel_provider";
    public static final int NOTIFICATION_ID_PROVIDER = 101;

    public static final int DEFAULT_FTPS_IMPLICIT_PORT = 990;

}
