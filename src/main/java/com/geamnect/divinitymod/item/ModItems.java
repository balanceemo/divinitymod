package com.geamnect.divinitymod.item;

import com.geamnect.divinitymod.DivinityMod;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item SOUL_WIND = registerItem("soul_wind", new Item(new Item.Settings()));
    public static final Item NETHERITE_PRIME = registerItem("netherite_prime", new Item(new Item.Settings()));
    public static final Item STELLAR_CORE_INGOT = registerItem("stellar_core_ingot", new Item(new Item.Settings()));
    public static final Item RAW_STELLAR_CORE = registerItem("raw_stellar_core", new Item(new Item.Settings()));

    // 2. 注册物品 (使用 1.21.1 最新的 Identifier.of 写法)
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(DivinityMod.MOD_ID, name), item);
    }

    // 3. 调用方法
    public static void registerModItems() {
        DivinityMod.LOGGER.info("Registering Items");
    }
}
