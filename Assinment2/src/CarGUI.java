import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class CarGUI extends JFrame {
   
	private static final long serialVersionUID = 1L;
	private JTextArea unsort;
    private JTextArea sort;
    private String content1="UnSorted Based On Milleage\n\n\n";;
    private String content2="Sorted Based On Milleage\n\n\n";;
    private SortCartList sortList;
    private UnsortedCartList unSortList;
    String current;
    
    public CarGUI()
    {
        sortList=new SortCartList();
        unSortList=new UnsortedCartList();
     this.setLayout(new GridLayout(1,2));
    
     //getting the current directory --> for working on any device or computer
        try {
             current = new java.io.File( "." ).getCanonicalPath();
        } catch (IOException ex) {
            Logger.getLogger(CarGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println(current);
     File file = new File(current+"\\src\\car.txt"); 
     
     
        unsort = new JTextArea(5, 20);
        unsort.setEditable(false);
        JScrollPane scrollPane1 = new JScrollPane(unsort);
        sort = new JTextArea(5, 20);
        sort.setEditable(false);
        JScrollPane scrollPane2 = new JScrollPane(sort);
        add(unsort);
        add(sort);
        
        
        
        
              try {
          Scanner read = new Scanner(file);
          while(read.hasNextLine())
          {
            String sentence=read.nextLine();
            StringTokenizer st=new StringTokenizer(sentence,",");
            String infoArray[]=new String[4];
            int infoCounter=0;
             while (st.hasMoreTokens())
             {
               infoArray[infoCounter]=st.nextToken();
               //System.out.println(infoArray[infoCounter]);
               infoCounter++;
             }
             
             // check if it has 4 token, other wise skip
             if(infoCounter<4)
             {
                for(int i=0;i<infoCounter;i++)
                {
                  System.out.print(infoArray[i]+" ");
                }
                System.out.println();
                continue;
             }
             Car newCar=new Car(Integer.parseInt(infoArray[2]),Integer.parseInt(infoArray[3]),infoArray[0],infoArray[1]);
             sortList.append(newCar);
             unSortList.append(newCar);
          }
      } catch (FileNotFoundException ex)
      {
          Logger.getLogger(CarGUI.class.getName()).log(Level.SEVERE, null, ex);
      }
      
      content1+=unSortList.toString();
      content2+=sortList.toString();
      unsort.setText(content1);
      sort.setText(content2);
    }
}
