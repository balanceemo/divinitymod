package com.geamnect.divinitymod.block;

import com.geamnect.divinitymod.DivinityMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.PathUtil;


public class ModBlocks {

    public static final Block NETHERITE_PRIME_BLOCK = registerBlock("netherite_prime_block", new Block(AbstractBlock.Settings.create().requiresTool().strength(3.0f, 3.0f)));

    public static final Block STELLAR_CORE_BLOCK = registerBlock("stellar_core_block", new Block(AbstractBlock.Settings.create().requiresTool().strength(3.0f, 3.0f)));

    public static final Block END_STELLAR_CORE_ORE = registerBlock("end_stellar_core_ore", new Block(AbstractBlock.Settings.create().requiresTool().strength(4.5f, 6.0f)));

    public static final Block RAW_STELLAR_CORE_BLOCK = registerBlock("raw_stellar_core_block", new Block(AbstractBlock.Settings.create().requiresTool().strength(3.0f, 3.0f)));

    public static void registerBlocksItems(String id, Block block) {
        Item item = Registry.register(Registries.ITEM, Identifier.of(DivinityMod.MOD_ID, id), new BlockItem(block, new Item.Settings()));
        if (item instanceof BlockItem) {
            ((BlockItem)item).appendBlocks(Item.BLOCK_ITEMS, item);
        }
    }

    public static Block registerBlock(String id, Block block) {
        registerBlocksItems(id, block);
        return Registry.register(Registries.BLOCK, Identifier.of(DivinityMod.MOD_ID, id), block);
    }

    public static void registerModBlocks() {
        DivinityMod.LOGGER.info("Registering Blocks");
    }

}
