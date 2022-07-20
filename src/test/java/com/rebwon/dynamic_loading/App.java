package com.rebwon.dynamic_loading;

import java.io.IOException;
import java.lang.reflect.Constructor;

public final class App {

    public static class URL {
        private String spec;

        public URL(String spec) {
            this.spec = spec;
        }

        public URLConnection openConnection() throws IOException {
            final StringBuilder sb = new StringBuilder("com.rebwon.dynamic_loading");
            String prefix = spec.substring(0, spec.indexOf(":"));

            sb.append(Character.toUpperCase(prefix.charAt(0)));
            sb.append(prefix.substring(1));
            sb.append("URLConnection");

            String className = sb.toString();

            try {
                Class<?> factory = Class.forName(className);
                Constructor<?> constructor = factory.getConstructor();
                return (URLConnection) constructor.newInstance();
            } catch(Exception e) {
                throw new IOException(e);
            }
        }
    }

    interface URLConnection {}

    static class HttpURLConnection implements URLConnection {}
    static class FtpURLConnection implements URLConnection {}
}
