package SubFunctionalities.GUI;

import Interfaces.DataEntity;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;


public class Functionalities {
    public static <T extends DataEntity> void addTableData(DefaultTableModel model, String[] headers, ArrayList<T> objectArray){

        //Adding the Header Names
        for(String column: headers){
            model.addColumn(column);
        }

        //Adding the row data
        int rowNumber = 1;
        for(T object : objectArray){
            String[] objectData = object.getData();
            String[] rowData = new String[objectData.length + 1];
            rowData[0] = String.valueOf(rowNumber);
            System.arraycopy(objectData, 0, rowData, 1, objectData.length);
            model.addRow(rowData);
            rowNumber++;
        }
    }
}
