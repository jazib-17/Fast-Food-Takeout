//Importing multiple packages
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.text.*;
public class JazibAhmed_FinalLogic
{
    //Declaring variables, using ArrayLists as I wanted an adjustable size of arrays for the cart and menu adding
    public static int j = 0, fLen = 0;
    public static ArrayList desserts = new ArrayList (), burgers = new ArrayList (), drinks = new ArrayList (), extras = new ArrayList (), bmenu = new ArrayList (), menu = new ArrayList ();
    public static ArrayList dp = new ArrayList (), bp = new ArrayList (), drp = new ArrayList (), ep = new ArrayList (), bmp = new ArrayList (), allp = new ArrayList (), myCart = new ArrayList ();
    public static void main (String[] args) throws IOException
    {
	run ();
    } // main method


    public static void run () throws IOException // the run method
    {
	int num = 0; //Declaring an integer
	BufferedReader fr = new BufferedReader (new FileReader ("menu.txt")); //Making a file reader that will read from the menu
	while (fr.readLine () != null) //While loop to find out the length of the file
	{
	    fLen++; //Storing length of file in this variable
	}
	fr.close(); //Closing the file reader

	// Making separate arraylists for each item (Burgers, Drinks etc.)
	// Calling on the FindLengthOfArrays method to give the line number of the specified string
	FindLengthOfArrays (j, "Drinks:");
	//Making the specified arraylist by using the previously stored line and the current line as the lines between them are the ones needed for the array (Example: the lines in between "Burgers: " and "Drinks: " contain the burgers)
	burgers = ArrayMaker (num, j);
	num = j; //Setting the num variable to the previous line number 
	//Getting all the items in the menu by repeating the methods
	FindLengthOfArrays (j, "Breakfast Menu:");
	drinks = ArrayMaker (num, j);
	num = j;
	FindLengthOfArrays (j, "Desserts:");
	bmenu = ArrayMaker (num, j);
	num = j;
	FindLengthOfArrays (j, "Extras:");
	desserts = ArrayMaker (num, j);
	num = j;
	FindLengthOfArrays (j, "End");
	extras = ArrayMaker (num, j);
	num = j;

	//Calling on the pricemaker method to obtain the prices from each arraylist
	dp = PriceMaker (desserts);
	bp = PriceMaker (burgers);
	bmp = PriceMaker (bmenu);
	drp = PriceMaker (drinks);
	ep = PriceMaker (extras);

	//Getting all the items from the menu into a menu arraylist and sorting them, which is useful when binary searching items
	MenuMaker (menu);
	sorter (menu);
	allp = PriceMaker (menu); //Also getting all the prices from the menu and storing them into an all prices arraylist
    }


    public static void FindLengthOfArrays (int a, String word) throws IOException //The FindLengthOfArrays method
    {
	j = 0; //Setting the j value to 0 to account for the file reading from the start each time
	BufferedReader fr = new BufferedReader (new FileReader ("menu.txt")); //Making a file reader that reads the menu
	while ((fr.readLine ().equals (word)) != true) //While loop that loops through until it finds the loop sent in with the method call
	{
	    j++; //Adding 1 each time to account for 1 more line not found with the said word
	}

    }


    public static ArrayList ArrayMaker (int num1, int num2) throws IOException //The ArrayMaker method
    {
	ArrayList items = new ArrayList (); //Making a new arraylist
	BufferedReader fr = new BufferedReader (new FileReader ("menu.txt")); //Making a file reader that reads the menu
	for (int i = 0 ; i < fLen - 1 ; i++) //For loop that runs the length of the file
	{
	    if (i > num1 && i < num2) //If statement for when the loop comes under the 2 line numbers specified
	    {
		items.add (fr.readLine ()); //Ading any item within those 2 line numbers
	    }
	    else //Else statement when line isnt in between both numbers
	    {
	    String trash = fr.readLine(); //Storing other lines in trash
	    }
	}
	return items; //Returning the arraylist
    }


    public static ArrayList PriceMaker (ArrayList inarray) //The PriceMaker method
    {
	String word = "", word2 = ""; //Declaring word strings
	ArrayList array2 = new ArrayList (); //Making a new arraylist
	for (int i = 0 ; i < inarray.size () ; i++) //For loop that runs the length of the array given by the user
	{
	    word = inarray.get (i).toString (); //Assigning a variable to each word that is in the array
	    for (int j = 0 ; j < word.length () ; j++) //For loop that runs the length of the word
	    {
		if (word.charAt (j) == '$') //Checking each letter in the word until the $ symbol is found to represent money
		{
		    word2 = word.substring (j + 1, word.length ()); //Getting the price that comes after the $ symbol and storing it in the word2 variable
		    array2.add (new Double (word2)); //Adding that price to the arraylist
		    inarray.set (i, word.substring (0, j - 3)); //Removing the price from the original array
		}
	    }
	}
	return array2; //Returning the arraylist
    }


    public static double PriceGetter (String word) //The PriceGetter method
    {
	double k = 0; //Declaring a double
	for (int j = 0 ; j < word.length () ; j++) //For loop that runs the length of the given word
	{
	    if (word.charAt (j) == '$') ////Checking each letter in the word until the $ symbol is found to represent money
	    {
		k = Double.parseDouble (word.substring (j + 1, word.length ())); //Getting the price that comes after the $ symbol and storing it in the k variable
		break; //Breaking the loop
	    }
	}
	return k; //returning the price
    }


