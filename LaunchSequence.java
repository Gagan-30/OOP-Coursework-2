public class LaunchSequence {
    private int[] sequence; // Array representing the sequence

    // Constructor to initialize the sequence
    public LaunchSequence(int[] sequence) {
        this.sequence = sequence;
    }

    // Method to get the size of the sequence
    public int size() {
        return sequence.length;
    }

    // Method to get a procedure at a specific index
    public int getProcedure(int i) {
        if (i >= 0 && i < sequence.length) {
            return sequence[i];
        } else {
            throw new IndexOutOfBoundsException("Index Out of Bounds");
        }
    }

    public int[] getSequence() {
        return sequence;    
    }

    // Override toString to return a space-separated sequence
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sequence.length; i++) {
            sb.append(sequence[i]);
            if (i < sequence.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
