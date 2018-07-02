package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for(Item item : items) {
            updateSingleItem(item);
        }
    }

    private void updateBackstagePass(Item item){
        incrementQuality(item);
        if(item.sellIn <= 10){
            incrementQuality(item);
        }
        if(item.sellIn <= 5){
            incrementQuality(item);
        }
        if(item.sellIn <= 0){
            item.quality = 0;
        }
        item.sellIn--;
    }

    private void incrementQuality(Item item) {
        if(item.quality < 50) {
            item.quality++;
        }
    }

    private void updateAgedBrie(Item item) {
        incrementQuality(item);
        if(item.sellIn < 0) {
            incrementQuality(item);
        }
        item.sellIn--;
    }

    private void updateSingleItem(Item item) {
        if(item.name.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        }

        if(item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            updateBackstagePass(item);
        } else if(item.name.equals("Aged Brie")) {
            new BrieProcessor(item).process();
        } else {
            updateStandardItem(item);
        }
    }

    private void updateStandardItem(Item item) {
        new StandardItemProcessor(item).process();
    }
}