import java.util.Arrays;

public class SequenceGenerator {

    // Method to initiate sequence generation
    public static void generateSequences(char[] letters) {
        for (int i = 1; i <= letters.length; i++) {
            System.out.println(i + "-element sequences:");
            sequenceHelper(letters, new char[i], 0, 0);
            System.out.println();
        }
    }

    // Recursive method to generate sequences
    public static void sequenceHelper(char[] letters, char[] sequence, int start, int depth) {
        if (depth == sequence.length) {
            printSequence(sequence);
            return;
        }

        for (int i = start; i < letters.length; i++) {
            sequence[depth] = letters[i];
            sequenceHelper(letters, sequence, i + 1, depth + 1);
            sequence[depth] = '\0'; // Reset the element after the recursive call
        }
    }

    // Print the generated sequence
    public static void printSequence(char[] sequence) {
        for (char c : sequence) {
            if (c != '\0') {
                System.out.print(c);
            }
        }
        System.out.print(" ");
    }

    // Main method to run the program
    public static void main(String[] args) {
        char[] letters = {'A', 'C', 'E', 'G'};
        generateSequences(letters);
    }
}