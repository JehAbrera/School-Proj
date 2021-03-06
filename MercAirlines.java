import java.awt.Dimension;
import java.awt.HeadlessException;
import java.util.Random;
import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import java.awt.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import java.awt.event.*;
import javax.swing.ButtonGroup;

class TripInf {
   public String traveltype;
   public String Destination;
   public double fare;
   public double F_insurance;
   public double tax;
   public double bagfee;
   public double addfee;
   public double Max;
   public double roundtrip;
   public String waytrip;
   public double discount;
   public double TravTax;
   public String name[];
   public int age[];
   public String ins[];
   public double fins[];
   public double travel_tax[];
   public double tprice[];
   public double disc[];
   public ButtonGroup group;
   public String cap;
   public int nop;
   public double fprice;
   public double amount=0;
   public double change=0;
   public String temp_Name;
   public String passengers="";

   private String planetype;
   private String location;
   private String rand;

   final ImageIcon i=new ImageIcon("plane.png");
   //--Getters | Setters--//
   public void setPlaneType(String p){
      planetype=p;
   }
   public String getPlaneType(){
      return planetype;
   }
   public void setLocation(String  l){
      location=l;
   }
   public String getLocation(){
      return location;
   }
   public void setRand(String r){
       rand=r;
   }
   public String getRand(){
      return rand;
   }
   //--Getter | Setter End--//

