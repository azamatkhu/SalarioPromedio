import java.sql.*;
import java.util.*;

public class MainSalarioPromedio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe",
                    "RIBERA",
                    "ribera"
            );

            System.out.println("Conectado!");


            String sql = "SELECT AVG(SALARIO) FROM EMPLEADO";
            Statement stam = connection.createStatement();

            ResultSet resultSet = stam.executeQuery(sql);

            if (resultSet.next()) {
                System.out.println("El salario promedio es: " + resultSet.getDouble(1));
            }

            resultSet.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}