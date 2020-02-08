package COMP250A1_W2020;

/**
 * <p>Tester for COMP 250 Assignment 1 @McGill University</p>
 *
 * @author Sasha Aleshchenko
 */
public class SuperTester {
    public static void main(String[] args) {
        System.out.println("Welcome to Sasha's megatester!              |               Vist sashaphoto.ca");
        try {
            SyntaxTester.main(new String[]{""}); //The prof's first tester
        } catch (Exception e) {
            System.out.println("Syntax Tester Failed. It is annoying and here are some reasons for which it may have failed:");
            e.printStackTrace();
            System.out.println("You may have put arguments in the wrong order in one of your methods, even though the assignment doesn't explicitly state order.");
            System.out.println("You may have used a Boolean instead of a boolean, an Integer instead of an int, etc. These are not the same and pass by reference.");
            System.out.println("You may have named a method differently than it wanted");
        }
        System.out.println("Escalating to MiniTester");
        MiniTester.main(new String[0]); //prof's second tester
        System.out.println("Escalating to AutoTester");
        new autoTester().runTest(); //My first tester(s)
        System.out.println("===================== For further debugging, the following is a game tester =====================");
        System.out.println("============ Use it to debug your code with manual input for method calls and inputs ============");
        for (int i = 0; i < 9; i++) {
            if (i % 2 == 0) {
                System.out.println();
            } else {
                System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
            }
        }
        gameTester.run(); //Game tester
    }
}
