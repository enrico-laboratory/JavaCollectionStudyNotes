package com.enricoruggieri.javastudies.networking;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

public class SocketClient {

    public void socketClientTest() throws IOException {


        try (var s = new Socket("time-a.nist.gov", 13);
             var in = new Scanner(s.getInputStream(), StandardCharsets.UTF_8)) {

            s.setSoTimeout(10000);
            InetAddress address = InetAddress.getByName("enricoruggieri.com");

            InetAddress[] addresses = InetAddress.getAllByName("google.com");
            while (in.hasNext()) {
                String line = in.nextLine();
                System.out.println(line);
            }
            System.out.println(address);

            System.out.println(Arrays.toString(addresses));
        }
    }
}
