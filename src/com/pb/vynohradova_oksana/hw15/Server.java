package com.pb.vynohradova_oksana.hw15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static ArrayList<Socket> sockets = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int port = 25691;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Сервер запущен. Порт " + port);

        ExecutorService threadPool = Executors.newCachedThreadPool();

        int i = 1;
        while (true) {
            Socket clientSocket = serverSocket.accept();
            threadPool.submit(new Processing(clientSocket, "Клиент " + i));
            sockets.add(clientSocket);
            i++;
        }
    }

    static class Processing implements Runnable {
        private final Socket socket;
        private final String name;

        public Processing(Socket socket, String name) {
            this.socket = socket;
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(name + " подключился.");
            sendMessage( true, false, "");

            try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

                String str;

                while (!socket.isClosed()) {
                    while (in.ready()) {
                        str = in.readLine();
                        System.out.println(name + ": " + str);

                        if (str.equalsIgnoreCase("exit")) {
                            sockets.removeIf(socket::equals);
                            sendMessage( false, true, "");
                            break;
                        }

                        sendMessage(false, false, str);
                    }
                }

                System.out.println(name + " разовал соединение.");
            } catch(Exception e){
                e.printStackTrace();
            }
        }

        private void sendMessage(boolean entry, boolean exit, String str) {
            String message;
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM, uuuu HH:mm:ss");

            if (entry) {
                message = name + " присоединился к чату.";
            } else if (exit) {
                message = name + " покинул чат.";
            } else {
                message = LocalDateTime.now().format(formatter) + " " + name + ": " + str;
            }

            try {
                for (Socket s : Server.sockets) {
                    PrintWriter out = new PrintWriter(s.getOutputStream(), true);
                    out.println(message);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}