//Importing multiple packages for the GUI
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.text.*;

public class JazibAhmed_FinalGUI extends JFrame implements ActionListener //Extending JFrame and Action Listener for the program to work
{
    //Making new labels, buttons, fonts, imageicons, text areas, containers,frames, doubles and assigning them to variables
    public static JLabel title, text1, label, label2, label3, label4, label5, label6, label7, burgerl[], drinkl[], extral[], brmenul[], dessertl[], pr1, pr2, pr3, pr4, pr5, pr6, i1, i2, i3, i4, i5;
    public static JButton selectedButton, additem, checkout, help, brmenu, burger, drink, search, extra, dessert, cart, remove, burgerb[], drinkb[], extrab[], brmenub[], dessertb[];
    public static Font t, t1, t2, t3, t4, t5;
    static ImageIcon back, back2, back3, back4, back5, back6, back7;
    public static JTextArea textarea;
    public Container frame;
    public static JFrame frame2, frame3, frame4, frame5, frame6, frame7;
    public static double subt = 0;
    public static NumberFormat df2 = NumberFormat.getCurrencyInstance (); //Making a public decimal formatter

    public static void main (String[] args) throws IOException, InterruptedException
    {
	JazibAhmed_FinalLogic.run (); //Running the logic program first in order to get the menu and prices
	new JazibAhmed_FinalGUI (); //Making the main GUI
    } // main method


    public JazibAhmed_FinalGUI () throws IOException //The GUI method
    {
	super ("Jazib's Fast Food Takeout Program"); //Naming the GUI "Jazib's Fast Food Takeout Program"

	//Getting background images and putting it on JLabels to put on the different GUIs
	back = new ImageIcon ("back.jpg");
	back2 = new ImageIcon ("back2.jpg");
	back3 = new ImageIcon ("back3.jpg");
	back4 = new ImageIcon ("back4.jpg");
	back5 = new ImageIcon ("back5.jpg");
	back6 = new ImageIcon ("back6.jpg");
	back7 = new ImageIcon ("back7.jpg");
	label = new JLabel (back, JLabel.CENTER);

	//Making new fonts
	t = new Font ("Georgia", Font.PLAIN, 36);
	t1 = new Font ("Georgia", Font.PLAIN, 22);
	t2 = new Font ("Comic Sans MS", Font.PLAIN | Font.BOLD, 20);
	t3 = new Font ("Comic Sans MS", Font.PLAIN | Font.BOLD, 30);
	t4 = new Font ("Comic Sans MS", Font.PLAIN | Font.BOLD, 15);
	t5 = new Font ("Georgia", Font.PLAIN, 18);

	//Getting content pane for frame and setting layout and location
	frame = getContentPane ();
	frame.setLayout (null);
	setLocation (200, 50);

	//Making JLabels with text and setting their color and font
	title = new JLabel ("Jazib's Fast Food Takeout");
	text1 = new JLabel ("Subtotal: " + df2.format (subt));
	pr1 = new JLabel ("Subtotal: " + df2.format (subt));
	pr2 = new JLabel ("Subtotal: " + df2.format (subt));
	pr3 = new JLabel ("Subtotal: " + df2.format (subt));
	pr4 = new JLabel ("Subtotal: " + df2.format (subt));
	pr5 = new JLabel ("Subtotal: " + df2.format (subt));
	pr6 = new JLabel ("Subtotal: " + df2.format (subt));
	text1.setFont (t2);
	title.setFont (t); //sets font for title
	title.setForeground (new Color (255, 40, 0, 255));
	text1.setForeground (new Color (30, 73, 246, 255));

	//Making new buttons with text of their functions
	brmenu = new JButton ("Breakfast");
	burger = new JButton ("Burgers");
	drink = new JButton ("Drinks");
	search = new JButton ("Search");
	extra = new JButton ("Extras");
	dessert = new JButton ("Desserts");
	cart = new JButton ("View Cart");
	additem = new JButton ("Add/Remove Item Help");
	checkout = new JButton ("Checkout");
	help = new JButton ("General Help");

	//Setting fonts for all buttons
	brmenu.setFont (t1);
	burger.setFont (t1);
	drink.setFont (t1);
	search.setFont (t1);
	extra.setFont (t1);
	dessert.setFont (t1);
	cart.setFont (t1);
	additem.setFont (t5);
	checkout.setFont (t1);
	help.setFont (t5);

	//Setting the background color and removing the border for the buttons
	drink.setBackground (Color.BLUE);
	search.setBackground (Color.YELLOW);
	extra.setBackground (Color.ORANGE);
	dessert.setBackground (Color.WHITE);
	brmenu.setBackground (new Color (255, 40, 0, 255));
	burger.setBackground (new Color (0, 235, 84, 255));
	additem.setBackground (new Color (29, 209, 209, 255));
	help.setBackground (new Color (29, 209, 209, 255));
	cart.setBackground (new Color (253, 216, 115, 255));
	checkout.setBackground (Color.RED);
	brmenu.setBorderPainted (false);
	cart.setBorderPainted (false);
	burger.setBorderPainted (false);
	drink.setBorderPainted (false);
	search.setBorderPainted (false);
	extra.setBorderPainted (false);
	dessert.setBorderPainted (false);
	additem.setBorderPainted (false);
	checkout.setBorderPainted (false);
	help.setBorderPainted (false);

	//Adding all labels, buttons and textboxes to the frame
	frame.add (title);
	frame.add (text1);
	frame.add (brmenu);
	frame.add (burger);
	frame.add (drink);
	frame.add (dessert);
	frame.add (search);
	frame.add (additem);
	frame.add (checkout);
	frame.add (help);
	frame.add (cart);
	frame.add (extra);
	frame.add (label);

	//Setting the location and boundaries for all labels, buttons and textboxes
	title.setBounds (305, 10, 450, 35);
	label.setBounds (0, 0, 1000, 600);
	text1.setBounds (735, 315, 400, 80);
	brmenu.setBounds (50, 105, 150, 65);
	burger.setBounds (355, 105, 150, 65);
	drink.setBounds (50, 300, 150, 65);
	search.setBounds (700, 90, 230, 85);
	extra.setBounds (355, 300, 150, 65);
	dessert.setBounds (200, 450, 150, 65);
	cart.setBounds (700, 220, 230, 85);
	help.setBounds (700, 400, 230, 65);
	checkout.setBounds (800, 0, 150, 55);
	additem.setBounds (700, 470, 230, 65);

	//Adding action listeners to the buttons
	brmenu.addActionListener (this);
	burger.addActionListener (this);
	drink.addActionListener (this);
	search.addActionListener (this);
	extra.addActionListener (this);
	dessert.addActionListener (this);
	cart.addActionListener (this);
	additem.addActionListener (this);
	checkout.addActionListener (this);
	help.addActionListener (this);

	setSize (1000, 600); //setting size of the frame
	show (); //setting visibility
    }


