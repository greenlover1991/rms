/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rms;

/**
 * List of project constants
 * @author squeekyclean
 */
public class ProjectConstants {
    /** Used for DB column status */
    public static String STATUS_ACTIVE = "Active";
    /** Used for DB column status */
    public static String STATUS_INACTIVE = "Inactive";

    /** Messages */
    public static String MSG_CONFIRM_DELETE = "Are you sure?";
    public static String MSG_SUCCESS_SAVE = "Saving successful.";
    public static String MSG_FAILED_SAVE = "Saving failed.";
    public static String MSG_SUCCESS_DELETE = "Deleting successful.";
    public static String MSG_FAILED_DELETE = "Deleting failed.";
    public static String MSG_ERROR_CONNECTION_DB = "Database Connection failed. Please try again.";
    public static String MSG_SUCCESS_CONNECTION_DB = "Database Connection successful.";
    public static String MSG_SUCCESS_CONFIG_FILE_SAVE = "Database Configuration Saved.";
    public static String MSG_ERROR_CONFIG_FILE = "Database Configuration file cannot be found. Please secure proper file.";
    public static String MSG_ERROR_CONNECTION_SOCKETS = "Socket Connection failed. Please try again.";
    public static String MSG_ERROR_LOGIN = "Incorrect login or password.";

    /** Configuration paths */
    public static final String DB_CONFIG_FILE_PATH = "database.config";

}
