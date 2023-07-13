package SubFunctionalities.GUI;

import Interfaces.DataEntity;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.util.ArrayList;
import java.util.List;


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

    public static <T extends DataEntity> void sortTable(JTable table, int columnIndex, SortOrder sortOrder, ArrayList<T> objectArray){
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(sorter);
        List<RowSorter.SortKey> sortKeys = new ArrayList<>(objectArray.size());
        sortKeys.add(new RowSorter.SortKey(columnIndex, sortOrder));
        sorter.setSortKeys(sortKeys);
    }
}
