import java.io.*;
import java.util.*;

class BranchPredictor {

    private ArrayList<Branch> resultingBranches;
    private String predictorKey;
    private HashMap<String, Integer> predictor;
    private ArrayList<Integer> predictions;
    private BranchBuffer branchBuffer;

    BranchPredictor(int numberOfEntries, ArrayList<Branch> resultingBranches) {
        this.resultingBranches = resultingBranches;
        this.predictor = new HashMap<>();
        this.predictions = new ArrayList<>();
        this.branchBuffer = new BranchBuffer(numberOfEntries);
        
        initializePredictor();
    }

    private void initializePredictor() {
        predictorKey = "00";
        predictor.put("00", 0);
        predictor.put("01", 0);
        predictor.put("10", 0);
        predictor.put("11", 0);
    }

    public void startPrediction() {
        System.out.print("Predictor");
        System.out.print("          ");
        System.out.print("Prediction");
        System.out.print("          ");
        System.out.print("Actual");
        System.out.print("          ");
        System.out.print("Result");
        System.out.print("          ");
        System.out.print("Buffer");
        System.out.println();

        for (int i = 0; i < resultingBranches.size(); i++) {
            predictions.add(predictor.get(predictorKey));
            branchBuffer.addToBuffer(resultingBranches.get(i).isTaken());
            prettifyPrintPrediction(i);
            if (branchBuffer.getBufferSize() - 2 >= 0) {
                Integer previous1 = branchBuffer.getElementOfIndex(branchBuffer.getBufferSize() - 2);
                Integer previous2 = branchBuffer.getElementOfIndex(branchBuffer.getBufferSize() - 1);
                predictor.put(predictorKey, previous2);
                predictorKey = "" + previous1 + previous2;
            }

            try {
                System.in.read();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public double getMisinterpretationRate() {
        int totalMisinterpretation = 0;
        for (int i = 0; i < resultingBranches.size(); i++) {
            if (resultingBranches.get(i).isTaken() != predictions.get(i)) {
                totalMisinterpretation = totalMisinterpretation + 1;
            }
        }
        return totalMisinterpretation / (double)resultingBranches.size();
    }

    public void prettifyPrintPrediction(int i) {
        System.out.print("(" + predictorKey + "," + predictor.get("00") + "," + predictor.get("01") + "," + predictor.get("10") + "," + predictor.get("11") + ")");
        System.out.print("          ");
        System.out.print(predictor.get(predictorKey));
        System.out.print("          ");
        System.out.print(resultingBranches.get(i).isTaken());
        System.out.print("          ");
        if (predictor.get(predictorKey) == resultingBranches.get(i).isTaken()) {
            System.out.print("BENAR");
        } else {
            System.out.print("SALAH");
        }
        System.out.print("          ");
        for (int j = 0; j < branchBuffer.getBufferSize(); j++) {
            System.out.print(branchBuffer.getElementOfIndex(j));
        }
        System.out.println();
    }

}
