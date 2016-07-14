package name.caiyao.client;

import java.io.*;
import java.net.Socket;

/**
 * Created by caiya on 2016/6/30 0030.
 */
public class SocketClient {
    public static void main(String[] args) {
        SocketClient socketClient = new SocketClient();
        socketClient.start();
    }

    private void start() {
        BufferedReader inputReader = null;
        BufferedReader bufferedReader = null;
        BufferedWriter outWriter = null;
        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", 8080);
            outWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            inputReader = new BufferedReader(new InputStreamReader(System.in));
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            startServerReplyLisenter(bufferedReader);
            String inputContent;
            while (!(inputContent = inputReader.readLine()).equals("bye")) {
                outWriter.write(inputContent);
                outWriter.write("\n");
                outWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outWriter != null) {
                    outWriter.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (inputReader != null) {
                    inputReader.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void startServerReplyLisenter(BufferedReader bufferedReader) {
        new Thread(() -> {
            try {
                String response;
                while ((response = bufferedReader.readLine()) != null) {
                    System.out.println(response);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
