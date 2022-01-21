import java.io.IOException;

public class letsCheckIt {
    public static void main(String[] args) {


        Cell.CellState[][] glider = new Cell.CellState[][] {
                {Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD},
                {Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.ALIVE, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD},
                {Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.ALIVE, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD},
                {Cell.CellState.DEAD, Cell.CellState.ALIVE, Cell.CellState.ALIVE, Cell.CellState.ALIVE, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD},
                {Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD},
                {Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD},
                {Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD},
                {Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD},
                {Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD},
                {Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD},
                {Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD},
                {Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.DEAD}
        };

        Simulation earthC137 = new Simulation(glider);

        try {
            letGenerationsPass(250,earthC137);
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }

    }

    public static void showMeUniverse(Simulation sim){
        int count;
        String prettierState;
        for (Cell.CellState[] cellRow:sim.getState()
        ) {
            count = 0;
            for (Cell.CellState cell:cellRow
            ) {
                if (cell == Cell.CellState.ALIVE){
                    prettierState = "X";
                }else{
                    prettierState = "O";
                }
                if(count==cellRow.length-1){
                    System.out.println(prettierState);
                }else{
                    System.out.print(prettierState+" - ");
                }
                count++;
            }
        }
        System.out.println("---------");

    }
    public static void letGenerationsPass(int numOfGenerations, Simulation sim) throws InterruptedException, IOException {
        for (int i = 0; i < numOfGenerations; i++) {
            showMeUniverse(sim);
            sim.update();
            Thread.sleep(400);
        }
    }


}
