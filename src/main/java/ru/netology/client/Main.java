package ru.netology.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {

        String host = "netology.homework";
        int port = 8087;
        String response = "";
        String clientMessage = "";
        String bodyLog = "Пользователь передал %s";

        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {

            clientMessage = "start client";
            System.out.println(clientMessage);

            out.println(clientMessage);
            response = in.readLine();
            System.out.println(response);

            clientMessage = "Данила";
            System.out.println(String.format(bodyLog, clientMessage));

            out.println(clientMessage);
            response = in.readLine();
            System.out.println(response);

            clientMessage = "chelenkov@mail.ru";
            System.out.println(String.format(bodyLog, clientMessage));

            out.println(clientMessage);
            response = in.readLine();
            System.out.println(response);

            clientMessage = "17";
            System.out.println(String.format(bodyLog, clientMessage));

            out.println(clientMessage);
            response = in.readLine();
            System.out.println(response);

            clientMessage = "4";
            System.out.println(String.format(bodyLog, clientMessage));

            out.println(clientMessage);
            response = in.readLine();
            System.out.println(response);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
