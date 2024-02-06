



//package example;


import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;


    public class JDBCConnection {

        private static String url = "jdbc:postgresql://localhost:5432/postgres";
        private static String user = "postgres";
        private static String password = "root";

        private static Connection connection;

        public JDBCConnection() {
            // Construtor privado para evitar instâncias diretas da classe
        }

        private static Connection initConnection() throws SQLException {
            return DriverManager.getConnection(url, user, password);
        }

        public static Connection getConnection() throws SQLException {
            if (connection == null || connection.isClosed()) {
                connection = initConnection();
            }
            return connection;
        }

        private void connect() {
            try (Connection connection = DriverManager.getConnection(url, user, password)) {
                if (connection != null) {
                    System.out.println("Conexão realizada com sucesso!");
                } else {
                    System.out.println("Conexão falhou!");
                }
            } catch (SQLException e) {
                // throw new RuntimeException(e);
                e.printStackTrace();
            }
        }

        public static void main(String[] args) {
            JDBCConnection sqlConnect = new JDBCConnection();
            sqlConnect.connect();
        }

    }


