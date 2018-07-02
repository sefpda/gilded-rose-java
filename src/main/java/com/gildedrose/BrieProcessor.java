package com.gildedrose;

public class BrieProcessor {

    Item item;

    public BrieProcessor(Item item) {
        this.item = item;
    }

    public void process() {
        incrementQuality(item);
        if(item.sellIn < 0) {
            incrementQuality(item);
        }
        item.sellIn--;
    }

    private void incrementQuality(Item item) {
        if(item.quality < 50) {
            item.quality++;
        }
    }
}
