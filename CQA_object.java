class CQA_object {
    private String customerID;
    private int qty;
    private double amount;

    private int xs_qty;
    private int s_qty;
    private int m_qty;
    private int l_qty;
    private int xl_qty;
    private int xxl_qty;

    

    CQA_object(String customerID,int qty,double amount){
        this.customerID=customerID;
        this.qty=qty;
        this.amount=amount;

        this.xs_qty=0;
        this.s_qty=0;
        this.m_qty=0;
        this.l_qty=0;
        this.xl_qty=0;
        this.xxl_qty=0;
    }
    CQA_object(){
        this.customerID="";
        this.qty=0;
        this.amount=0.0;

        this.xs_qty=0;
        this.s_qty=0;
        this.m_qty=0;
        this.l_qty=0;
        this.xl_qty=0;
        this.xxl_qty=0;


    }

    public void setXs_qty(int xs_qty) {
        this.xs_qty = xs_qty;
    }
    public void setS_qty(int s_qty) {
        this.s_qty = s_qty;
    }
    public void setM_qty(int m_qty) {
        this.m_qty = m_qty;
    }
    public void setL_qty(int l_qty) {
        this.l_qty = l_qty;
    }
    public void setXl_qty(int xl_qty) {
        this.xl_qty = xl_qty;
    }
    public void setXxl_qty(int xxl_qty) {
        this.xxl_qty = xxl_qty;
    }
    //getters
    public String getCustomerID() {
        return customerID;
    }
    public int getXs_qty() {
        return xs_qty;
    }
    public int getS_qty() {
        return s_qty;
    }
    public int getM_qty() {
        return m_qty;
    }
    public int getL_qty() {
        return l_qty;
    }
    public int getXl_qty() {
        return xl_qty;
    }
    public int getXxl_qty() {
        return xxl_qty;
    }
    public int getQty() {
        return qty;
    }
    public double getAmount() {
        return amount;
    }

    //setters
    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }
    public void setQty(int qty) {
        this.qty = qty;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void plusQty(int qty){
        this.qty+=qty;
    }

    public void plusAmount(double amount){
        this.amount+=amount;
    }


    public void plusXSqty(int xs_qty){
        this.xs_qty+=xs_qty;
    }

    public void plusSqty(int s_qty){
        this.s_qty+=s_qty;
    }

    public void plusMqty(int m_qty){
        this.m_qty+=m_qty;
    }

    public void plusLqty(int l_qty){
        this.l_qty+=l_qty;
    }

    public void plusXLqty(int xl_qty){
        this.xl_qty+=xl_qty;
    }

    public void plusXXLqty(int xxl_qty){
        this.xxl_qty+=xxl_qty;
    }
}
