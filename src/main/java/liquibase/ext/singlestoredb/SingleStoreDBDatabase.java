package liquibase.ext.singlestoredb;

import liquibase.database.DatabaseConnection;
import liquibase.exception.DatabaseException;

public class SingleStoreDBDatabase extends liquibase.database.core.PostgresDatabase {

    public static final int PRIORITY_DEFAULT = 9999;
    public static final String PRODUCT_NAME = "SingleStoreDB";

    public SingleStoreDBDatabase() {

    }

    @Override
    public String getShortName() {
        return "singlestoredb";
    }

    @Override
    public String getDefaultDatabaseProductName() {
        return "SingleStoreDB";
    }

    @Override
    public Integer getDefaultPort() {
        return 3306;
    }

    @Override
    public int getPriority() {
        return PRIORITY_DEFAULT;
    }

    @Override
    public boolean isCorrectDatabaseImplementation(DatabaseConnection conn) throws DatabaseException {
        return PRODUCT_NAME.equalsIgnoreCase(conn.getDatabaseProductName());
    }

    @Override
    public String getDefaultDriver(String url) {
        return "com.singlestore.jdbc.Driver";
    }

}