package com.wa2c.android.cifsdocumentsprovider.common.utils;


import static com.wa2c.android.cifsdocumentsprovider.common.values.Constants.DEFAULT_FTPS_IMPLICIT_PORT;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.OpenableColumns;
import android.webkit.MimeTypeMap;

import com.wa2c.android.cifsdocumentsprovider.common.values.ProtocolType;
import com.wa2c.android.cifsdocumentsprovider.common.values.StorageType;

import java.nio.file.Paths;
import java.util.UUID;

public class AppUtils {

    /**
     * Renew collection elements.
     */
    public static <E, T extends java.util.Collection<E>> T renew(T t, java.util.Collection<E> v) {
        t.clear();
        t.addAll(v);
        return t;
    }

    /**
     * Renew map elements.
     */
    public static <K, V, T extends java.util.Map<K, V>> T renew(T t, java.util.Map<K, V> m) {
        t.clear();
        t.putAll(m);
        return t;
    }

    /**
     * Get mime type
     */
    public static String getMimeType(String extension) {
        String mimeType = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extension);
        return mimeType != null ? mimeType : "*/*";
    }

    /**
     * Get URI text
     */
    public static String getUriText(StorageType type, String host, String port, String folder, boolean isDirectory) {
        if (host == null || host.trim().isEmpty()) return null;
        int portInt = port != null ? Integer.parseInt(port) : -1;
        String authority = host + (portInt > 0 ? (":" + port) : "");
        String uri = Paths.get(authority, folder != null ? folder : "").toString() + (isDirectory ? "/" : "");
        return type.getProtocol().getSchema() + "://" + uri;
    }

    /**
     * Get port
     */
    public static String getPort(String port, StorageType type, boolean isFtpsImplicit) {
        if (port != null && !port.isEmpty()) return port;
        if (type.getProtocol() == ProtocolType.FTPS && isFtpsImplicit)
            return String.valueOf(DEFAULT_FTPS_IMPLICIT_PORT);
        return null;
    }


    /**
     * Get last path
     */
    public static String getLastPath(String str) {
        String path = str.trim().endsWith("/") ? str.substring(0, str.length() - 1) : str;
        int startIndex = path.lastIndexOf('/') + 1;
        return path.substring(startIndex);
    }

    /**
     * Get file name (last segment)
     */
    public static String getFileName(String uri) {
        return Uri.decode(uri).substring(uri.lastIndexOf('/') + 1);
    }

    /**
     * Get file name
     */
    public static String getFileName(Context context, Uri uri) {
        if (ContentResolver.SCHEME_CONTENT.equals(uri.getScheme())) {
            try (Cursor cursor = context.getContentResolver().query(uri, null, null, null, null)) {
                if (cursor != null && cursor.moveToFirst()) {
                    int columnIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME);
                    if (columnIndex >= 0) {
                        return cursor.getString(columnIndex);
                    }
                }
            }
        }
        String path = uri.getPath();
        return path != null ? path.substring(path.lastIndexOf('/') + 1) : "";
    }

    /**
     * True if directory URI
     */
    public static boolean isDirectoryUri(String uri) {
        return uri.endsWith("/");
    }

    /**
     * Append separator(/)
     */
    public static String appendSeparator(String uri) {
        return uri.endsWith("/") ? uri : uri + "/";
    }

    /**
     * Append child entry
     */
    public static String appendChild(String parentUri, String childName, boolean isDirectory) {
        String name = isDirectory ? appendSeparator(childName) : childName;
        return appendSeparator(parentUri) + name.replaceFirst("^/", "");
    }

    /**
     * Generate UUID
     */
    public static String generateUUID() {
        return UUID.randomUUID().toString();
    }

}
