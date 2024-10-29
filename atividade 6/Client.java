import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: java Client <num1> <num2>");
            return;
        }
        try {
            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[1]);

            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            MyRemote service = (MyRemote) registry.lookup("MyRemote");

            String response = service.sayHello();
            int sumResult = service.sum(num1, num2);
            int subResult = service.sub(num1, num2);

            System.out.println("Resposta do servidor: " + response);

            System.out.println("Resposta do servidor para serviço de cálculo:");
            System.out.println(String.format("A soma de %d + %d = %d", num1, num2, sumResult));
            System.out.println(String.format("A subtração de %d - %d = %d", num1, num2, subResult));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
