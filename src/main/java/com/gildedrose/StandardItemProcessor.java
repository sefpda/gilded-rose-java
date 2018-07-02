package com.gildedrose;

public class StandardItemProcessor {

    private Item item;

    public StandardItemProcessor(Item item) {
        this.item = item;
    }

    public void process() {
        if (item.quality > 0) {
            item.quality--;
        }

        if (item.sellIn <= 0) {
            if (item.quality > 0) {
                item.quality--;
            }
        }

        item.sellIn--;
    }
}
