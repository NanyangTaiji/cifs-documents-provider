package com.wa2c.android.cifsdocumentsprovider.common.values;

public abstract class ConnectionResult {

    public abstract Throwable getCause();

    /** Success */
    public static class Success extends ConnectionResult {
        @Override
        public Throwable getCause() {
            return null;
        }
    }

    /** Warning */
    public static class Warning extends ConnectionResult {
        private final Throwable cause;

        public Warning(Throwable cause) {
            this.cause = cause != null ? cause : new RuntimeException();
        }

        @Override
        public Throwable getCause() {
            return cause;
        }
    }

    /** Failure */
    public static class Failure extends ConnectionResult {
        private final Throwable cause;

        public Failure(Throwable cause) {
            this.cause = cause != null ? cause : new RuntimeException();
        }

        @Override
        public Throwable getCause() {
            return cause;
        }
    }
}

