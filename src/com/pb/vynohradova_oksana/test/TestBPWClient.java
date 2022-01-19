package com.pb.vynohradova_oksana.test;

import java.io.*;
import java.net.Socket;

public class TestBPWClient {
    public static void main(String[] args) throws IOException {
        int port = 25691;

        try (Socket socket = new Socket("localhost", port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {

            System.out.println("Соединение с сервером установлено.");
            String str = "сообщение клиента";
            out.write(str);
            out.flush();

            while (in.ready()) {
                String message = in.readLine();
                System.out.println(message);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
