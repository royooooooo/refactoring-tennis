package cn.xpbootcamp.tennis;

public class TennisGame2 implements TennisGame {

    private Player player1;
    private Player player2;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public String getGameResult() {
        int player1Score = player1.getScore();
        int player2Score = player2.getScore();
        String gameResult = "";
        if (playerScoreIsSame()) {
            return getGameResultWhenScoreIsSame();
        }

        if (oneScoreIsOver0AndAnotherIs0(player1Score, player2Score) ||
            oneScoreIsOverAnotherButLessThan4(
                player1Score, player2Score)) {
            gameResult +=
                getSpecialGradeByScore(player1Score) + "-" + getSpecialGradeByScore(player2Score);
        }

        if (player1Score > player2Score && player2Score >= 3) {
            gameResult = "Advantage player1";
        }

        if (player2Score > player1Score && player1Score >= 3) {
            gameResult = "Advantage player2";
        }

        if (player1Score >= 4 && player2Score >= 0 && (player1Score - player2Score) >= 2) {
            gameResult = "Win for player1";
        }
        if (player2Score >= 4 && player1Score >= 0 && (player2Score - player1Score) >= 2) {
            gameResult = "Win for player2";
        }
        return gameResult;
    }

    private boolean oneScoreIsOverAnotherButLessThan4(int onePlayerScore, int anotherPlayerScore) {
        return (onePlayerScore > anotherPlayerScore && onePlayerScore < 4) || (
            anotherPlayerScore > onePlayerScore && anotherPlayerScore < 4);
    }

    private boolean oneScoreIsOver0AndAnotherIs0(int onePlayerScore, int anotherPlayerScore) {
        return (onePlayerScore > 0 && anotherPlayerScore == 0) || (anotherPlayerScore > 0
            && onePlayerScore == 0);
    }

    private String getGameResultWhenScoreIsSame() {
        if (player1.getScore() < 3) {
            return getSpecialGradeByScore(player1.getScore()) + "-All";
        }
        return "Deuce";
    }

    private boolean playerScoreIsSame() {
        return player1.getScore() == player2.getScore();
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

    public void wonPoint(String playerName) {
        if (playerName.equals(player1.getName())) {
            player1.wonPoint();
        } else {
            player2.wonPoint();
        }
    }
}