public class ProposedSequence {
    private LaunchSequence suggestion; // Suggested sequence
    private LaunchSequence solution;   // Correct solution

    // Constructor to initialize the suggested and solution sequences
    public ProposedSequence(LaunchSequence suggestion, LaunchSequence solution) {
        this.suggestion = suggestion;
        this.solution = solution;
    }

    // Returns the number of correctly positioned procedures
    public int getNumCorrect() {
        int correct = 0;
        int size = Math.min(suggestion.size(), solution.size());
        for (int i = 0; i < size; i++) {
            if (suggestion.getProcedure(i) == solution.getProcedure(i)) {
                correct++;
            }
        }
        return correct;
    }

    // Returns the number of procedures in the wrong position
    public int getNumWrongPosition() {
        int wrongPosition = 0;
        boolean[] suggestionUsed = new boolean[suggestion.size()];
        boolean[] solutionUsed = new boolean[solution.size()];

        // First pass: Count correct positions and mark used elements
        for (int i = 0; i < suggestion.size(); i++) {
            if (suggestion.getProcedure(i) == solution.getProcedure(i)) {
                suggestionUsed[i] = true;
                solutionUsed[i] = true;
            }
        }

        // Second pass: Count misplaced elements (wrong position)
        for (int i = 0; i < suggestion.size(); i++) {
            if (!suggestionUsed[i]) {  // If this procedure wasn't already correctly placed
                for (int j = 0; j < solution.size(); j++) {
                    if (!solutionUsed[j] && suggestion.getProcedure(i) == solution.getProcedure(j)) {
                        wrongPosition++;
                        solutionUsed[j] = true;
                        break;  // Prevent double-counting the same element
                    }
                }
            }
        }
        return wrongPosition;
    }

    public boolean isCorrect() {
        return getNumCorrect() == suggestion.size();  
    }

    // Getter for the suggested sequence
    public LaunchSequence getSequence() {
        return suggestion;
    }

    // Override toString to include the number of correct and wrong positions
    @Override
    public String toString() {
        return suggestion.toString() + " (Correct " + getNumCorrect() + ", Wrong position " + getNumWrongPosition() + ")";
    }
}
