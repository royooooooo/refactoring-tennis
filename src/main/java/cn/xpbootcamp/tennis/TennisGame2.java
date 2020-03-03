package cn.xpbootcamp.tennis;

public class TennisGame2 implements TennisGame {

    private Player player1;
    private Player player2;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1 = new Player(player1Name);
        this.player2 = new Player(player2Name);
    }

    public String getGameResult() {
        int P1point = player1.getScore();
        int P2point = player2.getScore();
        String score = "";
        if (playerScoreIsSame()) {
            return getGameResultWhenScoreIsSame();
        }

        if (oneScoreIsOver0AndAnotherIs0(P1point, P2point)) {
            score += getSpecialGradeByScore(P1point) + "-" + getSpecialGradeByScore(P2point);
        }

        if (oneScoreIsOverAnotherButLessThan4(
            P1point, P2point)) {
            score = getSpecialGradeByScore(P1point) + "-" + getSpecialGradeByScore(P2point);
        }

        if (P1point > P2point && P2point >= 3) {
            score = "Advantage player1";
        }

        if (P2point > P1point && P1point >= 3) {
            score = "Advantage player2";
        }

        if (P1point >= 4 && P2point >= 0 && (P1point - P2point) >= 2) {
            score = "Win for player1";
        }
        if (P2point >= 4 && P1point >= 0 && (P2point - P1point) >= 2) {
            score = "Win for player2";
        }
        return score;
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