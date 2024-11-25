import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MainWindowFashionShop extends JFrame{
    private OrderCollection orderCollection;
    
    private JPanel ButtonPanel;
    


    private JButton search;
    private JButton status;
    private JButton reports;
    private JButton delete;
    private JButton placeOrder;

    MainWindowFashionShop(){
        orderCollection=new OrderCollection();


        setSize(600,530);
        setTitle("Fashion Shop");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setBackground(new Color(256-244-244));

        JPanel titlePanel=new JPanel(new GridLayout(1,1));
              
        add("Center",new JLabel(new ImageIcon("photo.png")));    
        titlePanel.add(new JLabel(new ImageIcon("t.png")));

        ButtonPanel = new JPanel(new GridLayout(5,1));
        

        JPanel searchPanel=new JPanel(new GridLayout(2,1));
        JPanel statusPanel=new JPanel(new GridLayout(2,1));
        JPanel reportPanel=new JPanel(new GridLayout(2,1));
        JPanel deletePanel=new JPanel(new GridLayout(2,1));
        
        search=new JButton("Search");
        search.setFont(new Font("Arial Bold",1,20));
        search.setBackground(Color.white);
        searchPanel.setSize(200,40);
        searchPanel.add(search);
       
        ButtonPanel.add(searchPanel);

        status=new JButton("Status");
        status.setFont(new Font("Arial Bold",1,20));
        status.setBackground(Color.white);
        statusPanel.setSize(200,40);
        statusPanel.add(status);
        ButtonPanel.add(statusPanel);

        reports=new JButton("Reports");
        reports.setFont(new Font("Arial Bold",1,20));
        reports.setBackground(Color.white);
        reportPanel.setSize(200,40);
        reportPanel.add(reports);
        ButtonPanel.add(reportPanel);

        delete=new JButton("Delete");
        delete.setFont(new Font("Arial Bold",1,20));
        delete.setBackground(Color.white); 
        deletePanel.setSize(200,40);
        deletePanel.add(delete);
        ButtonPanel.add(deletePanel);

        
        placeOrder=new JButton("Place Order");
        placeOrder.setFont(new Font("Arial Bold",1,22)); 
        placeOrder.setBackground(Color.cyan);
        placeOrder.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				PlaceOrderForm p1=  new PlaceOrderForm(orderCollection);
                p1.setVisible(true);
                p1.setMousePoint();
			}
		});
        
        ButtonPanel.add(placeOrder);

        JPanel copyrightPanel=new JPanel(new FlowLayout());
        JLabel copyRight=new JLabel();
        copyRight.setText("Copyrights  @TKW 2024");
        copyRight.setFont(new Font("",1,10));
        copyrightPanel.add(copyRight);

		JPanel p1=new JPanel();
		p1.add(ButtonPanel);

        add("North",titlePanel);
        add("West",p1);
        add("South",copyrightPanel);

        delete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				DeleteOrderForm d1= new DeleteOrderForm(orderCollection);
                d1.setVisible(true);
                //p1.setMousePoint();
			}
		});


        status.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new StatusChangeInOrder(orderCollection).setVisible(true); 
			}
		});

        search.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				Object[] options = {"Search Customer","Search Order","Cancel" };
                int option = JOptionPane.showOptionDialog(null, "Please select the option", "Search Options",JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                if (option==0) {
                    new searchCustomerForm(orderCollection).setVisible(true);
                }else if (option==1) {
                    new searchOrderForm(orderCollection).setVisible(true);
                }else{
                    
                }

			}
		});


        reports.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				new ViewReportsForm(orderCollection).setVisible(true);

			}
		});



    }





    
public static void main(String[] args) {
    new MainWindowFashionShop().setVisible(true);
}
    
    
}
 
