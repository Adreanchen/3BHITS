package at.htlhl.mulserverclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MulClient {

    public MulClient() throws IOException {

        // Create a SOCKET connection to the specified server
        Socket server = new Socket("localhost", 4711);

        // prepare in and out stream for read and write
        DataInputStream in = new DataInputStream(server.getInputStream());
        DataOutputStream out = new DataOutputStream(server.getOutputStream());

        // WRITE data (factors)
        int sta = 4;
        int end = 9;
        out.writeInt(sta);
        out.writeInt(end);

        // READ data (result of multiplication)
        int result = in.readInt();
        System.out.printf("The result of %d * %d is: %d", sta, end, result);

        //CLOSE the socket connection to the server
        server.close();
    }

    public static void main(String[] args) {
        try {
            new MulClient();
        } catch (IOException ioex) {
            System.out.println("The Client has a problem" + ioex.getMessage());
        }
    }
}