    public void actionPerformed (ActionEvent e)  //ActionListener method
    {
	try
	{
	    if (e.getSource () == brmenu) //If statement to perform action when the "brmenu" button is pressed
	    {
		JazibAhmed_FinalGUI6 (); //Calling the breakfast menu GUI in order to display its contents
	    }
	    else if (e.getSource () == burger) //Else if statement to perform action when the "burger" button is pressed
	    {
		JazibAhmed_FinalGUI2 (); //Calling the burgers menu GUI in order to display its contents
	    }
	    else if (e.getSource () == drink) //Else if statement to perform action when the "drink" button is pressed
	    {
		JazibAhmed_FinalGUI3 (); //Calling the drinks menu GUI in order to display its contents
	    }
	    else if (e.getSource () == search) //Else if statement to perform action when the "search" button is pressed
	    {
		//Asking the user which item they want to search for and calling the search method from the logic program to search for the item

		String input = JOptionPane.showInputDialog ("Which item would you like to search for?");
		if (input != null)
		{
		    input = (Character.toUpperCase (input.charAt (0))) + input.substring (1, input.length ()); //Making the first letter capital in order for binary search to work
		    JazibAhmed_FinalLogic.search (JazibAhmed_FinalLogic.menu, input);
		}
	    }
	    else if (e.getSource () == extra) //Else if statement to perform action when the "extras" button is pressed
	    {
		JazibAhmed_FinalGUI5 (); //Calling the extras menu GUI in order to display its contents
	    }
	    else if (e.getSource () == dessert) //Else if statement to perform action when the "desserts" button is pressed
	    {
		JazibAhmed_FinalGUI4 (); //Calling the desserts menu GUI in order to display its contents
	    }
	    else if (e.getSource () == cart) //Else if statement to perform action when the "view cart" button is pressed
	    {
		JazibAhmed_FinalGUI7 (); //Calling the cart menu GUI in order to display its contents
	    }
	    else if (e.getSource () == additem) //Else if statement to perform action when the "add/remove item help" button is pressed
	    {
		JOptionPane.showMessageDialog (null, "If you want to add/remove items, go to the menu.txt text file and add an item under a group heading. \nFollow the format of the file and make sure not to add more than 9 items in each menu." +
			"\nFormat for adding is Item Name - Price in dollar format. \nTo remove an item, Just remove the line containing the item. \nMake sure to leave no spaces");
	    }
	    else if (e.getSource () == checkout) //Else if statement to perform action when the "checkout" button is pressed
	    {
		int s = 0;
		double word5 = 0;
		double tax = JazibAhmed_FinalLogic.calcTax (subt), total; //Calling on the calcTax method to calculate the tax on the current subtotal
		total = subt + tax; //calculaating the total and assigning it to the total variable above
		double tip = Double.parseDouble (JOptionPane.showInputDialog ("The subtotal is: " + df2.format (subt) + ". \n The tax was: " + df2.format (tax) + "\n The total will be: " + df2.format (total) + "\n Enter a tip amount")); //Asking the employee to enter a tip
		total += tip; //Adding the tip to the total
		if (JOptionPane.showInputDialog ("The final price will be: " + df2.format (total) + "\nWould you like to continue? (y/n)").equalsIgnoreCase ("y")) //Asking user to see if they want to continue one last time
		{
		    //When the employee says yes to continue
		    JazibAhmed_FinalGUI7(); //Calling the GUI but making the GUI itself invisible so the cart can compile the same items 
		    frame7.setVisible(false);
		    //Printing the receipt
		    System.out.println ("\t----Jazib's Fast Food Takeout Reciept---- \nItems:");
		    for (int v = 0 ; v < JazibAhmed_FinalLogic.myCart.size () ; v++)
		    {
			//Getting the word to also show the price of each item
			String word3 = JazibAhmed_FinalLogic.myCart.get(v).toString();
			 if (word3.charAt (0) > 47 && word3.charAt (0) < 59) //If statement for when there are multiple items
			 {
			 //The if statement then takes the number of items and also gets the item name, then searches it and gets the price. Then it multiplies the price by the number of items and puts it in the word5 variable
			 String word4 = word3.substring(2, word3.length()-1);
			 s = JazibAhmed_FinalLogic.binarySearch(JazibAhmed_FinalLogic.menu, word4);
			 word5 = (Double.parseDouble(JazibAhmed_FinalLogic.allp.get(s).toString()) * Character.getNumericValue(word3.charAt(0)));
			 }
			 else //Else statement for when there is only one item
			 {
			 //The item is then searched in the menu for its price and the price is put in word5 variable
			 s = JazibAhmed_FinalLogic.binarySearch(JazibAhmed_FinalLogic.menu, word3);
			 word5 = Double.parseDouble(JazibAhmed_FinalLogic.allp.get(s).toString());
			 }
			System.out.println(JazibAhmed_FinalLogic.myCart.get(v) + " - " + df2.format(word5)); //Printing out the items and their prices
		    }
		    System.out.println("---------------\nSubtotal: " + df2.format(subt) + "\nTax: " + df2.format(tax) + "\nTip: " + df2.format(tip) + "\nTotal: " + df2.format(total));
		    //End of receipt
		    
		    subt = 0; //Making the subtotal zero for the next order
		    setLabelTextPrice2 (subt); //Refreshing all subtotal labels to account for the reset of the subtotal
		    JazibAhmed_FinalLogic.myCart.clear (); //Clearing the items in the user's cart
		}
		else
		{
		    JOptionPane.showMessageDialog (null, "Checkout Cancelled!", "Cancel", JOptionPane.ERROR_MESSAGE); //Telling the user that the order is cancelled if they say no
		}
		
	    }
	    else if (e.getSource () == help) //Else if statement to perform action when the "General help" button is pressed
	    {
		JOptionPane.showMessageDialog (null, new JTextArea ("\t\t\t----------Instructions----------\n 1)On the left side of the main menu, you can access the food menus and when you click on them, each different menu will open.\n To add an item to the cart, just click on each items' corresponding add button. \n 2)The view cart button lets you see all the items in the cart.\nPressing on the remove items button within will give you an option to enter the items number. \nThis is seen by checking the number just in front of the item which is followed by a bracket like ')' \n 3) When all items have been ordered, double check the cart and then proceed to checkout for the final bill.\n Note: To close any menus, click on the X in the top right of the window"));
	    }
	}
	catch (IOException f)  //Using a try catch block to catch the IOException that occurs in some codes
	{
	}
    }