    public static void MenuMaker (ArrayList menu) throws IOException //The MenuMaker method
    {
	BufferedReader fr = new BufferedReader (new FileReader ("menu.txt")); //Making a new file reader that will read from the menu file
	for (int i = 0 ; i < fLen ; i++) //For loop that runs the length of the file
	{
	    String word = fr.readLine (); //Stroing the current line in the word variable
	    //If statement that does nothing when it finds words in the menu file that are not actual items on the menu
	    if (word.equals ("Drinks:") || word.equals ("Breakfast Menu:") || word.equals ("Desserts:") || word.equals ("Extras:") || word.equals ("End") || word.equals ("Burgers:"))
	    {
	    }
	    else //Else statement for when the reader does find items
	    {
		menu.add (word); //Adding the items to the menu arraylist
	    }
	}
    }


    public static void sorter (ArrayList men) //The sorter method
    {
	int f = 0; //Declaring variable as int

	for (int j = 0 ; j < men.size () ; j++) //For loop that runs the length of the menu
	{
	    for (int i = 0 ; i < men.size () - 1 ; i++) //Nested loop that runs again and again in order to sort properly
	    {
		//Calling on the NotEqual Method to look between the current word and the word after in the menu and find where letters are not the same
		f = NotEqual (men.get (i).toString (), men.get (i + 1).toString ());

		//Checking to see which letter is higher than the other and adjusting accordingly
		if (men.get (i).toString ().charAt (f) > men.get (i + 1).toString ().charAt (f))
		{
		    String tempN = men.get (i).toString (); //If letter from the first word is higher, the menu items switch
		    men.set (i, men.get (i + 1).toString ());
		    men.set (i + 1, tempN);
		}
	    }
	}
    }


    public static int NotEqual (String word, String word2)  //The NotEqual method
    {
	String space = word; //Declaring a string and setting it as the first word inputted
	int f = 0; //Declaring an integer
	if (word.length () > word2.length ()) //If statement to make the "space" variable the lower length word of the 2 words
	{
	    space = word2;
	}
	for (int i = 0 ; i < space.length () ; i++) //For loop that runs the length of the lower word so the loop does not break by going higher than the lower word
	{
	    if (word.charAt (i) != word2.charAt (i)) //If statement that checks each character of each word and finds when they are not the same
	    {
		f = i; //Returning the location of the letter for both words where the letters are not the same 
		break; //Breaking the loop
	    }
	}
	return f; //Returning the non equal letters location
    }


    public static int binarySearch (ArrayList menu, String searchItem)  //The BinarySearch method
    {
	int low = 0, high = menu.size () - 1, middle; //Declaring variables

	while (low <= high) //While loop that runs as long as the low variable is less than the high variable
	{
	    middle = (high + low) / 2; //Dividing sum of high and low by 2 to get the middle
	    //Calling on the NotEqual method to see the point where the 2 letters are not different between the searched item and the item in the middle
	    int l = NotEqual (searchItem, menu.get (middle).toString ());
	    if (searchItem.equalsIgnoreCase (menu.get (middle).toString ())) //Checking to see first if the searched item is the same as the item in the middle
	    {
		return middle; //Returning the location of the middle item
	    }
	    else if ((int) (searchItem.charAt (l)) < (int) menu.get (middle).toString ().charAt (l)) //Else if statement for when the letter of the word has a lower value than the middle
	    {
		high = middle - 1; //Making the high variable 1 value lower than the middle as the searched item is alphabetically lower than the item in the middle of the array
	    }
	    else //Else statement for when the letter of the word has a higher value than the middle
	    {
		low = middle + 1; //Making the low variable 1 value higher than the middle as the searched item is alphabetically higher than the item in the middle of the array
	    }
	}
	return -1; //Returning a -1 value if the item didn't match the middle after looping several times
    }


    public static void search (ArrayList menu, String searchItem) //The search method
    {
	NumberFormat df2 = NumberFormat.getCurrencyInstance (); //Making a money formatter
	int num = binarySearch (menu, searchItem); //Calling on the binary search method to return the location of the item in the menu array
	if (num == -1) //If statement for when the location comes as -1, which means the item was not found
	{
	    JOptionPane.showMessageDialog (null, "This item was not found", "Error" ,JOptionPane.ERROR_MESSAGE);//Telling the user the item was not found
	}
	 //Else statement for when the location is not -1, which means the searched item was found
	{
	    //If statement for when the user presses "yes" to adding the found item to the cart
	    if (JOptionPane.showConfirmDialog (null, "The item you searched: \n 1) " + menu.get (num) + "\n was found! \n Would you like to add it to the order for " + df2.format (allp.get (num)) + " ?", "Item found!",
			JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
	    {
		JOptionPane.showMessageDialog (null, menu.get (num) + " was added!"); //Using the location received to find the item and tell the user it was added
		myCart.add (menu.get (num)); //adding the item to the cart
		JazibAhmed_FinalGUI.setLabelTextPrice (df2.format (Double.parseDouble (allp.get (num).toString ()))); //Refreshing the subtotal labels to account for the new price added with the item
	    }
	    else //If statement for when the user presses "no" to adding the found item to the cart
	    {
		JOptionPane.showMessageDialog (null, "Alright, no problem!"); //Giving a response to show the item was not added
	    }
	}
    }
    
    
    public static double calcTax(double price) //The calcTax method
    {
    double tax = price * 0.13; //Multiplying the given price by 0.13, as tax is 13%
    return tax; //Returning the tax
    }
    
} // JazibAhmed_FinalLogic class


