// Exercise 35: TCP Client-Server Chat
// Run in two terminals:
//   Terminal 1: java Ex35_TCPServer
//   Terminal 2: java Ex35_TCPClient

import java.io.*;
import java.net.*;

// ── SERVER ───────────────────────────────────────────────────────────────────
class Ex35_TCPServer {
    public static void main(String[] args) throws IOException {
        int port = 5000;
        System.out.println("[Server] Listening on port " + port + " ...");

        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket client = serverSocket.accept()) {

            System.out.println("[Server] Client connected: " + client.getInetAddress());

            BufferedReader  in  = new BufferedReader(new InputStreamReader(client.getInputStream()));
            PrintWriter     out = new PrintWriter(client.getOutputStream(), true);
            BufferedReader  kbd = new BufferedReader(new InputStreamReader(System.in));

            // Simple half-duplex echo loop
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println("[Client] " + line);
                if (line.equalsIgnoreCase("bye")) { out.println("bye"); break; }
                System.out.print("[Server] Reply: ");
                String reply = kbd.readLine();
                out.println(reply);
            }
            System.out.println("[Server] Connection closed.");
        }
    }
}

// ── CLIENT ───────────────────────────────────────────────────────────────────
// Separate file: Ex35_TCPClient.java
/*
import java.io.*;
import java.net.*;

public class Ex35_TCPClient {
    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("localhost", 5000);
             PrintWriter     out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader  in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader  kbd = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("[Client] Connected to server.");
            String msg;
            while (true) {
                System.out.print("[Client] You: ");
                msg = kbd.readLine();
                out.println(msg);
                String reply = in.readLine();
                System.out.println("[Server] " + reply);
                if ("bye".equalsIgnoreCase(msg)) break;
            }
        }
    }
}
*/
