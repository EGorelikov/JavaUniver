class Word {
    private String word;
    private int count;

    public Word(String word) {
        this.word = word;
        this.count = 0;
    }

    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }

    public void incrementCount() {
        count++;
    }
}

