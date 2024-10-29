import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            MyRemote service = new MyRemoteImp();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("MyRemote", service);
            
            System.out.println("Servidor RMI iniciado");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
