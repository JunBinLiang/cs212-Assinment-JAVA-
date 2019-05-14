/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author leyal
 */
public class myFrame extends JFrame{
    private JPanel gameBoard;
    private JPanel buttomBoard;
    private JButton num1;  private JButton num2; private JButton num3; private JButton num4;
    private JButton num5; private JButton num6; private JButton num7; private JButton num8; private JButton num9;private JButton result;
    private JButton checker;
    private JMenuBar menubar;
    private JMenu file;
    private JMenu help;
    
    private int     gameArray[]=new int[81];
    private boolean gameBoolArray[]=new boolean[81];
    private boolean resultState=true;
     
    private JButton gameButton[]=
    {
     new JButton(),new JButton(),new JButton(),new JButton(),
     new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),
     new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),
     new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),
     new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),
     new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),
     new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),
     new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),
     new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),
     new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton(),new JButton()}; 
    
    public myFrame()
    {
        
       for(int i=0;i<gameArray.length;i++)
       {  
             gameArray[i]=-1;
       }   
        
      for(int i=0;i<gameBoolArray.length;i++)
       {  
                gameBoolArray[i]=false;
       }  
       
      gameBoard=new JPanel();
      buttomBoard=new JPanel();
      buttomBoard.setPreferredSize(new Dimension(100,50)); //1st param:width   2nd param: height
      //set the layout
      buttomBoard.setLayout(new GridLayout(1,10));
      gameBoard.setLayout(new GridLayout(9,9));
      
      menubar=new JMenuBar();
      file=new JMenu("File"); help=new JMenu("Help"); menubar.add(file);menubar.add(help);
      
      add(gameBoard,BorderLayout.CENTER);
      add(buttomBoard,BorderLayout.SOUTH);
      this.setJMenuBar(menubar);
      
      
      //Buttom board
      num1=new JButton("1");  num1.setBackground(Color.PINK);
      num2=new JButton("2");  num2.setBackground(Color.PINK);
      num3=new JButton("3");  num3.setBackground(Color.PINK);
      num4=new JButton("4");  num4.setBackground(Color.PINK);
      num5=new JButton("5");  num5.setBackground(Color.PINK);
      num6=new JButton("6");  num6.setBackground(Color.PINK);
      num7=new JButton("7");  num7.setBackground(Color.PINK);
      num8=new JButton("8");  num8.setBackground(Color.PINK);
      num9=new JButton("9");  num9.setBackground(Color.PINK);
      checker=new JButton("Check"); checker.setBackground(Color.cyan); checker.setSize(200,100);
      result=new JButton("T");
      addButton(num1,buttomBoard,new bottomNumListener(1));addButton(num2,buttomBoard,new bottomNumListener(2));
      addButton(num3,buttomBoard,new bottomNumListener(3));
      addButton(num4,buttomBoard,new bottomNumListener(4));
      addButton(num5,buttomBoard,new bottomNumListener(5));addButton(num6,buttomBoard,new bottomNumListener(6));
      addButton(num7,buttomBoard,new bottomNumListener(7));addButton(num8,buttomBoard,new bottomNumListener(8));
      addButton(num9,buttomBoard,new bottomNumListener(9));
      result.setBackground(Color.magenta);
      buttomBoard.add(result);
      addButton(checker,buttomBoard,new checkListener()); //checker
      
      //add to gameBoard
      for(int i=0;i<gameButton.length;i++)
      {
        addGameButton(gameButton[i],gameBoard,new gameButtonListener(i));
        
        if(i==3||i==4||i==5||i==12||i==13||i==14||i==21||i==22||i==23||i==27||i==28||i==29||i==33||i==34||i==35||
                i==36||i==37||i==38||i==42||i==43||i==44||i==45||i==46||i==47||i==51||i==52||i==53||i==57||i==58||i==59||
                i==66||i==67||i==68||i==75||i==76||i==77)
        {
        gameButton[i].setBackground(Color.yellow);
        }
        
        else
        {
        gameButton[i].setBackground(Color.white);
        }
      }
      
  
     
     
    }//constructor
    
    
    private void addButton(JButton button, JPanel panel, ActionListener listener)
    {   
        // System.out.println(((bottomNumListener)listener).gameVal);      cast back
        button.setBorder(new LineBorder(Color.BLACK));
        button.addActionListener(listener);
        panel.add(button);
    
    }
    
        private void addGameButton(JButton button, JPanel panel,ActionListener listener)
    {   
        button.addActionListener(listener);
        button.setBorder(new LineBorder(Color.BLACK));
        panel.add(button);
    
    }
    
    public void test()
    {
      System.out.print(gameButton.length);
    }
    
    
    
    
    
    private class bottomNumListener implements ActionListener
    {  //inner class, can access the variable from   myFrame

        private int gameVal;
          
        public bottomNumListener(int gameVal)
        { 
          //constructor
          this.gameVal=gameVal;  //   1 2 3 4 5 6 7 8 9
        }
        
        
        public void actionPerformed(ActionEvent ae) 
       {
           
           for(int i=0;i<gameBoolArray.length;i++)
            {
                
                if(gameBoolArray[i]==true)
                {
                  gameButton[i].setText(Integer.toString(gameVal));
                  gameArray[i]=gameVal;
                  
                }
            }
            
       }
        
        public void test()
        {
    
        }
        
    
    }
    
    
    private class gameButtonListener implements ActionListener
    {

        private int whichIndex;    
        
        
        public gameButtonListener(int whichIndex)
        {
            this.whichIndex=whichIndex;   //  1  2  3  .....79  80 
        }
        
        
   
        public void actionPerformed(ActionEvent ae) 
        {
            for(int i=0;i<gameBoolArray.length;i++)
            {
                //reset all to false
                gameBoolArray[i]=false;
            }
            gameBoolArray[whichIndex]=true;
            
           // make it focus
          //gameButton[whichIndex].setBackground(Color.gray);
          
          for(int i=0;i<gameBoolArray.length;i++)
            {
                
                if(gameBoolArray[i]==true)
                {
                  gameButton[whichIndex].setBackground(Color.gray);
                }
                else
                {
                    if(i==3||i==4||i==5||i==12||i==13||i==14||i==21||i==22||i==23||i==27||i==28||i==29||i==33||i==34||i==35||
                       i==36||i==37||i==38||i==42||i==43||i==44||i==45||i==46||i==47||i==51||i==52||i==53||i==57||i==58||i==59||
                       i==66||i==67||i==68||i==75||i==76||i==77)
                   {
                       gameButton[i].setBackground(Color.yellow);
                   }
        
                   else
                   {
                      gameButton[i].setBackground(Color.white);
                   }
                }
                
            }
              
        }
    
    
    }
    
    private class checkListener implements ActionListener
    { 
        private Map<Integer,Integer> subArray;
        private int counter;
        private int whichLine=0;
        private boolean loopCheck=true;
        private boolean horizontalResult=true;
        private boolean verticalResult=true;
        private boolean diagonalResult1=true;
        private boolean diagonalResult2=true;
        private boolean individualResult1=true;
        private boolean individualResult2=true;
        private boolean individualResult3=true;
        private boolean individualResult4=true;
        private boolean individualResult5=true;
        private boolean individualResult6=true;
        private boolean individualResult7=true;
        private boolean individualResult8=true;
        private boolean individualResult9=true;
        public checkListener()
        {
           counter=9;
           
           for(int i=0;i<gameBoolArray.length;i++)
            {
                //reset all to false
                gameBoolArray[i]=false;
                
            } // 1st for
           subArray=new HashMap();
        }
       
        public void actionPerformed(ActionEvent ae) 
        {
            
            for(int i=0;i<gameBoolArray.length;i++)
            {
                if(i==3||i==4||i==5||i==12||i==13||i==14||i==21||i==22||i==23||i==27||i==28||i==29||i==33||i==34||i==35||
                   i==36||i==37||i==38||i==42||i==43||i==44||i==45||i==46||i==47||i==51||i==52||i==53||i==57||i==58||i==59||
                   i==66||i==67||i==68||i==75||i==76||i==77)
               {
                   gameButton[i].setBackground(Color.yellow);
               }
        
               else
              {
                   gameButton[i].setBackground(Color.white);
              }
                
            }// 2nd for
            
            
            
            
            counter=9;
            loopCheck=true; //before enter the loop
            whichLine=0; //before enter
            horizontalResult=true;
            subArray.clear();
            
            for(int i=0;i<gameArray.length;i++)
           {  
               
               if(!loopCheck)  //false detect, exit loop
               {
                   
                   break;
               }
               
               
               if(subArray.containsValue(gameArray[i])&&gameArray[i]!=-1)
               {
                 System.out.println("Happen");
                 horizontalResult=false;
                 loopCheck=false;
                   
               }else
               {
                System.out.println("Nothing Happen");
                subArray.put(i,gameArray[i]);
                counter--;
                
               }
               
               
               if(counter==0)
               {
                counter=9;
                subArray.clear();
               }
               
           }
            
            
              loopCheck=true; 
              subArray.clear();
              verticalResult=true;
              
    for(int i=0;i<9;i++)
   {
       
        if(!loopCheck){break;}
              
           for(int j=0;j<9;j++)
        {
                
                 if(subArray.containsValue(gameArray[i+j*9])&&gameArray[i+j*9]!=-1)
               {
                   System.out.println("Vertical Happen");
                  verticalResult=false;
                  loopCheck=false;
                  subArray.clear();
                  break;
                   
               }else
               {
                 System.out.println("No Vertical Happen");
                 subArray.put((i+j*9),gameArray[i+j*9]);
               }
                 
                 if(j==8){ subArray.clear();}
        }
           
  } //loop
            
            
            subArray.clear();
            diagonalResult1=true;
            for(int i=0;i<81;i+=10)
            {
               if(subArray.containsValue(gameArray[i])&&gameArray[i]!=-1)
               {
                 diagonalResult1=false;
                 subArray.clear();
                 break;
               }else
               {
                 subArray.put(i,gameArray[i]);
               }
               if(i==80){subArray.clear();}
            }
             
             subArray.clear();
             diagonalResult2=true;
             
           for(int i=8;i<81;i+=8)
            {
               if(subArray.containsValue(gameArray[i])&&gameArray[i]!=-1)
               {
                 diagonalResult2=false;
                 subArray.clear();
                 break;
               }else
               {
                 subArray.put(i,gameArray[i]);
               }
               if(i==80){subArray.clear();}
            }
            
           individualResult1=true;
           subArray.clear();
           individualResult1=individualCheck(0,1,2,9,10,11,18,19,20);
           
           individualResult2=true;
           subArray.clear();
           individualResult2=individualCheck(3,4,5,12,13,14,21,22,23);
           
           individualResult3=true;
           subArray.clear();
           individualResult3=individualCheck(6,7,8,15,16,17,24,25,26);
           
           individualResult4=true;
           subArray.clear();
           individualResult4=individualCheck(27,28,29,36,37,38,45,46,47);
           
           individualResult5=true;
           subArray.clear();
           individualResult5=individualCheck(30,31,32,39,40,41,48,49,50);
           
           individualResult6=true;
           subArray.clear();
           individualResult6=individualCheck(33,34,35,42,43,44,51,52,53);
           
           individualResult7=true;
           subArray.clear();
           individualResult7=individualCheck(54,55,56,63,64,65,72,73,74);
           
           individualResult8=true;
           subArray.clear();
           individualResult8=individualCheck(57,58,59,66,67,68,75,76,77);
           
            individualResult9=true;
           subArray.clear();
           individualResult9=individualCheck(60,61,62,69,70,71,78,79,80);
           
           
           
           
           //test every possible result
            if(horizontalResult&&verticalResult&&diagonalResult1&&diagonalResult2&&individualResult1&&
                    individualResult2&&individualResult3&&individualResult4&&
                    individualResult5&&individualResult6&&individualResult7&&individualResult8&&individualResult9){result.setText("T");}
            else{result.setText("F");}
            
            
        }
    
        
     public boolean individualCheck(int... arr)
     {
       boolean toReturn=true;
       for(int i=0;i<arr.length;i++)
       {
         if(subArray.containsValue(gameArray[arr[i]])&&gameArray[arr[i]]!=-1)
         {
           toReturn=false;
           subArray.clear();
           break;
         }else
         {
          subArray.put(arr[i],gameArray[arr[i]]);
         }
         if(i==arr.length-1){subArray.clear();}
       }
     
       return toReturn;
     }   
        
        
  }//check listener
    
    
}//myFrame class
