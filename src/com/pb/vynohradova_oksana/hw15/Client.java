package com.pb.vynohradova_oksana.hw15;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;


public class Client extends Application {

    private static TextArea chat, textArea;
    private static Button sendButton;
    private static HBox bottomPart;
    private static AnchorPane topPart;
    private static VBox vBox;
    static PrintWriter out;
    static Socket socket;

    public static void main(String[] args) {
        launch(args);
    }

    static void connection() {
        int port = 25691;
        try {
            socket = new Socket("localhost", port);
            type("Соединение с сервером установлено.");

            ClientReader reader = new ClientReader(socket);
            new Thread(reader).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void sendMessage(String message) {
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            out.println(message);
            if (message.equals("exit")) {
                out.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class ClientReader implements Runnable {
        private final Socket socket;
        private static boolean isActive = true;

        public ClientReader(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                while (isActive) {
                    String message = in.readLine();
                    System.out.println(message);
                    type(message);
                }
            } catch (IOException e) {
                String m = e.getMessage();
                if (!m.contains("closed")) {
                    e.printStackTrace();
                }
            }
        }

        public static void exit() {
            isActive = false;
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Chat");
        primaryStage.setWidth(870);
        primaryStage.setHeight(700);
        primaryStage.setOnCloseRequest(event -> {
            sendMessage("exit");
            ClientReader.exit();
            primaryStage.close();
        });

        textArea = new TextArea();
        textArea.setPrefRowCount(3);
        textArea.setPrefWidth(730);
        textArea.setWrapText(true);
        textArea.setPromptText("Введите сообщение...");
        textArea.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                sendMessage(textArea.getText());
                textArea.clear();
                Platform.runLater(() -> textArea.positionCaret(0));
                event.consume();
            }
        });

        sendButton = new Button("Отправить");
        sendButton.setOnAction(event -> {
            sendMessage(textArea.getText());
            textArea.clear();
        });

        bottomPart = new HBox(textArea, sendButton);
        bottomPart.setSpacing(10);
        bottomPart.setPadding(new Insets(10));

        chat = new TextArea();
        chat.setPrefSize(850,500);
        chat.setEditable(false);
        chat.setWrapText(true);
        chat.setPadding(new Insets(10));

        topPart = new AnchorPane(chat);
        topPart.setPadding(new Insets(10));

        vBox = new VBox(topPart, bottomPart);

        Scene scene = new Scene(vBox);
        primaryStage.setScene(scene);

        connection();

        primaryStage.show();
    }

    static void type(String message) {
        chat.appendText(message + "\n");
    }
}