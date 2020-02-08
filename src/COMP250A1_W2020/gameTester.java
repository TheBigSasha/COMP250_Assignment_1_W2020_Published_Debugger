package COMP250A1_W2020;

import java.util.Scanner;

/**
 * <p>Tester for COMP 250 Assignment 1 @McGill University</p>
 *
 * @author Sasha Aleshchenko
 */
public class gameTester {
    public static Scanner scanner = new Scanner(System.in);
    private static Customer customer;
    private static randomTravelAgency rand = new randomTravelAgency();
    private static FlightReservation latestFlightReservation;
    private static HotelReservation latestHotelReservation;
    private static BnBReservation latestBnBReservation;

    public static void run() {
        customer = rand.nextCustomer();
        System.out.println("Now, you are playing a customer named " + customer.getName() + " with a balance of " + customer.getBalance() + " cents ");

        while (true) {
            System.out.println("Enter an option: [0] Add a FlightReservation [1] Add a HotelReservation [2] Add a BnBReservation");
            System.out.println("[3] Remove the last FlightReservation [4] Remove the last HotelReservation [5] Remove the last BnBReservation");
            System.out.println("[6] Clear Cart [7] Checkout [8] Add funds [9] GetNumberofReservations [10] Get Reservations");
            System.out.println("[11] Get total cost [12] AutoTester [13] MiniTester [14] SyntaxTester [15] Reset Game");
            System.out.println("[16] Run cruelTester (random) [17] Loop cruel tester [18] Run cruel tester with seed");
            System.out.println("[19] Help me!");
            int input = scanner.nextInt();
            int addAgain;
            int randOrUsr;
            switch (input) {
                case 0:
                    System.out.println("Random [0] or user [1]?");
                    randOrUsr = scanner.nextInt();
                    if (randOrUsr == 1) {
                        System.out.println("Arrival:");
                        Airport arrival = userAirport();
                        System.out.println("Departure");
                        Airport departure = userAirport();
                        latestFlightReservation = new FlightReservation(customer.getName(), departure, arrival);
                        customer.addToBasket(latestFlightReservation);
                        System.out.println("Add flight back? [0] or not [1]");
                        if (scanner.nextInt() == 0) {
                            latestFlightReservation = new FlightReservation(customer.getName(), arrival, departure);
                            customer.addToBasket(latestFlightReservation);
                        }
                    } else {
                        latestFlightReservation = rand.nextFlightReservation();
                        customer.addToBasket(latestFlightReservation);
                        System.out.println("Added a random flight reservation to cart. Cart has " + customer.getBasket().getNumOfReservations() + " items");
                    }
                    while (true) {
                        System.out.println("Add again? [0] yes /[1] no");
                        addAgain = scanner.nextInt();
                        if (addAgain == 0) {
                            customer.addToBasket(latestFlightReservation);
                            System.out.println("Added a duplicate of the last flight reservation to cart. Cart has " + customer.getBasket().getNumOfReservations() + " items");
                        } else {
                            break;
                        }
                    }
                    break;
                case 1:
                    latestHotelReservation = rand.nextHotelReservation();
                    customer.addToBasket(latestHotelReservation);
                    System.out.println("Added a random hotel reservation to cart. Cart has " + customer.getBasket().getNumOfReservations() + " items");
                    while (true) {
                        System.out.println("Add again? [0] yes /[1] no");
                        addAgain = scanner.nextInt();
                        if (addAgain == 0) {
                            customer.addToBasket(latestHotelReservation);
                            System.out.println("Added a duplicate of the last hotel reservation to cart. Cart has " + customer.getBasket().getNumOfReservations() + " items");
                        } else {
                            break;
                        }
                    }
                    break;
                case 2:
                    latestBnBReservation = rand.nextBnBReservation();
                    customer.addToBasket(latestBnBReservation);
                    System.out.println("Added a random BnB reservation to cart. Cart has " + customer.getBasket().getNumOfReservations() + " items");
                    while (true) {
                        System.out.println("Add again? [0] yes /[1] no");
                        addAgain = scanner.nextInt();
                        if (addAgain == 0) {
                            customer.addToBasket(latestBnBReservation);
                            System.out.println("Added a duplicate of the last BnB reservation to cart. Cart has " + customer.getBasket().getNumOfReservations() + " items");
                        } else {
                            break;
                        }
                    }
                    break;
                case 3:
                    try {
                        customer.removeFromBasket(latestFlightReservation);
                        System.out.println("Removed last FlightReservation " + customer.getBasket().getNumOfReservations() + " items");
                        System.out.println("This remove only removes the latest reservation or copies of it. This is to test whether remove");
                        System.out.println("removes everything or just the specifically requested item.");
                    } catch (NullPointerException e) {
                        System.out.println("you have not made a reservation of this type and thus cannot cancel it.");
                    }

                    break;
                case 4:
                    try {
                        customer.removeFromBasket(latestHotelReservation);
                        System.out.println("Removed last HotelReservation " + customer.getBasket().getNumOfReservations() + " items");
                        System.out.println("This remove only removes the latest reservation or copies of it. This is to test whether remove");
                        System.out.println("removes everything or just the specifically requested item.");
                    } catch (NullPointerException e) {
                        System.out.println("you have not made a reservation of this type and thus cannot cancel it.");
                    }
                    break;
                case 5:
                    try {
                        customer.removeFromBasket(latestBnBReservation);
                        System.out.println("Removed last BnBReservation " + customer.getBasket().getNumOfReservations() + " items");
                        System.out.println("This remove only removes the latest reservation or copies of it. This is to test whether remove");
                        System.out.println("removes everything or just the specifically requested item.");
                    } catch (NullPointerException e) {
                        System.out.println("you have not made a reservation of this type and thus cannot cancel it.");
                    }
                    break;
                case 6:
                    customer.getBasket().clear();
                    System.out.println("Cart Cleared. Customer cart now has " + customer.getBasket().getNumOfReservations() + " items");
                    break;
                case 7:
                    try {
                        customer.checkOut();
                        System.out.println("Checkout successful!");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e + " not enough $? ");
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    break;
                case 8:
                    System.out.println("How much to add (IN CENTS)? You presently have $" + (customer.getBalance() / 100.0));
                    int toAdd = scanner.nextInt();
                    customer.addFunds(toAdd);
                    System.out.println("You now have $ " + +(customer.getBalance() / 100.0));
                    break;
                case 9:
                    System.out.println("You have " + customer.getBasket().getNumOfReservations() + " Reservations. ");
                    break;
                case 10:
                    for (int i = 0; i < customer.getBasket().getNumOfReservations(); i++) {
                        System.out.print(customer.getBasket().getProducts()[i].getClass().getName() + ", ");
                    }
                    System.out.println();
                    break;
                case 11:
                    System.out.println("Total cost is " + (float) (customer.getBasket().getTotalCost()) / 100.0);
                    break;
                case 12:
                    new autoTester().runTest();
                    break;
                case 13:
                    MiniTester.main(new String[0]);
                    break;
                case 14:
                    SyntaxTester.main(new String[0]);
                    break;
                case 15:
                    reset();
                    break;
                case 16:
                    new autoTester().cruelTest();
                    break;
                case 17:
                    System.out.println("How many iterations?");
                    int iterations = scanner.nextInt();
                    int i = 0;
                    while (i <= iterations) {
                        autoTester current = new autoTester();
                        System.out.println("For iteration " + i + " seed is " + current.getRand().getSeed());
                        current.cruelTest();
                        i++;
                    }
                    System.out.println("Ran for " + i + " iterations.");
                    break;
                case 18:
                    System.out.println("What seed? [INT]");
                    int inputSeed = scanner.nextInt();
                    new autoTester(inputSeed).cruelTest();
                    break;
                case 19:
                    System.out.println("Contact the dev at sasha@sashaphoto.ca | alexander.aleshchenko@mail.mcgill.ca");
                    break;
                default:
                    break;

            }
        }

    }

    private static void reset() {
        customer = new Customer("Geoff", 0);
        latestFlightReservation = null;
        latestHotelReservation = null;
        latestBnBReservation = null;
    }

    public static Airport userAirport() {
        System.out.println("Enter Airport details: Position X");
        int positionX = scanner.nextInt();
        System.out.println("Enter Airport details: Position Y");
        int positionY = scanner.nextInt();
        System.out.println("Enter Airport details: Fees");
        int fees = scanner.nextInt();
        return new Airport(positionX, positionY, fees);
    }
}
