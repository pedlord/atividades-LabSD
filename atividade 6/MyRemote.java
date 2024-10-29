import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyRemote extends Remote{
    public String sayHello() throws RemoteException;

    int sum(int a, int b) throws RemoteException;

    int sub(int a, int b) throws RemoteException;
}
