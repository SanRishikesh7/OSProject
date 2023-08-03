import java.io.*;

public class SPARS {
    // Memory
    private MainMemory M;

    // CPU
    private Cpu cpu;

    // Declare the input file and the output file
    private FileReader input;
    private FileWriter output;

    // Declare the input and output reader
    private BufferedReader inputReader;
    private BufferedWriter outputReader;

    // The buffer to store the data
    private char[] buffer = new char[40];

    // used_memory to store the used memory
    private int used_memory = 0;

    public SPARS(String input, String output) {
        // Initializing the input and output file
        try {
            this.input = new FileReader(input);
            this.output = new FileWriter(output);
            this.inputReader = new BufferedReader(this.input);
            this.outputReader = new BufferedWriter(this.output);
        } catch (Exception e) {
            System.out.println("Error in initializing the input and output file");
        }
    }

    // init Method to initialize everything to zero
    public void init() {
        // Inititalizing the main memory
        System.out.println("Initializing the main memory\n");

        // Initializing the main memory
        this.M = new MainMemory();

        // Initializing the cpu
        this.cpu = new Cpu();
    }

    // LOAD method to load the data from the input file to the main memory
    public void LOAD() {
        String line = "";

        try {
            while ((line = inputReader.readLine()) != null) {
                buffer = line.toCharArray();

                if (buffer[0] == '$' && buffer[1] == 'A' && buffer[2] == 'M' && buffer[3] == 'J') {
                    System.out.println("Program card detected " + buffer[4] + buffer[5] + buffer[6] + buffer[7]);
                    continue;
                } else if (buffer[0] == '$' && buffer[1] == 'D' && buffer[2] == 'T' && buffer[3] == 'A') {
                    System.out.println("Data card detected");
                    continue;
                } else if (buffer[0] == '$' && buffer[1] == 'E' && buffer[2] == 'N' && buffer[3] == 'D') {
                    System.out.println("End card detected\n");
                    printMemory();
                    continue;
                }

                if (used_memory == 100) {
                    System.out.println("Memory is full");
                }

                System.out.println("Loading the instructions to memory");
                char memory[][] = M.getMemory();
                for (int i = 0; i < line.length();) {
                    memory[used_memory][i % 4] = buffer[i];
                    i++;
                    if (i % 4 == 0) {
                        used_memory++;
                    }
                }
                M.setMemory(memory);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Memory is full\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printMemory() {
        char m[][] = M.getMemory();
        System.out.println("Printing the memory...\n");
        // print memory in form of boxes
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 4; j++) {
                if (m[i][j] == 0) {
                    System.out.print(" - ");
                } else {
                    System.out.print(" " + m[i][j] + " ");
                }
                if (j == 3) {
                    System.out.println();
                } else {
                    System.out.print("|");
                }
            }
            System.out.println();
        }
    }
}