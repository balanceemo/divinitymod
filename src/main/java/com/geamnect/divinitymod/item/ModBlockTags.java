package com.geamnect.divinitymod.item;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

/**
 * 自定义方块标签注册
 * <p>
 * 白名单（XXX_MINEABLE）仅在 JSON 标签文件中通过 #divinitymod:xxx 被引用，
 * Java 侧不直接使用，保留常量便于统一管理和后续扩展。
 */
@SuppressWarnings("unused")
public class ModBlockTags {

    private static TagKey<Block> of(String name) {
        return TagKey.of(RegistryKeys.BLOCK, Identifier.of("divinitymod", name));
    }

    // ==================== 可挖掘白名单 ====================

    /** 陨星锭可挖掘（陨星线全部） */
    public static final TagKey<Block> STELLAR_CORE_MINEABLE = of("stellar_core_mineable");
    /** 虚空锭可挖掘（陨星线 + 虚空线） */
    public static final TagKey<Block> VOID_MINEABLE         = of("void_mineable");
    /** 终焉锭可挖掘（全部） */
    public static final TagKey<Block> TERMINUS_MINEABLE     = of("terminus_mineable");

    // ==================== 不适宜挖掘黑名单 ====================

    /** 陨星锭工具挖不动的方块 */
    public static final TagKey<Block> INCORRECT_FOR_STELLAR_CORE_TOOL = of("incorrect_for_stellar_core_tool");
    /** 虚空锭工具挖不动的方块 */
    public static final TagKey<Block> INCORRECT_FOR_VOID_TOOL         = of("incorrect_for_void_tool");
    /** 终焉锭工具挖不动的方块 */
    public static final TagKey<Block> INCORRECT_FOR_TERMINUS_TOOL     = of("incorrect_for_terminus_tool");
}