package client;


import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * 给服务端发送信息
 */
public class ClientSendData extends Thread{

    private DataOutputStream dataOutputStream;
    private static Scanner input = new Scanner(System.in);
    public ClientSendData(DataOutputStream dOutput) {
        dataOutputStream = dOutput;
    }
    @Override
    public void run() {
        try {
            while (true) {
                String msg = input.next();
                System.out.println("给服务器发信：" +msg);
                if (msg != null) {
                    dataOutputStream.writeUTF(msg);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getLocalizedMessage());
        }
    }
}
