package name.caiyao.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by caiya on 2016/6/30 0030.
 */
public class SocketServer {


    public static void main(String[] args) {
        SocketServer socketServer = new SocketServer();
        socketServer.startServer();
    }

    private void startServer() {
        ServerSocket serverSocket = null;

        Socket socket = null;
        try {
            serverSocket = new ServerSocket(9898);
            System.out.println("server started");
            while (true) {
                socket = serverSocket.accept();
                managerConnection(socket);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void startTimeTask(BufferedWriter buferWriter) {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    buferWriter.write("heart beat ...\n");
                    buferWriter.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 3000);
    }

    private void managerConnection(Socket socket) {
        new Thread(() -> {
            BufferedWriter bufferedWriter = null;
            BufferedReader bufferedReader = null;
            System.out.println("client:" + socket.hashCode() + " connected");
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                String receivedMsg;
                while ((receivedMsg = bufferedReader.readLine()) != null) {
                    System.out.println("client:" + socket.hashCode()+" "+receivedMsg);
                    bufferedWriter.write("server reply:" +receivedMsg + "\n");
                    bufferedWriter.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    bufferedReader.close();
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }).start();
    }
}
