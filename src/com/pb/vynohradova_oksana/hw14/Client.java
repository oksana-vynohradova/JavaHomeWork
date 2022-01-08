package com.pb.vynohradova_oksana.hw14;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int port = 25691;

        try (Socket socket = new Socket("localhost", port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            System.out.println("Соединение с сервером установлено. Для разрыва соединения введите exit.");
            ClientReader reader = new ClientReader(socket);
            new Thread(reader).start();

            System.out.println("Вводите сообщения с новой строки.");
            while (socket.isConnected()) {
                String str = scan.next();
                out.println(str);

                if (str.equalsIgnoreCase("exit")) {
                    reader.stopThread();
                    break;
                }
            }

            System.out.println("\033[0m" + "Соединение с сервером разорвано.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ClientReader implements Runnable {
        private final Socket socket;
        private boolean isActive = true;

        public ClientReader(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                while (isActive) {
                    String message = in.readLine();
                    System.out.println(message);
                }
            } catch (IOException e) {
                String m = e.getMessage();
                if (!m.contains("closed")) {
                    e.printStackTrace();
                }
            }
        }

        public void stopThread() {
            this.isActive = false;
        }
    }
}