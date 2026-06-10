package at.htlhl.mulserverclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MulServer {

    public MulServer() throws IOException {

        // BIND the IP address TCP port number 4711 and
        // LISTEN for incoming data on this address and port
        // (ip address / host is local one per default)
        ServerSocket server = new ServerSocket(4711);

        while (true) {

            // ACCEPT  an incoming client connection
            Socket client = server.accept();

            // prepare in and out streams for read and wirte
            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            // READ data (factors)
            int start = in.readInt();
            int end = in.readInt();

            int result = start * end;

            // WRITE data (result of multiplications)
            out.writeInt(result);

            // CLOSE the socket connection to the client
            client.close();
        }
    }

    public static void main(String[] args) {
        try {
            new MulServer();
        } catch (IOException ioex) {
            System.out.println("A problem with the server occurred: " + ioex.getMessage());
        }
    }
}