   //--Intro Popup--//
   public void Start() {
      JFrame start= new JFrame("HOME");
      start.setVisible(true);
      start.setResizable(false);
      start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      start.setBounds(500, 225, 300, 300);
      JLabel caption = new JLabel (" Welcome to Merc Airlines!");
      caption.setBounds(65,20,175,30); 
      start.getContentPane().add(caption);
      start.getContentPane().setLayout(null);
      JButton fb,bb,xb;
      fb=new JButton("Flight Table");
      fb.setBounds(83,70,120,30);
      fb.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e)
            {
                start.dispose();
                Flight_Table();
            }});
      bb = new JButton("Book A Flight");
      bb.setBounds(83,120,120,30);
      bb.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e)
            {
                start.dispose();
                PType();
            }}); 
      xb = new JButton("Exit");
      xb.setBounds(83,170,120,30);
      xb.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e)
            {
                start.dispose();
                JOptionPane.showMessageDialog(null,"THANK YOU FOR CHOOSING MERC AIRLINES!","CLOSE",JOptionPane.INFORMATION_MESSAGE,i);
            }}); 
      start.getContentPane().add(fb);
      start.getContentPane().add(bb);
      start.getContentPane().add(xb);
   }
   // Flight Table //
   public void Flight_Table() {
         JFrame frame=new JFrame("FLIGHT TABLE");
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setVisible(true);
         frame.setResizable(false);
         frame.setBounds(100 , 75 , 1100, 575);
         JPanel contentPane = new JPanel();
         frame.setContentPane(contentPane);
         contentPane.setLayout(null);
         
         JButton b1 = new JButton("<< Back");
         b1.setBounds(50, 475 , 80, 30);
         frame.getContentPane().add(b1);
         b1.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e)
            {
                frame.dispose();
                Start();
            }});
         
         JButton b2 = new JButton("Book a Flight >>");
         b2.setBounds(925, 475 , 125, 30);
         frame.getContentPane().add(b2);
         b2.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e)
            {
               frame.dispose();
               PType();
            }});
         JScrollPane scrollPane = new JScrollPane();
         scrollPane.setBounds(50 , 10 , 1000, 423);
         contentPane.add(scrollPane);
         String[][] data = {
            {"  A","  Manila-Batanes","  Local Type","  Php 8,000.00","  Php 12,500.00","  Php 3,500.00"},
         	{"  B","  Batanes-Manila","  Local Type","  Php 9,800.00","  Php 9,800.00","  Php 3,900.00"},
            {"  C","  Manila-Palawan","  Local Type","  Php 9,100.00","  Php 10,500.00","  Php 3,200.00"},
            {"  D","  Palawan-Manila","  Local Type","  Php 9,850.00","  Php 10,975.00","  Php 3,575.00"},
            {"  E","  Manila-South Korea","  International Type","  Php 27,450.00","  Php 37,390.00","  Php 12,055.00"},
            {"  F","  South Korea-Manila","  International Type","  Php 30,890.00","  Php 39,650.00","  Php 13,100.00"},
            {"  G","  Manila-Japan","  International Type","  Php 40,450.00","  Php 45,355.00","  Php 27,800.00"},
            {"  H","  Japan-Manila","  International Type","  Php 43,855.00","  Php 49,780.00","  Php 29,400.00"},
            {"  I","  Manila-Vietnam","  International Type","  Php 8,505.00","  Php 12,345.00","  Php 3,200.00"},
            {"  J","  Vietnam-Manila","  International Type","  Php 14,300.00","  Php 16,320.00","  Php 4,600.00"},
            };
         String[] column= {"OPTION","FROM-TO","TRAVEL TYPE","PRIVATE CLASS FARE","BUSINESS CLASS FARE", "REGULAR CLASS FARE"};

         JTable table = new JTable(data,column);
         table.setRowHeight(40);
         scrollPane.setViewportView(table);
   }
   
   // Plane Type //
   public void PType() {
         TripInf tp =new TripInf();
         JFrame frame2=new JFrame("SELECT");
         frame2.setVisible(true);
         frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame2.setResizable(false);
         frame2.setBounds(550 , 250 , 300, 300);
         JPanel pan= new JPanel();
         pan.setBounds(0,0, 280, 280);
         frame2.getContentPane().add(pan);
         pan.setLayout(null);
         
         JLabel plabe=new JLabel("Select your Plane Class");
         pan.add(plabe);
         plabe.setBounds(75, 10, 150, 20);
         
         JRadioButton priv = new JRadioButton("[Private Class]");
         priv.setActionCommand("Private Class");
         pan.add(priv);
         priv.setBounds(85, 30, 150, 20);
    
         JRadioButton busi = new JRadioButton("[Business Class]");
         busi.setActionCommand("Business Class");
         pan.add(busi);
         busi.setBounds(80, 60, 150, 20);
    
         JRadioButton reg = new JRadioButton("[Regular Class]");
         reg.setActionCommand("Regular Class");
         pan.add(reg);
         reg.setBounds(85, 90, 150, 20);
       
         reg.setSelected(true);
         
         JButton btn = new JButton("Ok");
         btn.setBounds(95, 140, 100 ,40);
         btn.addActionListener(new ActionListener() {  
               public void actionPerformed(ActionEvent e)
               {
                  frame2.dispose();
                  tp.setPlaneType(group.getSelection().getActionCommand());
                  String p =tp.getPlaneType(); 
                  if (p == "Private Class") {
                	F_insurance = 4500;
             		TravTax= 4260;
             		bagfee = 1250;
             		addfee = 550;
             		cap = "[PRIVATE]";
             		Max = 14;
                  }
                  else if (p == "Business Class") {
                	F_insurance = 6500;
             		TravTax = 5700;
             		bagfee = 2850;
             		addfee  = 550;
             		cap = "[BUSINESS]";
             		Max = 23;
                  }
                  else if (p == "Regular Class") {
                	F_insurance = 950;
             		TravTax = 2500;
             		bagfee = 950;
                	addfee = 255;
                	cap = "[REGULAR FARE]";
                	Max = 48;
                  } 
                  Location();    
               }});
         pan.add(btn);
         JButton cancel= new JButton("Cancel");
         cancel.setBounds(95, 190, 100 ,40);
         cancel.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e)
            {
                frame2.dispose();
                Start();
            }});
         pan.add(cancel);
         group = new ButtonGroup();
         group.add(reg);
         group.add(busi);
         group.add(priv);
      }
   // SELECT DESTINATION //   
   public void Location() {
      TripInf tp=new TripInf();
      String p=tp.getPlaneType();
      JFrame frame3= new JFrame("DESTINATION SELECT");
      frame3.setVisible(true);
      frame3.setResizable(false);
      frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame3.setBounds(450, 280, 450, 150);
      JPanel pane= new JPanel();
      pane.setBounds( 10 , 10 , 430 , 130 );
      frame3.getContentPane().add(pane);
      frame3.setLayout(null);
      
      JLabel loclab= new JLabel ("PLEASE CHOOSE YOUR DESTINATION");
      pane.add(loclab);
      loclab.setBounds(15, 10, 150, 40);
      
      String[] destination={"Manila-Batanes","Batanes-Manila","Manila-Palawan","Palawan-Manila","Manila-South Korea","South Korea-Manila",
         "Manila-Japan","Japan-Manila","Manila-Vietnam","Vietnam-Manila"};
       JComboBox seldes=new JComboBox(destination);
      pane.add(seldes);
      
      JButton select, cancel2;
      select=new JButton("Select");
      select.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e)
            {
                frame3.dispose();
                tp.setLocation((String)seldes.getSelectedItem());
                String l=tp.getLocation();
                if (l == "Manila-Batanes"){
                  traveltype= "LOCAL FLIGHT";
                  Destination = "MANILA TO BATANES" ;
                  if  (p == "Private Class"){
                     fare=8000;
                  }
                 else  if (p == "Business Class"){
                     fare=12500;
                  }
                  else if(p == "Regular Class"){
                     fare=3500;
                  }
               }
               else if(l== "Batanes-Manila"){
                  if  (p == "Private Class"){
                     fare=9800;
                  }
                 else  if (p == "Business Class"){
                     fare=12950;
                  }
                  else if(p == "Regular Class"){
                     fare=3900;
                  }
                }
                else if(l== "Manila-Palawan"){
                  if  (p == "Private Class"){
                     fare=8000;
                  }
                 else  if (p == "Business Class"){
                     fare=12500;
                  }
                  else if(p == "Regular Class"){
                     fare=3500;
                  }
               }
               else if(l == "Palawan-Manila"){
                  if  (p == "Private Class"){
                     fare=8000;
                  }
                 else  if (p == "Business Class"){
                     fare=12500;
                  }
                  else if(p == "Regular Class"){
                     fare=3500;
                  }
               }
               else if(l == "Manila-South Korea"){
                  if  (p == "Private Class"){
                     fare=8000;
                  }
                 else  if (p == "Business Class"){
                     fare=12500;
                  }
                  else if(p == "Regular Class"){
                     fare=3500;
                  }
               }
               else if(l == "South Korea-Manila"){
                  if  (p == "Private Class"){
                     fare=8000;
                  }
                 else  if (p == "Business Class"){
                     fare=12500;
                  }
                  else if(p == "Regular Class"){
                     fare=3500;
                  }
               }
               else if(l == "Manila-Japan"){
                  if  (p == "Private Class"){
                     fare=8000;
                  }
                 else  if (p == "Business Class"){
                     fare=12500;
                  }
                  else if(p == "Regular Class"){
                     fare=3500;
                  }
               }
               else if(l == "Japan-Manila"){
                  if  (p == "Private Class"){
                     fare=8000;
                  }
                 else  if (p == "Business Class"){
                     fare=12500;
                  }
                  else if(p == "Regular Class"){
                     fare=3500;
                  }
               }
               NoOfPass();
            }});
      cancel2=new JButton("Cancel");
      cancel2.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e)
            {
                frame3.dispose();
                PType();
            }});
      pane.add(select);
      pane.add(cancel2);
      }
   // GETS NUMBER OF PASSENGERS //
   public void NoOfPass(){
      try{
         JFrame frame4= new JFrame("Passengers");
         frame4.setVisible(true);
         frame4.setResizable(false);
         JPanel pane2=new JPanel();
         frame4.getContentPane().add(pane2);
         pane2.setLayout(null);
         frame4.setBounds(500, 325, 380, 200);
         pane2.setBounds(10,10, 350, 200);
         frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
         JLabel pass= new JLabel("Enter Number of Passengers:");
         pane2.add(pass);
         pass.setBounds(25, 20, 190, 30);
         JTextField count= new JTextField();
         pane2.add(count);
         count.setBounds(215, 20, 115, 30); 
         JButton submit, cancel3;
         submit= new JButton("Submit");
         submit.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e)
            {
                try{
                  String nopp= count.getText();
                  nop=Integer.parseInt(nopp);
                  if(nop<=0){
                     frame4.dispose();
                     JOptionPane.showMessageDialog(null,"INVALID INPUT","ERROR!!",JOptionPane.ERROR_MESSAGE);
                     NoOfPass();
                  }
                  else if(nop>Max){
                     frame4.dispose();
                     JOptionPane.showMessageDialog(null,"Sorry! You have exceeded the number of passengers required","ERROR!!",JOptionPane.ERROR_MESSAGE);
                     NoOfPass();
                  }
                  else {
                     frame4.dispose();
                     PassInfo();
                     Test_Display();
                  }
                }
                catch(HeadlessException | NumberFormatException f) {
                  JOptionPane.showMessageDialog(null,"INVALID INPUT","ERROR!",JOptionPane.ERROR_MESSAGE);
                   NoOfPass();
                }
            }});
         cancel3=new JButton("Cancel");
         cancel3.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e)
            {
                frame4.dispose();
                Location();
            }});
         pane2.add(submit);
         pane2.add(cancel3);
         submit.setBounds(229, 70, 100, 40);
         cancel3.setBounds(25, 70, 100, 40);
      }
      catch (Exception  e) {
         Start();
      }
   }
   // PASSENGER INFO //
   public void PassInfo() {
      TripInf tp=new TripInf();
      String rand;
     String name[]= new String[nop];
     int age[]= new int[nop];
     String ins[]= new String[nop];
     double fins[]=new double[nop];
     double travel_tax[]=new double[nop];
     double tprice[]=new double[nop];
     double discount[]=new double[nop];
     
     for (int x=0; x<nop; x++)
     {
            //----------------------PASSENGER'S NAME----------------------------
       while (true){
          try{
            int checker=0;
            temp_Name =  JOptionPane.showInputDialog(null, "Enter Passenger's Full Name" + " [" + (x+1) + "]");
            for (int z=0; z<x; z++)
            {
               if (temp_Name.equalsIgnoreCase(name[z]))
               {
                  JOptionPane.showMessageDialog(null,"Invalid name","Error!!",JOptionPane.ERROR_MESSAGE);
                  checker = 1;
                  break;
               }
            }
               if (checker == 1)
               {
                   continue;
               }
               else{
                  name[x] = temp_Name;
               }
               if ( name[x].length() < 8)
               {
                 JOptionPane.showMessageDialog(null,"Invalid name input atleast 8 characters","Error!!",JOptionPane.ERROR_MESSAGE);
               }
               if (name[x].length() >= 8)
               {
                   break;
                }
          }
          catch (Exception e)
          {
             JOptionPane.showMessageDialog(null,"Invalid Input","Error!!",JOptionPane.ERROR_MESSAGE);
           }
       }
 //----------------------PASSENGER'S AGE-----------------------------
       while(true)
       {
          try {
            String P_Age =  JOptionPane.showInputDialog(null, "Enter Passenger's Age");
            age[x] = Integer.parseInt(P_Age);
               if (P_Age.equals(""))
               {
                  JOptionPane.showMessageDialog(null,"Invalid Age","Error!!",JOptionPane.ERROR_MESSAGE);
                }
               if (age[x] > 0 && age[x] <= 100)
               {
                   break;
                }
                else if (age[x] > 100 )
                {
                     JOptionPane.showMessageDialog(null,"Invalid Age","Error!!",JOptionPane.ERROR_MESSAGE);
                 }
             }
            catch (NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null,"Invalid age","Error!!",JOptionPane.ERROR_MESSAGE);
             }  
         } 
//------------------PASSENGER'S INSURANCE-----------------------
         while(true)
         {       
             ins[x] =  JOptionPane.showInputDialog(null, "Want to Avail Insurance?[Y/N]");           
             if ("Y".equals(ins[x]) || "y".equals(ins[x]))
             {
                  fins[x] = F_insurance;
                  break;
              }
             else if ("N".equals(ins[x]) || "n".equals(ins[x])) {
                  fins[x] = F_insurance * 0;
                        break;
              }
              else if (ins[x].length() != 1)
              {
                  JOptionPane.showMessageDialog(null,"INVALID INPUT!","Error!!",JOptionPane.ERROR_MESSAGE);
               }
               else {
                   JOptionPane.showMessageDialog(null,"INVALID INPUT!","Error!!",JOptionPane.ERROR_MESSAGE);
                }
            }                                    
           if ( age[x] >= 60 )
           {
                  travel_tax[x] = TravTax * 0;
                  tprice[x] = (fins[x] + travel_tax[x] + bagfee + addfee + fare) * .80;
                  disc[x] = (fins[x] + travel_tax[x] + bagfee+ addfee + fare) * .20 ;
           }
          else 
          {
                 travel_tax[x] = TravTax;
                  tprice[x] = (fins[x] + travel_tax[x] + bagfee + addfee + fare);
                  //disc[x] = 0;
           }
     }
                 for (int y=0; y<name.length; y++)
            {
                fprice = fprice + tprice[y];
            }
                 
 //----------------------Age Restriction-----------------------------
      int child = 0;
      for (int a=0; a< nop; a++ )
      {
           if (age[a] < 18)
            {
                child+=1;
            }
        }
        if (child == nop)
        {
        JOptionPane.showMessageDialog(null,"Can't Travel and must be accompanied by at lease one (1) Adult and/or Senior Citizen ","Error!!",JOptionPane.ERROR_MESSAGE);
        Start();
         }
         new Transaction().Transaction();
         for (int y=0; y<name.length; y++)
         {
            
         Random ran = new Random();
			String code = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
			String random="";
			for(int c =0 ; c< 6; c++)
            {
				random = random + code.charAt(ran.nextInt(code.length()));
            tp.setRand("MA"+random);
				rand=tp.getRand();
		   	}
         // COMPUTATIONS
         rand=tp.getRand();
         passengers = passengers + "\nFlight Details" + "\nPASSENGER " +(y+1);
         passengers = String.format(passengers + "%-30s %s%n", "\nTransaction Code: ", rand);
         passengers = passengers + "\nGuest Details" + "\nName: " +name[y];
         passengers = passengers + "\nAge: "  + age[y];
         passengers = String.format(passengers + "\n\nPayment Details" + "%-36s PHP%,.2f%n", "\nFare: ", fare);
         passengers = String.format(passengers + "%-32s PHP%,.2f%n","Insurance: ", fins[y]);                          
         passengers = String.format(passengers + "%-34s PHP%,.2f%n", "Travel Tax: ", travel_tax[y]);
         passengers = String.format(passengers + "%-28s PHP%,.2f%n", "Baggage Fee: ", bagfee);
         passengers = String.format(passengers + "%-28s PHP%,.2f%n", "Additional Charges: ", addfee);
         passengers = String.format(passengers + "%-32s PHP%,.2f%n","Discount: ", disc[y]);                       
         
          tprice[y] = tprice[y];
         
         passengers = passengers +"----------------------------------------------------";
         passengers = String.format(passengers + "%-30s PHP%,.2f%n", "\nTotal Price: ", tprice[y]);
         passengers = passengers +"----------------------------------------------------";
         }
         passengers = String.format(passengers + "%-26s PHP%,.2f%n", "\nFinal Total Price: ", fprice);
         passengers = String.format(passengers + "%-30s PHP%,.2f%n", "Payment: ", amount);
         passengers = String.format(passengers + "%-30s PHP%,.2f%n", "Change: ", change);
    }
   public void Test_Display(){
      System.out.print(nop+"\n"+Destination+"\n"+traveltype+"\n"+F_insurance+"\n"+TravTax+"\n"+bagfee+"\n"+addfee+"\n"+cap+"\n"+Max);
   }

}


