import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;

class AllOrdersForm extends JFrame{

    private Collection orderCollection;    
    private JButton btnBack;
    
    private JTable tblCustomer;
    private DefaultTableModel dtm;


    AllOrdersForm(Collection orderCollection){
        this.orderCollection=orderCollection;

        setSize(600,530);
        setTitle("");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("All Orders");

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

                
        String [] columnName={"Order ID","Customer ID","Size","Qty","Amount","Status"};
        dtm= new DefaultTableModel(columnName,0);
        tblCustomer=new JTable(dtm);
        
        
        JScrollPane tblpane=new JScrollPane(tblCustomer);
        JPanel tblPanel=new JPanel();    
        add("Center",tblpane);

        
        
               
                    

           
        btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){           
                dispose();
   
			}

		});
       
       
      
    }


    public void createAllTablr(){
        Order [] array=orderCollection.allOrder();

        

        for (int i = 0; i < array.length; i++) {
            Object [] row={array[i].getOrderID(),array[i].getCustomerID(),array[i].getSize(),array[i].getQty(),array[i].getAmount(),array[i].getStatus()==0?"PROCESSING":array[i].getStatus()==1?"DELIVERING":"DELIVERED"};
            dtm.addRow(row);
                        
        }

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        centerRenderer.setVerticalAlignment(SwingConstants.CENTER);
        
                    
        for (int i = 0; i < tblCustomer.getColumnCount(); i++) {
            tblCustomer.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        tblCustomer.setRowHeight(64);
    }



}    
