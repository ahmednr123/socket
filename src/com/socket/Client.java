package com.socket;

import java.io.*;
import java.net.*;

public class Client {
    public Client () { }

    public void run () {
        try{
            Socket s = new Socket("139.59.13.222",6666);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            dout.writeUTF("Hello Server");
            dout.flush();


            DataInputStream din = new DataInputStream(s.getInputStream());
            String data;
            while(true) {
                data = din.readUTF();
                System.out.println(data);
                if (data == "close") {
                    break;
                }
            }
            dout.close();
            din.close();
            s.close();
        } catch(Exception e) {
            System.out.println(e);
        }
    }
}