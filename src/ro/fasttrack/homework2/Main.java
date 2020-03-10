package ro.fasttrack.homework2;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        QuoteService quoteService=new QuoteService("Quotes.txt");
        System.out.println(quoteService.getAllQuotes());
        System.out.println(quoteService.getQuotesForAuthor("Michael Korda"));
        System.out.println(quoteService.getAuthors());
        quoteService.setFavourite(500000);
        quoteService.setFavourite(3);
        System.out.println(quoteService.getFavourites());
        System.out.println(quoteService.getRandomQuote());
    }
}
