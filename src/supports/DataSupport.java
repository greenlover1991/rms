/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package supports;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DB support for mysql only
 * @author squeekyclean
 */
public class DataSupport {
    private static final String dbName = "rms";
    public static String userName = "root";
    public static String password = "SCtheapuh";
    public static String hostAddress = "127.0.0.1";
    private static String portAddress = "3306";

    private static final int DEFAULT_ISOLATION_LEVEL = Connection.TRANSACTION_READ_COMMITTED;

    private Connection conn;

    /**
     * Connect using the default connection string.
     * Instantiate everytime you want to do a query or DML sql.
     * Will do all the transaction commiting and closing of connection.
     * Connections are opened everytime you instantiate.
     * Connections are closed everytime you execute.
     */
    public DataSupport() throws SQLException{
        conn = DriverManager.getConnection("jdbc:mysql://"+hostAddress+":"+portAddress+"/"+dbName, userName, password);
        conn.setTransactionIsolation(DEFAULT_ISOLATION_LEVEL);
    }

    /**
     * Used for doing DML sqls.
     * refer to Statement.executeUpdate
     * @param sql = INSERT, UPDATE, or DELETE sql statements only
     * @return either (1) the row count for SQL Data Manipulation Language (DML) statements or (2) 0 for SQL statements that return nothing
     */
    public int executeUpdate(String sql) throws SQLException{
        int result = 0;

        try {
            Statement command = conn.createStatement();
            result = command.executeUpdate(sql);
            command.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataSupport.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            conn.rollback();
            result = 0;
            throw ex;
        }
        finally{
            conn.close();
        }


        return result;
    }

    /**
     * Executes the given SQL statement, which returns a single ResultSet object.
     * refer to Statement.executeQuery
     * @param sql an SQL statement to be sent to the database, typically a static SQL SELECT statement
     * @return a ResultSet object that contains the data produced by the given query; never null
     */
    public ResultSet executeQuery(String sql) throws SQLException{
        ResultSet result = null;

        try {
            Statement command = conn.createStatement();
            result = command.executeQuery(sql);
            command.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataSupport.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            conn.rollback();
            result = null;
            throw ex;
        }
        finally{
            conn.close();
        }
        
        return result;
    }




}
