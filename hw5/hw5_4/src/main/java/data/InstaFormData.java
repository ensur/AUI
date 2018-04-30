package data;

public enum InstaFormData {//энам для динамического локатора
    Next("_by8kl coreSpriteRightChevron"),
    Prev("_pak6p coreSpriteLeftChevron");

    private final String name;

    InstaFormData(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}