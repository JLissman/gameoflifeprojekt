
import org.junit.Test;


import static org.junit.Assert.*;


import static org.junit.Assert.assertArrayEquals;


public class SimulationTest {

    @Test
    public void StoreInitialState(){
        Cell.CellState[][] origin = new Cell.CellState[][] {
            {Cell.CellState.ALIVE, Cell.CellState.ALIVE, Cell.CellState.DEAD},
            {Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.ALIVE},
            {Cell.CellState.ALIVE, Cell.CellState.DEAD, Cell.CellState.ALIVE}
        };

        Simulation earthC137 = new Simulation(origin);

        Cell.CellState[][] actual = earthC137.getState();

        assertArrayEquals(origin,actual);
    }
    @Test
    public void updateCell(){
        Simulation sim = new Simulation(new Cell.CellState[][]{{ Cell.CellState.ALIVE}});

        sim.update();
        Cell.CellState[][] actualState = sim.getState();

        assertEquals(Cell.CellState.DEAD, actualState[0][0]);

    }

    @Test
    public void updateAllCells(){
        Simulation sim = new Simulation(new Cell.CellState[][]{
                {Cell.CellState.ALIVE, Cell.CellState.ALIVE, Cell.CellState.DEAD},
                {Cell.CellState.ALIVE, Cell.CellState.DEAD, Cell.CellState.DEAD},
                {Cell.CellState.ALIVE, Cell.CellState.ALIVE, Cell.CellState.ALIVE}

        });

        Cell.CellState[][] expectedValue = new Cell.CellState[][]{
                {Cell.CellState.ALIVE, Cell.CellState.ALIVE, Cell.CellState.DEAD},
                {Cell.CellState.DEAD, Cell.CellState.DEAD, Cell.CellState.ALIVE},
                {Cell.CellState.ALIVE, Cell.CellState.ALIVE, Cell.CellState.DEAD}

        };
        sim.update();

        assertArrayEquals(expectedValue, sim.getState());

    }


}
