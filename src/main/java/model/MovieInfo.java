package model;


import java.text.NumberFormat;

public class MovieInfo {

    private String query;
    private int numTweets=0, numRts=0, numberOfPositive=0,
            numberOfNegative=0, positiveNoRts=0, negativeNoRts=0, days, favoriteCount, wordCount, wordCountNoRts;
    private double normPositive=0, normNegative=0, normPositiveNoRts=0, normNegativeNoRts=0;
    private double gross;
    private NumberFormat formatter = NumberFormat.getCurrencyInstance();
    private int hasMovieInQuery;

    public MovieInfo(String query, double gross, int days){
        this.query = query;
        this.gross = gross;
        this.days = days;
        if (query.toLowerCase().contains("movie")){
            hasMovieInQuery = 1;
        } else{
            hasMovieInQuery = 0;
        }
        favoriteCount = 0;
        wordCount = 0;
        wordCountNoRts = 0;
    }

    public void normalizeTotals(){
        normPositive = ((double)numberOfPositive/((double)wordCount));
        normNegative = ((double)numberOfNegative/((double)wordCount));
    }

    public void normalizeNonRetweets(){
        normPositiveNoRts = ((double)positiveNoRts/((double)(wordCountNoRts)));
        normNegativeNoRts = ((double)negativeNoRts/((double)(wordCountNoRts)));
    }

    public void increaseWordCount(){
        this.wordCount++;
    }

    public void increaseWordCountNoRetweets(){
        this.wordCountNoRts++;
    }
    public void increaseFavorite(int count){
        this.favoriteCount += count;
    }
    public void increasePositive(){
        numberOfPositive++;
    }
    public void increaseNegative(){
        numberOfNegative++;
    }
    public void increasePositiveNoRetweets(){
        positiveNoRts++;
    }
    public void increaseNegativeNoRetweets(){
        negativeNoRts++;
    }
    public int getNumberOfPositive() {
        return numberOfPositive;
    }

    public void setNumberOfPositive(int numberOfPositive) {
        this.numberOfPositive = numberOfPositive;
    }

    public int getNumberOfNegative() {
        return numberOfNegative;
    }

    public void setNumberOfNegative(int numberOfNegative) {
        this.numberOfNegative = numberOfNegative;
    }

    public int getNumRts() {
        return numRts;
    }

    public void setNumRts(int numRts) {
        this.numRts = numRts;
    }

    public MovieInfo(String query){
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public int getNumTweets() {
        return numTweets;
    }

    public void setNumTweets(int numTweets) {
        this.numTweets = numTweets;
    }

    public double getGross() {
        return gross;
    }

    public void setGross(double gross) {
        this.gross = gross;
    }

    public int getHasMovieInQuery() {
        return hasMovieInQuery;
    }

    public void setHasMovieInQuery(int hasMovieInQuery) {
        this.hasMovieInQuery = hasMovieInQuery;
    }

    public double getNormPositive() {
        return normPositive;
    }

    public void setNormPositive(double normPositive) {
        this.normPositive = normPositive;
    }

    public double getNormNegative() {
        return normNegative;
    }

    public void setNormNegative(double normNegative) {
        this.normNegative = normNegative;
    }

    public int getPositiveNoRts() {
        return positiveNoRts;
    }

    public void setPositiveNoRts(int positiveNoRts) {
        this.positiveNoRts = positiveNoRts;
    }

    public int getNegativeNoRts() {
        return negativeNoRts;
    }

    public void setNegativeNoRts(int negativeNoRts) {
        this.negativeNoRts = negativeNoRts;
    }

    public double getNormPositiveNoRts() {
        return normPositiveNoRts;
    }

    public void setNormPositiveNoRts(double normPositiveNoRts) {
        this.normPositiveNoRts = normPositiveNoRts;
    }

    public double getNormNegativeNoRts() {
        return normNegativeNoRts;
    }

    public void setNormNegativeNoRts(double normNegativeNoRts) {
        this.normNegativeNoRts = normNegativeNoRts;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(int favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public int getWordCountNoRts() {
        return wordCountNoRts;
    }

    public void setWordCountNoRts(int wordCountNoRts) {
        this.wordCountNoRts = wordCountNoRts;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    @Override
    public String toString(){
        return "Movie hashtag is " + query + "\nwith " + numTweets + " tweets.\n"
                + "Number of retweets: " + numRts + "\n"
                + "Grossed " + formatter.format(gross) + " on opening weekend.\n"
                + normPositive + " normalized positive words.\n"
                + normNegative + " normalized negative words.\n"
                + normPositiveNoRts + " normalized positive in not retweets.\n"
                + normNegativeNoRts + " normalized negative in not retweets.\n"
                + "Is 'movie' in hashtag? " + hasMovieInQuery + "\n"
                + "Favorited: " + favoriteCount + "\n"
                + "Days in theater: " + days + "\n";
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;

        MovieInfo tempObject = (MovieInfo) o;
        if (this.query.equals(tempObject.query)){
            return true;
        }
        return false;
    }
}
