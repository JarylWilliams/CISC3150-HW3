/*
 * CISC.3150 HW3
 *Creating my own version of the String Class
 */

/**
 *
 * @author Jaryl
 */
import java.util.*;

    
//http://grepcode.com/file/repository.grepcode.com/java/root/jdk/openjdk/6-b14/java/lang/String.java#String


     class MyString {
        final private char [] characters;
	private int length;
	
        //Constructor
	public MyString (char [] chars)
        {
            characters = chars;
            
        }
	
        
	//https://docs.oracle.com/javase/7/docs/api/java/lang/StringIndexOutOfBoundsException.html
	public char charAt(int index)
	{
		if ((index < 0) || (index >= characters.length))
		    throw new StringIndexOutOfBoundsException(index); 
		return characters[index];
	}

	public int length ()
	{
		return characters.length;
	}   
        
            //Creates a substring 
        public MyString substring(int begin, int end) 
            {
		 char [] string1 = new char[end-begin+1]; 
               for (int i=0;begin+i <= end;i++)
               {
                 string1 [i] = characters [begin+i];
               }
               return new MyString (string1);
    }
    
	//converts string to all lower case
	public MyString toLowerCase ()
	{
		char[] string1= new char[characters.length];
                for (int i=0; i<characters.length; i++)
                {
                  string1[i] = Character.toLowerCase(characters[i]);
                 }
                return new MyString(string1);
	}	

        //convertsstring to all uppercase
	public MyString toUpperCase ()
	{
		char[] string1= new char[characters.length];
                for (int i=0; i<characters.length; i++)
                {
                 string1[i] = Character.toUpperCase(characters[i]);
                }
        return new MyString(string1);
	}	
        
        public MyString (String s)
	{
		
		characters = new char [length];
		for (int i = 0; i < length; i++)
			characters[i] = s.charAt(i);
	}
        
        //Returns -1 if string 1 is shorter than string2, Returns 1 if string 1 is longer and returns 0 if they are the same
          public int compareTo(MyString s) 
          {
            if (this.length() < s.length()) 
                    return -1;
                else if (this.length() > s.length()) 
                    return 1;
            else 
                    return 0;
            }
	//Accessor
	 public MyString getMyString()
        {
        return new MyString(characters);
        }
	
	
        @Override
	public String toString ()
	{
		return new String(characters);
	}	
        
                //http://grepcode.com/file/repository.grepcode.com/java/root/jdk/openjdk/6-b14/java/lang/String.java#String.valueOf%28int%29
        public static MyString valueOf(int i)
         {
            char[] charArray = (""+i).toCharArray();
            return new MyString(charArray);
         }
   }


public class StringClass {
    public static void main (String [] args)
    {
        Scanner input = new Scanner(System.in);

        // Input from user
        System.out.println("Please enter a string: ");
                MyString driverString = new MyString(input.nextLine().toCharArray());
        System.out.println("The String is: "+driverString.getMyString());

        
        // Length of String
        System.out.println("Length of the string: "+driverString.length());

        
        // Test charAt() method
        System.out.println("Please enter an index please: ");
                int index = Integer.parseInt(input.next());
        System.out.println("The value at the index "+index+" is: "+driverString.charAt(index));

        
        // Creates substring
        System.out.println("Please enter indices  new String [Index1  Index2]");
                int begin = Integer.parseInt(input.next());
                int end = Integer.parseInt(input.next());
                input.nextLine(); 
        System.out.println("The indices " + begin + " " + end);
        System.out.println("The substring is: "+driverString.substring(begin,end));

        
        // Makes string all upper case
        System.out.println("The string in all upper case is: "+driverString.toUpperCase());

        
        
        // Makes strinig all lower case
        System.out.println("The string in all lower case  is: "+driverString.toLowerCase());

        
        
        // Value of Method
        System.out.println("Please enter an INTEGER value to convert:");
                int val = Integer.parseInt(input.nextLine());
        System.out.println("Value of "+val+" is: "+MyString.valueOf(val)+" with the length: " + MyString.valueOf(val).length());

        
        
        // Compares orginal string to another string
        System.out.println("Enter word to compare: ");
                MyString string2 = new MyString(input.nextLine().toCharArray());
        System.out.println(driverString.getMyString()+ " compare to "+string2.getMyString()+" gives you a value of "+driverString.compareTo(string2));

     
   }
}
    
    