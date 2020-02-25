
package my_project;
import java.util.*;
import javax.swing.*;

//////////////////////////////////////////////////////////////////////////////   this class for car
class Car{
int length;
int ID;
int car_plac;
/////////////////////////////////////////////////////////////////////////////    constractor
public Car()
 {
  length=0;
  ID=0;
 }
}

/////////////////////////////////////////////////////////////////////////////// this class for barking
class Barking{
char [][] arr=new char[100][4];
 ArrayList<Integer> space = new ArrayList<>();                                 //this array list save to impty spaces length
 ArrayList<Integer> P = new ArrayList<>();                                     //this array list save to impty spaces first index
  ////////////////////////////////////////////////////////////////////////////   this functin to put initial value in the parking
void intial (){
   for(int i=0;i<100;i++)
   {
    for(int c=0;c<4;c++)
    {
          if(c==0||c==3)
          { arr[i][c]='-';}
          else   
          arr[i][c]=' ';
        
     }
      
  }
}
////////////////////////////////////////////////////////////////////////////////
void find_spaces(int print_or_not)     //to print and get the empty spaces in the parking
 {
     int c=0;
     ArrayList<Integer> spaces = new ArrayList<>();           //this array list save to impty spaces length
     ArrayList<Integer> p_index= new ArrayList<>();          //this array list save to impty spaces first index 
    

    
   for(int i=0 ;i<100 ;i++)
   {
     if(arr[i][0]=='-')  
     {
       c++;
     }
   if((arr[i][0]!='-'&&c!=0 )||(i==99&&c!=0))
     {
       if(i==99)  
       {
          p_index.add(i-(c-1));
         spaces.add(c);
       }
       else
       {
          p_index.add(i-c);                           //p it is the index of the free space
          spaces.add(c);                             //spaces is the length of the space
       } 
       c=0;
     }
   }
     space=spaces;
     P= p_index;
    if(print_or_not!=0)
    {
     JOptionPane.showMessageDialog(null, " you have empty spaces after   "+P+"   meters \n  the empty spaces length is "+space);
    }
 }

///////////////////////////////////////////////////////////////////////////////

int Search_for_parking(int l)     //l=car length             this function to return the index of the empty space for the defult choice
 {
     int c=0;
     int place=0;
   for(int i=0 ;i<100 ;i++)
   {
     if(arr[i][0]=='-')  
     {
       c++;
       if(c==l)
       {
           place=i;
           break;
       }
     }
     else{
     c=0;
     } 

   }
return place;                        //place is the index of the empty space
 }
///////////////////////////////////////////////////////////////////////////
int get_strategy(int choice ,int l)      //to get strategy from the user and search for the barking
{
   int print_or_not=0; 
   find_spaces(print_or_not);
   
   ArrayList <Integer> space_copy = new ArrayList<>();
   
   for(int r=0;r<space.size();r++)
   { 
       space_copy.add(space.get(r));
   } 

   int q=0;
  space_copy.sort(null);
  ///////////////////////////////////////////////////////////////////////  if choice == 1 put the car in the pest space
  if(choice==1)
  {
    
    int min=0;
    int g;
    for( g=0;g<space_copy.size();g++)
    {
     if(space_copy.get(g)>=l)
     {
       min=space_copy.get(g);
       break;
     }
    }
    for(int x=0;x<space.size();x++)
    {
       if(min==space.get(x))
       {
         set_car(P.get(x),l) ;
         return P.get(x);
       }
  
    }
     
  }
  /////////////////////////////////////////////////////////////////////// if choice == 2 put the car in the largest space
 if(choice==2)                        
 {

   int max=space_copy.get((space_copy.size())-1);  
   int i=0;
   for(;i<space_copy.size();i++)
   {
     if(max==space.get(i))
     {
       set_car(P.get(i),l) ;
       return P.get(i);
     }
   
   }
  }
 ////////////////////////////////////////////////////////////////////////  put the car in the first empty space 
   if(choice==3)
   {
     int p_index=(Search_for_parking(l)-(l-1));
     set_car(p_index,l) ;
     return p_index;
   }

 
 return q;
}

/////////////////////////////////////////////////////////////////////////////    to put the car in the barking
void set_car(int p,int l)      
{  
    for(int i=p;i<p+l;i++)
  {
     for(int c=0;c<4;c++)
     {
        arr[i][c]='x';
     }
  
  }
}

//////////////////////////////////////////////////////////////////////////////// to remove the car
void clear(int p,int l)
{  for(int i=p;i<p+l;i++)
   {
     for(int c=0;c<4;c++)
     {
        if(c==0||c==3)
        { arr[i][c]='-';}
        else   
        arr[i][c]=' ';    
     }
    }
      
}

//////////////////////////////////////////////////////////////////////////////   to show the parking status

void show_parking()
{
     System.out.printf("\f");
      System.out.print("<< this is your parking view>> \n");
       System.out.print("/////////////////////////////////////////////////////////////////////////////////////////////////////////////////"
               + "//////////////////////////////////////////////////////////////////////////////////////// \n");
      for(int c=0;c<4;c++)
      //for(int i=0;i<100;i++)
    {
      for(int i=0;i<100;i++)  
      //for(int c=0;c<5;c++)
      {
        System.out.print(arr[i][c]+" ");
      }
      
      System.out.print("\n");
    }  
       System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\"
               + "\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\"
               + "\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\ \n");
}  

}
//*****************************************************************************

