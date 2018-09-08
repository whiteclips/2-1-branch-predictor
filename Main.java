import java.util.*;

class Main {

    public static void main(String[] args) {
        ArrayList<Branch> branches = Reader.getBranchesFromFile("history.txt");
        for (Branch branch : branches) {
            System.out.println(branch.isTaken());
        }
    }

}