package com.geamnect.divinitymod.item;

import com.geamnect.divinitymod.DivinityMod;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class ModArmorMaterials {

    // 1. 定义 RegistryKey（唯一身份证）
    public static final RegistryKey<ArmorMaterial> STELLAR_CORE_KEY =
            RegistryKey.of(RegistryKeys.ARMOR_MATERIAL, Identifier.of(DivinityMod.MOD_ID, "stellar_core"));

    public static final RegistryKey<ArmorMaterial> VOID_KEY =
            RegistryKey.of(RegistryKeys.ARMOR_MATERIAL, Identifier.of(DivinityMod.MOD_ID, "void"));

    public static final RegistryKey<ArmorMaterial> TERMINUS_KEY =
            RegistryKey.of(RegistryKeys.ARMOR_MATERIAL, Identifier.of(DivinityMod.MOD_ID, "terminus"));

    // 2. 定义 RegistryEntry（供 ArmorItem 使用，先声明，在 register() 中赋值）
    public static RegistryEntry<ArmorMaterial> STELLAR_CORE_ENTRY;
    public static RegistryEntry<ArmorMaterial> VOID_ENTRY;
    public static RegistryEntry<ArmorMaterial> TERMINUS_ENTRY;

    // 3. 核心注册方法（必须在主类的 onInitialize 中调用）
    public static void register() {
        // 获取下界合金的装备声音（1.21中需要 RegistryEntry<SoundEvent>）
        RegistryEntry<SoundEvent> equipSound = Registries.SOUND_EVENT.getEntry(SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE.value());

        // ==================== 低级：陨星锭====================

        Map<ArmorItem.Type, Integer> stellarDefense = new EnumMap<>(ArmorItem.Type.class);
        stellarDefense.put(ArmorItem.Type.BOOTS, 8);        // 下界合金(4) × 2
        stellarDefense.put(ArmorItem.Type.LEGGINGS, 14);    // 下界合金(7) × 2
        stellarDefense.put(ArmorItem.Type.CHESTPLATE, 18);  // 下界合金(9) × 2
        stellarDefense.put(ArmorItem.Type.HELMET, 8);       // 下界合金(4) × 2
        stellarDefense.put(ArmorItem.Type.BODY, 18);

        ArmorMaterial stellarCoreMaterial = new ArmorMaterial(
                stellarDefense,
                30,                                 // 附魔权重：下界合金(15) × 2
                equipSound,
                () -> Ingredient.ofItems(ModItems.STELLAR_CORE_INGOT),
                List.of(new ArmorMaterial.Layer(Identifier.of(DivinityMod.MOD_ID, "stellar_core"))),
                6.0f,                               // 韧性：下界合金(3.0) × 2
                2.0f                                // 击退抗性：下界合金(1.0) × 2
        );

        STELLAR_CORE_ENTRY = Registry.registerReference(
                Registries.ARMOR_MATERIAL,
                STELLAR_CORE_KEY,
                stellarCoreMaterial
        );

        // ==================== 中级：虚空锭====================

        Map<ArmorItem.Type, Integer> voidDefense = new EnumMap<>(ArmorItem.Type.class);
        voidDefense.put(ArmorItem.Type.BOOTS, 12);       // 下界合金(4) × 3
        voidDefense.put(ArmorItem.Type.LEGGINGS, 21);    // 下界合金(7) × 3
        voidDefense.put(ArmorItem.Type.CHESTPLATE, 27);  // 下界合金(9) × 3
        voidDefense.put(ArmorItem.Type.HELMET, 12);      // 下界合金(4) × 3
        voidDefense.put(ArmorItem.Type.BODY, 27);

        ArmorMaterial voidMaterial = new ArmorMaterial(
                voidDefense,
                45,                                 // 附魔权重：下界合金(15) × 3
                equipSound,
                () -> Ingredient.ofItems(ModItems.VOID_INGOT),
                List.of(new ArmorMaterial.Layer(Identifier.of(DivinityMod.MOD_ID, "void"))),
                9.0f,                               // 韧性：下界合金(3.0) × 3
                3.0f                                // 击退抗性：下界合金(1.0) × 3
        );

        VOID_ENTRY = Registry.registerReference(
                Registries.ARMOR_MATERIAL,
                VOID_KEY,
                voidMaterial
        );

        // ==================== 终极：终焉锭（无限耐久）====================

        Map<ArmorItem.Type, Integer> terminusDefense = new EnumMap<>(ArmorItem.Type.class);
        terminusDefense.put(ArmorItem.Type.BOOTS, 24);       // 虚空(12) × 2
        terminusDefense.put(ArmorItem.Type.LEGGINGS, 42);    // 虚空(21) × 2
        terminusDefense.put(ArmorItem.Type.CHESTPLATE, 54);  // 虚空(27) × 2
        terminusDefense.put(ArmorItem.Type.HELMET, 24);      // 虚空(12) × 2
        terminusDefense.put(ArmorItem.Type.BODY, 54);

        ArmorMaterial terminusMaterial = new ArmorMaterial(
                terminusDefense,
                90,                                 // 附魔权重：虚空(45) × 2
                equipSound,
                () -> Ingredient.ofItems(ModItems.TERMINUS_INGOT),
                List.of(new ArmorMaterial.Layer(Identifier.of(DivinityMod.MOD_ID, "terminus"))),
                18.0f,                              // 韧性：虚空(9.0) × 2
                6.0f                                // 击退抗性：虚空(3.0) × 2
        );

        TERMINUS_ENTRY = Registry.registerReference(
                Registries.ARMOR_MATERIAL,
                TERMINUS_KEY,
                terminusMaterial
        );
    }
}