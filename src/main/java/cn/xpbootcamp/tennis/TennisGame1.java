package cn.xpbootcamp.tennis;

public class TennisGame1 implements TennisGame {

    private Player player1;
    private Player player2;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1.getName())) {
            player1.wonPoint();
        } else {
            player2.wonPoint();
        }
    }

    public String getGameResult() {
        if (playerScoreIsSame()) {
            return getGameResultWhenScoreIsSame();
        }
        if (anyPlayerScoreOverFourPoint()) {
            return getGameResultWhenAnyPlayerScoreOverFourPoint();
        }
        return getGameResultWhenNormalWay();
    }

    private String getGameResultWhenNormalWay() {
        return getSpecialGradeByScore(player1.getScore()) + "-" + getSpecialGradeByScore(
            player2.getScore());
    }

    private String getSpecialGradeByScore(int score) {
        switch (score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return "";
        }
    }

    private String getGameResultWhenAnyPlayerScoreOverFourPoint() {
        int minusResult = player1.getScore() - player2.getScore();
        if (minusResult == 1) {
            return "Advantage player1";
        }
        if (minusResult == -1) {
            return "Advantage player2";
        }
        if (minusResult >= 2) {
            return "Win for player1";
        }
        return "Win for player2";
    }

    private String getGameResultWhenScoreIsSame() {
        int currentScore = player1.getScore();
        if (currentScore < 3) {
            return getSpecialGradeByScore(currentScore) + "-All";
        }
        return "Deuce";
    }

    private boolean anyPlayerScoreOverFourPoint() {
        return player1.getScore() >= 4 || player2.getScore() >= 4;
    }

    private boolean playerScoreIsSame() {
        return player1.getScore() == player2.getScore();
    }
}