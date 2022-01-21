



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
        Cell.CellState[][] cellStates = new Cell.CellState[state.length][];
        for (int rad = 0; rad < state.length; rad++) {
            cellStates[rad] = new Cell.CellState[state[rad].length];
            for (int kolumn = 0; kolumn < state[rad].length; kolumn++) {
                cellStates[rad][kolumn] = state[rad][kolumn].getState();
                
            }
        }
        return cellStates;
    }

    public void update() {
        for (int rad = 0; rad < state.length; rad++) {
            for (int kolumn = 0; kolumn < state[rad].length; kolumn++) {
                int aliveNeighbors = getNumberOfAliveNeighbors();
                state[rad][kolumn].setState(state[rad][kolumn].getNextState(aliveNeighbors));

            }
        }
    }

    private int getNumberOfAliveNeighbors() {
        return 0;
    }
}
