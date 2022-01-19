import org.junit.Test;

import static org.junit.Assert.*;

public class CellTest {



    @Test
    public void IfZeroNeighborsThisDies(){
        Cell cell = new Cell(Cell.CellState.ALIVE);

        Cell.CellState actual = cell.GetNextState(1);

        assertEquals(Cell.CellState.DEAD, actual);
    }

    @Test
    public void IfOneNeighborsThisDies()  {
        Cell cell = new Cell(Cell.CellState.ALIVE);

        Cell.CellState actual = cell.GetNextState(1);

        assertEquals(Cell.CellState.DEAD, actual);
    }

    @Test
    public void IfTwoNeighborsThisLivesOn() {
        Cell cell = new Cell(Cell.CellState.ALIVE);

        Cell.CellState actual = cell.GetNextState(2);

        assertEquals(Cell.CellState.ALIVE, actual);
    }

    @Test
    public void IfThreeNeighborsThisLivesOn() {
        Cell cell = new Cell(Cell.CellState.ALIVE);

        Cell.CellState actual = cell.GetNextState(3);

        assertEquals(Cell.CellState.ALIVE, actual);
    }
    @Test
    public void IfFourNeighborsThisDies() {
        Cell cell = new Cell(Cell.CellState.ALIVE);

        Cell.CellState actual = cell.GetNextState(4);

        assertEquals(Cell.CellState.DEAD, actual);
    }

}
