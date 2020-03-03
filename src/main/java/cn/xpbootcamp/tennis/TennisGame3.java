package cn.xpbootcamp.tennis;

public class TennisGame3 implements TennisGame {

    private Player player1;
    private Player player2;

    public TennisGame3(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public String getGameResult() {
        if (isSameScore()) {
            return getGameResultWhenScoreIsSame();
        }

        if (noWinnerAndAdvantage()) {
            return getSpecialGradeByScore(player1.getScore()) + "-" + getSpecialGradeByScore(
                player2.getScore());
        }

        String highestScorePlayerName =
            player1.getScore() > player2.getScore() ? player1.getName() : player2.getName();

        if (onePlayerIsAdvantage()) {
            return "Advantage " + highestScorePlayerName;
        }
        return "Win for " + highestScorePlayerName;
    }

    private boolean noWinnerAndAdvantage() {
        return player1.getScore() < 4 && player2.getScore() < 4 && !(
            player1.getScore() + player2.getScore() == 6);
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

    private boolean onePlayerIsAdvantage() {
        return (player1.getScore() - player2.getScore()) * (player1.getScore() - player2.getScore()) == 1;
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