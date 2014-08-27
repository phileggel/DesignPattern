package pattern.mediator;

public class StockOffer {

    private int stockShares = 0;
    private String stockSymbol = "";
    private int colleagueCode = 0;

    public StockOffer(int numOfShares, String stock, int collcode) {

        stockShares = numOfShares;
        stockSymbol = stock;
        colleagueCode = collcode;

    }

    public int getStockShares() {
        return stockShares;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public int getCollCode() {
        return colleagueCode;
    }
}
