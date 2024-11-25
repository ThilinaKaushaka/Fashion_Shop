import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;

class ItemByAmountForm extends JFrame{

    private OrderCollection orderCollection;    
    private JButton btnBack;
    
    private JTable tblCustomer;
    private DefaultTableModel dtm;

    private JLabel total;

    ItemByAmountForm(OrderCollection orderCollection){
        this.orderCollection=orderCollection;

        setSize(600,530);
        setTitle("");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Items By Amount");

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

        
        
        SQA_object [] array=orderCollection.itemByQtyOrAmount(true);

        

        for (int i = 0; i < array.length; i++) {
            Object [] row={array[i].getSize(),array[i].getQty(),array[i].getAmount()};
            dtm.addRow(row);
                        
        }

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        centerRenderer.setVerticalAlignment(SwingConstants.CENTER);
        
                    
        for (int i = 0; i < tblCustomer.getColumnCount(); i++) {
            tblCustomer.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        tblCustomer.setRowHeight(64);       
                    

           
        btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){           
                dispose();
   
			}

		});
       
       
      
    }

}    
