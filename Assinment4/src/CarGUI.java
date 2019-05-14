import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class CarGUI extends JFrame {
	private JMenuBar myMenubar;
	private JMenuItem search;
	private JMenu edit;
	private static final long serialVersionUID = 1L;
	private JTextArea unsort;
    private JTextArea sort;
    private String content1="UnSorted Based On Milleage\n\n\n";;
    private String content2="Sorted Based On Milleage\n\n\n";;
    //private SortCartList sortList;
    //private UnsortedCartList unSortList;
    private JButton menuButton;
    private JButton exitButton;
    private JPanel mypanel;
    private JPanel mypanel2;
    String current;
    private JLabel status; 
    private JLabel dummyText; 
    File files[];
    File target;
    private boolean tester=false;
    private SortCartList sortList;
    private UnsortedCartList unSortList;
    private boolean choosen=false;
    
    
    public CarGUI()
    {
    	myMenubar=new JMenuBar();
    	edit=new JMenu("Edit");
    	search=new JMenuItem("Search");
    	edit.add(search);
    	myMenubar.add(edit);
    	
    	
    	search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(choosen) {
				String carName = JOptionPane.showInputDialog("Enter the Car you want to search. But choose the file first please!!!");
			    findCar(carName);
			    }
				else {
					 unsort.setText("Choose the File First, Thank You!!");
				}
			}
    		
    		
    	});
    	
    	
    	menuButton=new JButton("Choose File");
    	exitButton=new JButton("Exit");
      
    	
        mypanel=new JPanel();
        mypanel2=new JPanel();
        mypanel.setLayout(null);
        mypanel2.setLayout(null);
        mypanel.add(menuButton);
        mypanel2.add(exitButton);
        mypanel.getComponent(0).setBounds(0,100, 200, 70);
        mypanel2.getComponent(0).setBounds(50,100, 200, 70);
        
        
        
        exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("Exit the program");
				System.exit(0);
				
			}
        });
        
        
        menuButton.addActionListener(new FileMenuHandler() {
        	public void actionPerformed(ActionEvent e) {
        		tester=true;
     		   try {
  	             current = new java.io.File( "." ).getCanonicalPath();
  	        } catch (IOException ex) {
  	            Logger.getLogger(CarGUI.class.getName()).log(Level.SEVERE, null, ex);
  	        }
  		  //get into the current folder, carText available
  		
  		  JFileChooser fd = new JFileChooser(current);  
  		  fd.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
  	      fd.showOpenDialog(null);
  		  File f = fd.getSelectedFile();
  		  files= f.listFiles();
  		  //System.out.println(files[0]);
  		     for(int i=0;i<files.length;i++)
  		    {
  		    	
  				  dealingFile(files[i]);       
  				 if(files[i].getName().equals("car.txt")) {break;}
  		    }
  		
  		
          }
        });
        
     this.setLayout(new GridLayout(2,2));
    
     
     
     //getting the current directory --> for working on any device or computer
        try {
             current = new java.io.File( "." ).getCanonicalPath();
        } catch (IOException ex) {
            Logger.getLogger(CarGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println(current);
     //File file = new File(current+"\\src\\car.txt"); 
     
     
        unsort = new JTextArea(5, 20);
        unsort.setEditable(false);
        JScrollPane scrollPane1 = new JScrollPane(unsort);
        sort = new JTextArea(5, 20);
        sort.setEditable(false);
        JScrollPane scrollPane2 = new JScrollPane(sort);
        add(unsort);
        add(sort);
        add(mypanel);
        add(mypanel2);
        unsort.setText("Choose Src or Bin Directory that returns the car file \n\n Then use the menu to search your car ");
       
        this.setJMenuBar(myMenubar);

    }
    
    public void dealingFile(File file) {
    	//System.out.println(file.getName());
    	if(!(file.getName().equals("car.txt"))) {
    		unsort.setText("Wrong File \n\n Please Do it again by following the instruction");
    		sort.setText("Choose Src or Bin Directory that returns the car file");
    		return;
    	}
    	
       // System.out.println("Success");	
    	sortList=new SortCartList();
        unSortList=new UnsortedCartList() ;
    	
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
            	   //System.out.println(infoCounter);
            	   String smallArray[]=new String[4];
                  for(int i=0;i<infoCounter;i++)
                  {
                	  smallArray[i]=infoArray[i];
                	  
                  }
                  for(int i=infoCounter;i<4;i++) {
                	  //System.out.println(i);
                	  smallArray[i]="0";
                  }
                  Car newCar=new Car(smallArray[2],smallArray[3],smallArray[0],smallArray[1]);
                  sortList.append(newCar);
                  unSortList.append(newCar);
                  continue;
               }
                Car newCar=new Car(infoArray[2],infoArray[3],infoArray[0],infoArray[1]);
                sortList.append(newCar);
                unSortList.append(newCar);
            }
        } catch (FileNotFoundException ex)
        {
            Logger.getLogger(CarGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //content1+=unSortList.toString();
        //content2+=sortList.toString();
        //unsort.setText(content1);
        //sort.setText(content2);
    	
    	unsort.setText("Good! Right File!! \n\n Please use the Menu to enter the car\n\n Examples are : Forester, Camry, Maxima, \n Accord(Only 2 Text, also possibble) and so on.\n The second Column of the car.txt file");
    	sort.setText("");
    	choosen=true;
       
        //reset the string back for preventing repetition
        //content1="UnSorted Based On Milleage\n\n\n";;
        //content2="Sorted Based On Milleage\n\n\n";;
     }
   
     public void findCar(String car) 
     {
    	 boolean result=sortList.findCar(car,unsort);
    	 if(!result) {
    		 unsort.setText("Not Found!! \n\n Try Again?");
    		 return;
    	 }
    	 
    	 
     }
    
}
