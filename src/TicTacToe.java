// Importing libreries
import java.util.*;

// Creating class with name file
public class TicTacToe {

    // Creating two variables [ playerPosition and cpuPosition ].
    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

    // Create main function
    public static void main(String[] args) {

        // Write TicTacToe map
        char[] [] gameBoard = {
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        // Link to function for draw map
        printGameBoard(gameBoard);

        // Creating main cycle
        while (true) {
            // Getting player number on input
            Scanner scan = new Scanner(System.in);
            System.out.print("Enter your placement (1-9): ");
            int playerPos = scan.nextInt();

            // Get tru pl position
            while (playerPositions.contains(playerPos) || cpuPositions.contains(playerPositions)) {
                System.out.println("Position taken! Enter a correct position:");
                playerPos = scan.nextInt();
            }

            System.out.println(playerPos);

            // Function for writing pl symbol
            placePiece(gameBoard, playerPos, "player");

            // Check result
            String result = checkWinner();
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }

            // Get random number
            Random rand = new Random();
            int cpuPos = rand.nextInt(9) + 1;
            while (playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)) {
                cpuPos = rand.nextInt(9) + 1;
            }
            // Get and set cpu position
            placePiece(gameBoard, cpuPos, "cpu");

            // Draw in console map
            printGameBoard(gameBoard);

            result = checkWinner();

            if (result.length() > 0) {
                System.out.println(result);
                break;
            }
        }

    }

    // Function for draw map
    public static void printGameBoard(char[] [] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    // Function for set symbol player and cpu
    public static void placePiece(char[] [] gameBoard, int pos, String user) {

        char symbol = ' ';

        if (user.equals("player")) {
            symbol = 'X';
            playerPositions.add(pos);
        } else if (user.equals("cpu")) {
            symbol = '0';
            cpuPositions.add(pos);
        }

        // check what number is inputed
        switch (pos) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;
        }
    }

    // Function for check result
    public static String checkWinner() {
        // Rows
        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);
        // Colums
        List leftCol = Arrays.asList(1, 4, 7);
        List midCol = Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);
        // Cross
        List cross1 = Arrays.asList(1, 5, 9);
        List cross2 = Arrays.asList(7, 5, 3);

        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(cross1);
        winning.add(cross2);

        for (List l : winning) {
            if (playerPositions.containsAll(l)) {
                return "Congratulations you won!";
            } else if (cpuPositions.containsAll(l)) {
                return "CPU wins! Sorry :(";
            } else if (playerPositions.size() + cpuPositions.size() == 9) {
                return "CAT!";
            }
        }

        return "";
    }
}