    public static void JazibAhmed_FinalGUI2 () throws IOException //The FinalGUI2 method / The burgers menu
    {
	//Making an array of JLabels and JButtons that are the size of the burgers array
	JLabel burgerl[] = new JLabel [JazibAhmed_FinalLogic.burgers.size ()];
	JButton burgerb[] = new JButton [JazibAhmed_FinalLogic.burgers.size ()];
	final HashMap labelMap = new HashMap (); //Making a hashmap that will link the JLabels and JButtons together
	frame2 = new JFrame ("Burger Menu"); //Making a new frame for the burgers menu

	//Getting a content pane and setting the frame's location, size and layout
	Container frame2c = frame2.getContentPane ();
	frame2.setLocation (200, 50);
	frame2.setSize (1000, 600);
	frame2c.setLayout (null);

	label2 = new JLabel (back2, JLabel.CENTER); //Making the background picture a JLabel
	//Making a JLabel that will tell which item was recently added and setting its font, size, background, and color
	i1 = new JLabel ("");
	i1.setBounds (550, 20, 500, 50);
	i1.setFont (t4);
	i1.setForeground (Color.GREEN);
	//Making a second JLabel that displays the subtotal on the burgers menu
	pr1.setBounds (770, 20, 500, 50);
	pr1.setFont (t2);
	for (int i = 0 ; i < JazibAhmed_FinalLogic.burgers.size () ; i++) //For loop that runs the size of the burgers array
	{
	    //Creating each JLabel and JButton with a unique value given from the burger and burger prices array from the logic program
	    burgerl [i] = new JLabel (JazibAhmed_FinalLogic.burgers.get (i).toString ());
	    burgerb [i] = new JButton ("Add - " + df2.format (Double.parseDouble (JazibAhmed_FinalLogic.bp.get (i).toString ())));
	    makeButtonandLabel (burgerb, burgerl, i); //Calling on the makeButtonandLabel method to set the same attributes to each button and label
	    labelMap.put (burgerb [i], burgerl [i]); //Putting the JLabel and JButton under a hashmap so both items are linked together
	    burgerb [i].addActionListener (new ActionListener ()  //Adding an action listener to each JButton
	    {
		public void actionPerformed (ActionEvent ef)  //Actionlistener method
		{
		    //Getting the text of the corresponding JLabel to the JButton and telling the user that the corresponding item was added
		    JLabel selectedLabel = (JLabel) labelMap.get (ef.getSource ());
		    i1.setText (selectedLabel.getText () + " added!");
		    //Adding the following item to a cart so it can be displayed in the view cart GUI
		    JazibAhmed_FinalLogic.myCart.add (selectedLabel.getText ());
		    //Refreshing every subtotal label to account for the new item added
		    setLabelTextPrice (((JButton) ef.getSource ()).getText ());
		}
	    }
	    );
	    //Adding the JButtons and Jlabels to the frame
	    frame2c.add (burgerl [i]);
	    frame2c.add (burgerb [i]);
	}
	//Adding the background, price label and recent item label to the frame
	frame2c.add (pr1);
	frame2c.add (i1);
	frame2c.add (label2);
	label2.setBounds (0, 0, 1000, 600);
	frame2.setVisible (true); //Setting the frame visibility to true
    }


