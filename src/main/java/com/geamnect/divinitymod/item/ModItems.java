package com.geamnect.divinitymod.item;

import com.geamnect.divinitymod.DivinityMod;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {

    // 原版下界合金基础耐久
    private static final int NETHERITE_BASE = 37;

    // ==================== 基础材料 ====================
    public static Item VOID_INGOT;
    public static Item TERMINUS_INGOT;
    public static Item STELLAR_CORE_INGOT;
    public static Item RAW_STELLAR_CORE;

    // ==================== 陨星盔甲（低级）====================
    public static Item STELLAR_CORE_HELMET;
    public static Item STELLAR_CORE_CHESTPLATE;
    public static Item STELLAR_CORE_LEGGINGS;
    public static Item STELLAR_CORE_BOOTS;

    // ==================== 虚空盔甲（中级）====================
    public static Item VOID_HELMET;
    public static Item VOID_CHESTPLATE;
    public static Item VOID_LEGGINGS;
    public static Item VOID_BOOTS;

    // ==================== 终焉盔甲（终极，无限耐久）====================
    public static Item TERMINUS_HELMET;
    public static Item TERMINUS_CHESTPLATE;
    public static Item TERMINUS_LEGGINGS;
    public static Item TERMINUS_BOOTS;

    // ==================== 陨星工具 ====================
    public static Item STELLAR_CORE_PICKAXE;
    public static Item STELLAR_CORE_SHOVEL;
    public static Item STELLAR_CORE_AXE;
    public static Item STELLAR_CORE_HOE;

    // ==================== 虚空工具 ====================
    public static Item VOID_PICKAXE;
    public static Item VOID_SHOVEL;
    public static Item VOID_AXE;
    public static Item VOID_HOE;

    // ==================== 终焉工具（无限耐久）====================
    public static Item TERMINUS_PICKAXE;
    public static Item TERMINUS_SHOVEL;
    public static Item TERMINUS_AXE;
    public static Item TERMINUS_HOE;

    // ==================== 剑 ====================
    public static Item STELLAR_CORE_SWORD;
    public static Item VOID_SWORD;
    public static Item TERMINUS_SWORD;

    /**
     * 注册所有物品（在主类 onInitialize 中调用，
     * 必须在 ModToolMaterials.register() 之后）
     */
    public static void registerModItems() {
        DivinityMod.LOGGER.info("Registering Items for {}", DivinityMod.MOD_ID);

        // ==================== 基础材料（防火）====================
        VOID_INGOT = registerItem("void_ingot", new Item(new Item.Settings().maxCount(64).fireproof()));
        TERMINUS_INGOT = registerItem("terminus_ingot", new Item(new Item.Settings().maxCount(64).fireproof()));
        STELLAR_CORE_INGOT = registerItem("stellar_core_ingot", new Item(new Item.Settings().maxCount(64).fireproof()));
        RAW_STELLAR_CORE = registerItem("raw_stellar_core", new Item(new Item.Settings().maxCount(64).fireproof()));

        // ==================== 陨星盔甲 ====================
        STELLAR_CORE_HELMET = registerArmor("stellar_core_helmet", ModArmorMaterials.STELLAR_CORE_ENTRY, ArmorItem.Type.HELMET, "stellar_core", 1.5f);
        STELLAR_CORE_CHESTPLATE = registerArmor("stellar_core_chestplate", ModArmorMaterials.STELLAR_CORE_ENTRY, ArmorItem.Type.CHESTPLATE, "stellar_core", 1.5f);
        STELLAR_CORE_LEGGINGS = registerArmor("stellar_core_leggings", ModArmorMaterials.STELLAR_CORE_ENTRY, ArmorItem.Type.LEGGINGS, "stellar_core", 1.5f);
        STELLAR_CORE_BOOTS = registerArmor("stellar_core_boots", ModArmorMaterials.STELLAR_CORE_ENTRY, ArmorItem.Type.BOOTS, "stellar_core", 1.5f);

        // ==================== 虚空盔甲 ====================
        VOID_HELMET = registerArmor("void_helmet", ModArmorMaterials.VOID_ENTRY, ArmorItem.Type.HELMET, "void", 2.0f);
        VOID_CHESTPLATE = registerArmor("void_chestplate", ModArmorMaterials.VOID_ENTRY, ArmorItem.Type.CHESTPLATE, "void", 2.0f);
        VOID_LEGGINGS = registerArmor("void_leggings", ModArmorMaterials.VOID_ENTRY, ArmorItem.Type.LEGGINGS, "void", 2.0f);
        VOID_BOOTS = registerArmor("void_boots", ModArmorMaterials.VOID_ENTRY, ArmorItem.Type.BOOTS, "void", 2.0f);

        // ==================== 终焉盔甲（无限耐久 + 防火）====================
        TERMINUS_HELMET = registerTerminus("terminus_helmet", ArmorItem.Type.HELMET);
        TERMINUS_CHESTPLATE = registerTerminus("terminus_chestplate", ArmorItem.Type.CHESTPLATE);
        TERMINUS_LEGGINGS = registerTerminus("terminus_leggings", ArmorItem.Type.LEGGINGS);
        TERMINUS_BOOTS = registerTerminus("terminus_boots", ArmorItem.Type.BOOTS);

        // ==================== 陨星工具（防火）====================
        STELLAR_CORE_PICKAXE = registerItem("stellar_core_pickaxe",
                new PickaxeItem(ModToolMaterials.STELLAR_CORE, new Item.Settings()
                        .fireproof()
                        .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.STELLAR_CORE, 1, -2.8f))));
        STELLAR_CORE_SHOVEL = registerItem("stellar_core_shovel",
                new ShovelItem(ModToolMaterials.STELLAR_CORE, new Item.Settings()
                        .fireproof()
                        .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.STELLAR_CORE, 1.5f, -3.0f))));
        STELLAR_CORE_AXE = registerItem("stellar_core_axe",
                new AxeItem(ModToolMaterials.STELLAR_CORE, new Item.Settings()
                        .fireproof()
                        .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.STELLAR_CORE, 6.0f, -3.2f))));
        STELLAR_CORE_HOE = registerItem("stellar_core_hoe",
                new HoeItem(ModToolMaterials.STELLAR_CORE, new Item.Settings()
                        .fireproof()
                        .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.STELLAR_CORE, -2, -1.0f))));

        // ==================== 虚空工具（防火）====================
        VOID_PICKAXE = registerItem("void_pickaxe",
                new PickaxeItem(ModToolMaterials.VOID, new Item.Settings()
                        .fireproof()
                        .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.VOID, 1, -2.6f))));
        VOID_SHOVEL = registerItem("void_shovel",
                new ShovelItem(ModToolMaterials.VOID, new Item.Settings()
                        .fireproof()
                        .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.VOID, 1.5f, -2.8f))));
        VOID_AXE = registerItem("void_axe",
                new AxeItem(ModToolMaterials.VOID, new Item.Settings()
                        .fireproof()
                        .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.VOID, 6.0f, -3.0f))));
        VOID_HOE = registerItem("void_hoe",
                new HoeItem(ModToolMaterials.VOID, new Item.Settings()
                        .fireproof()
                        .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.VOID, -2, -1.0f))));

        // ==================== 终焉工具（无限耐久 + 防火）====================
        TERMINUS_PICKAXE = registerItem("terminus_pickaxe",
                new PickaxeItem(ModToolMaterials.TERMINUS, new Item.Settings()
                        .maxDamage(0)
                        .fireproof()
                        .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.TERMINUS, 2, -2.4f))));
        TERMINUS_SHOVEL = registerItem("terminus_shovel",
                new ShovelItem(ModToolMaterials.TERMINUS, new Item.Settings()
                        .maxDamage(0)
                        .fireproof()
                        .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.TERMINUS, 2.5f, -2.6f))));
        TERMINUS_AXE = registerItem("terminus_axe",
                new AxeItem(ModToolMaterials.TERMINUS, new Item.Settings()
                        .maxDamage(0)
                        .fireproof()
                        .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.TERMINUS, 8.0f, -2.8f))));
        TERMINUS_HOE = registerItem("terminus_hoe",
                new HoeItem(ModToolMaterials.TERMINUS, new Item.Settings()
                        .maxDamage(0)
                        .fireproof()
                        .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.TERMINUS, -1, -0.5f))));

        // ==================== 剑（防火）====================
        STELLAR_CORE_SWORD = registerItem("stellar_core_sword",
                new SwordItem(ModToolMaterials.STELLAR_CORE, new Item.Settings()
                        .fireproof()
                        .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.STELLAR_CORE, 3, -2.4f))));
        VOID_SWORD = registerItem("void_sword",
                new SwordItem(ModToolMaterials.VOID, new Item.Settings()
                        .fireproof()
                        .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.VOID, 3, -2.4f))));
        TERMINUS_SWORD = registerItem("terminus_sword",
                new SwordItem(ModToolMaterials.TERMINUS, new Item.Settings()
                        .maxDamage(0)
                        .fireproof()
                        .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.TERMINUS, 4, -2.4f))));
    }

    // ==================== 注册辅助方法 ====================

    /** 按「下界合金倍数」注册盔甲（自带防火） */
    private static Item registerArmor(String name,
                                      net.minecraft.registry.entry.RegistryEntry<net.minecraft.item.ArmorMaterial> material,
                                      ArmorItem.Type type, String setId, float multiplier) {
        int durability = (int) (NETHERITE_BASE * durabilityMultiplier(type) * multiplier);
        return registerItem(name, new ModArmorItem(material, type,
                new Item.Settings().maxDamage(durability).fireproof(), setId));
    }

    /** 终焉套：无限耐久 + 防火，不显示耐久条 */
    private static Item registerTerminus(String name, ArmorItem.Type type) {
        return registerItem(name, new ModArmorItem(ModArmorMaterials.TERMINUS_ENTRY, type,
                new Item.Settings().maxDamage(0).fireproof(), "terminus"));
    }

    /** 各部位耐久系数（原版规则） */
    private static int durabilityMultiplier(ArmorItem.Type type) {
        return switch (type) {
            case HELMET -> 11;
            case CHESTPLATE -> 16;
            case LEGGINGS -> 15;
            case BOOTS -> 13;
            default -> 13;
        };
    }

    private static Item registerItem(String name, Item item) {
        Identifier id = Identifier.of(DivinityMod.MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        return Registry.register(Registries.ITEM, key, item);
    }
}