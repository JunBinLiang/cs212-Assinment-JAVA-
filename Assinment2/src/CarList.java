public abstract class CarList {
    protected int size;
    protected CarNode head;
    protected CarNode first;
    protected CarNode last;
  
   
    public CarList(){
      size=0;
    }
    
    public void append(Car c)
    {
      if(this.getSize()==0){
          
        head=new CarNode(c);
        first=head;
        last=head;
        size++;
      }
      else{
          // append to the last
        CarNode myNewNode=new CarNode(c);
        last.next=myNewNode;
        last=myNewNode;
        size++;
      }
    }
    
    public int getSize()
    {
      return size;
    } 
}
