import java.util.*;

public class reverseString {

    static String reverse(String input) 
    {
	    if (input == null)
	    {
		    throw new IllegalArgumentException("Null is not valid input");
	    }
		
        else 
        {
		    StringBuilder result = new StringBuilder();
		    char[] charactersOfString = input.toCharArray();

		    for (int i = charactersOfString.length - 1; i >= 0; i--)
            {
			    result.append(charactersOfString[i]);
            }

		    return result.toString();
        }
	}

	public static void main(String[] args) 
    {
		String userInputString;
		Scanner userInput = new Scanner(System.in);

		System.out.println("Enter the word, phrase, or sentence you want to reverse: ");
		userInputString = userInput.nextLine();

		System.out.println(reverse(userInputString));
	}
}


/*
 
Enter the word, phrase, or sentence you want to reverse: 
nature lover for life
efil rof revol erutan

 */