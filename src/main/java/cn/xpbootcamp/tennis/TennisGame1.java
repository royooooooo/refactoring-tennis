package cn.xpbootcamp.tennis;

public class TennisGame1 implements TennisGame {

    private int player1Score = 0;
    private int player2Score = 0;

    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getPlayer1Name() {
        return player1Name;
    }

    public String getPlayer2Name() {
        return player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1Name)) {
            player1Score += 1;
        } else {
            player2Score += 1;
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
                tempScore = player1Score;
            } else {
                score.append("-");
                tempScore = player2Score;
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
        int minusResult = player1Score - player2Score;
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
        switch (player1Score) {
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
        return player1Score >= 4 || player2Score >= 4;
    }

    private boolean playerScoreIsSame() {
        return player1Score == player2Score;
    }
}