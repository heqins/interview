package interview.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatSocket {
    private String host;
    private int port;
    private Socket socket;
    private ServerSocket serverSocket;
    private OutputStream outputStream;

    // 以服务端形式启动，创建会话
    public void runAsServer(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
        System.out.println("[log] server started at port " + port);
        // 等待客户端的加入
        this.socket = serverSocket.accept();
        System.out.println("[log] successful connected with " + socket.getInetAddress());
        // 启动监听线程
        Thread listenThread = new Thread(new ListenThread(this.socket));
        listenThread.start();
        waitAndSend();
    }

    // 以客户端形式启动，加入会话
    public void runAsClient(String host, int port) throws IOException {
        this.socket = new Socket(host, port);
        System.out.println("[log] successful connected to server " + socket.getInetAddress());
        Thread listenThread = new Thread(new ListenThread(this.socket));
        listenThread.start();
        waitAndSend();
    }

    public void waitAndSend() throws IOException {
        this.outputStream = this.socket.getOutputStream();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            this.sendMessage(sc.nextLine());
        }
    }

    public void sendMessage(String message) throws IOException {
        byte[] msgBytes = message.getBytes("UTF-8");
        int length = msgBytes.length;
        outputStream.write(length>>8);
        outputStream.write(length);
        outputStream.write(msgBytes);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ChatSocket chatSocket = new ChatSocket();
        System.out.println("select connect type: 1 for server and 2 for client");
        int type = Integer.parseInt(scanner.nextLine().toString());
        if (type == 1) {
            System.out.print("input server port: ");
            int port = scanner.nextInt();
            try {
                chatSocket.runAsServer(port);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if (type == 2) {
            System.out.print("input server host: ");
            String host = scanner.nextLine();
            System.out.print("input server port: ");
            int port = scanner.nextInt();
            try {
                chatSocket.runAsClient(host, port);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

