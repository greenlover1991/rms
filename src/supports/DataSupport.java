/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package supports;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSetMetaData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import rms.ProjectConstants;
import rms.models.BaseTableModel;
import rms.models.DataRow;
import rms.views.SettingsView;

/**
 * DB support for mysql only
 * @author squeekyclean
 */
public class DataSupport {
    private static final String dbName = "rms";
    public static String userName;
    public static String password;
    public static String hostAddress;
    private static String portAddress = "3306";

    private static final String DEFAULT_USER_NAME = "root";
    private static final String DEFAULT_PASSWORD = "";
    private static final String DEFAULT_HOST_ADDRESS = "localhost";

    private static final int DEFAULT_ISOLATION_LEVEL = Connection.TRANSACTION_READ_COMMITTED;

    private Connection conn;

    /**
     * Connect using the default connection string.
     * Instantiate everytime you want to do a query or DML sql.
     * Will do all the transaction commiting and closing of connection.
     * Connections are opened everytime you instantiate.
     * Connections are closed everytime you execute.
     * @throws if it cannot connect.
     */
    public DataSupport() throws SQLException{
        conn = DriverManager.getConnection("jdbc:mysql://"+hostAddress+":"+portAddress+"/"+dbName, userName, password);
        conn.setTransactionIsolation(DEFAULT_ISOLATION_LEVEL);
        conn.setAutoCommit(false);
    }

    public static void loadSettings(){
        try {
            Scanner scanner = new Scanner(new FileInputStream(ProjectConstants.DB_CONFIG_FILE_PATH));
            DataSupport.hostAddress = scanner.nextLine();
            DataSupport.userName = scanner.nextLine();
            DataSupport.password = scanner.nextLine();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataSupport.class.getName()).log(Level.SEVERE, null, ex);
            DataSupport.hostAddress = DEFAULT_HOST_ADDRESS;
            DataSupport.userName = DEFAULT_USER_NAME;
            DataSupport.password = DEFAULT_PASSWORD;
            writeSettings();
        }
    }

    public static void writeSettings(){
        FileWriter writer;
        try {
            writer = new FileWriter(ProjectConstants.DB_CONFIG_FILE_PATH);
            writer.write(DataSupport.hostAddress);
            writer.write("\n");
            writer.write(DataSupport.userName);
            writer.write("\n");
            writer.write(DataSupport.password);
            writer.write("\n");
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(SettingsView.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            conn.commit();
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
     * Used for doing batch DML sqls.
     * refer to Statement.executebatch
     * @param sqls = multiple INSERT, UPDATE, or DELETE sql statements only
     * @return either (1) the row count for SQL Data Manipulation Language (DML) statements or (2) 0 for SQL statements that return nothing
     */
    public int[] executeBatchUpdate(List<String> sqls) throws SQLException{
        int result[] = {};

        try {
            Statement command = conn.createStatement();
            for(String s : sqls)
                command.addBatch(s);
            result = command.executeBatch();
            command.close();
            conn.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DataSupport.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            conn.rollback();
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
    public BaseTableModel executeQuery(String sql) throws SQLException{
        BaseTableModel result = null;

        try {
            Statement command = conn.createStatement();
            ResultSet rs = command.executeQuery(sql);
            result = convertResultSetToTableModel(rs);
            rs.close();
            command.close();
            conn.commit();
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


    public Connection getConnection(){
        return this.conn;
    }

    // convert result to basetablemodel instead
    private BaseTableModel convertResultSetToTableModel(ResultSet rs){
        BaseTableModel result = null;
        try {
            ResultSetMetaData rsmd = rs.getMetaData();

            int columns = rsmd.getColumnCount();
        
            List<String> columnNames = new ArrayList<String>();
            List<String> columnAliases = new ArrayList<String>();
            

            for(int i=1; i<=columns ; i++){
                columnNames.add(rsmd.getColumnName(i));
                columnAliases.add(rsmd.getColumnLabel(i));
            }

            result = new BaseTableModel(columnNames, columnAliases);
            while(rs.next()){
                List<Object> values = new ArrayList<Object>();
                for(int i=1;i<=columns;i++)
                    values.add(rs.getObject(i));
                DataRow row = new DataRow(columnNames, values);
                result.rows.add(row);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataSupport.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;

    }




}