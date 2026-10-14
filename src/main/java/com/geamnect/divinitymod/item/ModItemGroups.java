package com.geamnect.divinitymod.item;

import com.geamnect.divinitymod.DivinityMod;
import com.geamnect.divinitymod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    // 1. 定义标签页的 ID
    public static final RegistryKey<ItemGroup> DIVINITY_GROUP =
            RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(DivinityMod.MOD_ID, "divinitygroup"));

    // 2. 注册标签页本身
    public static void registerGroups() {
        Registry.register(Registries.ITEM_GROUP, DIVINITY_GROUP,
                FabricItemGroup.builder()
                        .displayName(Text.translatable("itemGroup.divinitymod.divinitygroup"))
                        .icon(() -> new ItemStack(ModItems.SOUL_WIND))
                        .build());
    }

    // 3. 核心步骤：把物品添加进这个标签页
    public static void registerItemGroupEntries() {
        ItemGroupEvents.modifyEntriesEvent(DIVINITY_GROUP).register((entries) -> {

            entries.add(ModItems.SOUL_WIND);
            entries.add(ModItems.NETHERITE_PRIME);
            entries.add(ModItems.STELLAR_CORE_INGOT);
            entries.add(ModItems.RAW_STELLAR_CORE);

            entries.add(ModBlocks.NETHERITE_PRIME_BLOCK);
            entries.add(ModBlocks.STELLAR_CORE_BLOCK);
            entries.add(ModBlocks.END_STELLAR_CORE_ORE);
            entries.add(ModBlocks.RAW_STELLAR_CORE_BLOCK);

            entries.add(ModItems.STELLAR_CORE_HELMET);
            entries.add(ModItems.STELLAR_CORE_CHESTPLATE);
            entries.add(ModItems.STELLAR_CORE_LEGGINGS);
            entries.add(ModItems.STELLAR_CORE_BOOTS);

            entries.add(ModItems.STELLAR_CORE_PICKAXE);
            entries.add(ModItems.STELLAR_CORE_SHOVEL);
            entries.add(ModItems.STELLAR_CORE_AXE);
            entries.add(ModItems.STELLAR_CORE_HOE);

        });
    }
}