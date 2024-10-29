import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServidorUDP {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(6000)) {
            System.out.println("Servidor UDP iniciado na porta 6000...");

            byte[] buffer = new byte[1024];

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                String mensagem = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Recebido: " + mensagem);

                String resposta = "Echo: " + mensagem;
                byte[] respostaBytes = resposta.getBytes();
                DatagramPacket respostaPacket = new DatagramPacket(
                        respostaBytes, respostaBytes.length, packet.getAddress(), packet.getPort());
                socket.send(respostaPacket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}