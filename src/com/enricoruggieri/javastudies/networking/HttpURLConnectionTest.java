package com.enricoruggieri.javastudies.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class HttpURLConnectionTest {
    public static void main(String[] args) throws IOException {
        var url = new URL("https://api.notion.com/v1/databases/a290b3f737f242b697959acb9f18283e/query");

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestMethod("POST");

        System.out.println(connection.getHeaderFields().toString());

        OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());
        wr.flush();

        var httpResult = connection.getResponseCode();
        System.out.println(httpResult);

        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(
                new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line).append(" ");
        }
    }

}
