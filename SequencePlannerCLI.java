import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SequencePlannerCLI {

    public static void main(String[] args) {
        // Create a new SequencePlanner object with a random solution
        SequencePlanner sequencePlanner = new SequencePlanner();
        runSimulation(sequencePlanner);
    }

    public static void runSimulation(SequencePlanner sequencePlanner) {
        Scanner scanner = new Scanner(System.in);
        int attempts = 0;
        List<String> previousAttempts = new ArrayList<>();

        while (true) {
            // Print previous attempts
            System.out.println("Previous attempts:");
            if (previousAttempts.isEmpty()) {
                System.out.println("No previous attempts");
            } else {
                for (String attempt : previousAttempts) {
                    System.out.println(attempt);
                }
            }

            // Prompt user for a new sequence
            System.out.println("Enter new sequence:");
            String input = scanner.nextLine().trim();

            // Validate the input and convert it to an array
            String[] inputs = input.split(" ");
            if (inputs.length != 5) {
                System.out.println("Invalid sequence! Please enter exactly 5 integers.");
                continue;  // Skip to next iteration
            }

            // Convert input to an array of integers
            int[] sequence = new int[5];
            boolean isValid = true;
            for (int i = 0; i < 5; i++) {
                try {
                    sequence[i] = Integer.parseInt(inputs[i]);
                    if (sequence[i] < 1 || sequence[i] > 9) {
                        isValid = false;
                        break;
                    }
                } catch (NumberFormatException e) {
                    isValid = false;
                    break;
                }
            }

            // Check for invalid sequence
            if (!isValid) {
                System.out.println("Invalid sequence! All numbers must be between 1 and 9.");
                continue;  // Skip to next iteration
            }

            // Add current attempt to the previous attempts list
            String attemptString = String.join(" ", inputs);
            previousAttempts.add(attemptString);

            // Check if the proposed sequence is correct
            attempts++;
            boolean isCorrect = sequencePlanner.checkProposedSequence(new LaunchSequence(sequence));

            // Provide feedback
            ProposedSequence proposed = new ProposedSequence(new LaunchSequence(sequence), sequencePlanner.getSolution());
            System.out.println("Correct " + proposed.getNumCorrect() + ", Wrong position " + proposed.getNumWrongPosition());

            // If the sequence is correct, end the loop
            if (isCorrect) {
                System.out.println("Sequence verified!");
                printProcedureNames(new LaunchSequence(sequence));
                System.out.println("You needed " + attempts + " attempts to find the sequence.");
                break;
            }
        }
    }

    // Print procedure names based on the sequence
    private static void printProcedureNames(LaunchSequence sequence) {
        String[] procedureNames = {
            "Launch Pad Clear", "Navigation Setup", "Communication Test",
            "Crew Boarding", "System Check", "Fueling", "Mission Briefing",
            "Spacecraft Inspection", "Countdown"
        };

        for (int i = 0; i < sequence.size(); i++) {
            int procedureCode = sequence.getProcedure(i);
            System.out.println(procedureNames[procedureCode - 1]);
        }
    }
}
