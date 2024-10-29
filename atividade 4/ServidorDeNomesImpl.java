import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServidorDeNomesImpl extends UnicastRemoteObject implements ServidorDeNomes {
    protected ServidorDeNomesImpl() throws RemoteException {}

    public String getEnderecoServidor(String tipoServico) throws RemoteException {
        if (tipoServico.equals("TCP")) {
            return "localhost:5000";
        } else if (tipoServico.equals("UDP")) {
            return "localhost:6000";
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        try {
            ServidorDeNomesImpl servidor = new ServidorDeNomesImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("ServidorDeNomes", servidor);
            System.out.println("Servidor de nomes pronto.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}