    public static void JazibAhmed_FinalGUI3 () throws IOException //The FinalGUI3 method / The drinks menu
    {
	//Making an array of JLabels and JButtons that are the size of the drinks array
	JLabel drinkl[] = new JLabel [JazibAhmed_FinalLogic.drinks.size ()];
	JButton drinkb[] = new JButton [JazibAhmed_FinalLogic.drinks.size ()];
	final HashMap labelMap = new HashMap (); //Making a hashmap that will link the JLabels and JButtons together
	frame3 = new JFrame ("Drinks Menu"); //Making a new frame for the drinks menu

	//Getting a content pane and setting the frame's location, size and layout
	Container frame3c = frame3.getContentPane ();
	frame3.setLocation (200, 50);
	frame3.setSize (1000, 600);
	frame3c.setLayout (null);

	label3 = new JLabel (back3, JLabel.CENTER); //Making the background picture a JLabel
	//Making a JLabel that will tell which item was recently added and setting its font, size, background, and color
	i2 = new JLabel ("");
	i2.setBounds (550, 80, 500, 50);
	i2.setFont (t4);
	i2.setForeground (Color.GREEN);
	//Making a second JLabel that displays the subtotal on the drinks menu
	pr2.setBounds (770, 20, 500, 50);
	pr2.setFont (t2);

	for (int i = 0 ; i < JazibAhmed_FinalLogic.drinks.size () ; i++) //For loop that runs the size of the drinks array
	{
	    //Creating each JLabel and JButton with a unique value given from the drinks and drinks prices array from the logic program
	    drinkl [i] = new JLabel (JazibAhmed_FinalLogic.drinks.get (i).toString ());
	    drinkb [i] = new JButton ("Add - " + df2.format (Double.parseDouble (JazibAhmed_FinalLogic.drp.get (i).toString ())));
	    makeButtonandLabel (drinkb, drinkl, i); //Calling on the makeButtonandLabel method to set the same attributes to each button and label
	    labelMap.put (drinkb [i], drinkl [i]); //Putting the JLabel and JButton under a hashmap so both items are linked together
	    drinkb [i].addActionListener (new ActionListener ()  //Adding an action listener to each JButton
	    {
		public void actionPerformed (ActionEvent ef)  //Actionlistener method
		{
		    //Getting the text of the corresponding JLabel to the JButton and telling the user that the corresponding item was added
		    JLabel selectedLabel = (JLabel) labelMap.get (ef.getSource ());
		    i2.setText (selectedLabel.getText () + " added!");
		    //Adding the following item to a cart so it can be displayed in the view cart GUI
		    JazibAhmed_FinalLogic.myCart.add (selectedLabel.getText ());
		    //Refreshing every subtotal label to account for the new item added
		    setLabelTextPrice (((JButton) ef.getSource ()).getText ());
		}
	    }
	    );
	    //Adding the JButtons and JLabels to the frame
	    frame3c.add (drinkl [i]);
	    frame3c.add (drinkb [i]);
	}
	//Adding the background, price label and recent item label to the frame
	frame3c.add (pr2);
	frame3c.add (i2);
	frame3c.add (label3);
	label3.setBounds (0, 0, 1000, 600);
	frame3.setVisible (true); //Setting the frame visibility to true
    }


