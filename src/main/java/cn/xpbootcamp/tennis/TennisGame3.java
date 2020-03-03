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
        if (player1Score < 4 && player2Score < 4 && !(player1Score + player2Score == 6)) {
            String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
            s = p[player1Score];
            return (player1Score == player2Score) ? s + "-All" : s + "-" + p[player2Score];
        } else {
            if (player1Score == player2Score) {
                return "Deuce";
            }
            s = player1Score > player2Score ? player1.getName() : player2.getName();
            return ((player1Score - player2Score) * (player1Score - player2Score) == 1) ?
                "Advantage " + s : "Win for " + s;
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