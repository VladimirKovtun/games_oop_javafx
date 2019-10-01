package ru.job4j.chess;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.white.BishopWhite;

public class LogicTest {

    @Test
    public void whenMoveFalse() {
        Logic logic = new Logic();
        Figure blackBishop = new BishopBlack(Cell.A1);
        Figure figure = new BishopWhite(Cell.D4);
        logic.add(blackBishop);
        logic.add(figure);
        boolean move = logic.move(blackBishop.position(), Cell.D4);
        Assert.assertFalse(move);
    }

    @Test
    public void whenMoveFalseAgain() {
        Logic logic = new Logic();
        Figure blackBishop = new BishopBlack(Cell.A1);
        Figure figure = new BishopWhite(Cell.D4);
        logic.add(blackBishop);
        logic.add(figure);
        boolean move = logic.move(blackBishop.position(), Cell.E5);
        Assert.assertFalse(move);
    }

    @Test
    public void whenMoveNotDiagonalThenFalse() {
        Logic logic = new Logic();
        Figure blackBishop = new BishopBlack(Cell.A1);
        Figure figure = new BishopWhite(Cell.D4);
        logic.add(blackBishop);
        logic.add(figure);
        boolean move = logic.move(blackBishop.position(), Cell.D5);
        Assert.assertFalse(move);
    }

    @Test
    public void whenMoveTrue() {
        Logic logic = new Logic();
        Figure blackBishop = new BishopBlack(Cell.A1);
        Figure figure = new BishopWhite(Cell.E5);
        logic.add(blackBishop);
        logic.add(figure);
        boolean move = logic.move(blackBishop.position(), Cell.D4);
        Assert.assertTrue(move);
    }
}
