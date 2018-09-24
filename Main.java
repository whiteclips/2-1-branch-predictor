import java.util.*;

class Main {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please provide the length of the buffer.");
            return;
        }
        if (Integer.parseInt(args[0]) < 2) {
            System.out.println("In order for this (2,1) Branch Predictor to work, the minimum length of buffer is 2.");
            return;
        }
        ArrayList<Branch> branches = Reader.getBranchesFromFile("history.txt");
        BranchPredictor branchPredictor = new BranchPredictor(Integer.parseInt(args[0]), branches);
        branchPredictor.startPrediction();
        System.out.println("Misinterpretation rate: " + branchPredictor.getMisinterpretationRate());
    }

}