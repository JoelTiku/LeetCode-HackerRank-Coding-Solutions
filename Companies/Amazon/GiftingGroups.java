import java.util.Arrays;
import java.util.List;

public class GiftingGroups {

    public static int countGroups(List<String> related) {

        int matrix[][] = new int[related.size()][related.size()];

        for (int i = 0; i < related.size(); i++) {

            String rows = related.get(i);

            for (int j = 0; j < rows.length(); j++) {
                matrix[i][j] = Integer.parseInt(Character.toString(rows.charAt(j)));
                
                System.out.print(matrix[i][j] +  " ");
            }

            System.out.println("");
        }

        boolean visited[] = new boolean[matrix.length];
        int numberOfGroups = 0;

        for (int i = 0; i < matrix.length; i++) {

            if (!visited[i]) {
                DFSHelper(matrix, visited, i);
                numberOfGroups++;
            }
        }

        return numberOfGroups;

    }

    private static void DFSHelper(int[][] graph, boolean[] visitedNodes, int currentNode) {
        visitedNodes[currentNode] = true;

        for (int neighborNode = 0; neighborNode < graph.length; neighborNode++) {
            if (graph[currentNode][neighborNode] == 1 && !visitedNodes[neighborNode]) {
                DFSHelper(graph, visitedNodes, neighborNode);
            }
        }
    }


    public static void main(String[] args) {

        String strArray1[] = { "110", "110", "011" }; // 2

        List<String> arrayList1 = Arrays.asList(strArray1);

        int result1 = countGroups(arrayList1);
        System.out.println("\n" + "The number of groups = " + result1);

        System.out.println("----------------------");


        String strArray2[] = { "1100", "1110", "0110", "0001" }; // 2

        List<String> arrayList2 = Arrays.asList(strArray2);

        int result2 = countGroups(arrayList2);
        System.out.println("\n" + "The number of groups = " + result2);

        System.out.println("----------------------");


        String strArray3[] = { "10000", "01000", "00100", "00010", "00001" }; // 5

        List<String> arrayList3 = Arrays.asList(strArray3);

        int result3 = countGroups(arrayList3);
        System.out.println("\n" + "The number of groups = " + result3);

        System.out.println("----------------------");
    }
}