



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
        Cell.CellState[][] copyofStates = getState();
        for (int rad = 0; rad < state.length; rad++) {
            for (int kolumn = 0; kolumn < state[rad].length; kolumn++) {
                int aliveNeighbors = getNumberOfAliveNeighbors(copyofStates, rad, kolumn);
                state[rad][kolumn].setState(state[rad][kolumn].getNextState(aliveNeighbors));

            }
        }
    }

    private int getNumberOfAliveNeighbors(Cell.CellState[][] state, int rad, int kolumn) {

        int aliveNeighbors = 0;
         if (rad > 0){
            int radOver = rad - 1;
            if (kolumn > 0){

                if(state[radOver][kolumn - 1] == Cell.CellState.ALIVE) aliveNeighbors++;
            }
            if(state[radOver][kolumn] == Cell.CellState.ALIVE) aliveNeighbors++;
            if(kolumn < state[rad].length - 1){
                if(state[radOver][kolumn + 1] == Cell.CellState.ALIVE)aliveNeighbors++;
            }
        }
        if (rad < state.length - 1){
            int radUnder = rad + 1;
            if (kolumn > 0){
                if(state[radUnder][kolumn -1] == Cell.CellState.ALIVE) aliveNeighbors++;
            }
            if(state[radUnder][kolumn] == Cell.CellState.ALIVE) aliveNeighbors++;
            if(kolumn < state[rad].length - 1){
                if(state[radUnder][kolumn + 1] == Cell.CellState.ALIVE)aliveNeighbors++;
            }
        }

        if(kolumn > 0){
            if(state[rad][kolumn-1] == Cell.CellState.ALIVE) aliveNeighbors++;
        }
        if(kolumn < state[rad].length -1){
            if(state[rad][kolumn+1] == Cell.CellState.ALIVE) aliveNeighbors++;

        }
        //System.out.println("DEBUG - rad:"+rad+" kolumn:"+kolumn+" state:"+ this.state[rad][kolumn].getState() +" levande:"+aliveNeighbors);
        return aliveNeighbors;
    }
}
