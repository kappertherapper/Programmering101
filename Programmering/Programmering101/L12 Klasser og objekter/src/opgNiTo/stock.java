package opgNiTo;

public class stock {

        String symbol;
        String name;

        double previousClosingPrice;
        double currentPrice;

    public stock(String symbol, String name) {

        this.symbol = symbol;
        this.name = name;



    }

    //Sets closing price
    public void setPreviousClosingPrice(double previousClosingPrice) {
        this.previousClosingPrice = previousClosingPrice;
    }

    //Sets current price
    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    //Gets previous closing price
    public double getPreviousClosingPrice(double previousClosingPrice) {
        return previousClosingPrice;

    }

    //Gets current price
    public double getCurrentPrice(double currentPrice) {
        return currentPrice;

    }



    /** Find the percent diffent between previous vs current price */
    public double getChangePercent() {

        return (currentPrice / previousClosingPrice) * 100 - 100;

    }

    /** Prints stock symbol, name, previous and current price */
    @Override
    public String toString() {
        return "Today we have Stock: " + symbol
                + "\n" + "Named: " + name
                + "\n\n" + "The previous closing price was: " + previousClosingPrice
                + "\n" + "And the current price is: " + currentPrice;
    }
}
