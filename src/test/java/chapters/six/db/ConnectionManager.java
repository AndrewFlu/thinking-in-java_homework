package chapters.six.db;

public class ConnectionManager {

    private static Connection[] connectionPool = new Connection[] {
            Connection.getConnection(),
            Connection.getConnection(),
            Connection.getConnection()
    };
    private static ConnectionSingleton[] connectionSingletonsPool = new ConnectionSingleton[] {
            ConnectionSingleton.getConnection(),
            ConnectionSingleton.getConnection(),
            ConnectionSingleton.getConnection()
    };
    private static int availableConnection = connectionPool.length;
    private static int availableConnectionSingleton = connectionSingletonsPool.length;

    public static Connection getConnection() {
        System.out.println("Установка соединения для  Connection...");
        if (availableConnection != 0) {
            int index = connectionPool.length - availableConnection--;
            System.out.println("Соединение установлено");

            return connectionPool[index];
        } else {
            System.out.println("Ошибка. Нет доступных соединений");
            return null;
        }
    }

    public static ConnectionSingleton getSingletonConnection() {
        System.out.print("Установка соединения для  ConnectionSingleton...");
        if (availableConnectionSingleton != 0) {
            int index = connectionSingletonsPool.length - availableConnectionSingleton--;
            System.out.println("Соединение установлено");

            return connectionSingletonsPool[index];
        } else {
            System.out.println("Ошибка. Нет доступных соединений");
            return null;
        }
    }

    public static void main(String[] args) {
        Connection connection1 = getConnection();
        Connection connection2 = getConnection();
        getConnection();
        getConnection();
        System.out.println(connection1 == connection2);
        System.out.println("");
        ConnectionSingleton singletonConnection1 = getSingletonConnection();
        ConnectionSingleton singletonConnection2 = getSingletonConnection();
        getSingletonConnection();
        getSingletonConnection();
        System.out.println(singletonConnection1 == singletonConnection2);
    }
}

class Connection {
    private Connection() {
    }

    public static Connection getConnection() {
        return new Connection();
    }
}

class ConnectionSingleton {
    private static ConnectionSingleton connection = new ConnectionSingleton();

    private ConnectionSingleton() {
    }

    public static ConnectionSingleton getConnection() {
        return connection;
    }

    public void printInfo() {
        System.out.println("Connection for ConnectSingleton has been established");
    }
}
