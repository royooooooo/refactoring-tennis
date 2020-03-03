package cn.xpbootcamp.tennis;

public class TennisGame2 implements TennisGame {

    public int P1point = 0;
    public int P2point = 0;

    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getGameResult() {
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
        if (P1point < 3) {
            return getSpecialGradeByScore(P1point) + "-All";
        }
        return "Deuce";
    }

    private boolean playerScoreIsSame() {
        return P1point == P2point;
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

    public void P1Score() {
        P1point++;
    }

    public void P2Score() {
        P2point++;
    }

    public void wonPoint(String player) {
        if (player.equals("player1")) {
            P1Score();
        } else {
            P2Score();
        }
    }
}