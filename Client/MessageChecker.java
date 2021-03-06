import java.io.DataInputStream;

public class MessageChecker extends Thread {
    private DataInputStream dis;
    private ClientApi client;

    public MessageChecker(ClientApi client, DataInputStream dis) {
        this.client = client;
        this.dis = dis;
    }

    public void run() {
        while (true) {
            try {
                client.processAnswer(dis.readUTF());
            } catch(Exception e) {}
        }
    }
}
