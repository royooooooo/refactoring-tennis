package cn.xpbootcamp.tennis;

public class TennisGame3 implements TennisGame {

    private Player player1;
    private Player player2;

    public TennisGame3(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public String getGameResult() {
        String s;
        int player1Score = player1.getScore();
        int player2Score = player2.getScore();
        if (isSameScore()) {
            return getGameResultWhenScoreIsSame();
        }

        if (player1Score < 4 && player2Score < 4 && !(player1Score + player2Score == 6)) {
            return getSpecialGradeByScore(player1Score) + "-" + getSpecialGradeByScore(
                player2Score);
        }

        String winOrAdvantagePlayerName =
            player1Score > player2Score ? player1.getName() : player2.getName();

        if (onePlayerIsAdvantage(player1Score, player2Score)) {
            return "Advantage " + winOrAdvantagePlayerName;
        }
        return "Win for " + winOrAdvantagePlayerName;
    }

    private String getGameResultWhenScoreIsSame() {
        if (player1.getScore() < 3) {
            return getSpecialGradeByScore(player1.getScore()) + "-All";
        }
        return "Deuce";
    }

    private boolean isSameScore() {
        return player1.getScore() == player2.getScore();
    }

    private boolean onePlayerIsAdvantage(int player1Score, int player2Score) {
        return (player1Score - player2Score) * (player1Score - player2Score) == 1;
    }

    public void wonPoint(String playerName) {
        if (playerName.equals(player1.getName())) {
            player1.wonPoint();
        } else {
            player2.wonPoint();
        }

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

}