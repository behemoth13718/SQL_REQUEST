package TableModel;

import Connections.Connect_All;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author behemoth
 */
public class TableModelCaseFolderFinished extends AbstractTableModel {


    private int columnCount = 12;
    
    private ArrayList<String[]> dataArrayList;

    public TableModelCaseFolderFinished() {
        dataArrayList = new ArrayList<>();
        for (int i = 0; i < dataArrayList.size(); i++) {
            dataArrayList.add(new String[getColumnCount()]);
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "CallCenterId";
            case 1:
                return "CaseFolderId";
            case 2:
                return "CallCenterName";
            case 3:
                return "CaseHandlingTypeName";
            case 4:
                return "Created";
            case 5:
                return "Creator";
            case 6:
                return "FinishedBy";
            case 7:
                return "Modified";
            case 8:
                return "ModifiedBy";
            case 9:
                return "ANoPhoneNumber";
            case 10:
                return "BNoPhoneNumber";
            case 11:
                return "CallId";
            
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

    public void addData(Connect_All connect, String sqlQuery) {

        ResultSet result = connect.query(sqlQuery);
        dataArrayList.clear();
        try {
            while (result.next()) {

                String [] row = {
                    result.getString("CallCenterId"),
                    result.getString("CaseFolderId"),
                    result.getString("CallCenterName"),
                    result.getString("CaseHandlingTypeName"),
                    result.getString("Created"),
                    result.getString("Creator"),
                    result.getString("FinishedBy"),
                    result.getString("Modified"),
                    result.getString("ModifiedBy"),
                    result.getString("ANoPhoneNumber"),
                    result.getString("BNoPhoneNumber"),
                    result.getString("CallId")
                        
                        
                };
                addData(row);
            }
            result.close();
        } catch (SQLException ex) {
            Logger.getLogger(TableModelCategory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

