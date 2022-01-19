package com.pb.vynohradova_oksana.test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TestBPWServer {
    public static void main(String[] args) throws IOException {
        int port = 25691;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Сервер запущен. Порт " + port);

        Socket clientSocket = serverSocket.accept();
        System.out.println("Клиент подключился.");

        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()))) {
            String str = "new";

            while (!clientSocket.isClosed()) {
                while (in.ready()) {
                    str = in.readLine();
                    System.out.println("Клиент: " + str);
                }

                out.write("Сервер: " + str);
                out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
