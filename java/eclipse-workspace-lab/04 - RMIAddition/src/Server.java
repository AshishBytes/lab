import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.createRegistry(5099);
        CalcClass obj = new CalcClass();
        registry.rebind("calc", obj);
        System.out.println("Server started");
    }
}
