package interview.socket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * The very basic interview.socket server that only listen one single message.
 */

public class Server {

    private ServerSocket server;
    private Socket socket;
    private int port;
    private InputStream inputStream;

    public Server(int port) {
        this.port = port;
    }

    public void runServer2() throws IOException {
        this.server = new ServerSocket(this.port);

        System.out.println("base interview.socket server started.");

        this.socket = server.accept();
        // the code will block here till the request come.

        this.inputStream = this.socket.getInputStream();
        Scanner sc = new Scanner(this.inputStream);
        while (sc.hasNextLine()) {
            System.out.println("get info from client: " + sc.nextLine());
        } // 循环接收并输出消息内容
        this.inputStream.close();
        socket.close();
    }

    public static void main(String[] args) {
        Server serverTest = new Server(12322);

        // ServerSocket server = new ServerSocket();
        // Socket socket = new Socket();
        // socket = server.accept();
        // InputStream input = socket.getInputStream();
        // Scanner sc = new Scanner(input);
        // while (sc.hasNextLine())
        // print(sc.nextLine());
        // input.close();
        // socket.close();

        // ClientSocket client = new ClientSocket();
        // Socket socket = new Socket();
        // socket = client.accept();
        // OutputStream output = socket.getOutputStream();
        // Scanner sc = new Scanner(System.in());
        // line = sc.nextLine();
        // outputStream.write(line.getBytes("UTF-8"));
        try {
            serverTest.runServer2();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}


