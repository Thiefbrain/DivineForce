package com.github.divineForce.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import org.apache.commons.lang3.tuple.Pair;

import com.github.divineForce.DivineForce;

/**
 * The database manager class manages database access. It's main use is to prevent the driver getting loaded multiple times.
 * 
 * @author Thiefbrain
 * 
 */
public final class DatabaseManager
{

    /** The directory the databases are in */
    private static String databaseDirectory;

    /** The instance of the database manager */
    private static DatabaseManager instance;

    /** The connection pool */
    private final Map<String, Connection> connectionPool = new HashMap<String, Connection>();

    /**
     * Returns the instance of the database manager.
     * 
     * @return {@link DatabaseManager} instance
     */
    public static synchronized DatabaseManager getInstance()
    {
        if (DatabaseManager.instance == null)
        {
            DatabaseManager.instance = new DatabaseManager();
        }

        return DatabaseManager.instance;
    }

    /**
     * Sets the directory the databases are stored in.
     * 
     * @param argDatabaseDirectory
     *            the directory
     */
    public static void setDatabaseDirectory(final String argDatabaseDirectory)
    {
        DatabaseManager.databaseDirectory = argDatabaseDirectory;
    }

    /**
     * Private constructor.
     */
    private DatabaseManager()
    {
        try
        {
            Class.forName("org.h2.Driver");
        }
        catch (final ClassNotFoundException classNotFoundException)
        {
            DivineForce.getLogger().log(Level.SEVERE, "Failed to load H2 driver", classNotFoundException);
        }
    }

    /**
     * Gets the connection for the given database.
     * 
     * @param database
     *            The database
     * @return {@link Connection}
     * @throws SQLException
     *             if a database access error occurs
     */
    public Connection getConnection(final String database) throws SQLException
    {
        if (!connectionPool.containsKey(database))
        {
            connectionPool.put(database, DriverManager.getConnection("jdbc:h2:" + DatabaseManager.databaseDirectory + database, "sa", ""));
        }

        return connectionPool.get(database);
    }

    /**
     * Executes the given select statement on the given connection and saves it in a statement pool.
     * 
     * @param statement
     *            The statement
     * @param connection
     *            The connection
     * @return result set
     * @throws SQLException
     *             on sql error
     */
    public ResultSet sqlSelectPrepared(Pair<String, List<?>> statement, Connection connection) throws SQLException
    {
        PreparedStatement sqlStatement = connection.prepareStatement(statement.getLeft());
    }

    /**
     * Executes an sql select statement on the given connection and saves it in a statement pool.
     * 
     * @param statement
     *            The statement
     * @param connection
     *            The connection
     * 
     * @return result set
     * @throws SQLException
     *             on sql error
     */
    public ResultSet sqlSelectPrepared(String statement, Connection connection) throws SQLException
    {
        Pair<String, List<?>> pair = Pair.of(statement, null);
        return sqlSelectPrepared(pair, connection);
    }

}
