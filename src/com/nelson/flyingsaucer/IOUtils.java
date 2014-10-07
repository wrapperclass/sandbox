package com.nelson.flyingsaucer;

import java.io.*;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ThorntonRP
 */
final class IOUtils {

    private static final Logger LOG = Logger.getLogger(FirstDoc.class.getName());

    private IOUtils() {
    }

    static int copy(InputStream in, OutputStream out) throws IOException {
        int bufferSize = 4096;
        byte[] buffer = new byte[bufferSize];
        int len;
        int count = 0;
        while (in != null && (len = in.read(buffer)) != -1) {
            out.write(buffer, 0, len);
            count += len;
        }
        out.flush();
        return count;
    }

    static String read(File file, String charset) throws IOException {
        FileInputStream in = null;
        ByteArrayOutputStream out = null;
        try {
            in = new FileInputStream(file);
            out = new ByteArrayOutputStream(4096);
            copy(in, out);
            return out.toString(charset);
        } finally {
            close(in, out);
        }
    }

    static void write(File file, String charset, String text) throws IOException {
        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        try {
            fos = new FileOutputStream(file);
            osw = new OutputStreamWriter(fos, charset);
            osw.write(text);
            osw.flush();
        } finally {
            close(fos, osw);
        }
    }

    static void close(Closeable... c) {
        for (Closeable closeable : c) {
            if (closeable != null) {
                try {
                    ((Closeable) closeable).close();
                } catch (IOException ex) {
                    LOG.log(Level.WARNING, "Failed to release resource: " + closeable, ex);
                }
            }
        }
    }

    static void delete(File file) {
        if (!file.delete()) {
            LOG.log(Level.WARNING, "Failed to delete temporary resource file: {0}", file);
        }
    }

    static void delete(Collection<File> files) {
        for (File file : files) {
            delete(file);
        }
    }
}
