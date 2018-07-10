
package sqlv1.pkg4;

import Connections.Connect_All;
import TableModel.TableModelCaseFolderFinished;
import TableModel.TableModelCategory;
import TableModel.TableModelDefault;
import TableModel.TableModelProduct;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Properties;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

public class GUI extends javax.swing.JFrame {

   // Varrible Conections
    String URL_1 = "jdbc:sqlserver://192.168.2.198:62785;database=Shop";
    String URL_2 = "jdbc:sqlserver://192.168.2.198:62785;database=omnidata";
    
    

    Connect_All connect_DB_1 = new Connect_All(URL_1);
    Connect_All connect_DB_2 = new Connect_All(URL_2);
    Connect_All connect_DB_FREE = new Connect_All(getUrlFree(URL_FREE),getNameFree(USER_NAME_FREE),getNameFree(USER_NAME_FREE));
    
    
    
    
    

    //Varrible ComboBox

       String DB_QUERY_BOX;
       String DB_REGION_BOX;
       String DB_1 = "DB_1";
       String DB_2 = "DB_2";
       String DB_3 = "DB_3";
       String ALIAS;
static String URL_FREE = "";
static String USER_NAME_FREE = "";
static String USER_PASS_FREE = "";
static String LOGER = "";
static String QUERY_FREE = "";

    //Varrible TableModel
    static TableModelDefault modelDefault = new TableModelDefault();
    static TableModelProduct modelProduct = new TableModelProduct();
    static TableModelCaseFolderFinished modelCaseFolderFinished = new TableModelCaseFolderFinished();
    static TableModelCategory modelCategory = new TableModelCategory();
    
    
    public GUI() {
        
        initComponents();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane = new javax.swing.JScrollPane();
        DATA_TABLE_ = new javax.swing.JTable();
        String[][] items2 = {{"",""},{"МО", "DB_1"}, {"ВО", "DB_2"}, {"TEST", "DB_3"}};
        String[] alias2 = new String[items2.length];
        String[] select2 = new String[items2.length];
        box_REGION_ = new javax.swing.JComboBox();
        btn_CONNECT_ = new javax.swing.JToggleButton();
        String[][] items = {{"", ""},{"Выбрать все из таблицы Product", "select * from Product"}, {"Найти закрытую карточку по номеру", "select * from cse_CaseFolderFinished_tab where CaseFolderId="}, {"Найти завершенные карточки по номеру", "select * from cse_CaseFolderFinished_tab where CaseID="}};
        String[] alias = new String[items.length];
        String[] select = new String[items.length];
        box_QUERY_ = new javax.swing.JComboBox();
        btn_QUERY_ = new javax.swing.JButton();
        num_CASE_ = new javax.swing.JTextField();
        URL_FILD = new javax.swing.JTextField();
        LOGIN_FILD = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        PASS_FILD = new javax.swing.JPasswordField();
        BTN_CONNECT = new javax.swing.JToggleButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        LOG = new javax.swing.JTextArea();
        QUERY_FILD = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(111, 111));

        jScrollPane.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        DATA_TABLE_.setModel(modelDefault);
        DATA_TABLE_.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        DATA_TABLE_.setDragEnabled(true);
        jScrollPane.setViewportView(DATA_TABLE_);

        box_REGION_.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int i = box_REGION_.getSelectedIndex();
                // textField.setText(select[i]);

