package com.enricoruggieri.javastudies.networking;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class HTTPRequests {

    public static void main(String[] args) throws IOException {
        var url = new URL("http://www.enricoruggieri.com");

        // simple connection
        InputStream inputStream = url.openStream();
        var in = new Scanner(inputStream, StandardCharsets.UTF_8);

        while (in.hasNext()) {
            System.out.println(in);
        }

        // Richer connection, a lot of methods, including getHeaderFields()
        URLConnection connection = url.openConnection();
        connection.connect();

        System.out.println(connection.getContentType());
        // get the complete header (MAP)
        Map<String, List<String>> headers = connection.getHeaderFields();
        for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
            String key = entry.getKey();
            for (String value : entry.getValue())  {
                System.out.println(key + "+" + value);
            }

        }
        System.out.println(connection.getHeaderFields().toString());
        // get the key corresponding to the int
        System.out.println(connection.getHeaderFieldKey(1));
        // get the value corresponding to the int or the key
        System.out.println(connection.getHeaderField(0));
        System.out.println(connection.getHeaderField("Date"));
        System.out.println(connection.getContentEncoding());

        var inputStream2 = connection.getInputStream();
        var in2 = new Scanner(inputStream2, StandardCharsets.UTF_8);

        while (in.hasNext()) {
            System.out.println(in2);
        }

        // to post data to web server
        connection.setDoOutput(true);


    }
}
