package com.company;


public class Main {
    public static void main(String[] args) {
        Server server=new Server();
        try{
            server.start(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
