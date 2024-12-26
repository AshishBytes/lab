import java.rmi.Remote;

public interface CalcI extends Remote {
    public int add(int x, int y) throws Exception;
}
