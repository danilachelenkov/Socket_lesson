package ru.netology;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {

        System.out.println("Сервер запущен");
        int port = 8087;

        try (ServerSocket serverSocket = new ServerSocket(port)) {

            try (Socket clienSocket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(clienSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clienSocket.getInputStream()));
            ) {
                System.out.printf("Соединение подтверждено.");

                final String name = in.readLine();

                out.println(String.format("Привет %s, ваш порт %d", name, clienSocket.getPort()));

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}