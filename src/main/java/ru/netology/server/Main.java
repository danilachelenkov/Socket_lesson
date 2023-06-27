package ru.netology.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    static String nameClinetHosting;
    static String emailClinetHosting;
    static int yearsOldClientHosting = -1;

    static int numberCatagory = 0;

    public static void main(String[] args) {

        System.out.println("Сервер запущен");
        int port = 8087;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                try (Socket clienSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clienSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clienSocket.getInputStream()));) {

                    nameClinetHosting = in.readLine();
                    System.out.println(nameClinetHosting);

                    out.println("Вас привествуют на сервере просмотра кинофильмов, введите пожалуйста свое имя?");
                    nameClinetHosting = in.readLine();
                    System.out.println(nameClinetHosting);
                    out.println(String.format("%s, введите адрес своей электронной почты?", nameClinetHosting));

                    emailClinetHosting = in.readLine();
                    System.out.println(emailClinetHosting);
                    out.println(String.format("%s, укажите сколько вам лет?", nameClinetHosting));

                    yearsOldClientHosting = Integer.parseInt(in.readLine());
                    System.out.println("Возраст клиента сервиса сохранен");

                    out.println("выберете категорию фильмов для просмотра (укажите порядковый номер)? 1. Исторические 2. Боевики 3. Фантастика 4. Для взрослых");

                    numberCatagory = Integer.parseInt(in.readLine());

                    if (yearsOldClientHosting >= 18) {
                        out.println(String.format("%s, вам доступны все категории видеоконтента", nameClinetHosting));
                    } else {
                        if (numberCatagory == 4) {
                            out.println(String.format("%s, вам не доступны категории видеоконтента для взрослых.", nameClinetHosting));
                        }
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}