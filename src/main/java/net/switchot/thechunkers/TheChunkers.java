package net.switchot.thechunkers;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TheChunkers implements ModInitializer {
	public static final String Mod_ID = "thechunkersmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(Mod_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
	}
}