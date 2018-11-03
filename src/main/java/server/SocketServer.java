package server;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class SocketServer {

    private final static int PORT = 8888;
    //private static ServerSocket serverSocket;

    private static List<Socket> list = new ArrayList();
    private static int count =0;


    public static void main(String[] args) throws IOException {
        //创建服务器
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("已经启动服务器...");
        while (true) {
            list.add(server.accept());
            System.out.println("有" + (count + 1)+ "个人连接了服务器！");
            //发信息(有多个人)
            if (count == 0) {
                new ServerSendData(list).start();
            }
            //收信息
            new ServerReceiveDate(new DataInputStream(list.get(count).getInputStream())).start();
            count++;
        }
    }

}
