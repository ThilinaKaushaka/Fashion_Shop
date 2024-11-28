import javax.swing.table.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.*;

 

import java.awt.*;
import java.awt.event.*;

class DeleteOrderForm extends JFrame{
    private OrderCollection orderCollection;
    
    private JButton btnBack;
    private JButton btnDelete;
    private JButton btnSearch;

    
    private JLabel lblOrderID;
    private JLabel lblCustomerID;
    private JLabel lblSize;
    private JLabel lblQty;
    private JLabel lblAmount;
    private JLabel lblStatus;

    private JTextField txtOrderID;

    private JLabel lbl_customerId;
    private JLabel lbl_size;
    private JLabel lbl_qty;
    private JLabel lbl_amount;
    private JLabel lbl_status;


    private int deleteIndex;


    DeleteOrderForm(OrderCollection orderCollection){
        this.orderCollection=orderCollection;

        setSize(600,530);
        setTitle("");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Delete Order");

        deleteIndex=-1;

        btnBack=new JButton("Back");
        btnBack.setBackground(Color.orange);

        JPanel topPanel=new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(btnBack);
        add("North",topPanel);

        btnDelete=new JButton(" Delete ");
        btnDelete.setFont(new Font("",1,40));
       
        btnDelete.setBackground(Color.red);
        btnDelete.setFont(new Font("Arial Bold",0,20));
        JPanel BottomPanel=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        BottomPanel.add(btnDelete);
        add("South",BottomPanel);

        JPanel labelPanel=new JPanel(new GridLayout(13,1));

        lblOrderID=new JLabel("    Enter Order ID :    ");
        lblOrderID.setFont(new Font("",1,20));

        lblCustomerID=new JLabel("    Customer ID :    ");
        lblCustomerID.setFont(new Font("",1,20));

        lblSize=new JLabel("    Size :    ");
        lblSize.setFont(new Font("",1,20));

        lblQty=new JLabel("    QTY :    ");
        lblQty.setFont(new Font("",1,20));

        lblAmount=new JLabel("    Amount :    ");
        lblAmount.setFont(new Font("",1,20));

        lblStatus=new JLabel("    Status :    ");
        lblStatus.setFont(new Font("",1,20));

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

        labelPanel.add(lblStatus);
        JPanel p55=new JPanel();
        labelPanel.add(p55);

        add("West",labelPanel);

        JPanel textPanel=new JPanel(new GridLayout(13,1));
        txtOrderID=new JTextField(10);
        txtOrderID.setFont(new Font("",1,20));

        JPanel top2=new JPanel();
        textPanel.add(top2);
        
        textPanel.add(txtOrderID);

        
        lbl_customerId=new JLabel();
        lbl_customerId.setFont(new Font("",1,20));

        lbl_size=new JLabel();
        lbl_size.setFont(new Font("",1,20));

        lbl_qty=new JLabel();
        lbl_qty.setFont(new Font("",1,20));
    
        lbl_amount=new JLabel();
        lbl_amount.setFont(new Font("",1,20));

        lbl_status=new JLabel();
        lbl_status.setFont(new Font("",1,20));

        JPanel p6=new JPanel();
        textPanel.add(p6);
        textPanel.add(lbl_customerId);

        JPanel p7=new JPanel();
        textPanel.add(p7);
        textPanel.add(lbl_size);

        JPanel p8=new JPanel();
        textPanel.add(p8);
        textPanel.add(lbl_qty);

        JPanel p9=new JPanel();
        textPanel.add(p9);
        textPanel.add(lbl_amount);

        JPanel p10=new JPanel();
        textPanel.add(p10);
        textPanel.add(lbl_status);

        add("Center",textPanel);


        JPanel WestPanel=new JPanel(new GridLayout(13,1));
        JPanel panel=new JPanel();
        WestPanel.add(panel);

        btnSearch=new JButton(" Search ");
        btnSearch.setFont(new Font("",1,15));
        btnSearch.setBackground(Color.GREEN);
               
        WestPanel.add(btnSearch);

        add("East",WestPanel);

        btnBack.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				dispose();
			}
		});

        btnSearch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){

                Order ob=orderCollection.search(txtOrderID.getText().toUpperCase());
                if (ob!=null) {
                    deleteIndex=ob.getIndex();
                    lbl_customerId.setText(ob.getCustomerID());
                    lbl_size.setText(ob.getSize());
                    lbl_qty.setText(Integer.toString(ob.getQty()));
                    lbl_amount.setText(Double.toString(ob.getAmount()));
                    lbl_status.setText(ob.getStatus()==0?"PROCESSING":ob.getStatus()==1?"DELIVERING":ob.getStatus()==2?"DELIVERED":"ERROR");


                }else{
                    JOptionPane.showMessageDialog(textPanel,"Invalid Order ID...");
                }

			}
		});

        
 


        btnDelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if (deleteIndex>-1) {
                    int opcion = JOptionPane.showConfirmDialog(null, "Do you want to Delete this Order ?", "", JOptionPane.YES_NO_OPTION);
                    if (opcion == 0) {
                    
                        if (orderCollection.deleteOrder(deleteIndex)) {
                            JOptionPane.showMessageDialog(textPanel,"Order Deleted...");
                            txtOrderID.setText("");
                            txtOrderID.requestFocus();
                            lbl_customerId.setText("");
                            lbl_amount.setText("");
                            lbl_qty.setText("");
                            lbl_size.setText("");
                            lbl_status.setText("");
                        
                            deleteIndex=-1;
                            Order []or=orderCollection.toOrderArray();
                            for (int i = 0; i < orderCollection.toOrderArray().length; i++)
							{
								System.out.println(or[i].getCustomerID());
								System.out.println("===========");
							}
							
                        }else{
                            JOptionPane.showMessageDialog(textPanel,"Error..");
                            txtOrderID.setText("");
                            txtOrderID.requestFocus();
                            lbl_customerId.setText("");
                            lbl_amount.setText("");
                            lbl_qty.setText("");
                            lbl_size.setText("");
                            lbl_status.setText("");
                            deleteIndex=-1;
                        }


                    }else {
                        txtOrderID.setText("");
                        txtOrderID.requestFocus();
                        lbl_customerId.setText("");
                        lbl_amount.setText("");
                        lbl_qty.setText("");
                        lbl_size.setText("");
                        lbl_status.setText("");
                        deleteIndex=-1;
                    }
                }
			}
		});



    }
}
