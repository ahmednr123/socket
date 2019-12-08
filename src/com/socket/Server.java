package com.socket;

import java.io.*;
import java.net.*;

public class Server {
    public Server () { }

    public void run () {
        try{
            ServerSocket ss = new ServerSocket(6666);
            Socket s = ss.accept();

            System.out.println("Client Data: ");
            System.out.println("Address: " + s.getInetAddress().getHostAddress());
            System.out.println("Name: " + s.getInetAddress().getHostName());
            System.out.println("Remote socket address: " + s.getRemoteSocketAddress());

            DataInputStream dis = new DataInputStream(s.getInputStream());
            String  str = dis.readUTF();
            System.out.println("Request: " + str);
            ss.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}