package COMP250A1_W2020;

import java.util.Random;
import java.util.Scanner;


public class sashaUberTester {
    public static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Sasha's megatester!");
        try {
            SyntaxTester.main(new String[]{""});
        } catch (Exception e) {
            System.out.println("Syntax Tester Failed. It is annoying and here are some reasons for which it may have failed:");
            e.printStackTrace();
            System.out.println("You may have put arguments in the wrong order in one of your methods, even though the assignment doesn't explicitly state order.");
            System.out.println("You may have used a Boolean instead of a boolean, an Integer instead of an int, etc. These are not the same and pass by reference.");
            System.out.println("You may have named a method differently than it wanted");
        }
        System.out.println("Escalating to MiniTester");
        MiniTester.main(new String[0]);
        System.out.println("What's your name?");
        String userName = scanner.next();
        System.out.println("this is where the fun begins, enter seed");
        int seed = scanner.nextInt();
        System.out.println("running with your name");
        System.out.println(new autoTester(userName, seed).runTest());
        while (true) {
            System.out.println("Do you want the game tester [0] cruel tester [1] all testers [2] or just the auto tester [anything else]?");
            int choice = scanner.nextInt();
            switch (choice) {
                case 0:
                    gameTester(new randomTravelAgency().nextName());
                    break;
                case 1:
                    new autoTester().cruelTest();
                    break;
                case 2:
                    SyntaxTester.main(new String[0]);
                    MiniTester.main(new String[0]);
                    new autoTester();
                    break;
            }
            int counter = 0;
            while (counter < 50) {
                autoTester[] tests = {new autoTester(), new autoTester(), new autoTester(), new autoTester(), new autoTester(), new autoTester(), new autoTester(), new autoTester(), new autoTester(), new autoTester(), new autoTester(), new autoTester(), new autoTester(), new autoTester(), new autoTester(), new autoTester(), new autoTester(), new autoTester(), new autoTester(), new autoTester(), new autoTester(), new autoTester(), new autoTester(), new autoTester(), new autoTester(), new autoTester(), new autoTester(), new autoTester(), new autoTester(), new autoTester(), new autoTester(), new autoTester(), new autoTester(), new autoTester(), new autoTester(), new autoTester(), new autoTester(), new autoTester(), new autoTester(), new autoTester(), new autoTester(), new autoTester(), new autoTester(), new autoTester(), new autoTester(), new autoTester(), new autoTester(), new autoTester(), new autoTester(), new autoTester(), new autoTester(), new autoTester()};
                for (int i = 0; i < tests.length; i++) {
                    tests[i].runTest();
                }
                counter++;
            }
            System.out.println("now again with a random name");
            System.out.println(new autoTester(seed).runTest());
        }

    }

    private static void gameTester(String userName) {
        final Airport YUL = new Airport(10000, 9808, 9091);
        final Airport YVR = new Airport(15000, 6303, 8991);
        Airport YYZ = new Airport(13500, 9010, 9000);
        final Airport LHR = new Airport(19000, 13500, 10700);
        final Airport LAX = new Airport(25000, 6000, 4000);
        final Airport[] airports = new Airport[]{YUL, YVR, YYZ, LHR, LAX};
        Basket b1 = new Basket();
        Airport a1 = new Airport(7, 80000, 30000);
        Airport a2 = new Airport(8, 50000, 10000);
        Airport a3 = new Airport(8, 50000, 10000);
        FlightReservation r1 = new FlightReservation("myReservation", a1, a2);
        FlightReservation r2 = new FlightReservation("secondReservation", a1, a3);
        FlightReservation r3 = new FlightReservation("thirdReservation", a2, a3);
        b1.add(r1);
        b1.add(r2);
        b1.add(r3);
        try {
            boolean res;
            try {
                res = b1.remove(r2);
            } catch (Exception e) {
                res = false;
                System.out.println("Remove threw exception " + e.toString());
            }
            Reservation[] myProducts = b1.getProducts();
            if (res) {
                try {
                    if (myProducts.length == 2 && myProducts[0].equals(r1) && myProducts[1].equals(r3)) {
                        System.out.println("Remove worked");
                    } else {
                        System.out.println("Remove said it worked but didn't");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println(e.toString());
                }
            } else {
                System.out.println("Error: Basket.remove() doesn't shift the products down.\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());

        }
        Room[] shadyRooms = randomRoomMaker(5);
        Room[] bougieRooms = randomRoomMaker(7);
        Room[] airBNBRooms = randomRoomMaker(9);
        Room room1 = new Room("double");
        Room room2 = new Room("queen");
        Room room3 = new Room("king");
        Room[] test = new Room[]{room1, room2, room3};
        Hotel ShadySprings = new Hotel("Shady Springs Resort", test);
        Hotel BougieBouge = new Hotel("Bougie Hotel", bougieRooms);
        Hotel CrapAirBNB = new Hotel("Shady airBNB", airBNBRooms);

        System.out.println("What's the arrival airport? [YUL, YVR, YYZ, LHR, LAX]");

        Airport arrival = userAirportSwitch(scanner, airports);
        System.out.println("What's the departure airport? [YUL, YVR, YYZ, LHR, LAX]");

        Airport departure = userAirportSwitch(scanner, airports);
        System.out.println("booking flight from " + departure + " to " + arrival);
        FlightReservation firstFlight = new FlightReservation(userName, arrival, departure);
        System.out.println("your flight details are: ");
        System.out.println("cost is $" + ((double) firstFlight.getCost() / 100.0));
        System.out.println("booked under " + (firstFlight.reservationName()));

        System.out.println("Before we add to cart, how broke are you *in cents*?");
        int customerBalanceInit = scanner.nextInt();
        System.out.println("Wow, you're broke! You only have $" + (double) customerBalanceInit / 100.0);
        Customer user1 = new Customer(userName, customerBalanceInit);
        System.out.println("Let's try adding that flight");
        user1.addToBasket(firstFlight);
        System.out.println("Your cart contains " + user1.getBasket().getNumOfReservations() + " items");
        System.out.println("Now, you need a place to stay. Let's book a hotel. How long do you plan to stay (days)?");
        int howLongInHotel = scanner.nextInt();
        System.out.println("Where do you want to stay? [Shady Springs (0), Bougie Hotel (1), AirBNB (2)]?");
        int whichHotelInt = scanner.nextInt();
        Hotel[] HotelOptions = new Hotel[]{ShadySprings, BougieBouge, CrapAirBNB};
        Hotel whichHotel;
        try {
            whichHotel = HotelOptions[whichHotelInt];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Your input was invalid. You're too dumb to send the right input so we'll put you in the worst one");
            whichHotel = HotelOptions[0];
        }
        System.out.println("What room do you want? [double (0), queen (1), king (2)]?");
        String[] roomOptions = new String[]{"double", "queen", "king"};
        int whichRoomInt = scanner.nextInt();
        HotelReservation firstStay;
        try {
            firstStay = new HotelReservation(userName, whichHotel, roomOptions[whichRoomInt], howLongInHotel);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Your input was invalid. You're too dumb to send the right input so we'll put you in the worst one");
            firstStay = new HotelReservation(userName, whichHotel, roomOptions[0], howLongInHotel);
        }
        System.out.println("Let's try adding that flight");
        user1.addToBasket(firstStay);
        System.out.println("Your cart contains " + user1.getBasket().getNumOfReservations() + " items");
        System.out.println("Using advanced AI and neural networks, we have determined that there's a 100% chance that you want to checkout now. We will proceed accordingly.");
        try {
            int testBalance = customerBalanceInit - user1.getBasket().getTotalCost();
            user1.checkOut();
            if (user1.getBalance() != testBalance) {
                System.out.println("Balance calculation check failed.");
            }
        } catch (IllegalStateException e) {
            System.out.println("nah, you're too broke to checkout. Too bad.");
        }


    }

    private static Airport userAirportSwitch(Scanner scanner, Airport[] input) {
        Airport departure = null;
        while (departure == null) {
            String inputAirport = scanner.next();
            switch (inputAirport) {
                case "YUL":
                    departure = input[0];
                    System.out.println("your airport is " + inputAirport);
                    break;
                case "YVR":
                    departure = input[1];
                    System.out.println("your airport is " + inputAirport);
                    break;
                case "YYZ":
                    departure = input[2];
                    System.out.println("your airport is " + inputAirport);
                    break;
                case "LAX":
                    departure = input[3];
                    System.out.println("your airport is " + inputAirport);
                    break;
                case "LHR":
                    departure = input[4];
                    System.out.println("your airport is " + inputAirport);
                    break;
                default:
                    System.out.println("Invalid airport. Your input was: " + inputAirport);
                    break;
            }
        }
        return departure;
    }

    public static Room[] randomRoomMaker(int numOfRooms) {
        Room[] rooms = new Room[numOfRooms];
        Random rand = new Random();
        String[] types = {"double", "queen", "king"};
        for (int i = 0; i < numOfRooms; i++) {
            rooms[i] = new Room(types[rand.nextInt(2)]);
        }
        return rooms;
    }

}
