import java.util.*;

class checkOddElementsInList {
   public static void main(String[] args) {
       Scanner userInput= new Scanner(System.in);

       System.out.print("Enter the size of list: ");
       int numberOfElements = userInput.nextInt();

       List<Integer> listOfNumbers = new ArrayList<>();
       System.out.println("Enter the numbers into the list: ");
            for(int i = 0; i < numberOfElements; i++) 
            {
                listOfNumbers.add(userInput.nextInt());
            }
            
            if(isListOdd(listOfNumbers)) 
            {
                System.out.println("The list contains only odd numbers");
            }
            else 
            {
                System.out.println("The list contains an even number");
            }
    }
    
        // Function to check whether the list has only odd elements or not
        static boolean isListOdd(List<Integer> listOfNumbers)
        {
            // iterate through all the elements in the array list called listOfNumbers
            // and divide each element by 0; if there is a remainder of 0,
            // then return false since this means it is an even number.
            for(int element:listOfNumbers)
            {
                if(element % 2 == 0)
                return false;
            }
            return true;
        }
}