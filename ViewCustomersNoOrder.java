import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;

class ViewCustomersNoOrder extends JFrame{

    private Collection orderCollection;    
    private JButton btnBack;
    
    private JTable tblCustomer;
    private DefaultTableModel dtm;

    private JLabel total;

    ViewCustomersNoOrder(Collection orderCollection){
        this.orderCollection=orderCollection;

        setSize(600,530);
        setTitle("");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("View Customers");

        btnBack=new JButton("Back");
        btnBack.setBackground(Color.orange);

        JPanel topPanel=new JPanel(new GridLayout(2,1));
        JPanel backBtnPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
        backBtnPanel.add(btnBack);
        topPanel.add(backBtnPanel);
        add("North",topPanel);

        add("West",new JPanel());
        add("East",new JPanel());
        add("South",new JPanel());

                
        String [] columnName={"Customer ID","Qty","Amount"};
        dtm= new DefaultTableModel(columnName,0);
        tblCustomer=new JTable(dtm);
        
        
        JScrollPane tblpane=new JScrollPane(tblCustomer);
        JPanel tblPanel=new JPanel();    
        add("Center",tblpane);

        if (orderCollection.toOrderArray().length!=0) {
            CQA_object [] dataArray=orderCollection.createCustomersDataArray();
                dtm.setRowCount(0);
                for (int i = 0; i < dataArray.length; i++) {
                    Object [] row={dataArray[i].getCustomerID(),dataArray[i].getQty(),dataArray[i].getAmount()};
                    dtm.addRow(row);                   
                }
    
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
                centerRenderer.setVerticalAlignment(SwingConstants.CENTER);                
                for (int i = 0; i < tblCustomer.getColumnCount(); i++) {
                    tblCustomer.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
                }
                tblCustomer.setRowHeight(54); 
        }       
        btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){           
                dispose();
   
			}

		});
       
       
      
    }

}    
