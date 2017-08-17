package lotto;

public class LottoChecker {
    private LottoGame lottoGame;
    private Win win;
    
    private int matchUp = 0;
    
    private int match3 = 0;
    private int match4 = 0;
    private int match5 = 0;
    private int match6 = 0;
    
    public LottoChecker(LottoGame lottoGame, Win win) {
        this.lottoGame = lottoGame;
        this.win = win;
    }
    
    public void matchUp() {
        for (int i = 0; i < lottoGame.getAvailableCount(); i++) {
            checkLottoGame(lottoGame.getLotto(i));
        }
    }
    
    private void checkLottoGame(Lotto lotto) {
        for (int i = 0; i < lotto.getPickedNumCount(); i++) {
            isContains(win.isContains(lotto.findLottoNum(i)));
        }
        countUpMatches(matchUp);
        matchUp = 0;
    }
    
    private void isContains(Boolean check) {
        if(check) matchUp++;
    }
    private void countUpMatches(int matchUp) {
        switch (matchUp) {
            case 3:
                match3++;
                break;
            case 4:
                match4++;
                break;
            case 5:
                match5++;
                break;
            case 6:
                match6++;
                break;
        }
    }
    
    public int getMatch3() {
        return match3;
    }
    public int getMatch4() {
        return match4;
    }
    public int getMatch5() {
        return match5;
    }
    public int getMatch6() {
        return match6;
    }
}
