import java.util.Arrays;

interface Collection{
    public static OrderCollection getOrderCollection(){
        return null;
	}
    public boolean addOrder(Order order);   
    public String setOrderID();
    public boolean isValidCustomerID(String customerID);
    public boolean isValidSize(String size);
    public Order[] toOrderArray();
    public Order lastObject();
    public boolean isValidOrderID(String id);
    public int contains(String id);
    public Order search(String id);
    public boolean deleteOrder(int index);
    public boolean statusChange(int index,int status);   
    public SQA_object [] searchCustomer(String customerID);    
    public boolean isHaveCustomerID(String customerID);   
    public CQA_object [] createCustomersDataArray();
    public CQA_object[] sortCQA(CQA_object [] ar);
    public SQA_object[] itemByQtyOrAmount(boolean Lc);
    public Order [] sort();
    public Order[] allOrder();    
}

class OrderCollection implements Collection {
    private static OrderCollection orderCollentionObject;   
    private int ID;
    private Order [] orderArray;
    
    private OrderCollection(){
        orderArray = new Order[0];
        ID=1;        
    }

    public static OrderCollection getOrderCollection(){
        if(orderCollentionObject==null){
            orderCollentionObject=new OrderCollection();
        }
        return orderCollentionObject;
    }



    //add order
    public boolean addOrder(Order order){
        if(isValidCustomerID(order.getCustomerID())&&isValidSize(order.getSize())){
            extendOrderArray();
            orderArray[orderArray.length-1]=order;
            ID++;
            return true;
        }

        return false;
        
    }

    //extend order array
    private void extendOrderArray(){
        Order [] tempArray=new Order[orderArray.length+1];
        for (int i = 0; i < orderArray.length; i++) {
            tempArray[i]=orderArray[i];
        }
        orderArray=tempArray;
    }
    
    //auto genarate order ID
    public String setOrderID(){	
		String newId=String.format("ODR#%06d",ID);
		return newId;
	}

    //valid customerID
    public boolean isValidCustomerID(String customerID){
        boolean Lc=false;
        for (int i = 0; i < customerID.length(); i++) {         
            if(customerID.charAt(i)=='0'||customerID.charAt(i)=='1'||customerID.charAt(i)=='2'||customerID.charAt(i)=='3'||customerID.charAt(i)=='4'||customerID.charAt(i)=='5'||customerID.charAt(i)=='6'||customerID.charAt(i)=='7'||customerID.charAt(i)=='8'||customerID.charAt(i)=='9'){     
                Lc =true;
            }else{
                Lc=false;
                break;
            }
        }
        return customerID.charAt(0)=='0'&&customerID.length()==10&&Lc;
    }

    //valid size
    public boolean isValidSize(String size){
        return size.equalsIgnoreCase("XS")||size.equalsIgnoreCase("S")||size.equalsIgnoreCase("M")||size.equalsIgnoreCase("L")||size.equalsIgnoreCase("XL")||size.equalsIgnoreCase("XXL");
    }


    //to Order Array
    public Order[] toOrderArray(){
        Order [] tempOrderArray=orderArray;
        return tempOrderArray;
    }

    //return last object
    public Order lastObject(){
        return orderArray[orderArray.length-1];
    }


    //valid orderID
    public boolean isValidOrderID(String id){   
        if(id.substring(0,4).equalsIgnoreCase("ODR#")&&Integer.parseInt(id.substring(4))>0) return true;
        return false;
    }


    public int contains(String id){
        for (int i = 0; i < orderArray.length; i++) {
            if(orderArray[i].getOrderID().equalsIgnoreCase(id)) return i;
        }
        return -1;
    }


    public Order search(String id){
        int index=contains(id);

        if (index!=-1) {
            Order ob=orderArray[index];
            ob.setIndex(index);
            return ob;
        }

        return null;

    }


    //delete order
    public boolean deleteOrder(int index){
        Order [] tempArray=new Order[orderArray.length-1];
        L1:for (int i = 0; i < tempArray.length; i++) {
            if(i>=index){
				tempArray[i]=orderArray[i+1];
				continue L1;
			}	
            tempArray[i]=orderArray[i];
        }
        orderArray=tempArray;
        System.out.println(orderArray.length);
        return true;
    }


    //set status
    public boolean statusChange(int index,int status){
        if (status==1||status==2){
            orderArray[index].setStatus(status==1?orderArray[index].DELIVERING:orderArray[index].DELIVERED);
            return true;
        }
        return false;    
        
    }

