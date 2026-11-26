package com.geamnect.divinitymod.block;

import com.geamnect.divinitymod.DivinityMod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    // ===== 陨星线：下界合金及以上可挖（硬度 75）=====
    public static final Block END_STELLAR_CORE_ORE = registerBlock("end_stellar_core_ore",
            new Block(AbstractBlock.Settings.create()
                    .requiresTool()
                    .strength(75.0f, 1200.0f)));

    public static final Block RAW_STELLAR_CORE_BLOCK = registerBlock("raw_stellar_core_block",
            new Block(AbstractBlock.Settings.create()
                    .requiresTool()
                    .strength(75.0f, 1200.0f)));

    public static final Block STELLAR_CORE_BLOCK = registerBlock("stellar_core_block",
            new Block(AbstractBlock.Settings.create()
                    .requiresTool()
                    .strength(75.0f, 1200.0f)));

    // ===== 虚空线：虚空锭及以上可挖（硬度 100）=====
    public static final Block VOID_INGOT_BLOCK = registerBlock("void_ingot_block",
            new Block(AbstractBlock.Settings.create()
                    .requiresTool()
                    .strength(100.0f, 1500.0f)));

    // ===== 终焉线：终焉锭可挖（硬度 200）=====
    public static final Block TERMINUS_INGOT_BLOCK = registerBlock("terminus_ingot_block",
            new Block(AbstractBlock.Settings.create()
                    .requiresTool()
                    .strength(200.0f, 2000.0f)));

    public static void registerBlocksItems(String id, Block block) {
        BlockItem item = Registry.register(Registries.ITEM,
                Identifier.of(DivinityMod.MOD_ID, id),
                new BlockItem(block, new Item.Settings().fireproof()));
        item.appendBlocks(Item.BLOCK_ITEMS, item);
    }

    public static Block registerBlock(String id, Block block) {
        registerBlocksItems(id, block);
        return Registry.register(Registries.BLOCK,
                Identifier.of(DivinityMod.MOD_ID, id), block);
    }

    public static void registerModBlocks() {
        DivinityMod.LOGGER.info("Registering Blocks");
    }
}