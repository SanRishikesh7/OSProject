import java.util.Arrays;

public class Cpu {
    // Instruction register
    private int[] IR = new int[4];

    // toggle
    private boolean C = false;

    // Instruction counter
    private int[] IC = new int[2];

    // General purpose Register
    private int[] R = new int[4];

    // Constructor
    public Cpu() {
        // Instruction register
        Arrays.fill(IR, 0);

        // toggle
        this.C = false;

        // Instruction counter
        Arrays.fill(IC, 0);

        // General purpose register
        Arrays.fill(R, 0);
    }

    // getter for the instruction register
    public int[] getIR() {
        return this.IR;
    }

    // setter for the instruction register
    public void setIR(int[] IR) {
        this.IR = IR;
    }

    // getter for the toggle
    public boolean getC() {
        return this.C;
    }

    // setter for the toggle
    public void setC(boolean C) {
        this.C = C;
    }

    // getter for the instruction counter
    public int[] getIC() {
        return this.IC;
    }

    // setter for the instruction counter
    public void setIC(int[] IC) {
        this.IC = IC;
    }
}
