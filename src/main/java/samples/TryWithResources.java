package samples;

import java.sql.Connection;

public class TryWithResources {

    class InJava8 {
        void doSomethingWith(Connection connection) throws Exception {
            // in Java 8, try-with-resources can only manage resources
            // that are declared for the statement
            try(Connection c = connection) {
                c.isReadOnly();
            }
        }
    }

    class InJava9 {
        void doSomethingWith(Connection connection) throws Exception {
            // in Java 9, all effectively final variables work
            try (connection) {
                connection.isReadOnly();
            }
        }
    }

}
