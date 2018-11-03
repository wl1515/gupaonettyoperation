package server;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 给客户端发送消息
 */
public class ServerSendData extends Thread {

    private static Scanner input = new Scanner(System.in);
    private static List<Socket> list = new ArrayList();
    private DataOutputStream dataOutputStream;

    public ServerSendData(List<Socket> listSockets) {
        list = listSockets;
    }
    @Override
    public void run() {
        try {
            while (true) {
                String msg = input.next();
                for (Socket socket : list) {
                    dataOutputStream = new DataOutputStream(socket.getOutputStream());
                    System.out.println(("服务端发送信息：" + msg));
                    dataOutputStream.writeUTF(msg);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getLocalizedMessage());
        } finally {
            if(input != null) {
                input.close();
            }
        }
    }
}