    public static void JazibAhmed_FinalGUI4 () throws IOException //The FinalGUI4 method / The desserts menu
    {
	//Making an array of JLabels and JButtons that are the size of the desserts array
	JLabel dessertl[] = new JLabel [JazibAhmed_FinalLogic.desserts.size ()];
	JButton dessertb[] = new JButton [JazibAhmed_FinalLogic.desserts.size ()];
	final HashMap labelMap = new HashMap (); //Making a hashmap that will link the JLabels and JButtons together
	frame4 = new JFrame ("Desserts Menu"); //Making a new frame for the desserts menu

	//Getting a content pane and setting the frame's location, size and layout
	Container frame4c = frame4.getContentPane ();
	frame4.setLocation (200, 50);
	frame4.setSize (1000, 600);
	frame4c.setLayout (null);

	label4 = new JLabel (back4, JLabel.CENTER); //Making the background picture a JLabel
	//Making a JLabel that will tell which item was recently added and setting its font, size, background, and color
	i3 = new JLabel ("");
	i3.setBounds (550, 20, 500, 50);
	i3.setFont (t4);
	i3.setForeground (Color.GREEN);
	//Making a second JLabel that displays the subtotal on the desserts menu
	pr3.setBounds (770, 20, 500, 50);
	pr3.setFont (t2);

	for (int i = 0 ; i < JazibAhmed_FinalLogic.desserts.size () ; i++) //For loop that runs the size of the desserts array
	{
	    //Creating each JLabel and JButton with a unique value given from the desserts and desserts' prices array from the logic program
	    dessertl [i] = new JLabel (JazibAhmed_FinalLogic.desserts.get (i).toString ());
	    dessertb [i] = new JButton ("Add - " + df2.format (Double.parseDouble (JazibAhmed_FinalLogic.dp.get (i).toString ())));
	    makeButtonandLabel (dessertb, dessertl, i); //Calling on the makeButtonandLabel method to set the same attributes to each button and label
	    labelMap.put (dessertb [i], dessertl [i]); //Putting the JLabel and JButton under a hashmap so both items are linked together
	    dessertb [i].addActionListener (new ActionListener ()  //Adding an action listener to each JButton
	    {
		public void actionPerformed (ActionEvent ef)  //Actionlistener method
		{
		    //Getting the text of the corresponding JLabel to the JButton and telling the user that the corresponding item was added
		    JLabel selectedLabel = (JLabel) labelMap.get (ef.getSource ());
		    i3.setText (selectedLabel.getText () + " added!");
		    //Adding the following item to a cart so it can be displayed in the view cart GUI
		    JazibAhmed_FinalLogic.myCart.add (selectedLabel.getText ());
		    //Refreshing every subtotal label to account for the new item added
		    setLabelTextPrice (((JButton) ef.getSource ()).getText ());
		}
	    }
	    );
	    //Adding the JButtons and JLabels to the frame
	    frame4c.add (dessertl [i]);
	    frame4c.add (dessertb [i]);
	}
	//Adding the background, price label and recent item label to the frame
	frame4c.add (pr3);
	frame4c.add (i3);
	frame4c.add (label4);
	label4.setBounds (0, 0, 1000, 600);
	frame4.setVisible (true);  //Setting the frame visibility to true
    }


    public static void JazibAhmed_FinalGUI5 () throws IOException //The FinalGUI5 method / The extras menu
    {
	//Making an array of JLabels and JButtons that are the size of the extras array
	JLabel extral[] = new JLabel [JazibAhmed_FinalLogic.extras.size ()];
	JButton extrab[] = new JButton [JazibAhmed_FinalLogic.extras.size ()];
	final HashMap labelMap = new HashMap (); //Making a hashmap that will link the JLabels and JButtons together
	frame5 = new JFrame ("Extras Menu"); //Making a new frame for the extras menu

	//Getting a content pane and setting the frame's location, size and layout
	Container frame5c = frame5.getContentPane ();
	frame5.setLocation (200, 50);
	frame5.setSize (1000, 600);
	frame5c.setLayout (null);

	label5 = new JLabel (back5, JLabel.CENTER); //Making the background picture a JLabel
	//Making a JLabel that will tell which item was recently added and setting its font, size, background, and color
	i4 = new JLabel ("");
	i4.setBounds (550, 20, 500, 50);
	i4.setFont (t4);
	i4.setForeground (Color.GREEN);
	//Making a second JLabel that displays the subtotal on the extras menu
	pr4.setBounds (770, 20, 500, 50);
	pr4.setFont (t2);

	for (int i = 0 ; i < JazibAhmed_FinalLogic.extras.size () ; i++) //For loop that runs the size of the extras array
	{
	    //Creating each JLabel and JButton with a unique value given from the extras and extras' prices array from the logic program
	    extral [i] = new JLabel (JazibAhmed_FinalLogic.extras.get (i).toString ());
	    extrab [i] = new JButton ("Add - $" + JazibAhmed_FinalLogic.ep.get (i).toString ());
	    makeButtonandLabel (extrab, extral, i); //Calling on the makeButtonandLabel method to set the same attributes to each button and label
	    extral [i].setForeground (new Color (30, 73, 246, 255)); //Setting a different colored text for the labels in this menu so they do not blend in with background
	    labelMap.put (extrab [i], extral [i]); //Putting the JLabel and JButton under a hashmap so both items are linked together
	    extrab [i].addActionListener (new ActionListener ()  //Adding an action listener to each JButton
	    {
		public void actionPerformed (ActionEvent ef)  //Actionlistener method
		{
		    //Getting the text of the corresponding JLabel to the JButton and telling the user that the corresponding item was added
		    JLabel selectedLabel = (JLabel) labelMap.get (ef.getSource ());
		    i4.setText (selectedLabel.getText () + " added!");
		    //Adding the following item to a cart so it can be displayed in the view cart GUI
		    JazibAhmed_FinalLogic.myCart.add (selectedLabel.getText ());
		    //Refreshing every subtotal label to account for the new item added
		    setLabelTextPrice (((JButton) ef.getSource ()).getText ());
		}
	    }
	    );
	    //Adding the JButtons and JLabels to the frame
	    frame5c.add (extral [i]);
	    frame5c.add (extrab [i]);
	}
	//Adding the background, price label and recent item label to the frame
	frame5c.add (pr4);
	frame5c.add (i4);
	frame5c.add (label5);
	label5.setBounds (0, 0, 1000, 600);
	frame5.setVisible (true); //Setting the frame visibility to true
    }


