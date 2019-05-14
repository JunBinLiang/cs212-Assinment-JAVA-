public class UnsortedCartList extends CarList {
    private CarNode walker;
    
    public UnsortedCartList()
    {
      super();
    
    }
    
    public void unSortPrint(){
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
