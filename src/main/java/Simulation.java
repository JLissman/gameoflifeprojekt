



public class Simulation {

    private Cell[][] state;


    public Simulation(Cell.CellState[][] cellStates){
        state = new Cell[cellStates.length][];
        for (int rad = 0; rad < cellStates.length; rad++) {
            state[rad] = new Cell[cellStates[rad].length];
            for (int kolumn = 0; kolumn < cellStates[rad].length; kolumn++) {
                state[rad][kolumn] = new Cell(cellStates[rad][kolumn]);
            }
        }
    }

    public Cell.CellState[][] getState(){
        return null;
    }
}
