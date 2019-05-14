
public class SortCartList extends CarList {
      private CarNode walker;
    
    public SortCartList()
    {
      super();
    
    }
    
      @Override
    public void append(Car c)
    {
     
       if(getSize()==0){
         CarNode newNode =new CarNode(c);
         head=newNode;
         first=newNode;
         last=newNode;
         size++;
         
       } 
       else  //not size==0
           
       { //sort based on Milleage
           CarNode newNode =new CarNode(c);
           walker=head;
           if(newNode.data.getMileage()>=walker.data.getMileage())
           {
          
             while(walker.next!=null&&(newNode.data.getMileage()>walker.next.data.getMileage()))
             {
             
              walker=walker.next; //traverse for the appropriate position
                 
             } //while loop
             
             newNode.next=walker.next;
             walker.next=newNode;
             size++;
           }
            
          else{
             newNode.next=head;  //put infront of the head if less than it
             head=newNode;
             first=newNode;
             size++;
             }
                    
         
       }
    
    }
    
    
    public void sortPrint()
    {
        walker=head;
        while(walker!=null)
        {
          System.out.println(walker.data);
          walker=walker.next;
        }
        
    }
    
      @Override
     public String toString(){
      String result="";
      walker=head;
        while(walker!=null)
        {
          result+=walker.data.toString()+"\n";
          walker=walker.next;
        }
        return result;
    }
    
}
