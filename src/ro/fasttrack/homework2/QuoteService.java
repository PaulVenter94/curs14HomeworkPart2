package ro.fasttrack.homework2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class QuoteService {
    private final List<Quote> quoteList;

    public QuoteService(String file) throws FileNotFoundException {
        quoteList = addQuotesFromFile(file);
    }

    private List<Quote> addQuotesFromFile(String file) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader(file));
        List<Quote> result = new ArrayList<>();
        int i = 1;
        while (scanner.hasNext()) {
            String[] fileLine = scanner.nextLine().split("~");
            result.add(new Quote(i, fileLine[0], fileLine[1]));
            i++;
        }
        return result;
    }

    public List<String> getAllQuotes() {
        List<String> quotes = new ArrayList<>();
        for (Quote quote : quoteList) {
            quotes.add(quote.getQuote());
        }
        return quotes;
    }

    public List<String> getQuotesForAuthor(String name) {
        List<String> quotes = new ArrayList<>();
        for (Quote quote : quoteList) {
            if (quote.getAuthor().equals(name)) {
                quotes.add(quote.getQuote());
            }
        }
        return quotes;
    }

    public List<String> getAuthors() {
        List<String> authors = new ArrayList<>();
        for (Quote quote : quoteList) {
            authors.add(quote.getAuthor());
        }
        return authors;
    }

    public void setFavourite(int index) {
        if (findQuote(index) != null) {
            findQuote(index).setFavorite(true);
        } else {
            System.out.println("Quote not found");
        }
    }

    public List<Quote> getFavourites() {
        List<Quote> favQuotes = new ArrayList<>();
        for (Quote quote : quoteList) {
            if (quote.isFavorite() == true) {
                favQuotes.add(quote);
            }
        }
        return favQuotes;
    }

    public String getRandomQuote() {
        Random random = new Random();
        int n = random.nextInt(quoteList.size() - 1);
        return findQuote(n).getQuote();
    }

    private Quote findQuote(int index) {
        for (Quote quote : quoteList) {
            if (quote.getId() == index) {
                return quote;
            }
        }
        return null;
    }
}