    private int[] extendArray(int [] ar){
        int [] temp=new int[ar.length+1];
        for (int i = 0; i < ar.length; i++) {
            temp[i]=ar[i];
        }
        return temp;
    }


    private int[] createIndexArray(String customerID){
        int [] indexArray=new int[0];

        for (int i = 0; i < orderArray.length; i++) {
            if (orderArray[i].getCustomerID().equalsIgnoreCase(customerID)) {
                indexArray= extendArray(indexArray);
                indexArray[indexArray.length-1]=i;
            }
        }

        return indexArray;
    }

    public SQA_object [] searchCustomer(String customerID){
        int [] indexArray=createIndexArray(customerID);
        Order []tempOrderArray=toOrderArray();

        SQA_object [] array={new SQA_object("XS", 0,0),new SQA_object("S", 0,0),new SQA_object("M", 0,0),new SQA_object("L", 0,0),new SQA_object("XL", 0,0),new SQA_object("XXL", 0,0)};

        for (int i = 0; i < indexArray.length; i++) {
            if(tempOrderArray[indexArray[i]].getSize().equalsIgnoreCase("XS")) {
                array[0].plusAmount(tempOrderArray[indexArray[i]].getAmount());
                array[0].plusQty(tempOrderArray[indexArray[i]].getQty());
            
            }else if (tempOrderArray[indexArray[i]].getSize().equalsIgnoreCase("S")) {
                array[1].plusAmount(tempOrderArray[indexArray[i]].getAmount());
                array[1].plusQty(tempOrderArray[indexArray[i]].getQty());
            
            }else if (tempOrderArray[indexArray[i]].getSize().equalsIgnoreCase("M")) {
                array[2].plusAmount(tempOrderArray[indexArray[i]].getAmount());
                array[2].plusQty(tempOrderArray[indexArray[i]].getQty());
            
            }else if (tempOrderArray[indexArray[i]].getSize().equalsIgnoreCase("L")) {
                array[3].plusAmount(tempOrderArray[indexArray[i]].getAmount());
                array[3].plusQty(tempOrderArray[indexArray[i]].getQty());
            
            }else if (tempOrderArray[indexArray[i]].getSize().equalsIgnoreCase("XL"))  {
                array[4].plusAmount(tempOrderArray[indexArray[i]].getAmount());
                array[4].plusQty(tempOrderArray[indexArray[i]].getQty());
            
            }else if (tempOrderArray[indexArray[i]].getSize().equalsIgnoreCase("XXL")) {
                array[5].plusAmount(tempOrderArray[indexArray[i]].getAmount());
                array[5].plusQty(tempOrderArray[indexArray[i]].getQty());
            }
        }

        return sortQAS(array,true);

    }


    private SQA_object[] sortQAS(SQA_object [] ar,boolean Lc){       
		for(int i=ar.length-1; i>=0; i--){
			for(int j=0; j<i; j++){
				if(Lc==true?ar[j].getAmount()<ar[j+1].getAmount():ar[j].getQty()<ar[j+1].getQty()){
					SQA_object t=ar[j];
					ar[j]=ar[j+1];
					ar[j+1]=t;
				}
				
			}
		}
        return ar;
    }

    public boolean isHaveCustomerID(String customerID){
        for (int i = 0; i < orderArray.length; i++) {
            if (orderArray[i].getCustomerID().equalsIgnoreCase(customerID)) {
                return true;
            }
        }
        return false;
    }


    private String[] extentCusIDArray(String [] array){
        String [] temp=new String[array.length+1];
        for (int i = 0; i < array.length; i++) {
            temp[i]=array[i];
        }
        return temp;
    }


    private String [] getCustomerIDs(){
        Order [] ar=orderArray;
        String [] cusIDarray=new String[0];



        L1:for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < cusIDarray.length; j++) {
                if (ar[i].getCustomerID().equalsIgnoreCase(cusIDarray[j])) {
                    continue L1;
                }

            }

