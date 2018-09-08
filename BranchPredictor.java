import java.util.*;

class BranchPredictor {

    private int numberOfEntries;
    private ArrayList<Integer> predictions = null;
    private ArrayList<Branch> resultingBranches;

    BranchPredictor(int numberOfEntries, ArrayList<Branch> resultingBranches) {
        this.numberOfEntries = numberOfEntries;
        this.resultingBranches = resultingBranches;
    }

    public void startPredictionWithInitialPrediction(int initialPrediction) {
        predictions = new ArrayList<>();
        predictions.add(initialPrediction);

        //  Code goes here
        for (int i = 1; i < resultingBranches.size(); i++) {
            predictions.add(1);
        }
    }

    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    public double getMisinterpretationRate() {
        if (predictions.size() != resultingBranches.size()) {
            System.out.println("Please start the prediction before attempting to get the misinterpretaion rate.");
            return 0.0;
        }
        int totalMisinterpretation = 0;
        for (int i = 0; i < resultingBranches.size(); i++) {
            if (resultingBranches.get(i).isTaken() != predictions.get(i)) {
                totalMisinterpretation = totalMisinterpretation + 1;
            }
        }
        return totalMisinterpretation / (double)resultingBranches.size();
    }

}
