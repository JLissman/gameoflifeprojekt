import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(JUnitParamsRunner.class)
public class CellTest {

    @Test
    @Parameters({
            "ALIVE, 0, DEAD",
            "ALIVE, 1, DEAD",
            "ALIVE, 2, ALIVE",
            "ALIVE, 3, ALIVE",
            "ALIVE, 4, DEAD",
            "ALIVE, 5, DEAD",
            "ALIVE, 6, DEAD",
            "ALIVE, 7, DEAD",
            "ALIVE, 8, DEAD",
            "DEAD, 0, DEAD",
            "DEAD, 1, DEAD",
            "DEAD, 2, DEAD",
            "DEAD, 3, ALIVE",
            "DEAD, 4, DEAD",
            "DEAD, 5, DEAD",
            "DEAD, 6, DEAD",
            "DEAD, 7, DEAD",
            "DEAD, 8, DEAD",
    })
    public void allConditionsFulfilled(String initial, int neighbors, String expected ){

        Cell cell = new Cell(Cell.CellState.valueOf(initial));

        Cell.CellState actual = cell.GetNextState(neighbors);

        assertEquals(Cell.CellState.valueOf(expected), actual);

    }

    @Test
    @Parameters({"ALIVE", "DEAD"})
    public void returnCellState(String initValue){
        Cell cell = new Cell(Cell.CellState.valueOf(initValue));

        assertEquals(Cell.CellState.valueOf(initValue), cell.getState());

    }

}
