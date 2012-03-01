/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rms.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author squeekyclean
 */
public class DataRow {
    private List<String> columnNames;
    private HashMap<String, Object> objects;

    public DataRow(List<String> columnNames, List<Object> values){
        this.columnNames = columnNames;
        objects = new HashMap<String, Object>();
        for(int i=0;i<columnNames.size();i++){
            objects.put(columnNames.get(i), values.get(i));
        }
    }

    public Object get(int index){
        return get(columnNames.get(index));
    }

    public Object get(String column){
        return objects.get(column);
    }

    public void set(Object value, int index){
        set(value, columnNames.get(index));
    }

    public void set(Object value, String column){
        objects.put(column, value);
    }

    public Map<String, Object> getRow(){
        return objects;
    }

    public Map<String, String> getRowAsStrings(){
        Map<String, String> result = new HashMap<String, String>();
        for(String key : objects.keySet())
            result.put(key, objects.get(key).toString());
        return result;
    }


}