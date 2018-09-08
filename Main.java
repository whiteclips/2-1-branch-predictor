import java.util.*;

class Main {

    public static void main(String[] args) {
        ArrayList<Branch> branches = Reader.getBranchesFromFile("history.txt");
        BranchPredictor branchPredictor = new BranchPredictor(4, branches);
        branchPredictor.startPredictionWithInitialPrediction(1);
        System.out.println("Number of BTB entries: " + branchPredictor.getNumberOfEntries());
        System.out.println("Misinterpretation rate: " + branchPredictor.getMisinterpretationRate());
    }

}