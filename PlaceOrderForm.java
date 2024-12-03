import javax.swing.table.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.*;




import java.awt.*;
import java.awt.event.*;


class PlaceOrderForm extends JFrame{
    private Collection orderCollection;

    private JLabel lblOrderID;
    private JLabel lblCustomerID;
    private JLabel lblSize;
    private JLabel lblQty;
    private JLabel lblAmount;

    private JLabel lblOrderIDprint;
    private JLabel txtAmount;

    private JTextField txtCustomerID;
    private JTextField txtSize;
    private JTextField txtQty;
    

    private JButton btnBack;
    private JButton btnPlace;

    PlaceOrderForm(Collection orderCollection){
        this.orderCollection=orderCollection;

        setSize(600,530);
        setTitle("");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Place Order");

        btnBack=new JButton("Back");
        btnBack.setBackground(Color.orange);

        JPanel labelPanel=new JPanel(new GridLayout(11,1));

        lblOrderID=new JLabel("    Order ID :    ");
        lblOrderID.setFont(new Font("",1,20));

        lblCustomerID=new JLabel("    Customer ID :    ");
        lblCustomerID.setFont(new Font("",1,20));

        lblSize=new JLabel("    Size :    ");
        lblSize.setFont(new Font("",1,20));

        lblQty=new JLabel("    QTY :    ");
        lblQty.setFont(new Font("",1,20));

        lblAmount=new JLabel("    Amount :    ");
        lblAmount.setFont(new Font("",1,20));

        JPanel top=new JPanel();
        labelPanel.add(top);
        
        JPanel p1=new JPanel();
        labelPanel.add(lblOrderID);
        labelPanel.add(p1);

        labelPanel.add(lblCustomerID);
        JPanel p2=new JPanel();
        labelPanel.add(p2);

        labelPanel.add(lblSize);
        JPanel p3=new JPanel();
        labelPanel.add(p3);

        labelPanel.add(lblQty);
        JPanel p4=new JPanel();
        labelPanel.add(p4);

        labelPanel.add(lblAmount);
        JPanel p5=new JPanel();
        labelPanel.add(p5);

        add("West",labelPanel);

        JPanel textPanel=new JPanel(new GridLayout(11,1));

        lblOrderIDprint=new JLabel(orderCollection.setOrderID());
        lblOrderIDprint.setFont(new Font("",1,20));
        
        

        txtCustomerID=new JTextField(10);
        txtCustomerID.setFont(new Font("",1,20));

        txtSize=new JTextField(10);
        txtSize.setFont(new Font("",1,20));
        

        txtQty=new JTextField(10);
        txtQty.setFont(new Font("",1,20));
              

        txtAmount=new JLabel();
        txtAmount.setFont(new Font("",1,20));
        
        
        JPanel top2=new JPanel();
        textPanel.add(top2);

        textPanel.add(lblOrderIDprint);
        JPanel p6=new JPanel();
        textPanel.add(p6);

        textPanel.add(txtCustomerID);
        JPanel p7=new JPanel();
        textPanel.add(p7);

        textPanel.add(txtSize);
        JPanel p8=new JPanel();
        textPanel.add(p8);

        textPanel.add(txtQty);
        JPanel p9=new JPanel();
        textPanel.add(p9);

        textPanel.add(txtAmount);
        JPanel p10=new JPanel();
        textPanel.add(p10);

        add("Center",textPanel);

        JPanel WestPanel=new JPanel(new GridLayout(11,1));
        JPanel panel=new JPanel();
        JPanel pane2=new JPanel();
        JPanel pane3=new JPanel();
        JPanel panel4=new JPanel();
        JPanel panel5=new JPanel();

        JLabel sizeLabel=new JLabel("    XS/S/M/L/XL/XXL       ");
        sizeLabel.setFont(new Font("",1,12));

        WestPanel.add(panel);
        WestPanel.add(pane2);
        WestPanel.add(pane3);
        WestPanel.add(panel4);
        WestPanel.add(panel5);
        WestPanel.add(sizeLabel);

        add("East",WestPanel);

        JPanel topPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(btnBack);
        add("North",topPanel);

        btnPlace=new JButton(" Place ");
        btnPlace.setFont(new Font("",1,30));
       
        btnPlace.setBackground(Color.CYAN);
        btnPlace.setFont(new Font("Arial Bold",0,20));
        JPanel BottomPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        BottomPanel.add(btnPlace);
        add("South",BottomPanel);



        //INFO:-ACTION EVENTS===============================
        
        //back button event
        btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
			}
		});


        //txtSize ecent
        txtSize.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				txtAmount.setText(Double.toString(setAmount(txtSize.getText(),Integer.parseInt(txtQty.getText()))));
			}
		});

        //txtQty event
        txtQty.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				txtAmount.setText(Double.toString(setAmount(txtSize.getText(),Integer.parseInt(txtQty.getText()))));
			}
		});


        //place button event
        btnPlace.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evts){
				
                String orderID=lblOrderIDprint.getText();
                String customerID=txtCustomerID.getText();
                String size=txtSize.getText();
                int qty=Integer.parseInt(txtQty.getText());
                double amount=setAmount(size, qty);

                txtAmount.setText(Double.toString(setAmount(txtSize.getText(),Integer.parseInt(txtQty.getText()))));
                
                
                if (!orderCollection.isValidCustomerID(customerID)) {
                    JOptionPane.showMessageDialog(textPanel,"Invalid Input...");
					txtCustomerID.setText("");
					txtCustomerID.requestFocus();
                }
                
                if (!orderCollection.isValidSize(size)) {
                    JOptionPane.showMessageDialog(textPanel,"Invalid Input...");
                    txtSize.setText("");
                    txtSize.requestFocus();
                    txtAmount.setText(Double.toString(setAmount(txtSize.getText(),Integer.parseInt(txtQty.getText()))));
                }
                
                if(qty<1){
                    JOptionPane.showMessageDialog(textPanel,"Invalid Input...");
                    txtQty.setText("");
                    txtQty.requestFocus();
                    txtAmount.setText(Double.toString(setAmount(txtSize.getText(),Integer.parseInt(txtQty.getText()))));
                }

                Order order=new Order(orderID,customerID,size,qty,amount);
                
                if (orderCollection.addOrder(order)) {
                    JOptionPane.showMessageDialog(textPanel,"Order Placed...");
                    
                    
                    
                    
                    lblOrderIDprint.setText("");
                    lblOrderIDprint.setText(orderCollection.setOrderID());
                    

                    txtCustomerID.setText("");
                    txtCustomerID.requestFocus();
                    txtSize.setText("");
                    txtQty.setText("");
                    txtAmount.setText("");
                }else{
                    JOptionPane.showMessageDialog(textPanel,"Please Enter Valid Input...");
                    txtCustomerID.setText("");
                    txtCustomerID.requestFocus();
                    txtSize.setText("");
                    txtQty.setText("");
                    txtAmount.setText("");
                }								
			}
		});
    }

    //set mouse point to customer id 
    public void setMousePoint(){
        txtCustomerID.requestFocus();
        
    }

    //amount genarate
    public double setAmount(String size,int qty){
        return size.equalsIgnoreCase("XS")?qty*600:size.equalsIgnoreCase("S")?qty*800:size.equalsIgnoreCase("M")?qty*900:size.equalsIgnoreCase("L")?qty*1000:size.equalsIgnoreCase("XL")?qty*1100:size.equalsIgnoreCase("XXL")?qty*1200:0;
    }

}
