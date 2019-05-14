import javax.swing.JFrame;


public class Project3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //SortCartList unSort=new SortCartList();
        //unSort.append(new Car(1,10,"junbin10","jiejie"));
        //unSort.append(new Car(2,20,"junbin20","jiejie1"));
        //unSort.append(new Car(3,5,"junbin5","jiejie2"));
        //unSort.append(new Car(3,40,"junbin40","jiejie2"));
        
        //unSort.sortPrint();
        
         JFrame frame = new CarGUI();
         frame.setTitle("Car");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setVisible(true);
         frame.setSize(600, 600);
        
        
    }
    
}