    public static void JazibAhmed_FinalGUI6 () throws IOException //The FinalGUI6 method / The breakfast menu
    {
	//Making an array of JLabels and JButtons that are the size of the breakfast array
	JLabel brmenul[] = new JLabel [JazibAhmed_FinalLogic.bmenu.size ()];
	JButton brmenub[] = new JButton [JazibAhmed_FinalLogic.bmenu.size ()];
	final HashMap labelMap = new HashMap (); //Making a hashmap that will link the JLabels and JButtons together
	frame6 = new JFrame ("Breakfast Menu"); //Making a new frame for the breakfast menu

	//Getting a content pane and setting the frame's location, size and layout
	Container frame6c = frame6.getContentPane ();
	frame6.setLocation (200, 50);
	frame6.setSize (1000, 600);
	frame6c.setLayout (null);

	label6 = new JLabel (back6, JLabel.CENTER); //Making the background picture a JLabel
	//Making a JLabel that will tell which item was recently added and setting its font, size, background, and color
	i5 = new JLabel ("");
	i5.setBounds (550, 20, 500, 50);
	i5.setFont (t4);
	i5.setForeground (Color.GREEN);
	//Making a second JLabel that displays the subtotal on the breakfast menu
	pr5.setBounds (770, 20, 500, 50);
	pr5.setFont (t2);

	for (int i = 0 ; i < JazibAhmed_FinalLogic.bmenu.size () ; i++) //For loop that runs the size of the breakfast array
	{
	    //Creating each JLabel and JButton with a unique value given from the breakfast and breakfast items' prices array from the logic program
	    brmenul [i] = new JLabel (JazibAhmed_FinalLogic.bmenu.get (i).toString ());
	    brmenub [i] = new JButton ("Add - $" + JazibAhmed_FinalLogic.bmp.get (i).toString ());
	    makeButtonandLabel (brmenub, brmenul, i); //Calling on the makeButtonandLabel method to set the same attributes to each button and label
	    brmenul [i].setForeground (new Color (30, 73, 246, 255)); //Setting a different colored text for the labels in this menu so they do not blend in with background
	    labelMap.put (brmenub [i], brmenul [i]); //Putting the JLabel and JButton under a hashmap so both items are linked together
	    brmenub [i].addActionListener (new ActionListener ()  //Adding an action listener to each JButton
	    {
		public void actionPerformed (ActionEvent ef)  //Actionlistener method
		{
		    //Getting the text of the corresponding JLabel to the JButton and telling the user that the corresponding item was added
		    JLabel selectedLabel = (JLabel) labelMap.get (ef.getSource ());
		    i5.setText (selectedLabel.getText () + " added!");
		    //Adding the following item to a cart so it can be displayed in the view cart GUI
		    JazibAhmed_FinalLogic.myCart.add (selectedLabel.getText ());
		    //Refreshing every subtotal label to account for the new item added
		    setLabelTextPrice (((JButton) ef.getSource ()).getText ());
		}
	    }
	    );
	    //Adding the JButtons and JLabels to the frame
	    frame6c.add (brmenul [i]);
	    frame6c.add (brmenub [i]);
	}
	//Adding the background, price label and recent item label to the frame
	frame6c.add (pr5);
	frame6c.add (i5);
	frame6c.add (label6);
	label6.setBounds (0, 0, 1000, 600);
	frame6.setVisible (true); //Setting the frame visibility to true
    }


