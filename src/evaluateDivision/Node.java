package evaluateDivision;

import java.util.ArrayList;
import java.util.HashMap;

public class Node {
    public String val;
    public HashMap<String, Double> neighbor;
    public Node(String val, HashMap<String, Double> neighbor){
        this.val = val;
        this.neighbor = neighbor;
    }
}