            cusIDarray=extentCusIDArray(cusIDarray);
            cusIDarray[cusIDarray.length-1]=ar[i].getCustomerID();
                
        }

        return cusIDarray;
    }

    public CQA_object [] createCustomersDataArray(){
        String [] cusIDArray=getCustomerIDs();
        CQA_object [] cqaArray=new CQA_object[cusIDArray.length];
              
        for (int i = 0; i < cusIDArray.length; i++) {          
            int [] indexArray=createIndexArray(cusIDArray[i]);
            cqaArray[i]=new CQA_object();
            cqaArray[i].setCustomerID(cusIDArray[i]);
            for (int j = 0; j < indexArray.length; j++) {
                cqaArray[i].plusQty(orderArray[indexArray[j]].getQty());
                cqaArray[i].plusAmount(orderArray[indexArray[j]].getAmount());



                if (orderArray[indexArray[j]].getSize().equalsIgnoreCase("XS")) {
                    cqaArray[i].plusXSqty(orderArray[indexArray[j]].getQty());

                }else if (orderArray[indexArray[j]].getSize().equalsIgnoreCase("S")) {
                    cqaArray[i].plusSqty(orderArray[indexArray[j]].getQty());
                
                }else if (orderArray[indexArray[j]].getSize().equalsIgnoreCase("M")) {
                    cqaArray[i].plusMqty(orderArray[indexArray[j]].getQty());
                
                }else if (orderArray[indexArray[j]].getSize().equalsIgnoreCase("L")) {
                    cqaArray[i].plusLqty(orderArray[indexArray[j]].getQty());
                
                }else if (orderArray[indexArray[j]].getSize().equalsIgnoreCase("XL")) {
                    cqaArray[i].plusXLqty(orderArray[indexArray[j]].getQty());
                
                }else if (orderArray[indexArray[j]].getSize().equalsIgnoreCase("XXL")) {
                    cqaArray[i].plusXXLqty(orderArray[indexArray[j]].getQty());
                
                }

            }

        }


        return cqaArray;

    }

    public CQA_object[] sortCQA(CQA_object [] ar){       
		for(int i=ar.length-1; i>=0; i--){
			for(int j=0; j<i; j++){
				if(ar[j].getAmount()<ar[j+1].getAmount()){
					CQA_object t=ar[j];
					ar[j]=ar[j+1];
					ar[j+1]=t;
				}
				
			}
		}
        return ar;
    }







    public SQA_object[] itemByQtyOrAmount(boolean Lc){

        SQA_object [] allArray={new SQA_object("XS",0,0),new SQA_object("S",0,0),new SQA_object("M", 0, 0),new SQA_object("L", 0, 0),new SQA_object("XL",0, 0),new SQA_object("XXL", 0, 0)};

        for (int i = 0; i < orderArray.length; i++) {
            if (orderArray[i].getSize().equalsIgnoreCase("XS")) {
                allArray[0].plusAmount(orderArray[i].getAmount());
                allArray[0].plusQty(orderArray[i].getQty());
            
            }else if (orderArray[i].getSize().equalsIgnoreCase("S")) {
                allArray[1].plusAmount(orderArray[i].getAmount());
                allArray[1].plusQty(orderArray[i].getQty());
            
            }else if (orderArray[i].getSize().equalsIgnoreCase("M")) {
                allArray[2].plusAmount(orderArray[i].getAmount());
                allArray[2].plusQty(orderArray[i].getQty());
            
            }else if (orderArray[i].getSize().equalsIgnoreCase("L")) {
                allArray[3].plusAmount(orderArray[i].getAmount());
                allArray[3].plusQty(orderArray[i].getQty());
            
            }else if (orderArray[i].getSize().equalsIgnoreCase("XL")) {
                allArray[4].plusAmount(orderArray[i].getAmount());
                allArray[4].plusQty(orderArray[i].getQty());
            
            }else if (orderArray[i].getSize().equalsIgnoreCase("XXL")) {
                allArray[5].plusAmount(orderArray[i].getAmount());
                allArray[5].plusQty(orderArray[i].getQty());
            
            }

        }


        return sortQAS(allArray, Lc);



    }




    public Order [] sort(){


        Order [] ar=new Order[orderArray.length];


        for (int i = 0; i < ar.length; i++) {
            ar[i]=orderArray[i];
        }



        for(int i=ar.length-1; i>=0; i--){
			for(int j=0; j<i; j++){
				if(ar[j].getAmount()<ar[j+1].getAmount()){
					Order t=ar[j];
					ar[j]=ar[j+1];
					ar[j+1]=t;
				}
				
			}
		}
        return ar;


    }

public Order[] allOrder(){
    Order[]temp=orderArray;
    return temp;

}    




}
