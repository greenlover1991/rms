/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rms.models.management;

import java.util.Arrays;
import rms.models.BaseTableModel;

/**
 *
 * @author squeekyclean
 */
public class IngredientTableModel extends BaseTableModel{
    public static final String TABLE_NAME = "ingredients";

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String DESCRIPTION = "description";
    public static final String UNIT_OF_MEASURE = "unit_of_measure";
    public static final String MINIMUM_QUANTITY = "minimum_quantity";
    public static final String QUANTITY = "quantity";
    public static final String STATUS = "status";

    private static final String[] columns = {ID, NAME, DESCRIPTION, UNIT_OF_MEASURE, MINIMUM_QUANTITY, QUANTITY, STATUS};
    private static final String[] primary_columns = {ID};

    public IngredientTableModel(){
        super(TABLE_NAME, Arrays.asList(columns), Arrays.asList(primary_columns));
    }
}
