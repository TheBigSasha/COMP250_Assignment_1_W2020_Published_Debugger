package COMP250A1_W2020;

import java.util.Random;

/**
 * Travel Agency Project Randomizer
 *
 * <P>Extends random to include object types from COMP250_W2020_A1 at McGillU
 * <p>
 * Seed, name, numberOfNights, and balance are class variables, as they must be kept consistent for a given customer.
 *
 * @author Sasha Aleshchenko
 */
public class randomTravelAgency extends Random {
    private String inputName;
    private int seed;
    private int numberOfNights;
    private int customerBalanceInit;

    randomTravelAgency(String userName, int inputSeed) {
        this.inputName = userName;
        this.seed = inputSeed;
        this.numberOfNights = nextInt(15);
        this.customerBalanceInit = this.nextInt(999999);
    }

    randomTravelAgency(int inputSeed) {
        this.inputName = nextName();
        this.seed = inputSeed;
        this.numberOfNights = nextInt(15);
        this.customerBalanceInit = this.nextInt(999999);
    }

    randomTravelAgency() {
        this.seed = nextInt();
        this.inputName = nextName();
        this.numberOfNights = nextInt(15);
        this.customerBalanceInit = this.nextInt(999999);
    }

    /**
     * Name generator
     *
     * <P>Generates a String of realistic length and composition for names
     *
     * <P>Uses Asian characters for names less than 4 long, and latin for longer names
     *
     * @return String, randomized name of realistic length
     */
    public String nextName() {
        int nameLength = nextInt(11);
        nameLength += 1;
        char[] nameOutChar = new char[nameLength];
        for (int i = 0; i < nameLength; i++) {
            if (nameLength <= 4) {
                nameOutChar[i] = (char) nextInt(18500);
                nameOutChar[i] += nextInt(5000);
            } else {
                int nameNumber = nextInt(90 - 65) + 65;
                nameOutChar[i] = (char) nameNumber;
                if (i == nameLength - 3) {
                    nameOutChar[i + 1] = (char) 85;
                }
            }
        }
        String nameOut = String.valueOf(nameOutChar);
        //System.out.println(nameOut);
        return nameOut;
    }

    /**
     * Room generator
     *
     * <P>Generates a Room object with random parameters
     *
     * @return Room, randomized
     */
    public Room nextRoom() {
        return new Room(nextRoomType());
    }

    /**
     * Airport generator
     *
     * <P>Generates an Airport object with random, realistic parameters
     *
     * @return Airport, randomized
     */
    public Airport nextAirport() {
        return new Airport(nextInt(10000), nextInt(5000), nextInt(5000));
    }

    /**
     * Hotel generator
     *
     * <P>Generates an Hotel object filled with upto 10 random rooms. There is no quota for room types. Minimum 1 room.
     *
     * @return Hotel, randomized
     */
    public Hotel nextHotel() {
        setSeed(seed);
        Random rand = new Random(seed);
        int randomLength = rand.nextInt(9) + 1;
        Room[] rooms = new Room[randomLength];
        for (int i = 0; i < randomLength; i++) {
            rooms[i] = nextRoom();
        }
        return new Hotel(inputName, rooms);
    }

    /**
     * Room generator
     *
     * <P>Generates a String containing a valid room type for use in the Room object
     *
     * @return String, roomType, randomized
     */
    private String nextRoomType() {
        String[] roomTypes = {"queen", "king", "double"};
        return roomTypes[nextInt(2)];
    }

    /**
     * HotelReservation generator
     *
     * <P>Generates a HotelReservation from randomized Hotel, roomType, and numberOfNights and the input name
     *
     * @return HotelReservation, randomized
     */
    public HotelReservation nextHotelReservation() {
        try {
            return new HotelReservation(inputName, nextHotel(), nextRoomType(), numberOfNights);
        } catch (IllegalArgumentException e) {
            return nextHotelReservation();
        }
    }

    /**
     * FlightReservation generator
     *
     * <P>Generates a HotelReservation from randomized Airports and the input name
     *
     * @return FlightReservation, randomized
     */
    public FlightReservation nextFlightReservation() {
        return new FlightReservation(inputName, nextAirport(), nextAirport());
    }

    /**
     * Customer generator
     *
     * <P>Generates a customer with a given name and a given balance
     *
     * @return FlightReservation, randomized
     */
    public Customer nextCustomer() {
        return new Customer(inputName, this.customerBalanceInit);
    }

    /**
     * BnBReservation generator
     *
     * <P>Generates a BnBReservation from randomized Hotel, roomType, and numberOfNights and the input name
     *
     * @return BnBReservation, randomized
     */
    public BnBReservation nextBnBReservation() {
        return new BnBReservation(inputName, nextHotel(), nextRoomType(), numberOfNights);
    }

    /**
     * name getter
     *
     * <P>gets the working name
     *
     * @return String, name
     */
    public String getName() {
        return this.inputName;
    }

    /**
     * NumberOfNights getter
     *
     * <P>gets the numberOfNights
     *
     * @return int, numberOfNights
     */
    public int getNumberOfNights() {
        return this.numberOfNights;
    }

    /**
     * Balance getter
     *
     * <P>gets the balance
     *
     * @return int, balance
     */
    public int getCustomerBalanceInit() {
        return this.customerBalanceInit;
    }

    /**
     * Seed getter
     *
     * <P>gets the seed
     *
     * @return int, seed
     */
    public int getSeed() {
        return this.seed;
    }


}
