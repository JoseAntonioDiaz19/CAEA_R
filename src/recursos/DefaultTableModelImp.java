/**
 * Esta clase crea un modelo de tabla 
 * donde se define los nombres de columnas y las filas que contendra
 * las celdas que se pueden editar
 */
package recursos;

import javax.swing.table.DefaultTableModel;

/**
 * @version 1.0
 * @author campu
 * fecha de creacion: 19/Nov/2018
 */
public class DefaultTableModelImp extends DefaultTableModel {

    public DefaultTableModelImp(Object[][] data, Object[] columnNames) {
        super(data, columnNames);
    }
    
    boolean[] canEdit = new boolean[]{
        false, false, false, false, false, false, false
    };

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit[columnIndex];
    }
}