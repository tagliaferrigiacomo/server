package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws Exception {

    ServerSocket ss = new ServerSocket(3000);
    Socket client = ss.accept();

    BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
    PrintWriter out = new PrintWriter(client.getOutputStream(), true);

    String riga;
    

      while ((riga = in.readLine()) != null && !riga.equals("exit")) {
            String[] dati = riga.split(" ");

            double a = Double.parseDouble(dati[0]);
            String operazione = dati[1];
            double b = Double.parseDouble(dati[2]);
            double risultato;

            if (operazione.equals("+")) {
                risultato = a + b;
                out.println(risultato);
            } else if (operazione.equals("-")) {
                risultato = a - b;
                out.println(risultato);
            } else if (operazione.equals("*")) {
                risultato = a * b;
                out.println(risultato);
            } else if (operazione.equals("/")) {
                if (b == 0) {
                    out.println("ERR-0:divided_by_zero");
                } else {
                    risultato = a / b;
                    out.println(risultato);
                }
            }
        }

        client.close();
        ss.close();
    }
}