package TableModel;

import Connections.Connect_All;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;


public class TableModelDefault extends AbstractTableModel {


    private int columnCount = 4;
    private ArrayList<String[]> dataArrayList;

    public TableModelDefault() {
        dataArrayList = new ArrayList<>();
        for (int i = 0; i < dataArrayList.size(); i++) {
            dataArrayList.add(new String[getColumnCount()]);
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "*";
            case 1:
                return "*";
            case 2:
                return "*";
            case 3:
                return "*";
        }
        return "";
    }

    @Override
    public int getRowCount() {
        return dataArrayList.size();

    }

    @Override
    public int getColumnCount() {
        return columnCount;

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String[] rows = dataArrayList.get(rowIndex);
        return rows[columnIndex];

    }

    public void addData(String[] row) {
        String[] rowTable;
        rowTable = row;
        dataArrayList.add(rowTable);
    }

    public void addData(Connect_All connect) {

        ResultSet result = connect.query("select * from Catigory");
        try {
            while (result.next()) {
                String [] row = {
                        result.getString("ID"),
                        result.getString("Category"),
                        result.getString("Discount"),
                        result.getString("Opisanie")
                };
                addData(row);
            }

        } catch (SQLException ex) {
            Logger.getLogger(TableModelCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


}
