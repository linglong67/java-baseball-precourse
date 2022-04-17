package baseball;

import baseball.dto.Game;
import baseball.controller.PlayController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Game game = new Game();
        PlayController playController = new PlayController();

        boolean continueGame = true;
        do {
            continueGame = playController.play();
        } while (continueGame);

    }
}
