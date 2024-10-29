import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyRemoteImp extends UnicastRemoteObject implements MyRemote {
    public String sayHello(){
        return "Olá mundo";
    }

    public MyRemoteImp() throws RemoteException{
        super();
    }

    public int sum(int a, int b) throws RemoteException {
        return a + b;
    }

    public int sub(int a, int b) throws RemoteException {
        return a - b;
    }

    
}
