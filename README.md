# COMP250 Assignment 1 Winter 2020 Debugger
A series of testers for COMP250 Assignment 1 at McGill University.

# Install Instructions

For IntelliJ IDEA (recommended)

VCS -> Get from Version Control... -> Paste the URL of this repository

For Eclipse

File -> Import -> Git -> Projects from Git (With Smart Import) -> Clone URI -> paste URL of this repository into the URI box -> Click next a bunch, setting directory at your own discression, Master branch from origin. All else default -> Finish

For both:

Drag your .java files from the assignment into the tester package.

In case your IDE does not automatically set package name, change your package name to COMP250A1_W2020

Regularly update the tester (pull the repository). Your assignment files will be ignored.

# To test your program:

Run SuperTester.java

If you fail a tester:

Look at the error, look at your code and check for obvious oversights.

If nothing comes up, take a look at the tester code to better understand if an edge case is being tested.

Try the game tester with your problem, to see if you can recreate it by calling methods yourself.

To run a repeatable cruel tester, use a seed. Cruel tester is randomized and designed to be looped to test a variety of edge cases and strange behaviours. It is normal to sometimes fail cruel tester due to an illegal argument exception (as of current version, this will be patched) if it creates a hotel without the rooms it needs.

#Why GameTester?

GameTester is used to test your theories as to why a method doesn't work. 
Do you think add is broken when the cart has 0 items? Try it out. Do you think that remove removes all instances of identical reservations instead of just the first occurance? Test it for yourself! It is the most powerful tool in the package.

# NOTE:
You are expected to have your own classes written as assigned which pass the Syntax Tester for this to run.

This repository will ignore correctly named class files from the assignment, so pulling it to your project will have no effect on existing code.

If you wish to collaborate, or have any questions contact me at sasha@sashaphoto.ca
