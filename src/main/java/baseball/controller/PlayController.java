package baseball.controller;

import baseball.dto.Game;
import camp.nextstep.edu.missionutils.Console;
import baseball.service.PlayService;

public class PlayController {
    public static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private PlayService playService = new PlayService();
    private Game game;

    public void play() {
        boolean continueGame = true;
        do {
            game = new Game();
            continueGame = playService.playGame(game.getAnswer());
        } while (continueGame);
    }

}
