package client;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketClientTwo {

    public static void main(String[] args) throws UnknownHostException, IOException {
        Socket socket = new Socket("127.0.0.1", 8888);
        System.out.println("已连上服务器。。。");

        new ClientReceiveData(new DataInputStream(socket.getInputStream())).start();
        new ClientSendData(new DataOutputStream(socket.getOutputStream())).start();
    }

}
