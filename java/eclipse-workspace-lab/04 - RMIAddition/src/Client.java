import java.rmi.Naming;

public class Client {
    public static void main(String[] args) throws Exception {
        try {
            CalcI obj = (CalcI) Naming.lookup("rmi://localhost:5099/calc");
            int n = obj.add(5, 7);
            System.out.println("Result: " + n);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
