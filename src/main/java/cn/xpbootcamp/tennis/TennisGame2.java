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
        if (playerScoreIsSame()) {
            return getGameResultWhenScoreIsSame();
        }

        if (player1Score >= 4 && player2Score >= 0 && (player1Score - player2Score) >= 2) {
            return "Win for player1";
        }
        if (player2Score >= 4 && player1Score >= 0 && (player2Score - player1Score) >= 2) {
            return "Win for player2";
        }

        if (player1Score > player2Score && player2Score >= 3) {
            return "Advantage player1";
        }

        if (player2Score > player1Score && player1Score >= 3) {
            return "Advantage player2";
        }

        return
            getSpecialGradeByScore(player1Score) + "-" + getSpecialGradeByScore(player2Score);

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