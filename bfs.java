import java.io.*;
import java.util.*;
import java.util.ArrayList;

//Ahmet Emirhan Bakkal

public class bfs {
    static int objectNumber;

    public static void main(String[] args) throws IOException {

        // User must enter a file name with .txt extension.
        String fileName = "";
        if (args.length > 0) {
            fileName += args[0];
        }
        String str = "";
        String data = "";

        // Created the value arraylist to save data from input files and created wireless arraylists to put the objects I created.
        ArrayList<String> value = new ArrayList<>();
        ArrayList<Laptop> wireless = new ArrayList<>();

        try {

            FileInputStream fstream = new FileInputStream(fileName);
            DataInputStream dstream = new DataInputStream(fstream);
            BufferedReader breader = new BufferedReader(new InputStreamReader(dstream));

            while ((str = breader.readLine()) != null) {
                if (!str.contains("#")) {
                    value.add(str);
                }
            }
            dstream.close();
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }

        // Total number of objects saved.
        objectNumber = Integer.parseInt(value.get(0));
        String[] DataArray = new String[objectNumber - 1];

        // Txt files were kept without split. Split and put on objects.
        createObjects(value, DataArray, wireless);
        int a = 0;
        int[][] AdjacencyMatrix = new int[objectNumber][objectNumber];
        checkOverlap(wireless, AdjacencyMatrix);
        value.clear();
        hopDistanceWithBFS(AdjacencyMatrix, wireless);
        wireless.clear();
    }

    // The x, y and radius values taken from the file are assigned to the objects in this method and the objects are enumerated.
    public static void createObjects(ArrayList<String> value, String[] DataArray, ArrayList<Laptop> wireless) {
        int a = 0;
        for (int i = 1; i < value.size(); i++) {
            DataArray = value.get(i).split("\\s+");
            for (int j = 0; j < DataArray.length; j++) {
                if (j % 3 == 0) {
                    wireless.add(new Laptop());
                    wireless.get(a).setX(Float.parseFloat(DataArray[j]));
                    wireless.get(a).setlaptopWirelessNumber(a);
                }
                if (j % 3 == 1) {

                    wireless.get(a).setY(Double.parseDouble(DataArray[j]));

                }
                if (j % 3 == 2) {

                    wireless.get(a).setRadius(Double.parseDouble(DataArray[j]));
                    a++;
                }
            }
        }
    }

    // This method calculates the wireless transmission ranges and adjacency matrix values are assigned according to these values.
    // It looks at the position of each laptop with each other while creating the adjacency matrix.
    public static void checkOverlap(ArrayList<Laptop> wireless, int[][] AdjacencyMatrix) {
        double distanceSquare = 0;
        double sumOfRadiusSquare = 0;
        for (int i = 0; i < wireless.size(); i++) {
            for (int j = 0; j < wireless.size(); j++) {
                distanceSquare = (wireless.get(i).getX() - wireless.get(j).getX()) * (wireless.get(i).getX() - wireless.get(j).getX()) + (wireless.get(i).getY() - wireless.get(j).getY()) * (wireless.get(i).getY() - wireless.get(j).getY());
                sumOfRadiusSquare = (wireless.get(i).getRadius() + wireless.get(j).getRadius()) * (wireless.get(i).getRadius() + wireless.get(j).getRadius());

                if (distanceSquare == sumOfRadiusSquare || distanceSquare < sumOfRadiusSquare) {
                    if (distanceSquare != 0) {
                        AdjacencyMatrix[i][j] = 1;
                    }
                } else {
                    AdjacencyMatrix[i][j] = 0;
                }
            }
        }
    }

    // This method calculates the hop distance of each node based on the BFS algorithm.
    public static void hopDistanceWithBFS(int[][] AdjacencyMatrix, ArrayList<Laptop> wireless) {
        int root = 0;
        int control = 0;
        String result = "";
        boolean visited[] = new boolean[objectNumber];

        Queue<Laptop> laptopWireless = new LinkedList<>();
        laptopWireless.add(wireless.get(root));
        visited[root] = true;
        wireless.get(0).setHopDistance(0);
        // Each iteration root gets a new value and the old one is deleted.
        while (laptopWireless.size() != 0) {
            if (control != 0) {
                laptopWireless.remove(root);
            }

            assert laptopWireless.peek() != null;
            root = laptopWireless.peek().getlaptopWirelessNumber();
            laptopWireless.remove();
            control++;
            // Root's neighbors are checked and added to the queue if they haven't been visited.
            for (int i = 0; i < objectNumber; i++) {
                if (AdjacencyMatrix[root][i] == 1 && !visited[i]) {

                    visited[i] = true;
                    laptopWireless.add(wireless.get(i));
                    wireless.get(i).setHopDistance(wireless.get(root).getHopDistance() + 1);

                }
            }
        }

        for (int i = 0; i < objectNumber; i++) {
            System.out.println(wireless.get(i).getHopDistance());
            result = String.valueOf(wireless.get(i).getHopDistance());
            fileWriter(result);
        }
    }

    // This method is involved in printing the output file.
    public static void fileWriter(String hopdistance) {
        File file = new File("output.txt");

        try {
            FileWriter fileWriter = new FileWriter(file, true);
            BufferedWriter bWriter = new BufferedWriter(fileWriter);
            bWriter.write(hopdistance);
            bWriter.newLine();
            bWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}







