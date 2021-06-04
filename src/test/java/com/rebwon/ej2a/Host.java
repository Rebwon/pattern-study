package com.rebwon.ej2a;

import java.io.Serializable;
import java.util.Comparator;

public final class Host {

    public static final Comparator<String> STRING_LENGTH_COMPARATOR = new StringLengthComparator();

    private static class StringLengthComparator implements Comparator<String>, Serializable {

        @Override
        public int compare(String o1, String o2) {
            return o1.length() - o2.length();
        }
    }
}
