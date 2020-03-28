import java.util.Random;

public class AI extends AGamer
{
    MainGameField gameField;
    String playerSign = "";
    static int aiLevel = 0;

    public AI(String sign, int aiLevel, String playerSign) {
        this.sign = sign;
        this.playerSign = playerSign;
        this.aiLevel = aiLevel;
    }

    boolean shot(int x, int y) {
        gameField = MainGameField.getInstance();
        x = -1;
        y = -1;
        boolean aiWin = false;
        boolean userWin = false;
        // Знаходимо виграшний хід
        if (aiLevel == 2) {
            for (int i = 0; i < gameField.linesCount; i++) {
                for (int j = 0; j < gameField.linesCount; j++) {
                    if (!gameField.isCellBusy(i, j)) {
                        gameField.cell[i][j] = sign;
                        if (gameField.checkWin(sign)) {
                            x = i;
                            y = j;
                            aiWin = true;
                        }
                        gameField.cell[i][j] = gameField.NOT_SIGN;
                    }
                }
            }
        }
        // Блокування ходу користувача, якщо він перемагає на наступному ході
        if (aiLevel > 0) {
            if (!aiWin) {
                for (int i = 0; i < gameField.linesCount; i++) {
                    for (int j = 0; j < gameField.linesCount; j++) {
                        if (!gameField.isCellBusy(i, j)) {
                            gameField.cell[i][j] = this.playerSign;
                            if (gameField.checkWin(this.playerSign)) {
                                x = i;
                                y = j;
                                userWin = true;
                            }
                            gameField.cell[i][j] = gameField.NOT_SIGN;
                        }
                    }
                }
            }
        }
        if (!aiWin && !userWin) {
            do {
                Random rnd = new Random();
                x = rnd.nextInt(gameField.linesCount);
                y = rnd.nextInt(gameField.linesCount);
            }
            while (gameField.isCellBusy(x, y));
        }
        gameField.cell[x][y] = sign;
        return true;
    }

    boolean win() {
        gameField = MainGameField.getInstance();
        return gameField.checkWin(this.sign);
    }
}
