import javax.swing.table.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.*;


import java.awt.*;
import java.awt.event.*;

class ViewReportsForm extends JFrame{
    private Collection orderCollection;
    
    private JButton btnBack;

    private JButton btnViewCustomers;
    private JButton btnBestInCustomers;
    private JButton btnAllCustomers;

    private JButton btnCatagorizedByQTY;
    private JButton btnCatagorizedByAmount;

    private JButton btnOrdersByAmount;
    private JButton btnAllOrders;


    ViewReportsForm(Collection orderCollection){
        this.orderCollection=orderCollection;

        setSize(600,230);
        setTitle("");
        setDefaultCloseOperation(1);
        setLocationRelativeTo(null);
        setTitle("View Reports");

        

        btnBack=new JButton("Back");
        btnBack.setBackground(Color.orange);

        JPanel topPanel=new JPanel(new GridLayout(2,1));
        JPanel backBtnPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
        backBtnPanel.add(btnBack);
        topPanel.add(backBtnPanel);
        add("North",topPanel);

        btnViewCustomers=new JButton(" View  Customers ");
        btnViewCustomers.setBackground(Color.GREEN);
        btnViewCustomers.setFont(new Font("",1,15));
        btnViewCustomers.setForeground(Color.WHITE);

        btnBestInCustomers=new JButton("Best In Customers");
        btnBestInCustomers.setBackground(Color.GREEN);
        btnBestInCustomers.setFont(new Font("",1,15));
        btnBestInCustomers.setForeground(Color.WHITE);

        btnAllCustomers=new JButton("   All Customers   ");
        btnAllCustomers.setBackground(Color.GREEN);
        btnAllCustomers.setFont(new Font("",1,15));
        btnAllCustomers.setForeground(Color.WHITE);


        btnCatagorizedByQTY=new JButton("Categorized By QTY");
        btnCatagorizedByQTY.setBackground(Color.BLUE);
        btnCatagorizedByQTY.setFont(new Font("",1,15));
        btnCatagorizedByQTY.setForeground(Color.WHITE);

        btnCatagorizedByAmount=new JButton("Categorized By Amount");
        btnCatagorizedByAmount.setBackground(Color.BLUE);
        btnCatagorizedByAmount.setFont(new Font("",1,15));
        btnCatagorizedByAmount.setForeground(Color.WHITE);


        btnOrdersByAmount=new JButton("Orders By Amount");
        btnOrdersByAmount.setBackground(Color.GRAY);
        btnOrdersByAmount.setFont(new Font("",1,15));
        btnOrdersByAmount.setForeground(Color.WHITE);

        btnAllOrders=new JButton("All Orders");
        btnAllOrders.setBackground(Color.GRAY);
        btnAllOrders.setFont(new Font("",1,15));
        btnAllOrders.setForeground(Color.WHITE);

        JPanel west=new JPanel(new GridLayout(3,1));       
        JPanel p1=new JPanel();
        p1.add(btnViewCustomers);
        JPanel p2=new JPanel();
        p2.add(btnBestInCustomers);
        JPanel p3=new JPanel();
        p3.add(btnAllCustomers);
        west.add(p1);
        west.add(p2);
        west.add(p3);
        add("West",west);


        JPanel center=new JPanel(new GridLayout(2,1));
        JPanel p4=new JPanel();
        p4.add(btnCatagorizedByQTY);
        JPanel p5=new JPanel();
        p5.add(btnCatagorizedByAmount);
        center.add(p4);
        center.add(p5);
        add("Center",center);

        JPanel east=new JPanel(new GridLayout(2,1));
        JPanel p6=new JPanel();
        p6.add(btnOrdersByAmount);
        JPanel p7=new JPanel();
        p7.add(btnAllOrders);
        east.add(p6);
        east.add(p7);
        add("East",east);



        btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
			}
		});

        btnViewCustomers.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new ViewCustomersNoOrder(orderCollection).setVisible(true);
			}
		});


        btnBestInCustomers.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new BestInCustomersForm(orderCollection).setVisible(true);
			}
		});

        btnAllCustomers.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new AllCustomerReportForm(orderCollection).setVisible(true);
			}
		});

        btnCatagorizedByQTY.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new ItemByQtyForm(orderCollection).setVisible(true);
			}
		});


        btnCatagorizedByAmount.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new ItemByAmountForm(orderCollection).setVisible(true);
			}
		});

        btnOrdersByAmount.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new AllOrdersSortForm(orderCollection).setVisible(true);
			}
		});


        btnAllOrders.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				AllOrdersForm a1=new AllOrdersForm(orderCollection);
                a1.createAllTablr();
                a1.setVisible(true);
			}
		});

    }
}
