package COMP250A1_W2020;

/**
 * <p>Tester for COMP 250 Assignment 1 @McGill University</p>
 *
 * @author Sasha Aleshchenko
 */
public class autoTester {
    private randomTravelAgency rand;

    public autoTester() {
        rand = new randomTravelAgency();
        runTest();
    }

    public autoTester(int inputSeed) {
        rand = new randomTravelAgency(inputSeed);
    }

    public autoTester(String inputName, int inputSeed) {
        rand = new randomTravelAgency(inputName, inputSeed);
    }

    public autoTester(boolean cruelTester) {
        if (cruelTester) {
            cruelTest();
        } else {
            runTest();
        }
    }

    public String runTest() {
        int errors = 0;

        try {
            Airport test = rand.nextAirport();
        } catch (Exception e) {
            System.out.println("[BASIC TESTER] Test failed while attempting to create airport and threw exception" + e);
            errors++;
        }//Airport test

        try {
            Room test = rand.nextRoom();
        } catch (Exception e) {
            Room test = null;
            System.out.println("[BASIC TESTER] Test failed while attempting to create room and threw exception" + e);
            errors++;
        }//Room test

        try {
            Hotel test = rand.nextHotel();
        } catch (Exception e) {
            Hotel test = null;
            System.out.println("[BASIC TESTER] Test failed while attempting to create Hotel and threw exception" + e);
            errors++;
        }//Hotel test

        try {//TODO: check I implemented all methods
            FlightReservation test = rand.nextFlightReservation();
            try {
                test.getCost();
            } catch (Exception e) {
                System.out.println("[BASIC TESTER] Test failed while attempting to getCost " + test.getClass() + " and threw exception" + e);
                errors++;
            }
            try {
                FlightReservation test2 = rand.nextFlightReservation();
            } catch (Exception e) {
                System.out.println("[BASIC TESTER] Test failed while attempting to test equality " + test.getClass() + " and threw exception" + e);
                errors++;
            }
            try {
                if (!(test.reservationName().equals(rand.getName()))) {//TODO: Why doesn't equals pass?
                    errors++;
                    System.out.println("[BASIC TESTER] Working name is " + rand.getName() + " reservation name is " + test.reservationName());
                    System.out.println("[BASIC TESTER] Test failed while comparing reservation name to working name ");
                    System.out.println("[BASIC TESTER]       Reservation name is: " + test.reservationName() + " working name is " + rand.getName());
                }
            } catch (Exception e) {
                System.out.println("[BASIC TESTER] Test failed while attempting to getName " + test.getClass() + " and threw exception" + e);
                errors++;
            }
        } catch (Exception e) {
            System.out.println("[BASIC TESTER] Test failed while attempting to create FlightReservation and threw exception" + e);
            errors += 6;
        }//FlightReservation Test

        try {
            HotelReservation test = rand.nextHotelReservation();
            try {
                test.getCost();
            } catch (Exception e) {
                System.out.println("[BASIC TESTER] Test failed while attempting to getCost " + test.getClass() + " and threw exception" + e);
                errors++;
            }
            try {
                test.getNumOfNights();//TODO: Compare to known value
            } catch (Exception e) {
                System.out.println("[BASIC TESTER] Test failed while attempting to getNumNights " + test.getClass() + " and threw exception" + e);
                errors++;
            }
            try {
                HotelReservation test2 = rand.nextHotelReservation();
            } catch (Exception e) {
                System.out.println("[BASIC TESTER] Test failed while attempting to test equality " + test.getClass() + " and threw exception" + e);
                errors++;
            }
            try {
                if (!test.reservationName().equals(rand.getName())) {
                    errors++;
                    System.out.println("[BASIC TESTER] Working name is " + rand.getName() + " reservation name is " + test.reservationName());
                    System.out.println("[BASIC TESTER] Test failed while comparing reservation name to working name ");
                }
            } catch (Exception e) {
                System.out.println("[BASIC TESTER] Test failed while attempting to getName " + test.getClass() + " and threw exception" + e);
                errors++;
            }

        } catch (Exception e) {
            System.out.println("[BASIC TESTER] Test failed while attempting to create HotelReservation and threw exception" + e);
            errors += 5;
        }//HotelReservation Test

        try {
            BnBReservation test = rand.nextBnBReservation();
            try {
                test.getCost();
            } catch (Exception e) {
                System.out.println("[BASIC TESTER] Test failed while attempting to getCost " + test.getClass() + " and threw exception" + e);
                errors++;
            }
            try {
                if (test.getNumOfNights() != rand.getNumberOfNights()) {
                    System.out.println("[BASIC TESTER] Test failed while attempting to getNumNights " + test.getClass() + " because nights didn't match input");
                }
            } catch (Exception e) {
                System.out.println("[BASIC TESTER] Test failed while attempting to getNumNights " + test.getClass() + " and threw exception" + e);
                errors++;
            }
            try {
                BnBReservation test2 = rand.nextBnBReservation();
            } catch (Exception e) {
                System.out.println("[BASIC TESTER] Test failed while attempting to test equality " + test.getClass() + " and threw exception" + e);
                errors++;
            }
            try {
                if (!test.reservationName().equals(rand.getName())) {
                    errors++;
                    System.out.println("[BASIC TESTER] Working name is " + rand.getName() + " reservation name is " + test.reservationName());
                    System.out.println("[BASIC TESTER] Test failed while comparing reservation name to working name ");
                }
            } catch (Exception e) {
                System.out.println("[BASIC TESTER] Test failed while attempting to getName " + test.getClass() + " and threw exception" + e);
                errors++;
            }

        } catch (Exception e) {
            System.out.println("[BASIC TESTER] Test failed while attempting to create HotelReservation and threw exception" + e);
            errors += 5;
        }//BNBReservation Test

        try {
            Basket testBasket = new Basket();
            try {
                if (testBasket.getNumOfReservations() != 0) {
                    errors++;
                    System.out.println("[BASIC TESTER] nonzero number of reservations in empty basket");
                }
            } catch (Exception e) {
                errors++;
                System.out.println("[BASIC TESTER] Empty basket number of reservations could not be read due to Java exception " + e);
            }
            try {
                if (testBasket.getTotalCost() != 0) {
                    errors++;
                    System.out.println("[BASIC TESTER] nonzero cost in empty basket");
                }
            } catch (Exception e) {
                errors++;
                System.out.println("[BASIC TESTER] Empty basket cost could not be read due to Java exception " + e);
            }
            try {
                if (testBasket.getProducts() != null) {
                    if (testBasket.getProducts().length != 0) {
                        errors++;
                        System.out.println("[BASIC TESTER] nonzero Reservations[] in empty basket");
                    }
                }
            } catch (Exception e) {
                errors++;
                System.out.println("[BASIC TESTER] Empty basket could not be read due to Java exception " + e);
            }
            try {
                testBasket.remove(rand.nextBnBReservation());
            } catch (Exception e) {
                System.out.println("[BASIC TESTER] random reservation could not be removed from empty basket " + e);
            }

            try {
                testBasket.clear();
                if (testBasket.getNumOfReservations() != 0) {
                    errors++;
                    System.out.println("[BASIC TESTER] nonzero number of reservations in empty basket (after clear)");
                }
            } catch (Exception e) {
                errors++;
                System.out.println("[BASIC TESTER] Empty basket number of reservations could not be read due to Java exception " + e);
            }

            try {
                HotelReservation tester = rand.nextHotelReservation();
                testBasket.add(tester);
                if (testBasket.getNumOfReservations() != 1) {
                    errors++;
                    System.out.println("[BASIC TESTER] Number of reservations did not change with add");
                }
                try {
                    if (testBasket.getTotalCost() != tester.getCost()) {
                        errors++;
                        System.out.println("[BASIC TESTER] Reservation's getCost does not match cart getTotalCost");
                    }
                } catch (Exception e) {
                    errors++;
                    System.out.println("[BASIC TESTER] Failed to retrieve cost of basket " + e);
                }
                try {
                    if (testBasket.getProducts()[0] != tester) {
                        errors++;
                        System.out.println("[BASIC TESTER] Reservation returned was not the same reservation as was added");
                    }
                } catch (Exception e) {
                    errors++;
                    System.out.println("[BASIC TESTER] Failed to retrieve reservation due to java error " + e);
                }
            } catch (Exception e) {
                errors++;
                System.out.println("[BASIC TESTER] Add to basket failed because " + e);
            }


        } catch (Exception e) {
            System.out.println("[BASIC TESTER] Test failed while attempting to create Basket and threw exception" + e);
            errors += 6; //TODO: Correct number of tests contained in first try loop
        }//Basket Test

        try {
            Customer test1 = rand.nextCustomer();
            try {
                if (test1.getBalance() != rand.getCustomerBalanceInit()) {
                    errors++;
                    System.out.println("[BASIC TESTER] Customer balance failed to report properly.");
                }
            } catch (Exception e) {
                errors++;
                System.out.println("[BASIC TESTER] Customer balance failed to read balance due to Java error: " + e);
            }

            try {
                int fundsToAdd = rand.nextInt(2000);
                test1.addFunds(fundsToAdd);
                if (test1.getBalance() != rand.getCustomerBalanceInit() + fundsToAdd) {
                    errors++;
                    System.out.println("[BASIC TESTER] Customer balance failed to add properly due to checksum.");
                }
            } catch (Exception e) {
                errors++;
                System.out.println("[BASIC TESTER] Customer balance failed to add due to Java error: " + e);
            } //Checks adding balance

            try {
                test1.getBasket();//TODO: Run basket on this side and compare
            } catch (Exception e) {
                errors++;
                System.out.println("[BASIC TESTER] Customer balance failed to get empty basket due to Java error: " + e);
            } //Checks getting empty basket

        } catch (Exception e) {
            System.out.println("[BASIC TESTER] Test failed while attempting to create Customer and threw exception" + e);
            errors += 5;
        }//Customer test

        //TODO: Add testers for the rest of the methods checkout, etc.
        if (errors != 0) {

            return "[BASIC TESTER] Test concluded with " + errors + " errors";
        } else {
            System.out.println("[BASIC TESTER] All tests passed. Escalating to CRUEL TESTER");
            boolean passedCruel = cruelTest();
            if (passedCruel) {
                return "Congrats, all tests passed.";
            } else {
                return "It's ok, the test was unfair anyway";
            }

        }

    }

