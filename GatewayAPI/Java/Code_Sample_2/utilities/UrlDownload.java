package utilities;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlDownload {

    private final static int SIZE = 4096;

    public static byte[] downloadFromUrl(String urlStr) {
        System.out.println("Downloading document from URL...");

        URL url = null;
        try {
            url = new URL(urlStr);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if (url == null)
            return null;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            byte[] bytes = new byte[SIZE];
            InputStream stream = url.openStream();
            int bytesRead;

            while ((bytesRead = stream.read(bytes)) > 0) {
                outputStream.write(bytes, 0, bytesRead);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return outputStream.toByteArray();
    }
}
