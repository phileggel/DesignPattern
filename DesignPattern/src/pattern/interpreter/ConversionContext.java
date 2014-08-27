package pattern.interpreter;

/**
 * <h1>Interpreter Design Pattern</h1>
 * <p>Context</p>
 *
 * @author Philippe Eggel (based on Derek Banas video tutorials) 01/08/2014
 * @version 1
 *
 * @see pattern.interpreter
 * @see ConversionContext
 */
public class ConversionContext {

    private String conversionQues = "";
    private String conversionReponse = "";
    private String fromConversion = "";
    private String toConversion = "";
    private double quantity;

    String[] partsOfQues;

    public ConversionContext(String input) {

        conversionQues = input;
        partsOfQues = getInput().split(" ");
        fromConversion = getCapitalized(partsOfQues[1]);
        toConversion = getLowerCase(partsOfQues[3]);
        quantity = Double.valueOf(partsOfQues[0]);
        conversionReponse = partsOfQues[0] + " " + partsOfQues[1] + " equals ";

    }

    public String getConversionReponse() {
        return conversionReponse;
    }

    public String getFromConversion() {
        return fromConversion;
    }

    public String getToConversion() {
        return toConversion;
    }

    public double getQuantity() {
        return quantity;
    }

    private String getLowerCase(String wordToLowercase) {
        return wordToLowercase.toLowerCase();
    }

    private String getCapitalized(String wordToCapitalize) {
        wordToCapitalize = wordToCapitalize.toLowerCase();
        wordToCapitalize = Character.toUpperCase(wordToCapitalize.charAt(0)) + wordToCapitalize.substring(1);

        int lengthOfWord = wordToCapitalize.length();

        if ((wordToCapitalize.charAt(lengthOfWord - 1)) != 's') {
            wordToCapitalize = new StringBuffer(wordToCapitalize).insert(lengthOfWord, "s").toString();
        }

        return wordToCapitalize;
    }

    private String getInput() {
        return conversionQues;
    }
}