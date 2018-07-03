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

    private void updateSingleItem(Item item) {
        if(item.name.equals("Sulfuras, Hand of Ragnaros")) {
            new SulfurasProcessor(item).process();
        } else if(item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            new BackstagePassProcessor(item).process();
        } else if(item.name.equals("Aged Brie")) {
            new BrieProcessor(item).process();
        } else if(item.name.equals("Conjured Mana Cake")) {
            new ConjuredItemProcessor(item).process();
        } else {
            new StandardItemProcessor(item).process();
        }
    }

}