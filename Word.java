public class Word {
    private String definition;
    private String english;
    private boolean known;

    public Word(String definition, String english) {
        this.definition = definition;
        this.english = english;
        this.known = false; // by default, word is unknown
    }

    public String getDefinition() {
        return definition;
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
        return definition + " – " + english + (known ? " ✅" : " ❌");
    }

    // Returns a file-friendly string like: pies;dog;true
    public String toFileString() {
        return definition + ";" + english + ";" + known;
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