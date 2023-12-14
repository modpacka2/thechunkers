package net.switchot.thechunkers.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.switchot.thechunkers.TheChunkers;
import net.switchot.thechunkers.block.custom.AdvancedChunkAnalyzerBlocks;

public class ModBlocks {
//block
    public static final Block CHUNK_BLOCK = registerBlock("chunk_block",
            new Block(FabricBlockSettings.copyOf(Blocks.DIRT).sounds(BlockSoundGroup.SLIME).strength(2f, 3f)));
    public static final Block ADVANCED_CHUNK_ANALYZER = registerBlock("advanced_chunk_analyzer",
            new AdvancedChunkAnalyzerBlocks(FabricBlockSettings.copyOf(Blocks.STONE)));
    //minerai
    public static final Block CHUNKS_HEART = registerBlock("chunks_heart",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).requiresTool(), UniformIntProvider.create(4,7)));
    public static final Block DEEPSLATE_CHUNKS_HEART = registerBlock("deepslate_chunks_heart",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE).requiresTool(), UniformIntProvider.create(4,7)));









//utilities
    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(TheChunkers.Mod_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block){
return Registry.register(Registries.ITEM, new Identifier(TheChunkers.Mod_ID, name),
        new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks(){
        TheChunkers.LOGGER.info("Registering ModBlocks for: " + TheChunkers.Mod_ID);
    }
}
