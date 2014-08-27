package pattern.mediator;

import java.util.ArrayList;

/**
 * Created by DevMac on 03/08/2014.
 */
public class StockMediator implements Mediator {

    private ArrayList<Colleague> colleagues;
    private ArrayList<StockOffer> stockBuyOffers;
    private ArrayList<StockOffer> stockSellOffers;

    private int colleagueCode = 0;

    public StockMediator() {

        colleagues = new ArrayList<Colleague>();
        stockBuyOffers = new ArrayList<StockOffer>();
        stockSellOffers = new ArrayList<StockOffer>();

    }

    public void addColleague(Colleague colleague) {
        colleagues.add(colleague);
        colleagueCode++;
        colleague.setCollCode(colleagueCode);
    }

    @Override
    public void saleOffer(String stock, int shares, int collCode) {
        boolean stockSold = false;
        for (StockOffer offer : stockBuyOffers) {
            if ((offer.getStockSymbol() == stock) &&
                    (offer.getStockShares() == shares)) {
                System.out.println(shares + " shares of " + stock
                + " sold to colleague code " + offer.getCollCode());
                stockBuyOffers.remove(offer);
                stockSold = true;

            }

            if (stockSold) { break; }
        }

        if (!stockSold) {
            System.out.println(shares + " share of " + stock + " added to inventory");
            StockOffer newOffering = new StockOffer(shares, stock, collCode);
            stockSellOffers.add(newOffering);
        }
    }

    @Override
    public void buyOffer(String stock, int shares, int collCode) {
        boolean stockBought = false;
        for (StockOffer offer : stockSellOffers) {
            if ((offer.getStockSymbol() == stock) &&
                    (offer.getStockShares() == shares)) {
                System.out.println(shares + " shares of " + stock
                        + " bought by colleague code " + offer.getCollCode());
                stockSellOffers.remove(offer);
                stockBought = true;

            }

            if (stockBought) { break; }
        }

        if (!stockBought) {
            System.out.println(shares + " share of " + stock + " added to inventory");
            StockOffer newOffering = new StockOffer(shares, stock, collCode);
            stockBuyOffers.add(newOffering);
        }
    }

    public void getStockOfferings() {
        System.out.println("\nStocks for sale");

        for (StockOffer offer : stockSellOffers) {
            System.out.println(offer.getStockShares() + " of "
            + offer.getStockSymbol());
        }

        System.out.println("\nStocks Buy offers");

        for (StockOffer offer : stockBuyOffers) {
            System.out.println(offer.getStockShares() + " of "
                    + offer.getStockSymbol());
        }
    }

}
