package com.company;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {


            DatagramSocket dgs = new DatagramSocket();
            Scanner scan = new Scanner(System.in);
            InetAddress address = InetAddress.getByName("localhost");
            byte[] inArr = new  byte[1000];
            DatagramPacket inPacket = new DatagramPacket(inArr, inArr.length);


            while(true){
                String msg = scan.nextLine();
                byte[] outArr = msg.getBytes();
                DatagramPacket outPacket = new DatagramPacket(outArr, outArr.length, address, 6780);
                dgs.send(outPacket);

                dgs.receive(inPacket);
                String inMessage = new String(inArr,0, inPacket.getLength());
                System.out.println(inMessage);

            }

        } catch (Exception e){

        }
    }

}
