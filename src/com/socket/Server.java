package com.socket;

import java.io.*;
import java.net.*;

public class Server {
    public Server () { }

    public void run () {
        try{
            ServerSocket ss = new ServerSocket(6666);
            Socket s = ss.accept();
            DataInputStream dis = new DataInputStream(s.getInputStream());
            String  str = dis.readUTF();
            System.out.println("message=" + str);
            ss.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}