package com.geamnect.divinitymod.item;

import net.minecraft.block.Block;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

public class ModToolMaterials {

    public static ToolMaterial STELLAR_CORE;

    /**
     * 初始化工具材料（在主类 onInitialize 中、ModItems.register() 之前调用）
     */
    public static void register() {
        STELLAR_CORE = new ToolMaterial() {
            @Override
            public float getMiningSpeedMultiplier() {
                return 9.0F;
            }

            @Override
            public float getAttackDamage() {
                return 4.0F;
            }

            @Override
            public TagKey<Block> getInverseTag() {
                return BlockTags.INCORRECT_FOR_NETHERITE_TOOL;
            }

            @Override
            public int getDurability() {
                return 2031;
            }

            @Override
            public int getEnchantability() {
                return 15;
            }

            @Override
            public Ingredient getRepairIngredient() {
                return Ingredient.ofItems(ModItems.STELLAR_CORE_INGOT);
            }
        };
    }
}