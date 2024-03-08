package com.wa2c.android.cifsdocumentsprovider.common.values;

public enum HostSortType {
    DetectionAscend(10),
    DetectionDescend(1),
    HostNameAscend(20),
    HostNameDescend(21),
    IpAddressAscend(30),
    IpAddressDescend(31);

    private final int intValue;

    public int getIntValue(){return intValue;}

    HostSortType(int intValue) {
        this.intValue = intValue;
    }

    /** Default sort type */
    public static final HostSortType DEFAULT = DetectionAscend;

    /**
     * Find sort type or default (DetectionAscend).
     */
    public static HostSortType findByValueOrDefault(Integer value) {
        for (HostSortType type : HostSortType.values()) {
            if (type.intValue == (value != null ? value : DEFAULT.intValue)) {
                return type;
            }
        }
        return DEFAULT;
    }
}

