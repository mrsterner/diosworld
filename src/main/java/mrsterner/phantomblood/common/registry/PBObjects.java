package mrsterner.phantomblood.common.registry;

import mrsterner.phantomblood.common.block.CoffinBlock;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.fabricmc.loader.FabricLoader;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.*;
import net.minecraft.tag.Tag;
import net.minecraft.util.DyeColor;
import net.minecraft.block.entity.BlockEntityType.Builder;
import mrsterner.phantomblood.PhantomBlood;
import mrsterner.phantomblood.common.item.*;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.LinkedHashMap;
import java.util.Map;

import static mrsterner.phantomblood.PhantomBlood.PHANTOMBLOOD_GROUP;
import static net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings.copyOf;


public class PBObjects {
    private static final Map<Block, Identifier> BLOCKS = new LinkedHashMap<>();
    private static final Map<Item, Identifier> ITEMS = new LinkedHashMap<>();


    //Armor
    public static final Item STONE_MASK_ITEM = create("stonemaskitem", new StonemaskItem(ArmorMaterials.DIAMOND, EquipmentSlot.HEAD, gen()));
    public static final Item BLOODY_STONE_MASK_ITEM = create("bloodstonemaskitem", new BloodStonemaskItem(ArmorMaterials.DIAMOND, EquipmentSlot.HEAD, gen()));
    public static final Item VAMPIRE_HAT = create("vampire_hat", new VampireArmorItem(PBMaterials.VAMPIRE_ARMOR, EquipmentSlot.HEAD));
    public static final Item VAMPIRE_JACKET = create("vampire_coat", new VampireArmorItem(PBMaterials.VAMPIRE_ARMOR, EquipmentSlot.CHEST));
    public static final Item VAMPIRE_JACKET_F = create("vampire_coat_f", new VampireArmorItem(PBMaterials.VAMPIRE_ARMOR, EquipmentSlot.CHEST));
    public static final Item VAMPIRE_PANTS = create("vampire_pants", new VampireArmorItem(PBMaterials.VAMPIRE_ARMOR, EquipmentSlot.LEGS));
    public static final Item VAMPIRE_BOOTS = create("vampire_shoes", new VampireArmorItem(PBMaterials.VAMPIRE_ARMOR, EquipmentSlot.FEET));
    //Item
    public static final Item STONE_OF_AJA = create("stone_of_aja", new Item(gen()));
    public static final Item BLOOD_AMPOULE = create("blood_ampoule", new BloodAmpouleItem(gen()));
    public static final Item AMPOULE = create("ampoule", new Item(gen()));
    //Blocks
    public static final Block BLACK_COFFIN = create("black_coffin", new CoffinBlock(DyeColor.BLACK, copyOf(Blocks.BLACKSTONE).nonOpaque()), true);
    public static final Block RED_COFFIN = create("red_coffin", new CoffinBlock(DyeColor.RED, copyOf(Blocks.BLACKSTONE).nonOpaque()), true);
    public static final Block GREEN_COFFIN = create("green_coffin", new CoffinBlock(DyeColor.GREEN, copyOf(Blocks.BLACKSTONE).nonOpaque()), true);
    public static final Block BROWN_COFFIN = create("brown_coffin", new CoffinBlock(DyeColor.BROWN, copyOf(Blocks.BLACKSTONE).nonOpaque()), true);
    public static final Block BLUE_COFFIN = create("blue_coffin", new CoffinBlock(DyeColor.BLUE, copyOf(Blocks.BLACKSTONE).nonOpaque()), true);
    public static final Block PURPLE_COFFIN = create("purple_coffin", new CoffinBlock(DyeColor.PURPLE, copyOf(Blocks.BLACKSTONE).nonOpaque()), true);
    public static final Block CYAN_COFFIN = create("cyan_coffin", new CoffinBlock(DyeColor.CYAN, copyOf(Blocks.BLACKSTONE).nonOpaque()), true);
    public static final Block LIGHT_GRAY_COFFIN = create("light_gray_coffin", new CoffinBlock(DyeColor.LIGHT_GRAY, copyOf(Blocks.BLACKSTONE).nonOpaque()), true);
    public static final Block GRAY_COFFIN = create("gray_coffin", new CoffinBlock(DyeColor.GRAY, copyOf(Blocks.BLACKSTONE).nonOpaque()), true);
    public static final Block PINK_COFFIN = create("pink_coffin", new CoffinBlock(DyeColor.PINK, copyOf(Blocks.BLACKSTONE).nonOpaque()), true);
    public static final Block LIME_COFFIN = create("lime_coffin", new CoffinBlock(DyeColor.LIME, copyOf(Blocks.BLACKSTONE).nonOpaque()), true);
    public static final Block YELLOW_COFFIN = create("yellow_coffin", new CoffinBlock(DyeColor.YELLOW, copyOf(Blocks.BLACKSTONE).nonOpaque()), true);
    public static final Block LIGHT_BLUE_COFFIN = create("light_blue_coffin", new CoffinBlock(DyeColor.LIGHT_BLUE, copyOf(Blocks.BLACKSTONE).nonOpaque()), true);
    public static final Block MAGENTA_COFFIN = create("magenta_coffin", new CoffinBlock(DyeColor.MAGENTA, copyOf(Blocks.BLACKSTONE).nonOpaque()), true);
    public static final Block ORANGE_COFFIN = create("orange_coffin", new CoffinBlock(DyeColor.ORANGE, copyOf(Blocks.BLACKSTONE).nonOpaque()), true);
    public static final Block WHITE_COFFIN = create("white_coffin", new CoffinBlock(DyeColor.WHITE, copyOf(Blocks.BLACKSTONE).nonOpaque()), true);

    //Tags
    public static final Tag<Item> VAMPIRE_FOODS = TagRegistry.item(new Identifier(PhantomBlood.MODID, "vampire_foods"));


    //Register
    private static <T extends Block> T create(String name, T block, boolean createItem) {
        BLOCKS.put(block, new Identifier(PhantomBlood.MODID, name));
        if (createItem) {
            ITEMS.put(new BlockItem(block, gen()), BLOCKS.get(block));
        }
        return block;
    }

    private static <T extends Item> T create(String name, T item) {
        ITEMS.put(item, new Identifier(PhantomBlood.MODID, name));
        return item;
    }


    private static Item.Settings gen() {
        return new Item.Settings().group(PHANTOMBLOOD_GROUP);
    }

    public static <T extends BlockEntity> BlockEntityType<T> registerBlockEntity(String name, Builder<T> builder) {
        if (FabricLoader.INSTANCE.isDevelopmentEnvironment()) {
            BlockEntityType<T> blockEntityType = builder.build(null);
            Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(PhantomBlood.MODID, name), blockEntityType);
            return blockEntityType;
        }
        return null;
    }

    public static void init() {
        BLOCKS.keySet().forEach(block -> Registry.register(Registry.BLOCK, BLOCKS.get(block), block));
        ITEMS.keySet().forEach(item -> Registry.register(Registry.ITEM, ITEMS.get(item), item));
    }


}
