/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package supports;

import java.sql.Connection;

/**
 *
 * @author squeekyclean
 */
public class DataSupport {
    public static String connectionString = "";

    private Connection conn;

    /**
     * Connect using the default connection string
     */
    public DataSupport(){
        
    }

    public DataSupport(String connectionString){
        this.connectionString = connectionString;
    }

}
