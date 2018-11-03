package client;


import java.io.DataInputStream;
import java.io.IOException;

/**
 * 收取服务端发来的信息
 */
public class ClientReceiveData extends Thread{

    private DataInputStream dataInputStream;
    public ClientReceiveData(DataInputStream dInput) {
        dataInputStream = dInput;
    }
    @Override
    public void run() {

        try {
            while (true) {
                String msg = dataInputStream.readUTF();
                if (msg != null) {
                    System.out.println("服务器来信：" + msg);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getLocalizedMessage());
        }
/*        finally {
            try {
                dataInputStream.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }*/

    }
}
