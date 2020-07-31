import java.io.*;
import java.net.Socket;

public class MainClient {
    private Socket socket;
    private FileInputStream in;
    private DataOutputStream out;

    public MainClient(String host, int port, String file) {
        try {
            socket = new Socket(host, port);
            sendFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendFile(String file) throws IOException {
        out = new DataOutputStream(socket.getOutputStream());
        in = new FileInputStream(file);

        byte[] arr = new byte[4000];

        while (in.read(arr) > 0) {
            out.write(arr);
        }

        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        Student student = new Student("Adilet", 1);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("studentOne.ser"));
        objectOutputStream.writeObject(student);
        objectOutputStream.close();
        new MainClient("localHost", 8189, "studentOne.ser");
    }
}
