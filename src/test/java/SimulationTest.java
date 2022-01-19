
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;


public class SimulationTest {

    @Test
    public void shouldStoreInitialState(){
        Cell.CellState[][] origin = new Cell.CellState[][] {
            {Cell.CellState.ALIVE, Cell.CellState.ALIVE, Cell.CellState.DEAD},
            {Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.ALIVE},
            {Cell.CellState.ALIVE, Cell.CellState.DEAD, Cell.CellState.ALIVE}
        };


        Simulation earthC137 = new Simulation(origin);

        Cell.CellState[][] actual = earthC137.getState();

        assertArrayEquals(origin,actual);
    }

}
