import java.rmi.server.UnicastRemoteObject;

public class CalcClass extends UnicastRemoteObject implements CalcI {
    public CalcClass() throws Exception {
        super();
    }
    public int add(int x, int y) {
        return x + y;
    }
}
