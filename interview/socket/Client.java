package interview.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.Scanner;

/**
 * The very basic interview.socket client that only send one single message.
 */

public class Client {
    private String serverHost;
    private int serverPort;
    private Socket socket;
    private OutputStream outputStream;
    public Client(String host, int port) {
        this.serverHost = host;
        this.serverPort = port;
    }

    public void connetServer2() throws IOException {
        this.socket = new Socket(this.serverHost, this.serverPort);
        this.outputStream = socket.getOutputStream();
    }

    public void send(String message) throws IOException {
        String sendMsg = message + "\n"; // we mark \n as a end of line.
        try {
            this.outputStream.write(sendMsg.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        }
//        this.outputStream.close();
//        this.interview.socket.shutdownOutput();
    }

    public static void main(String[] args) {
        Client cc = new Client("127.0.0.1", 12322);
        try {
            cc.connetServer2();
            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {
                String line = sc.nextLine();
                cc.send(line);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

}


