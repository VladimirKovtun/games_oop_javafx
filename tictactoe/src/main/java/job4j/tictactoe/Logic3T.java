package job4j.tictactoe;

import java.util.function.Function;
import java.util.function.Predicate;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
            startX += deltaX;
            startY += deltaY;
        }
        return result;
    }

    public boolean isWinner(Predicate<Figure3T> predicate) {
        return this.fillBy(predicate, 0, 0, 1, 0)
                || this.fillBy(predicate, 0, 0, 0, 1)
                || this.fillBy(predicate, 0,0, 1, 1)
                || this.fillBy(predicate, this.table.length - 1, 0, -1, 1)
                || this.fillBy(predicate, this.table.length - 1, this.table.length - 1, 0, -1)
                || this.fillBy(predicate, 0, this.table.length - 1, 1, 0)
                || this.fillBy(predicate, this.table.length - 2, 0, 0, 1)
                || this.fillBy(predicate, 0, this.table.length - 2, 1, 0);
    }


    public boolean isWinnerX() {
        return isWinner(Figure3T::hasMarkX);
        }

    public boolean isWinnerO() {
        return isWinner(Figure3T::hasMarkO);
    }

    public boolean hasGap() {
        boolean rst = true;
        int index = 0;
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (table[i][j].hasMarkO() || table[i][j].hasMarkX()) {
                    index++;
                }
            }
        }
        if (index == table.length * table[0].length) {
            rst = false;
        }

        return rst;
    }
}
