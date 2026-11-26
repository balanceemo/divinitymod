package com.geamnect.divinitymod.item;

import net.minecraft.block.Block;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.TagKey;

public class ModToolMaterials {

    public static ToolMaterial STELLAR_CORE;
    public static ToolMaterial VOID;
    public static ToolMaterial TERMINUS;

    /** 原版下界合金工具基准值 */
    private static final int NETHERITE_DURABILITY = 2031;
    private static final float NETHERITE_ATTACK_DAMAGE = 4.0F;

    // ==================== 陨星线 ====================
    private static class StellarCoreMaterial implements ToolMaterial {
        @Override
        public float getMiningSpeedMultiplier() {
            return 190.0F;
        }

        @Override
        public float getAttackDamage() {
            return NETHERITE_ATTACK_DAMAGE * 2;
        }

        @Override
        public TagKey<Block> getInverseTag() {
            return ModBlockTags.INCORRECT_FOR_STELLAR_CORE_TOOL;
        }

        @Override
        public int getDurability() {
            return NETHERITE_DURABILITY * 2;
        }

        @Override
        public int getEnchantability() {
            return 30;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.ofItems(ModItems.STELLAR_CORE_INGOT);
        }
    }

    // ==================== 虚空线 ====================
    private static class VoidMaterial implements ToolMaterial {
        @Override
        public float getMiningSpeedMultiplier() {
            return 260.0F;
        }

        @Override
        public float getAttackDamage() {
            return NETHERITE_ATTACK_DAMAGE * 3;
        }

        @Override
        public TagKey<Block> getInverseTag() {
            return ModBlockTags.INCORRECT_FOR_VOID_TOOL;
        }

        @Override
        public int getDurability() {
            return NETHERITE_DURABILITY * 3;
        }

        @Override
        public int getEnchantability() {
            return 45;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.ofItems(ModItems.VOID_INGOT);
        }
    }

    // ==================== 终焉线 ====================
    private static class TerminusMaterial implements ToolMaterial {
        @Override
        public float getMiningSpeedMultiplier() {
            return 520.0F;
        }

        @Override
        public float getAttackDamage() {
            return NETHERITE_ATTACK_DAMAGE * 6;
        }

        @Override
        public TagKey<Block> getInverseTag() {
            return ModBlockTags.INCORRECT_FOR_TERMINUS_TOOL;
        }

        /**
         * 终焉工具为无限耐久。
         * 实际耐久由 ModItems 中的 Item.Settings().maxDamage(0) 决定，
         * maxDamage(0) 会让 ItemStack.isDamageable() 返回 false，
         * 所有 damage() 调用被原版直接拦截，等同无尽模组的无限耐久。
         * 此处返回值仅作占位，不参与实际计算。
         */
        @Override
        public int getDurability() {
            return 1;
        }

        @Override
        public int getEnchantability() {
            return 90;
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.ofItems(ModItems.TERMINUS_INGOT);
        }
    }

    /**
     * 初始化工具材料（在主类 onInitialize 中、ModItems.registerModItems() 之前调用）
     */
    public static void register() {
        STELLAR_CORE = new StellarCoreMaterial();
        VOID = new VoidMaterial();
        TERMINUS = new TerminusMaterial();
    }
}