public class My_project {

 ////////////////////////////////////////////////////////////////////////////

 static void show_cars( Car [] car)     // to print how many car in the parking and all cars lengths and IDs
{
  int c=0;
   for(int i=0;i<100;i++)
   {
     if(car[i].ID!=0)
     {
       c++;  
     }
   }
  System.out.println("you have (" + c + ")car");
  c=0;
  
   for(int i=0;i<100;i++)
   {
     if(car[i].ID!=0)
     {
       c++; 
        System.out.println("***************************************************************************************");
       System.out.print("car number***["+c+"]*** ID is ***{"+car[i].ID+"}*** and its lenth***{"+car[i].length+"}*** meters \n");
      
     }
   }
   System.out.println("*****************************************************************"
           + "**************************************************************************************\n\n");
 }   
   ////////////////////////////////////////////////////////////////////////// 
    

    public static void main(String[] args) {
             
   int choice1;
   int choice2;
Car []c=new Car[100];                                             //create array of car opject
Barking b=new Barking();                                          // creat an opject of the barking
b.intial();

///////////////////////////////////////////////////////////////////////////////
for(int i=0;i<100;i++)                                           
{
c[i]=new Car();
c[i].ID=0;
c[i].length=0;
}

int i=1;
 int a=0;
 int length=0;
 String s;
//*****************************************************************************
do{
    String x=JOptionPane.showInputDialog( " enter which you want \n"
             + "if you want to add a new car press 1 \n"
             + "if a car want to leave press 2\n"
             + "if you want to show the parking status press 3 \n"
             + "if you want to exit  press 0 \n");

     choice1=Integer.parseInt(x);
 //////////////////////////////////////////////////////////////////////////////

    switch (choice1)
     {

       case 1:
       boolean h=false;
 /////////////////////////////////////////////////////////////////////////////// 
       do{
           h=true;
           s=JOptionPane.showInputDialog("enter car ID ");  
           int ID=Integer.parseInt(s);
           for(int n=0;n<100;n++)
           {
             if(ID==c[n].ID)
             {  
                JOptionPane.showMessageDialog(null, "there is a car with the same ID ");
                 s=JOptionPane.showInputDialog("enter car ID ");  
                 ID=Integer.parseInt(s);
                n=0;
             }
               
           }
           
            for(int count=0;count<100;count++)
            {
             if(c[count].ID==0)
             {
               c[count].ID=ID;
               break;
             }
            }
           
        }while(h==false);
       //////////////////////////////////////////////////////////////////////////////
         do{ 
             
            s=JOptionPane.showInputDialog("enter car length \n car length must be great than ZERO"); 
            length=Integer.parseInt(s);
              
           }while(length==0); 
         
             int place;
             place=b.Search_for_parking(length);
             if(place==0)
             {
               JOptionPane.showMessageDialog(null, "there is no space for this car");
             }
        
             else
             {
                 int count;
               for(count=0;count<100;count++)
              {
               if(c[count].length==0)
               {
                c[count].length=length;
                break;
               }
              }  
        ///////////////////////////////////////////////////////////////////////////////////////////       
            do{   
               s=JOptionPane.showInputDialog("<< choose your strategy >> \n"
                       + "to set the car in the best space enter 1 \n"
                       + "to set the car in the largest space enter 2 \n"
                       + "to set the car in the in the first empty space enter 3 \n");
                choice2=Integer.parseInt(s);
            }while((choice2!=1)&&(choice2!=2)&&(choice2!=3));
         ////////////////////////////////////////////////////////////////////////////////////   
                c[count].car_plac = b. get_strategy(choice2, c[count].length);
                 i++;
                 
             }
              a=i; 
         break;      
    ///////////////////////////////////////////////////////////////////////
       case 2:
            boolean z=true;
            
   if (a!=0)
   {  
        do{
            
           s=JOptionPane.showInputDialog("enter car ID ");
  
           int ID=Integer.parseInt(s);
           for(int t=0 ;t<i;t++)
           {
             if(ID==c[t].ID)
             {
               b.clear(c[t].car_plac, c[t].length);
               z=false;
               c[t].ID=0;
               c[t].length=0;
               --a;
              break;
             }
             if(t==i-1&&z==true)
             {
              JOptionPane.showMessageDialog(null, "this is not ID  try again");
             }

            }
        }while(z==true);
   }
      break;
  ///////////////////////////////////////////////////////////////////////
       case 3:
	b.show_parking();
        int print_or_not=1;
        show_cars(c);
        b.find_spaces(print_or_not);
       
       break;
	
       default:
	
       break;
     }  
        
  }while(choice1!=0 );   
JOptionPane.showMessageDialog(null, "this program developed by\n 1- ^_^ HOSSAM HASAN ^_^\n 2- ^_^ BAHAA EL DIN NASSER ^_^\n <<At the end thank you for your patient>>");
//*****************************************************************************
 }   
}
  