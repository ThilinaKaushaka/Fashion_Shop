class Order {

    //final variable
    static final int PROCESSING = 0 ;
    static final int DELIVERING = 1 ;
    static final int DELIVERED  = 2 ; 

    //object attribute
    private String orderID;
    private String customerID;
    private String size;
    private int qty;
    private double amount;
    private int status;
    private int index;

    //parameterized constructor
    Order(String orderID,String customerID,String size,int qty,double amount){
        this.orderID=orderID;
        this.customerID=customerID;
        this.size=size;
        this.qty=qty;
        this.amount=amount;
        this.status=PROCESSING;
        this.index=-1;
    }


    //default constructor 
    Order(){
        
    }

    //GETTERS
    public String getOrderID(){
        return this.orderID;
    }

    public String getCustomerID(){
        return this.customerID;
    }

    public String getSize(){
        return this.size;
    }

    public int getQty(){
        return this.qty;
    }

    public double getAmount(){
        return this.amount;
    }

    public int getStatus(){
        return this.status;
    }

    public int getIndex(){
        return this.index;
    }

    //SETTERS
    public void setOrderID(String orderID){
        this.orderID=orderID;
    }

    public void setCustomerID(String customerID){
        this.customerID=customerID;
    }

    public void setSize(String size){
        this.size=size;
    }

    public void setQty(int qty){
        this.qty=qty;
    }

    public void setAmount(double amount){
        this.amount=amount;
    }

    public void setStatus(int status){
        this.status=status;
    } 
    
    public void setIndex(int index){
        this.index=index;
    }
}
