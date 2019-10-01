package ru.job4j.chess.figures.black;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;

public class BishopBlackTest {

    @Test
    public void whenCopyIsTrue() {
        Figure bishopBlack = new BishopBlack(Cell.C7);
        Figure copy = bishopBlack.copy(Cell.A1);
        Assert.assertThat(copy.position(), Is.is(Cell.A1));
    }

    @Test
    public void whenPositionBornisTrue() {
        Figure bishopBlack = new BishopBlack(Cell.A1);
        Assert.assertThat(bishopBlack.position(), Is.is(Cell.A1));
    }

    @Test
    public void whenFigureWayisCorrect() {
        Figure bishopBlack = new BishopBlack(Cell.B1);
        Cell[] resultWay = bishopBlack.way(bishopBlack.position(), Cell.H7);
        Cell[] expectWay = {Cell.C2, Cell.D3, Cell.E4, Cell.F5, Cell.G6, Cell.H7};
        Assert.assertThat(resultWay, Is.is(expectWay));

    }

    @Test(expected = IllegalStateException.class)
    public void whenFigureWayIsNotCorrectThenException() {
        Figure bishopBlack = new BishopBlack(Cell.G1);
        bishopBlack.way(bishopBlack.position(), Cell.D3);

    }

    @Test
    public void whenNotDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F1);
        boolean diagonal = bishopBlack.isDiagonal(bishopBlack.position(), Cell.E1);
        Assert.assertFalse(diagonal);
    }
}
