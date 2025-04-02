public class Word {
    private String polish;
    private String english;
    private boolean known;

    public Word(String polish, String english) {
        this.polish = polish;
        this.english = english;
        this.known = false; // by default, we don't know the word yet
    }

    public String getPolish() {
        return polish;
    }

    public String getEnglish() {
        return english;
    }

    public boolean isKnown() {
        return known;
    }

    public void setKnown(boolean known) {
        this.known = known;
    }
}
