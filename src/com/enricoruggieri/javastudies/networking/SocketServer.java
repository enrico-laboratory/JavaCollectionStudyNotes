package com.enricoruggieri.javastudies.networking;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

    public static void main(String[] args) throws IOException {
        // Only one thread
        var s = new ServerSocket(8189);
        Socket incoming = s.accept();

        InputStream inputStream = incoming.getInputStream();
        OutputStream outputStream = incoming.getOutputStream();


    }
}