                DB_REGION_BOX = select2[i];
            }
        });

        for (int i = 0; i < items2.length; i++) {
            alias2[i] = items2[i][0];
        }

        for (int i = 0; i < items2.length; i++) {
            select2[i] = items2[i][1];
        }
        box_REGION_.setModel(new javax.swing.DefaultComboBoxModel(alias2));

        btn_CONNECT_.setText("Подключиться");
        btn_CONNECT_.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                btn_CONNECT_ItemStateChanged(evt);
            }
        });
        btn_CONNECT_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CONNECT_ActionPerformed(evt);
            }
        });

        box_QUERY_.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int i = box_QUERY_.getSelectedIndex();
                DB_QUERY_BOX = select [i];

                ALIAS = alias [i];

            }
        });

        for (int i = 0; i < items.length; i++) {
            alias[i] = items[i][0];
        }

        for (int i = 0; i < items.length; i++) {
            select[i] = items[i][1];
        }
        box_QUERY_.setModel(new javax.swing.DefaultComboBoxModel(alias));
        box_QUERY_.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                box_QUERY_ItemStateChanged(evt);
            }
        });
        box_QUERY_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box_QUERY_ActionPerformed(evt);
            }
        });

        btn_QUERY_.setText("Выполнить");
        btn_QUERY_.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_QUERY_ActionPerformed(evt);
            }
        });

        URL_FILD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                URL_FILDActionPerformed(evt);
            }
        });

        LOGIN_FILD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LOGIN_FILDActionPerformed(evt);
            }
        });

        jLabel1.setText("URL");

        jLabel2.setText("LOGIN");

        jLabel3.setText("PASS");

        BTN_CONNECT.setText("Connect");
        BTN_CONNECT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_CONNECTActionPerformed(evt);
            }
        });

        jLabel4.setText(" Выберите из списка БД для подключения");

        jLabel5.setText("Выберите запрос");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 208, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 162, Short.MAX_VALUE)
        );

        LOG.setColumns(20);
        LOG.setRows(5);
        jScrollPane2.setViewportView(LOG);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(box_QUERY_, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(num_CASE_, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_QUERY_, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(box_REGION_, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(69, 69, 69)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(18, 18, 18)
                                .addComponent(btn_CONNECT_)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(URL_FILD, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(BTN_CONNECT))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(PASS_FILD, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                                            .addComponent(LOGIN_FILD, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(26, 26, 26)
                                        .addComponent(QUERY_FILD, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)))
                        .addContainerGap())))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(480, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(18, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(URL_FILD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(BTN_CONNECT))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(LOGIN_FILD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(PASS_FILD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(QUERY_FILD))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(btn_CONNECT_))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(box_REGION_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(box_QUERY_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(num_CASE_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_QUERY_))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(249, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(25, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public String getUrlFree(String URL_FREE){
        
        if(URL_FREE == ""){
            
        }
        else{
            Connect_All connect_DB_FREE = new Connect_All(URL_FREE);
            System.out.println("Я положил туда...");
        }
        return URL_FREE;
    }
    
    public String getNameFree(String USER_NAME_FREE){
        
        if(USER_NAME_FREE == ""){
            
        }
        else{
            Connect_All connect_DB_FREE = new Connect_All(USER_NAME_FREE);
            System.out.println("Я положил туда...");
        }
        return USER_NAME_FREE;
    }
    
    public String getPassFree(String USER_PASS_FREE){
        
        if(USER_PASS_FREE == ""){
            
        }
        else{
            Connect_All connect_DB_FREE = new Connect_All(USER_PASS_FREE);
            System.out.println("Я положил туда...");
        }
        return USER_PASS_FREE;
    }
    
     public static String getUrlFild(){
     return   URL_FREE = URL_FILD.getText();
    }
     public static String getNameFild(){
     return   USER_NAME_FREE = LOGIN_FILD.getText();
    }
     public static String getPassFild(){
     return   USER_PASS_FREE = PASS_FILD.getText();
    }

     public static String getQueryFild(){
     return   QUERY_FREE = QUERY_FILD.getText();
    }

    public static void putLog(String str){
        LOG.append(str);
    }
     
    public void getStartBoxSTR(String STR){
        if(STR==DB_1){
            connect_DB_1.connectOn();
        }
        else if (STR==DB_2) {
            connect_DB_2.connectOn();
        }else if(STR==DB_3){
            System.out.println("return Connection DB3");
        }
        else{
            System.out.println("Chose connect");
        }
    }
    
     public void getStopBoxSTR(String STR){
        if(STR==DB_1){
            connect_DB_1.connectOff();
        }
        else if (STR==DB_2) {
            connect_DB_2.connectOff();
        }
        else{
            System.out.println("Connect no off");
        }
    }
    

    private void btn_CONNECT_ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_btn_CONNECT_ItemStateChanged
        if(btn_CONNECT_.isSelected()){
            getStartBoxSTR(DB_REGION_BOX);
            btn_CONNECT_.setText("Отключиться");
        } else {
            btn_CONNECT_.setText("Подключиться");
            getStopBoxSTR(DB_REGION_BOX);
        }
    }//GEN-LAST:event_btn_CONNECT_ItemStateChanged

 ///вернуть из поля значение!!!!!!
    
    private void btn_QUERY_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_QUERY_ActionPerformed
        getQueryFild();
        
        if(ALIAS == "Выбрать все из таблицы Product"){
            DATA_TABLE_.setModel(modelProduct);                
            modelProduct.addData(connect_DB_1,DB_QUERY_BOX);
        }
        else if(ALIAS == "Найти закрытую карточку по номеру"){
            DATA_TABLE_.setModel(modelDefault);
            
            if(DB_QUERY_BOX == "select * from cse_CaseFolderFinished_tab where CaseFolderId="){
                String SUM_QUERY = DB_QUERY_BOX + num_CASE_.getText();
                DATA_TABLE_.setModel(modelCaseFolderFinished);
                modelCaseFolderFinished.addData(connect_DB_FREE,SUM_QUERY);
                DATA_TABLE_.getColumnModel().getColumn(0).setMinWidth(75);
                DATA_TABLE_.getColumnModel().getColumn(1).setMinWidth(80);
                DATA_TABLE_.getColumnModel().getColumn(2).setMinWidth(90);
                DATA_TABLE_.getColumnModel().getColumn(3).setMinWidth(90);
                DATA_TABLE_.getColumnModel().getColumn(4).setMinWidth(145);
                DATA_TABLE_.getColumnModel().getColumn(5).setMinWidth(100);
                DATA_TABLE_.getColumnModel().getColumn(6).setMinWidth(100);
                DATA_TABLE_.getColumnModel().getColumn(7).setMinWidth(100);
                DATA_TABLE_.getColumnModel().getColumn(8).setMinWidth(100);
                DATA_TABLE_.getColumnModel().getColumn(9).setMinWidth(100);
                DATA_TABLE_.getColumnModel().getColumn(10).setMinWidth(75);
                DATA_TABLE_.getColumnModel().getColumn(11).setMinWidth(75);
            }
        }
        else if(QUERY_FREE != "select * from cse_CaseFolderFinished_tab where CaseFolderId=1" ){
                DATA_TABLE_.setModel(modelCaseFolderFinished);
                modelCaseFolderFinished.addData(connect_DB_FREE,QUERY_FREE);
                DATA_TABLE_.getColumnModel().getColumn(0).setMinWidth(75);
                DATA_TABLE_.getColumnModel().getColumn(1).setMinWidth(80);
                DATA_TABLE_.getColumnModel().getColumn(2).setMinWidth(90);
                DATA_TABLE_.getColumnModel().getColumn(3).setMinWidth(90);
                DATA_TABLE_.getColumnModel().getColumn(4).setMinWidth(145);
                DATA_TABLE_.getColumnModel().getColumn(5).setMinWidth(100);
                DATA_TABLE_.getColumnModel().getColumn(6).setMinWidth(100);
                DATA_TABLE_.getColumnModel().getColumn(7).setMinWidth(100);
                DATA_TABLE_.getColumnModel().getColumn(8).setMinWidth(100);
                DATA_TABLE_.getColumnModel().getColumn(9).setMinWidth(100);
                DATA_TABLE_.getColumnModel().getColumn(10).setMinWidth(75);
                DATA_TABLE_.getColumnModel().getColumn(11).setMinWidth(75);
            }
       
        else{
            DATA_TABLE_.setModel(modelCategory);
//            modelCategory.addData(connect_1,DB_QUERY_BOX);
        }
    }//GEN-LAST:event_btn_QUERY_ActionPerformed

    private void btn_CONNECT_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CONNECT_ActionPerformed
       // TODO add your handling code here:
    }//GEN-LAST:event_btn_CONNECT_ActionPerformed

    
    private void box_QUERY_ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_box_QUERY_ItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_box_QUERY_ItemStateChanged
    private void setConnectDB_Free(){
        getUrlFild();
        getNameFild();
        getPassFild();
        this.connect_DB_FREE = new Connect_All(getUrlFree(URL_FREE),getNameFree(USER_NAME_FREE),getPassFree(USER_PASS_FREE));
    }
    
    private void BTN_CONNECTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_CONNECTActionPerformed
        if(BTN_CONNECT.isSelected()){
            setConnectDB_Free();
            connect_DB_FREE.connectOnFree();
            BTN_CONNECT.setText("Отключиться");
        } else {
            BTN_CONNECT.setText("Подключиться");
            connect_DB_FREE.connectOff();
        }
    }//GEN-LAST:event_BTN_CONNECTActionPerformed

    private void LOGIN_FILDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LOGIN_FILDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LOGIN_FILDActionPerformed


    
    private void box_QUERY_ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box_QUERY_ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_box_QUERY_ActionPerformed

    private void URL_FILDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_URL_FILDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_URL_FILDActionPerformed

   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BTN_CONNECT;
    private javax.swing.JTable DATA_TABLE_;
    private static javax.swing.JTextArea LOG;
    private static javax.swing.JTextField LOGIN_FILD;
    private static javax.swing.JPasswordField PASS_FILD;
    private static javax.swing.JTextField QUERY_FILD;
    private static javax.swing.JTextField URL_FILD;
    private javax.swing.JComboBox box_QUERY_;
    private javax.swing.JComboBox box_REGION_;
    private javax.swing.JToggleButton btn_CONNECT_;
    private javax.swing.JButton btn_QUERY_;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField num_CASE_;
    // End of variables declaration//GEN-END:variables
}
