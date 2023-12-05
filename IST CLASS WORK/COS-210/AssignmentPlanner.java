import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class AssignmentPlanner 
{

    public static void main(String[] args) {
        
            //scanner object to scan user inputs
            Scanner scan = new Scanner(System.in);
            //list to store assignments
            ArrayList<Assignment> assignmentPlanner = new ArrayList<>();
        while(true)
        {
            System.out.println("Welcome to your personal Assinngment Planner!\n\nWhat would you like to do today?\n");
            System.out.println("To ADD a new assignment press: (1)");
            System.out.println("To REMOVE an assignment press: (2)");
            System.out.println("To display list of assignments press: (3)");
            System.out.println("To find most urgent assignment press: (4)");
            System.out.println("to EXIT press: (5)\n");

            //scans for number user inputs 
            int input = scan.nextInt();
            scan.nextLine(); 
            
            if (input == 1)
            {
                //asks user for name and date of the assignment and adds it as an "Assignment" on the list
                System.out.println("Please enter the name of your assignment:");
                String description = scan.nextLine();
                System.out.println("Please enter the due date using this format: YYYY-MM-DD");
                String dueDate = scan.nextLine();
                
                //adds to list
                assignmentPlanner.add(new Assignment(description, dueDate));
                System.out.println("Assignment successfully added.");
            } 
        
            else if (input == 2) 
            {
                //removes an existing assignemnt from the list
                System.out.println("\nPlease enter the description of the assignment you would like to remove.");
                String assignmentToRemove = scan.nextLine();
                
                //value to store whether assignment has been successfully removed or not
                boolean removed = removeAssignment(assignmentPlanner, assignmentToRemove);
                if (removed) 
                {
                    System.out.println("Assignment successfully removed");
                } 
                //when not in list returns this
                else
                {
                    System.out.println("Assignment is not present in the list.");
                }
            } 
            
            else if (input == 3) 
            {
                //displays all assignments
                System.out.println("These are the current assignments:");
                for (Assignment assignment : assignmentPlanner) 
                {
                    System.out.println(assignment);
                }
            } 
        
            else if (input == 4) 
            {
                //pools all due dates to see which one is the most "urgent" / which one is due the earliest
                Assignment urgentAssignment = findUrgentAssignment(assignmentPlanner);
                if (urgentAssignment != null) 
                {
                    System.out.println("\nYour most urgent assigment is: " + urgentAssignment);
                }
                //if there are no assignments this prints
                else 
                {
                    System.out.println("\nYou have no urgent assignments");
                }
            } 
        
            else if (input == 5)
            {
                //exits program
                System.out.println("Thank you for planning with us!");
                scan.close();
                System.exit(0);
            } 
        
            else 
            {
                //notifies the user that their choice was not present on the list
                System.out.println("\nINVALID: please enter one of the corresponding numbers!");
            }
        
        }
    }
    private static boolean removeAssignment(ArrayList<Assignment> assignmentPlanner, String assignmentToRemove) 
    {
        //Iterator checks which assignment is in the list and if it is the same as the input it removes it
        Iterator<Assignment> iterator = assignmentPlanner.iterator();
        while (iterator.hasNext()) 
        {
            //making assignment object for iteration
            Assignment assignment = iterator.next();
            if (assignment.getName().equalsIgnoreCase(assignmentToRemove)) 
            {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
    static class Assignment 
    {
        private String name;
        private String date;

        public Assignment(String name, String date) 
        {
            this.name = name;
            this.date = date;
        }
        public String getName() 
        {
            //gives name
            return name;
        }

        public String getDate() 
        {
            //gives due date
            return date;
        }
        public String toString() 
        {
            //returns all info of the assignment (combo of the getdate and getname)
            return "Name:" + name + ", Date it is due:" + date;
        }

    }
    
    private static Assignment findUrgentAssignment(ArrayList<Assignment> assignmentPlanner) 
    {
        //takes all the assignments and chooses which date is the earliest or most "urgent"
        if (assignmentPlanner.isEmpty()) 
        {
            return null;
        }

        Assignment urgentAssignment = assignmentPlanner.get(0);

        //looping through the planner
        for (Assignment assignment : assignmentPlanner) 
        {
            if (assignment.getDate().compareTo(urgentAssignment.getDate()) < 0) 
            {
                urgentAssignment = assignment;
            }
        }

        return urgentAssignment;
    }

}