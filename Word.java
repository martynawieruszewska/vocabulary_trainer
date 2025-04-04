public class Word {
    private String polish;
    private String english;
    private boolean known;

    public Word(String polish, String english) {
        this.polish = polish;
        this.english = english;
        this.known = false; // by default, word is unknown
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

    public void markAsKnown() {
        this.known = true;
    }

    @Override // Overrides the default toString() method from the Object class
    public String toString() {
        return polish + " – " + english + (known ? " ✅" : " ❌");
    }

    // Returns a file-friendly string like: pies;dog;true
    public String toFileString() {
        return polish + ";" + english + ";" + known;
    }

    // Parses a Word object from a file line
    public static Word fromFileString(String line) {
        String[] parts = line.split(";");
        if (parts.length != 3) return null;

        Word word = new Word(parts[0], parts[1]);
        word.setKnown(Boolean.parseBoolean(parts[2]));
        return word;
    }
}