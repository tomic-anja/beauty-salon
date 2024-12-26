/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import domain.Employee;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.Controller;
import thread.ClientThread;

/**
 *
 * @author Dell E5450
 */
public class Server extends Thread {

    private Controller controller;
    private List<ClientThread> clients;
    ServerSocket serverSocket;
    private boolean end = false;

    public Server() {
        this.controller = new Controller();
        clients = new ArrayList<>();
        try {
            serverSocket = new ServerSocket(9000);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (!end) {
            try {
                System.out.println("Waiting for connection...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Connected!");
                ClientThread clientThread = new ClientThread(clientSocket, this);
                clientThread.start();
                clients.add(clientThread);
            } catch (IOException ex) {
//                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }

    public void stopServer() throws Exception {
        try {
            for (ClientThread clientThread : clients) {
                clientThread.setEnd(true);

            }

            serverSocket.close();
            System.out.println("Server stopped");
            end = true;

        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean notLogin(Employee employee) {
        for (ClientThread client : clients) {
            if (employee.equals(client.getLoginUser())) {
                return false;
            }
        }
        return true;
    }

}
