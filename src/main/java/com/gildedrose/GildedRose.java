package com.gildedrose;

class GildedRose {
    private Item[] items;
    private BaseItemProcessor[] processors;

    public GildedRose(Item[] items) {
        this.items = items;

        processors = new BaseItemProcessor[]{
                new ConjuredItemProcessor(null),
                new BackstagePassProcessor(null),
                new BrieProcessor(null),
                new SulfurasProcessor(null)
        };
    }

    public void updateQuality() {
        for(Item item : items) {
            buildProcessorFor(item).process();
        }
    }

    BaseItemProcessor buildProcessorFor(Item item) {

        for(BaseItemProcessor processor: processors) {
            processor.setItem(item);
            if(processor.canProcess()) {
                return processor;
            }
        }

        return new StandardItemProcessor(item);
    }

}