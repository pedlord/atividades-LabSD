import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Uso: java Cliente <tipoServico>");
            return;
        }
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            ServidorDeNomes servidorDeNomes = (ServidorDeNomes) registry.lookup("ServidorDeNomes");

            String tipoServico = args[0].toUpperCase(); // Alternar entre "TCP" e "UDP"
            String endereco = servidorDeNomes.getEnderecoServidor(tipoServico);

            if (tipoServico.equals("TCP")) {
                String[] parts = endereco.split(":");
                String host = parts[0];
                int port = Integer.parseInt(parts[1]);
                Socket socket = new Socket(host, port);
                
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                
                out.println("Olá servidor TCP!");
                System.out.println("Resposta: " + in.readLine());
                
                socket.close();
            } else if (tipoServico.equals("UDP")) {
                String[] parts = endereco.split(":");
                String host = parts[0];
                int port = Integer.parseInt(parts[1]);
                
                DatagramSocket socket = new DatagramSocket();
                byte[] sendData = "Olá servidor UDP!".getBytes();
                
                InetAddress address = InetAddress.getByName(host);
                DatagramPacket packet = new DatagramPacket(sendData, sendData.length, address, port);
                socket.send(packet);
                
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                socket.receive(receivePacket);
                
                String resposta = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Resposta: " + resposta);
                
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}