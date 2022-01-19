import org.junit.Test;

import static org.junit.Assert.*;

public class CellTest {

    @Test
    public void IfOneNeighborThisDies()  {
        Cell cell = new Cell(Cell.CellState.ALIVE);

        Cell.CellState actual = cell.GetNextState(1);

        assertEquals(Cell.CellState.DEAD, actual);
    }

}
