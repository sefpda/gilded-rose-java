package com.gildedrose;

public class SulfurasProcessor extends BaseItemProcessor {

    public SulfurasProcessor(Item item) {
        super(item);
    }

    protected void updateQuality() {
        item.quality = 80;
    }

    protected void updateSellIn() {
    }

    @Override
    public boolean canProcess() {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }
}
