# OOP-Coursework-2

You will write a game called “Space Mission Launch Sequence.”

The user plays the role of a trainee at Stellar Space Center, working under a veteran Mission Controller. The trainee is completing their placement year at the center, and the Mission Controller is known for their exacting standards and perfectionist approach. The trainee has been tasked with developing a simulation tool that will help determine the optimal launch sequence for the next mission. That is, they need to arrange 5 critical procedures in the correct order from a set of 9 possible procedures.

The Mission Controller has a very specific idea of the correct launch sequence but, due to security protocols, cannot directly tell the trainee the exact order. However, they can provide feedback on any proposed sequence.

They “know it when they see it” – this means the trainee has to suggest several draft sequences to the Mission Controller. For each sequence, the Mission Controller can tell them:

    how many procedures are in their correct position in the sequence, and
    how many procedures are needed but are in the wrong position in the sequence.

With this feedback, the trainee can refine their sequence until it’s correct.

The available launch procedures at Stellar Space Center are:

    System Check (procedure code 01),
    Fuel Loading (procedure code 02),
    Navigation Setup (procedure code 03),
    Communication Test (procedure code 04),
    Engine Ignition (procedure code 05),
    Weather Verification (procedure code 06),
    Crew Boarding (procedure code 07),
    Safety Override (procedure code 08), and
    Launch Pad Clear (procedure code 09).

We use the last digit of their procedure codes to represent them. The five positions in the sequence represent:

    Pre-launch verification
    System initialization
    Final preparation
    Launch readiness
    Mission start

For instance

9 3 4 7 1

represents a sequence that has Launch Pad Clear as pre-launch verification, Navigation Setup as system initialization, Communication Test as final preparation, Crew Boarding as launch readiness, and System Check as mission start.

Suppose the Mission Controller was expecting the sequence

9 3 4 7 1

If the trainee suggested

1 3 4 5 9

the Mission Controller would indicate that

    two procedures belong in the sequence but are in the wrong position (System Check (01) and Launch Pad Clear (09)), and
    two procedures are in the right spot (Navigation Setup (03) and Communication Test (04)).

The game will proceed in a loop. First, the list of previous attempts so far is displayed – this includes the guesses and the Mission Controller’s feedback. The user is then asked to input their next suggestion. If the answer is correct, “Sequence verified!” is displayed and the program terminates. Otherwise, the game loops.

If the user enters a sequence containing a procedure code that does not exist at Stellar Space Center, or a sequence containing duplicated procedures, the program should indicate that the sequence is not valid and ask the user to enter another attempt.

An example run is shown below. Notice that the list of previous attempts is always displayed with the most recent sequence first.

> Previous attempts:
> No previous attempts
> Enter new sequence:
< 9 4 7 1 3
> Previous attempts:
> 9 4 7 1 3 (Correct 1, Wrong position 4)
> Enter new sequence:
< 4 7 1 3 9 
> Previous attempts:
> 4 7 1 3 9 (Correct 0, Wrong position 5)
> 9 4 7 1 3 (Correct 1, Wrong position 4)
> Enter new sequence:
< 9 3 7 4 1
> Previous attempts:
> 9 3 7 4 1 (Correct 3, Wrong position 2)
> 4 7 1 3 9 (Correct 0, Wrong position 5)
> 9 4 7 1 3 (Correct 1, Wrong position 4)
> Enter new sequence:
< 9 3 4 7 1
> Sequence verified!
> The final sequence is:
> Launch Pad Clear
> Navigation Setup
> Communication Test
> Crew Boarding
> System Check
> You needed 4 attempts to find the sequence.

Detailed Instructions

We recommend you complete your work on NoMachine, but you can work on your own machine if more convenient as long as you can run the tester on it too. Create a new folder “CS1811Assignment2” for your work. Create all files needed for the questions below in this directory. Make sure to use the stated file names.

Each question will ask you to build a component of the final game. You can run the tester after each question to test your work so far (but you should not rely exclusively on the tester, you should run your program alone too, use temporary main methods when needed).

To submit your work, create a zip file of the CS1811Assignment2 folder and upload it to the submission box below.

You should test your submission using the CS1811 Assignment 2 Testing Tool . Please download the tester file and save it to the same directory where you are working on your assignment. To use the tester, first compile your code, and then run the command below.

$ java -jar cs1811Assignment2TesterStudent.jar

Please refer to CS1811 Formative Coursework for more details on interpreting the output of the tester.

Tip: to test an individual question, the tester has a --test flag that takes a prefix of the test name. E.g. you can run Question 4 tests with

$ java -jar cs1811Assignment2TesterStudent.jar --test testQ4

You should also run your own tests – the tester provided is not exhaustive, meaning you need to take responsibility for the correctness of your code.
