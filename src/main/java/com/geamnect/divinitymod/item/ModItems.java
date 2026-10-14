package com.geamnect.divinitymod.item;

import com.geamnect.divinitymod.DivinityMod;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {

    // ==================== 基础材料 ====================
    public static final Item SOUL_WIND = registerItem("soul_wind", new Item(new Item.Settings().maxCount(64)));
    public static final Item NETHERITE_PRIME = registerItem("netherite_prime", new Item(new Item.Settings().maxCount(64)));
    public static final Item STELLAR_CORE_INGOT = registerItem("stellar_core_ingot", new Item(new Item.Settings().maxCount(64)));
    public static final Item RAW_STELLAR_CORE = registerItem("raw_stellar_core", new Item(new Item.Settings().maxCount(64)));

    // ==================== 星核盔甲 ====================
    public static final Item STELLAR_CORE_HELMET = registerItem(
            "stellar_core_helmet",
            new StellarCoreHelmet(ModArmorMaterials.STELLAR_CORE_ENTRY, ArmorItem.Type.HELMET, new Item.Settings())
    );
    public static final Item STELLAR_CORE_CHESTPLATE = registerItem(
            "stellar_core_chestplate",
            new StellarCoreArmor(ModArmorMaterials.STELLAR_CORE_ENTRY, ArmorItem.Type.CHESTPLATE, new Item.Settings())
    );
    public static final Item STELLAR_CORE_LEGGINGS = registerItem(
            "stellar_core_leggings",
            new StellarCoreArmor(ModArmorMaterials.STELLAR_CORE_ENTRY, ArmorItem.Type.LEGGINGS, new Item.Settings())
    );
    public static final Item STELLAR_CORE_BOOTS = registerItem(
            "stellar_core_boots",
            new StellarCoreArmor(ModArmorMaterials.STELLAR_CORE_ENTRY, ArmorItem.Type.BOOTS, new Item.Settings())
    );

    // ==================== 星核工具 ====================
    public static final Item STELLAR_CORE_PICKAXE = registerItem(
            "stellar_core_pickaxe",
            new PickaxeItem(ModToolMaterials.STELLAR_CORE, new Item.Settings().attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.STELLAR_CORE, 1, -2.8f)))
    );
    public static final Item STELLAR_CORE_SHOVEL = registerItem(
            "stellar_core_shovel",
            new ShovelItem(ModToolMaterials.STELLAR_CORE, new Item.Settings().attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.STELLAR_CORE, 1.5f, -3.0f)))
    );
    public static final Item STELLAR_CORE_AXE = registerItem(
            "stellar_core_axe",
            new AxeItem(ModToolMaterials.STELLAR_CORE, new Item.Settings().attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.STELLAR_CORE, 6.0f, -3.2f)))
    );
    public static final Item STELLAR_CORE_HOE = registerItem(
            "stellar_core_hoe",
            new HoeItem(ModToolMaterials.STELLAR_CORE, new Item.Settings().attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.STELLAR_CORE, -2, -1.0f)))
    );

    // ==================== 注册辅助方法 ====================
    private static Item registerItem(String name, Item item) {
        Identifier id = Identifier.of(DivinityMod.MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        return Registry.register(Registries.ITEM, key, item);
    }

    // ✅ 已删除 registerCreativeTabItems() 方法
    // 所有物品的标签页归属统一由 ModItemGroups.registerItemGroupEntries() 管理

    public static void registerModItems() {
        DivinityMod.LOGGER.info("Registering Items for {}", DivinityMod.MOD_ID);
        // 不再调用 registerCreativeTabItems()
    }
}