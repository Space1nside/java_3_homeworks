import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer extends Thread{
    private ServerSocket serverSocket;

    public MainServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void run() {
        try {
            Socket socket = serverSocket.accept();
            try {
                getFile(socket);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void getFile(Socket socketClient) throws IOException, ClassNotFoundException {
        DataInputStream in = new DataInputStream(socketClient.getInputStream());
        FileOutputStream out = new FileOutputStream("studentTwo.ser");
        byte[] buffer = new byte[4000];
        int x;
        while((x = in.read(buffer)) > 0) {
            out.write(buffer);
        }
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("studentTwo.ser"));
        Student serializedStudent = (Student) objectInputStream.readObject();
        serializedStudent.info();
        in.close();
        out.close();
        objectInputStream.close();
    }

    public static void main(String[] args) {
        MainServer server = new MainServer(8189);
        server.start();
    }
}
