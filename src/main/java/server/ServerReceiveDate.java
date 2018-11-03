package server;


import java.io.DataInputStream;
import java.io.IOException;

/**
 * 接收客户端信息
 */
public class ServerReceiveDate extends Thread {

    private DataInputStream dataInputStream;

    public ServerReceiveDate(DataInputStream dInput) {
        dataInputStream = dInput;
    }

    @Override
    public void run() {
            try {
                while (true) {
                    String msg = dataInputStream.readUTF();
                    if (msg != null) {
                        System.out.println("客户端来信：" + msg);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println(e.getLocalizedMessage());
            }finally {
                if(dataInputStream != null){
                    try {
                        dataInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
    }
}
