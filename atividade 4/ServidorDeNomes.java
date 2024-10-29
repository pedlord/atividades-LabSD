import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServidorDeNomes extends Remote {
    String getEnderecoServidor(String tipoServico) throws RemoteException;
}