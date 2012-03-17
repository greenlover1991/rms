/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package extras;

import java.awt.Component;
import java.beans.PropertyChangeEvent;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;
import org.jbundle.thin.base.screen.jcalendarbutton.JCalendarButton;

/**
 *
 * @author squeekyclean
 */
public class DateCellEditor extends AbstractCellEditor implements TableCellEditor{

    public static DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
    JCalendarButton calendarButton;
    JTextField txtField;

    public DateCellEditor() {
        txtField = new JTextField();
        calendarButton = new JCalendarButton();
        
        calendarButton.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dateOnlyPopupChanged(evt);
            }

            private void dateOnlyPopupChanged(PropertyChangeEvent evt) {
                if (evt.getNewValue() instanceof Date)
                    setDate((Date)evt.getNewValue());
            }

        });
        
    }

    //Implement the one CellEditor method that AbstractCellEditor doesn't.
    public Object getCellEditorValue() {
        return txtField.getText();
    }

    //Implement the one method defined by TableCellEditor.
    public Component getTableCellEditorComponent(JTable table,
                                                 Object value,
                                                 boolean isSelected,
                                                 int row,
                                                 int column) {
        return calendarButton;
    }

    /**
     * Validate and set the datetime field on the screen given a datetime string.
     * @param dateTime The datetime string
     */
    public void setDate(String dateString)
    {
		Date date = null;
		try	{
            if ((dateString != null) && (dateString.length() > 0))
                date = dateFormat.parse(dateString);
		} catch (Exception e)	{
            date = null;
		}
        this.setDate(date);
    }
    /**
     * Validate and set the datetime field on the screen given a date.
     * @param dateTime The datetime object
     */
    public void setDate(Date date)
    {
        String dateString = "";
        if (date != null)
    		dateString = dateFormat.format(date);
        txtField.setText(dateString);
        calendarButton.setTargetDate(date);
        fireEditingStopped();
    }
}
