import java.util.Random;

public class SequencePlanner {
    
    private class Node {
        ProposedSequence data;
        Node next;

        public Node(ProposedSequence data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            StringBuilder result = new StringBuilder();
            Node current = this;
            while (current != null) {
                result.append(current.data.toString()).append("\n");
                current = current.next;
            }
            return result.toString();
        }
    }

    private LaunchSequence solution;
    private Node head;               

    public SequencePlanner(LaunchSequence solution) {
        this.solution = solution;
        this.head = null;
    }

    public SequencePlanner() {
        this.solution = generateRandomSolution();
        this.head = null;    
    }

    private LaunchSequence generateRandomSolution() {
        Random rand = new Random();
        int[] solutionArray = new int[5];
        int count = 0;
    
        while (count < 5) {
            int procedure = rand.nextInt(9) + 1; // Random number between 1 and 9
            
            // Check if the procedure is already in the array
            boolean isDuplicate = false;
            for (int i = 0; i < count; i++) {
                if (solutionArray[i] == procedure) {
                    isDuplicate = true;
                    break;
                }
            }
    
            // If it's not a duplicate, add it to the array
            if (!isDuplicate) {
                solutionArray[count] = procedure;
                count++;
            }
        }

        // Return the LaunchSequence object
        return new LaunchSequence(solutionArray);
    }

    public boolean checkProposedSequence(LaunchSequence sequence) {
        ProposedSequence proposed = new ProposedSequence(sequence, solution);
        Node newNode = new Node(proposed);

        newNode.next = head;
        head = newNode;

        return proposed.isCorrect();
    }

    public String getPreviousSuggestions() {
        return head == null ? null : head.toString();
    }

    public LaunchSequence getSolution() {
        return solution;
    }

}
