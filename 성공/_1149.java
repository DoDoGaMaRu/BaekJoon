import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1149 {
    static final int RED = 0;
    static final int GREEN = 1;
    static final int BLUE = 2;

    static int[][] costTable;
    static int[][] minCostTable;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        makeCostTable(br);
        minCostTable = new int[costTable.length][3];
        minCostTable[0][RED] = costTable[0][RED];
        minCostTable[0][GREEN] = costTable[0][GREEN];
        minCostTable[0][BLUE] = costTable[0][BLUE];

        int lastIdx = costTable.length - 1;

        System.out.print(Math.min(getMinCost(lastIdx, RED), Math.min(getMinCost(lastIdx, GREEN), getMinCost(lastIdx, BLUE))));
    }

    public static int getMinCost(int idx, int color) {
        if (minCostTable[idx][color] == 0) {
            switch(color) {
                case RED :
                    minCostTable[idx][RED] = Math.min(getMinCost(idx - 1, GREEN), getMinCost(idx - 1, BLUE)) + costTable[idx][RED];
                    break;
                case GREEN:
                    minCostTable[idx][GREEN] = Math.min(getMinCost(idx - 1, RED), getMinCost(idx - 1, BLUE)) + costTable[idx][GREEN];
                    break;
                case BLUE:
                    minCostTable[idx][BLUE] = Math.min(getMinCost(idx - 1, RED), getMinCost(idx - 1, GREEN)) + costTable[idx][BLUE];
                    break;
            }
        }
        return minCostTable[idx][color];
    }

    public static void makeCostTable(BufferedReader br) throws IOException {
        costTable = new int[Integer.parseInt(br.readLine())][3];
        for (int i = 0; i < costTable.length; i++) {
            int price[] = new int[3];
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                price[j] = Integer.parseInt(str[j]);
            }
            costTable[i] = price;
        }
    }
}