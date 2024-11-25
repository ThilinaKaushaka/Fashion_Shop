class  SQA_object {
    private String size;
    private int qty;
    private double amount;

    SQA_object(String size,int qty,double amount){
        this.size=size;
        this.qty=qty;
        this.amount=amount;
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

    public void plusAmount(double amount){
        if (this.size.equalsIgnoreCase("xs")) {
            this.amount+=amount;
        }else if (this.size.equalsIgnoreCase("s")) {
            this.amount+=amount;
        }else if (this.size.equalsIgnoreCase("m")) {
            this.amount+=amount;
        }else if (this.size.equalsIgnoreCase("l")) {
            this.amount+=amount;
        }else if (this.size.equalsIgnoreCase("xl")) {
            this.amount+=amount;
        }else if (this.size.equalsIgnoreCase("xxl")) {
            this.amount+=amount;
        }
    }

    public void plusQty(int qty){
        this.qty+=qty;
    }


    public String getSize(){
        return size;
    }

    
    public int getQty(){
        return qty;
    }

    public double getAmount(){
        return amount;
    }

}