    public static void JazibAhmed_FinalGUI7 ()  //The FinalGUI7 method / The cart menu
    {
	int count = 0; //Declaring a counter as integer
	frame7 = new JFrame ("Cart"); //Making a GUI for the cart menu

	//Getting a content pane and setting the frame's location, size and layout
	Container frame7c = frame7.getContentPane ();
	frame7.setLocation (200, 50);
	frame7.setSize (1000, 600);
	frame7c.setLayout (null);
	label7 = new JLabel (back7, JLabel.CENTER); //Making the background picture a JLabel

	//Making a new button that will remove items from the cart and setting its look and font
	remove = new JButton ("Remove Items");
	remove.setBackground (Color.RED);
	remove.setBorderPainted (false);
	remove.setFont (t1);
	remove.addActionListener (new ActionListener ()  //Adding an action listener to the remove button
	{
	    public void actionPerformed (ActionEvent ef)  //Actionlistener method
	    {
		if (JazibAhmed_FinalLogic.myCart.size () == 0) //If statement for button's output when there are no items in the cart
		{
		    JOptionPane.showMessageDialog (null, "The cart is empty", "Error", JOptionPane.ERROR_MESSAGE); //Button tells the user there are no items in the cart
		}
		else //Else statement for when there are items in the cart
		{
		    int i = Integer.parseInt (JOptionPane.showInputDialog ("Enter the number/index of the item you would like to remove")); //Asking user to enter the number/index of item they want to remove
		    if (i > JazibAhmed_FinalLogic.myCart.size () || i < 0) //If statement to catch user errors with inputting the wrong index
		    {
			JOptionPane.showMessageDialog (null, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
		    }
		    else
		    {
			String word = JazibAhmed_FinalLogic.myCart.get (i).toString (); //Getting the item they would like to remove
			if (word.charAt (0) > 47 && word.charAt (0) < 59) //First checking to see if there are multiple items in the line by checking to see if there is an integer as the first letter due to the format. Example "2 Cheeseburgers"
			{
			    int j = Integer.parseInt (JOptionPane.showInputDialog ("There are multiple items in this order, how many would you like to remove?")); //Telling user there are multiple items and asking how many they want to remove
			    int k = (Character.getNumericValue (word.charAt (0))) - j; //Subtracting the amount of items by the user's input
			    if (k == 0) //If statement for when no more of those items remain after subtraction
			    {
				JazibAhmed_FinalLogic.myCart.remove (i); //Removing the item completely from the cart
				String word2 = word.substring (2, word.length () - 1); //Getting the item name that can be used in the menu array by subtraction the numbers in front and the s at the end for plural
				int f = JazibAhmed_FinalLogic.binarySearch (JazibAhmed_FinalLogic.menu, word2); //Searching for the item in the menu using binary search method
				subt -= (Double.parseDouble (JazibAhmed_FinalLogic.allp.get (f).toString ())) * j; //Subtracting the price of the item from the subtotal and multiplying it to account for multiple items being removed
				setLabelTextPrice2 (subt); //Refreshing the subtotal to account for the removed items
			    }
			    else if (k < 0) //Else if statement for when the user removes too many items
			    {
				JOptionPane.showMessageDialog (null, "That value exceeds the number of items to remove", "Error", JOptionPane.ERROR_MESSAGE); //Telling the user they have removed too many items
			    }
			    else if (k == 1)
			    {
				String word2 = word.substring (2, word.length () - 1); //Getting the item name that can be used in the menu array by subtraction the numbers in front and the s at the end for plural
				int g = JazibAhmed_FinalLogic.binarySearch (JazibAhmed_FinalLogic.menu, word2); //Searching for the item in the menu using binary search method
				JazibAhmed_FinalLogic.myCart.set (i, word2);
				subt -= Double.parseDouble (JazibAhmed_FinalLogic.allp.get (g).toString ()) * j; ////Subtracting the price of the item from the subtotal and multiplying it to account for multiple items being removed
				setLabelTextPrice2 (subt); //Refreshing the subtotal to account for the removed items
			    }
			    else //Else statement for when some items still remain after subtraction
			    {
				String word2 = word.substring (2, word.length () - 1); //Getting the item name that can be used in the menu array by subtraction the numbers in front and the s at the end for plural
				int e = JazibAhmed_FinalLogic.binarySearch (JazibAhmed_FinalLogic.menu, word2); //Searching for the item in the menu using binary search method
				JazibAhmed_FinalLogic.myCart.set (i, k + " " + word2.substring (0, word2.length ()) + "s"); //Changing the values of the item in the cart so it accounts for the amount of items removed

				subt -= Double.parseDouble (JazibAhmed_FinalLogic.allp.get (e).toString ()) * j; ////Subtracting the price of the item from the subtotal and multiplying it to account for multiple items being removed
				setLabelTextPrice2 (subt); //Refreshing the subtotal to account for the removed items
			    }
			}
			else //Else statement for when there is only one of the item being removed
			{
			    int e = JazibAhmed_FinalLogic.binarySearch (JazibAhmed_FinalLogic.menu, word); //Searching for the item in the menu using the binary search method
			    subt -= Double.parseDouble (JazibAhmed_FinalLogic.allp.get (e).toString ()); ////Subtracting the price of the item from the subtotal only once as there is one item
			    setLabelTextPrice2 (subt); //Refreshing the subtotal to account for the removed items
			    JazibAhmed_FinalLogic.myCart.remove (i); //Removing the item completely from the cart
			}
			textarea.setText (""); //Refreshing the text area
			for (int l = 0 ; l < JazibAhmed_FinalLogic.myCart.size () ; l++)
			{
			    textarea.append (l + ") " + JazibAhmed_FinalLogic.myCart.get (l).toString () + "\n"); //Printing the changed values leftover after the removal
			}
		    }
		}
	    }
	}
	);
	//Making a textbox to show the items in the cart and setting differnt attributes
	textarea = new JTextArea ();
	textarea.setSize (500, 500);
	textarea.setLineWrap (true); //makes JTextArea wrap around
	textarea.setEditable (false); //Making the text area uneditable so that user cannot mess around

	//Making a scrollbar for the textbox for the output
	JScrollPane scroll = new JScrollPane ();
	scroll.setVerticalScrollBarPolicy (JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	scroll.setHorizontalScrollBarPolicy (JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	scroll.getViewport ().add (textarea);
	scroll.getViewport ().setBackground (Color.WHITE);

	//Setting background color and font for the textarea
	textarea.setBackground (new Color (107, 183, 250, 255));
	textarea.setFont (t2);
	int x = 0; //Declaring an integer variable
	//The following is for showing the items in the text area to the user
	if (JazibAhmed_FinalLogic.myCart.size () == 0)  //If statement for when the cart is empty
	{
	    textarea.setText ("There are no items in the cart"); //Telling the user there are no items in the cart
	}
	else //Else statement for when there are items in the cart
	{
	    for (int m = 0 ; m < JazibAhmed_FinalLogic.myCart.size () ; m++) //For loop that runs through each word in the cart
	    {
		count = 1;
		for (int a = 0 ; a < JazibAhmed_FinalLogic.myCart.size () ; a++) //Another for loop that also runs through each word in the cart
		{
		    x = m; //Making the current value of the starter loop equal to the x variable
		    if (a != m) //If statement to make sure both values in each loop do not collide and create errors
		    {
			//If statement that checks one item with every other item in the cart in order to compile same items
			if (JazibAhmed_FinalLogic.myCart.get (x).toString ().equals (JazibAhmed_FinalLogic.myCart.get (a).toString ()))
			{
			    JazibAhmed_FinalLogic.myCart.remove (a); //Removing the same item from the cart
			    x--; //Making the x value go back one to account for the size of the array decreasing due to the item being removed
			    a--; //Making the a value go back one to account for the size of the array decreasing due to the item being removed
			    count++; //Increasing the count of the number of items
			}
		    }
		}
		if (count != 1) //If statement for when the same items were found and were compiled
		{
		    JazibAhmed_FinalLogic.myCart.set (m, count + " " + JazibAhmed_FinalLogic.myCart.get (m).toString () + "s"); //Showing the user that the items were compiled with their count
		}
		m = x; //Making the starter loop equal to the x variable, which accounts for the new size of the array
	    }
	    for (int k = 0 ; k < JazibAhmed_FinalLogic.myCart.size () ; k++) //For loop that runs through each item in the cart
	    {
		textarea.append (k + ") " + JazibAhmed_FinalLogic.myCart.get (k).toString () + "\n"); //Printing the items in the cart to the text area
	    }
	}
	pr6.setFont(t2); //Setting font and color of the subtotal displayed
	pr6.setForeground (new Color (30, 73, 246, 255));
	//Adding the scrollpane, text area, remove button, subtotal label, and the background to the frame and setting their size
	scroll.setBounds (400, 20, 500, 500);
	textarea.setBounds (400, 20, 500, 500);
	remove.setBounds (70, 200, 240, 105);
	label7.setBounds (0, 0, 1000, 600);
	pr6.setBounds(110, 350, 400, 80);
	frame7c.add (scroll);
	frame7c.add (pr6);
	frame7c.add (remove);
	frame7c.add (label7);
	frame7.setVisible (true); //Setting the frame visibility to true
    }


    public static void setLabelTextPrice (String selectedButton)  //The setLabelTextPrice method which takes in the text within a button
    {
	subt += JazibAhmed_FinalLogic.PriceGetter (selectedButton); //Calling on the pricegetter method from the logic program to obtain the price recorded within the button
	//Refreshing the subtotal to display the correct prices after each order
	text1.setText ("Subtotal: " + df2.format (subt));
	pr1.setText ("Subtotal: " + df2.format (subt));
	pr2.setText ("Subtotal: " + df2.format (subt));
	pr3.setText ("Subtotal: " + df2.format (subt));
	pr4.setText ("Subtotal: " + df2.format (subt));
	pr5.setText ("Subtotal: " + df2.format (subt));
	pr6.setText ("Subtotal: " + df2.format (subt));
    }


    public static void setLabelTextPrice2 (double subt2)  //The setLabelTextPrice2 method
    {
	//This method is used to set the price within all the labels
	text1.setText ("Subtotal: " + df2.format (subt2));
	pr1.setText ("Subtotal: " + df2.format (subt2));
	pr2.setText ("Subtotal: " + df2.format (subt2));
	pr3.setText ("Subtotal: " + df2.format (subt2));
	pr4.setText ("Subtotal: " + df2.format (subt2));
	pr5.setText ("Subtotal: " + df2.format (subt2));
	pr6.setText ("Subtotal: " + df2.format (subt));
    }


    public static void makeButtonandLabel (JButton[] jb, JLabel[] jl, int i)  //The makeButtonandLabel method
    {
	//This method creates a button one by one and is used in a for loop to reduce reptitiveness
	jl [i].setBounds (50, 70 * i, 500, 50);
	jl [i].setFont (t3);
	jl [i].setForeground (new Color (243, 158, 31, 255));

	jb [i].setBackground (Color.RED);
	jb [i].setBorderPainted (false);
	jb [i].setBounds (410, (70 * i) + 5, 120, 40);
    }
} // JazibAhmed_GUI class