//--Prints Receipt--//
class Transaction extends TripInf{
      // DITO NA LANG SIGURO ILAGAY UNG TRANSACTION METHOD, COMPUTATION, SAKA PRINT RECEIPT
      // ----- THIS SPACE-----//
      //
      public void Transaction(){
         String amount1;
         amount1= JOptionPane.showInputDialog(null,"TOTAL AMOUNT TO PAY: " + this.fprice+ "\nInput Amount"); 
         try 
            {
             amount = Double.parseDouble(amount1);
             if (amount1.equals(""))
                {
                  JOptionPane.showMessageDialog(null,"Invalid Input","Error!!",JOptionPane.ERROR_MESSAGE);
                }
             
             if ( amount < fprice)
                {
                  JOptionPane.showMessageDialog(null,"INVALID AMOUNT!","WARNING",JOptionPane.WARNING_MESSAGE);
                }
            }
            catch (NumberFormatException e)
                {
                  JOptionPane.showMessageDialog(null,"INVALID AMOUNT!","Error!!",JOptionPane.ERROR_MESSAGE);
                }
            if (amount >= fprice)
                {
                  change = amount - fprice; 
                }
             System.exit(0);
          }
}


//--Main Running Class--//
public class MercAirlines{
   public static void main (String [] args)
   {
      final ImageIcon i=new ImageIcon("plane.png");
      JOptionPane.showMessageDialog(null,"WELCOME TO MERC AIRLINE TICKET RESERVATION","MERC AIRLINES",JOptionPane.PLAIN_MESSAGE,i);
      Transaction obj = new Transaction();
      obj.Start();
   }
}
