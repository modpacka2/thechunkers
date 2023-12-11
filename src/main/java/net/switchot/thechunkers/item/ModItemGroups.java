package net.switchot.thechunkers.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.switchot.thechunkers.TheChunkers;
import net.switchot.thechunkers.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup TheChunkersGroup = Registry.register(Registries.ITEM_GROUP,new Identifier(net.switchot.thechunkers.TheChunkers.Mod_ID, "thechunkers"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.thechunkers"))
            .icon(() -> new ItemStack(Moditems.CHUNK_PART)).entries((displayContext, entries) -> {
entries.add(Moditems.CHUNK_PART);
entries.add(Moditems.RAW_CHUNK_PART);
entries.add(Moditems.DEEPSLATE_RAW_CHUNK_PART);


entries.add(ModBlocks.CHUNK_BLOCK);
entries.add(ModBlocks.CHUNKS_HEART);
entries.add(ModBlocks.DEEPSLATE_CHUNKS_HEART);
            }).build());

    public static void registerItemGroups(){
        TheChunkers.LOGGER.info("Registering Item Groups for: " + TheChunkers.Mod_ID);
    }
}
