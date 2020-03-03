package cn.xpbootcamp.tennis;

public class TennisGame1 implements TennisGame {

    private Player player1;
    private Player player2;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1.getName())) {
            player1.wonPoint();
        } else {
            player2.wonPoint();
        }
    }

    public String getScore() {
        if (playerScoreIsSame()) {
            return getGameResultWhenScoreIsSame();
        }
        if (anyPlayerScoreOverFourPoint()) {
            return getGameResultWhenAnyPlayerScoreOverFourPoint();
        }
        return getGameResultWhenNormalWay();
    }

    private String getGameResultWhenNormalWay() {
        StringBuilder score = new StringBuilder();
        int tempScore;
        for (int i = 1; i < 3; i++) {
            if (i == 1) {
                tempScore = player1.getScore();
            } else {
                score.append("-");
                tempScore = player2.getScore();
            }
            switch (tempScore) {
                case 0:
                    score.append("Love");
                    break;
                case 1:
                    score.append("Fifteen");
                    break;
                case 2:
                    score.append("Thirty");
                    break;
                case 3:
                    score.append("Forty");
                    break;
            }
        }
        return score.toString();
    }

    private String getGameResultWhenAnyPlayerScoreOverFourPoint() {
        int minusResult = player1.getScore() - player2.getScore();
        if (minusResult == 1) {
            return ("Advantage player1");
        }
        if (minusResult == -1) {
            return ("Advantage player2");
        }
        if (minusResult >= 2) {
            return ("Win for player1");
        }
        return ("Win for player2");
    }

    private String getGameResultWhenScoreIsSame() {
        switch (player1.getScore()) {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            default:
                return "Deuce";
        }
    }

    private boolean anyPlayerScoreOverFourPoint() {
        return player1.getScore() >= 4 || player2.getScore() >= 4;
    }

    private boolean playerScoreIsSame() {
        return player1.getScore() == player2.getScore();
    }
}