package net.switchot.thechunkers.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.switchot.thechunkers.TheChunkers;
import net.switchot.thechunkers.item.custom.HeartDetectorItem;

public class Moditems {
    public static final Item CHUNK_PART = registerItem("chunk_part", new Item(new FabricItemSettings()));
    public static final Item RAW_CHUNK_PART = registerItem("raw_chunk_part", new Item(new FabricItemSettings()));
    public static final Item DEEPSLATE_RAW_CHUNK_PART = registerItem("deepslate_raw_chunk_part", new Item(new FabricItemSettings()));

    //tool / custom uses
    public static final Item CHUNK_ANALYZER = registerItem("chunk_analyzer", new HeartDetectorItem(new FabricItemSettings()));









    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries){
        entries.add(CHUNK_PART);
    }

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(TheChunkers.Mod_ID, name), item);
    }
    public static void registerModItems(){
        TheChunkers.LOGGER.info("Registering Mod items for " + TheChunkers.Mod_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(Moditems::addItemsToIngredientItemGroup);
    }
}
