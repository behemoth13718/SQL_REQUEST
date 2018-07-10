package TableModel;

import Connections.Connect_All;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

public class TableModelProduct extends AbstractTableModel {

        private int columnCount = 2;
        private ArrayList<String[]> dataArrayList;

        public TableModelProduct() {
            dataArrayList = new ArrayList<>();
            for (int i = 0; i < dataArrayList.size(); i++) {
                dataArrayList.add(new String[getColumnCount()]);
            }
        }

        @Override
        public String getColumnName(int columnIndex) {
            switch (columnIndex) {
                case 0:
                    return "ID";
                case 1:
                    return "TYPE";

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
            try {
                while (result.next()) {
                    String [] row = {
                            result.getString("ID"),
                            result.getString("TYPE")

                    };
                    addData(row);
                }
                result.close();
            } catch (SQLException ex) {
                Logger.getLogger(TableModelCategory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

