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

    /** Unit of measurements */
    public static final String UNIT_KILOGRAMS = "kgs";
    public static final String UNIT_PIECES = "pcs";
    public static final String UNIT_PACKS = "packs";
    public static final String UNIT_LITERS = "liters";
    public static final String UNIT_CANS = "cans";
    public static final String UNIT_BOTTLES = "bottles";

    /** Possible unit of measurements*/
    public static final String[] UNIT_OF_MEASUREMENTS = {UNIT_KILOGRAMS, UNIT_PIECES, UNIT_PACKS, UNIT_LITERS, UNIT_CANS, UNIT_BOTTLES};

    /** Table Statuses */
    public static final String TABLE_STATUS_AVAILABLE = "Available";
    public static final String TABLE_STATUS_OCCUPIED = "Occupied";
    public static final String TABLE_STATUS_RESERVED = "Reserved";
    public static final String TABLE_STATUS_DIRTY = "Dirty";
    public static final String TABLE_STATUS_OUT_OF_ORDER = "Out of Order";

    /** Order Slip Item Statuses */
    /** Still pending to be finalized by customer, can still be cancelled. */
    public static final String ORDER_ITEM_STATUS_PENDING = "Pending";
    /** Already queued to be cooked, cannot be cancelled. */
    public static final String ORDER_ITEM_STATUS_QUEUED = "Queued";
    public static final String ORDER_ITEM_STATUS_CANCELLED = "Cancelled";
    public static final String ORDER_ITEM_STATUS_PROCESSING = "Processing";
    public static final String ORDER_ITEM_STATUS_PROCESSED = "Processed";
    public static final String ORDER_ITEM_STATUS_SERVED = "Served";

    /** Order Slip Statuses */
    public static final String ORDER_STATUS_ACTIVE = "Active";
    public static final String ORDER_STATUS_TENDERED = "Tendered";
    public static final String ORDER_STATUS_CANCELLED = "Cancelled";

    /** Roles */
    public static final String ROLE_ADMIN = "Administrator";
    public static final String ROLE_CHEF = "Chef";
    public static final String ROLE_CASHIER = "Cashier";
    public static final String ROLE_WAITER = "Waiter";
}
