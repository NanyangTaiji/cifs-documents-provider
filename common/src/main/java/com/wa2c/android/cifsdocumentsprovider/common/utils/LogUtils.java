package com.wa2c.android.cifsdocumentsprovider.common.utils;

import timber.log.Timber;

public class LogUtils {

    /**
     * Initialize log
     */
    public static void initLog(boolean isDebug) {
        // Set logger
        if (isDebug) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    /** Output the verbose message */
    public static void logV(Object obj, Object... args) {
        if (obj instanceof Throwable) {
            Timber.asTree().v((Throwable) obj);
        }
        Timber.asTree().v(obj != null ? obj.toString() : null, args);
    }

    /** Output the debug message */
    public static void logD(Object obj, Object... args) {
        if (obj instanceof Throwable) {
            Timber.asTree().d((Throwable) obj);
        }
        Timber.asTree().d(obj != null ? obj.toString() : null, args);
    }

    /** Output the info message */
    public static void logI(Object obj, Object... args) {
        if (obj instanceof Throwable) {
            Timber.asTree().i((Throwable) obj);
        }
        Timber.asTree().i(obj != null ? obj.toString() : null, args);
    }

    /** Output the warning message */
    public static void logW(Object obj, Object... args) {
        if (obj instanceof Throwable) {
            Timber.asTree().w((Throwable) obj);
        }
        Timber.asTree().w(obj != null ? obj.toString() : null, args);
    }

    /** Output the error message */
    public static void logE(Object obj, Object... args) {
        if (obj instanceof Throwable) {
            Timber.asTree().e((Throwable) obj);
        }
        Timber.asTree().e(obj != null ? obj.toString() : null, args);
    }

}

