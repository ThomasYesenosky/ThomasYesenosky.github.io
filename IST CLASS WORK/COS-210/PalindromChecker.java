import java.util.Scanner;
import java.util.Stack;

public class PalindromeChecker 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to check if it's a palindrome:");
        String str = scanner.nextLine();
        System.out.println(isPalindrome(str) ? "The string is a palindrome." : "The string is not a palindrome.");
        scanner.close();
    }

    public static boolean isPalindrome(String str) 
    {
        // Initialize two stacks to hold characters
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        // Push characters from the input string onto stack1
        for (int i = 0; i < str.length(); i++) 
        {
            stack1.push(str.charAt(i));
        }

        int halfLength = str.length() / 2;
        // Push first half of characters from stack1 onto stack2
        for (int i = 0; i < halfLength; i++) 
        {
            stack2.push(stack1.pop());
        }

        // If the length is odd, skip the middle character
        if (str.length() % 2 != 0) 
        {
            stack1.pop();
        }

        // Compare characters from stack1 and stack2
        while (!stack1.isEmpty()) 
        {
            if (stack1.pop() != stack2.pop()) 
            {
                return false;
            }
        }

        // If all characters match, the string is a palindrome
        return true;
    }
}