    public boolean cruelTest() {
        //System.out.println("[CRUEL TESTER] Welcome to the cruel tester");
        int errors = 0;
        Customer[] customers = {rand.nextCustomer(), rand.nextCustomer(), rand.nextCustomer(), rand.nextCustomer(), rand.nextCustomer(), rand.nextCustomer()};
        for (int i = 0; i < customers.length; i++) {
            //System.out.println("[CRUEL TESTER] Testing customer " + i);
            customers[i].addToBasket(rand.nextAirport(), rand.nextAirport());
            customers[i].addToBasket(rand.nextHotelReservation());
            Airport AP1 = rand.nextAirport();
            Airport AP2 = rand.nextAirport();
            FlightReservation toBeRemoved = new FlightReservation(customers[i].getName(), AP2, AP1);
            FlightReservation toBeKept = new FlightReservation(customers[i].getName(), AP1, AP2);
            customers[i].addToBasket(toBeRemoved);
            customers[i].addToBasket(toBeKept);
            //TODO: Compare number of things added, getnumofreservations, and addtobasket outputs

            //System.out.println("[CRUEL TESTER] After adding 4 reservations, customer " + i + " has " + customers[i].getBasket().getNumOfReservations() + " reservation(s)");
            boolean passed = false;
            boolean canRemove = customers[i].removeFromBasket(toBeRemoved);
            //System.out.println("[CRUEL TESTER] After removing 1 reservation, customer " + i + " has " + customers[i].getBasket().getNumOfReservations() + " reservation(s)");
            if (canRemove) {
                for (int j = 0; j < customers[i].getBasket().getProducts().length; j++) {
                    try {
                        //System.out.println("[CRUEL TESTER] Number of products being tested is " + (customers[i].getBasket().getProducts().length));
                        if (customers[i].getBasket().getProducts()[j].equals(toBeRemoved)) {
                            errors++;
                            System.out.println("[CRUEL TESTER] the reservation to be removed was kept in place " + j);
                        }
                        if (customers[i].getBasket().getProducts()[j].equals(toBeKept)) {
                            //System.out.println("[CRUEL TESTER] the reservation to be kept was kept :) It's in place " + j);
                            passed = true;
                        }
                    } catch (NullPointerException e) {
                        System.out.println("[CRUEL TESTER] ERROR: Reservation in place " + j + " is null");
                        e.printStackTrace();
                        errors++;
                    }
                }
            } else {
                errors++;
                System.out.println("[CRUEL TESTER] failed to remove existing item from cart");
            }
            if (!passed) {
                errors++;
                System.out.println("[CRUEL TESTER] the reservation to be kept was removed");
            }
            while (customers[i].getBalance() > customers[i].getBasket().getTotalCost()) {
                customers[i].checkOut();
                customers[i].addToBasket(rand.nextHotelReservation());
            }
            while (customers[i].getBalance() < customers[i].getBasket().getTotalCost()) {
                customers[i].addFunds(1);
            }
            customers[i].checkOut();
            if (customers[i].getBalance() != 0) {
                errors++;
                System.out.println("[CRUEL TESTER] Balance should be 0");
            }
            //System.out.println("[CRUEL TESTER] Test concluded for customer " + i);
        }
        if (errors == 0) {
            System.out.println("[CRUEL TESTER] You passed!");
            return true;
        } else {
            System.out.println("[CRUEL TESTER] You failed with " + errors + " errors :(");
            return false;
        }
    }

    public randomTravelAgency getRand() {
        return rand;
    }
}
