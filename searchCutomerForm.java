import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;

class searchCustomerForm extends JFrame{

    private OrderCollection orderCollection;    
    private JButton btnBack;
    private JButton btnSearch;
    private JLabel lblCustomerID;
    private JTextField txtCutomerID;
    private JTable tblCustomer;
    private DefaultTableModel dtm;

    private JLabel total;

    searchCustomerForm(OrderCollection orderCollection){
        this.orderCollection=orderCollection;

        setSize(600,530);
        setTitle("");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Search Customer");

        btnBack=new JButton("Back");
        btnBack.setBackground(Color.orange);

        JPanel topPanel=new JPanel(new GridLayout(3,1));
        JPanel backBtnPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
        backBtnPanel.add(btnBack);
        topPanel.add(backBtnPanel);
                
        lblCustomerID=new JLabel("    Enter Customer ID : ");
        lblCustomerID.setFont(new Font("",1,20));

        JPanel panel=new JPanel(new BorderLayout());
        panel.add("West",lblCustomerID);
        
        txtCutomerID=new JTextField(10);
        txtCutomerID.setFont(new Font("",1,20));
        panel.add("Center",txtCutomerID);

        btnSearch=new JButton(" Search ");
        btnSearch.setFont(new Font("",1,15));
        btnSearch.setBackground(Color.GREEN);

        panel.add("East",btnSearch);

        topPanel.add(panel);
        JPanel p=new JPanel();
        topPanel.add(p);
        
        add("North",topPanel);

        JPanel west=new JPanel();
        add("West",west);

        JPanel East=new JPanel();
        add("East",East);

        total=new JLabel();
        total.setFont(new Font("",1,20));

        String [] columnName={"Size","Qty","Amount"};
        dtm= new DefaultTableModel(columnName,0);
        tblCustomer=new JTable(dtm);
        
        JScrollPane tblpane=new JScrollPane(tblCustomer);
        add("Center",tblpane);

        JPanel tp=new JPanel();
        tp.add(total);

        add("South",tp);

        btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
			}
		});
      
        btnSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
                String customerID=txtCutomerID.getText();
				if (orderCollection.isHaveCustomerID(customerID)) {                             
                    dtm.setRowCount(0);
                    SQA_object [] array=orderCollection.searchCustomer(customerID);
                    double tot=0; 

                    for (int i = 0; i < array.length; i++) {
                        Object [] row={array[i].getSize(),array[i].getQty(),array[i].getAmount()};
                        dtm.addRow(row);
                        tot+=array[i].getAmount();
                    }

                    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                    centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
                    centerRenderer.setVerticalAlignment(SwingConstants.CENTER);
        
                    
                    for (int i = 0; i < tblCustomer.getColumnCount(); i++) {
                        tblCustomer.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
                    }

                    tblCustomer.setRowHeight(54);       
                    total.setText("Total :                                                    "+tot);

                    txtCutomerID.requestFocus();

                }
			}
		});

    }

}    