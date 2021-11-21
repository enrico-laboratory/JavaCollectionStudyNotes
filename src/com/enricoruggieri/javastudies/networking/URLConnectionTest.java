package com.enricoruggieri.javastudies.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionTest {

    public static void main(String[] args) throws IOException {
        URL url = new URL("http://example.org");

        // URLConnection Class
        URLConnection urlConnection = url.openConnection();
        // to write
        urlConnection.setDoOutput(true);
        // All the connection configuration have to be defined before method connect()
        urlConnection.connect();

        BufferedReader inputStreamer = new BufferedReader(
                new InputStreamReader(urlConnection.getInputStream())
        );
        String line = "";
        while (line != null) {
            line = inputStreamer.readLine();
            System.out.println(line);
        }
        inputStreamer.close();


        // URL class
        BufferedReader inputStreamer2 = new BufferedReader(
                new InputStreamReader(url.openStream())
        );
        String line2 = "";
        while (line2 != null) {
            line2 = inputStreamer2.readLine();
            System.out.println(line2);
        }
        inputStreamer.close();

//        URI uri = url.toURI();
//
//        System.out.println("Scheme = " + uri.getScheme());
//        System.out.println("Scheme-specific part = " + uri.getSchemeSpecificPart());
//        System.out.println("Authority = " + uri.getAuthority());
//        System.out.println("User info = " + uri.getUserInfo());
//        System.out.println("Host = " + uri.getHost());
//        System.out.println("Port = " + uri.getPort());
//        System.out.println("Path = " + uri.getPath());
//        System.out.println("Query = " + uri.getQuery());
//        System.out.println("Fragment = " + uri.getFragment());


    }
}
