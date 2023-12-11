package net.switchot.thechunkers;

import net.fabricmc.api.ModInitializer;

import net.switchot.thechunkers.block.ModBlocks;
import net.switchot.thechunkers.item.ModItemGroups;
import net.switchot.thechunkers.item.Moditems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TheChunkers implements ModInitializer {
	public static final String Mod_ID = "thechunkersmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(Mod_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		Moditems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}