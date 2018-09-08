import java.io.*;
import java.util.*;

class Reader {

    public static ArrayList<Branch> getBranchesFromFile(String filename) {
        BufferedReader br = null;
		FileReader fr = null;
        ArrayList<Branch> branches = new ArrayList<>();

		try {
			fr = new FileReader(filename);
			br = new BufferedReader(fr);
			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				String[] strings = sCurrentLine.split(" ");
                Branch branch = new Branch(strings[0], strings[1], Integer.valueOf(strings[2]));
                branches.add(branch);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

        return branches;
    }
}