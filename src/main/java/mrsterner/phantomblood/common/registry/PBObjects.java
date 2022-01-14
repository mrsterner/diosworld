package mrsterner.phantomblood.common.registry;

import mrsterner.phantomblood.PhantomBlood;
import mrsterner.phantomblood.common.block.*;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.loader.FabricLoader;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.*;
import net.minecraft.util.DyeColor;
import net.minecraft.block.entity.BlockEntityType.Builder;
import mrsterner.phantomblood.common.item.*;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

import java.util.LinkedHashMap;
import java.util.Map;

import static net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings.copyOf;


public class PBObjects {
    private static final Map<Block, Identifier> BLOCKS = new LinkedHashMap<>();
    private static final Map<BlockEntityType<?>, Identifier> BLOCK_ENTITY_TYPES = new LinkedHashMap<>();
    private static final Map<Item, Identifier> ITEMS = new LinkedHashMap<>();

    //Item

    public static final Item ARROW_HEAD = create("arrow_head", new ArrowHeadItem(gen().maxCount(1)));
    public static final Item DAGGER = create("dagger", new DaggerItem(ToolMaterials.IRON, 1, -2, gen()));
    public static final Item BLOOD_AMPOULE = create("blood_ampoule", new BloodAmpouleItem(gen()));
    public static final Item AMPOULE = create("ampoule", new Item(gen()));
    public static final Item STONE_OF_AJA = create("stone_of_aja", new Item(new Item.Settings())); //Should not register in Item group right now
    public static final Item KILLER_QUEEN_TRIGGER = create("killer_queen_trigger", new KillerQueenTriggerItem(new Item.Settings()));
    public static final Item BLACK_FABRIC = create("black_fabric", new Item(gen()));

    public static final Item CORPSE_HEAD = create("corpse_head", new Item(gen()));
    public static final Item CORPSE_BODY = create("corpse_body", new Item(gen()));
    public static final Item CORPSE_ARM_RIGHT = create("corpse_arm_right", new Item(gen()));
    public static final Item CORPSE_ARM_LEFT = create("corpse_arm_left", new Item(gen()));
    public static final Item CORPSE_EARS = create("corpse_ears", new Item(gen()));
    public static final Item CORPSE_HEART = create("corpse_heart", new Item(gen()));
    public static final Item CORPSE_SPINE = create("corpse_spine", new Item(gen()));
    public static final Item CORPSE_LEG_RIGHT = create("corpse_leg_right", new Item(gen()));
    public static final Item CORPSE_LEG_LEFT = create("corpse_leg_left", new Item(gen()));
    public static final Item CORPSE_EYE_RIGHT = create("corpse_eye_right", new Item(gen()));
    public static final Item CORPSE_EYE_LEFT = create("corpse_eye_left", new Item(gen()));

    public static final Item ANUBIS_SWORD = create("anubis_sword", new AnubisSwordItem(ToolMaterials.IRON,4,1, gen()));
    public static final Item KILLER_VIRUS = create("killer_virus", new KillerVirusItem(gen().maxCount(1)));

    public static final Item STAR_PLATINUM_DISC = create("star_platinum_disc", new StandDiscItem(gen().rarity(Rarity.RARE).maxCount(1)));
    public static final Item THE_WORLD_DISC = create("the_world_disc", new StandDiscItem(gen().rarity(Rarity.RARE).maxCount(1)));
    public static final Item KILLER_QUEEN_DISC = create("killer_queen_disc", new StandDiscItem(gen().rarity(Rarity.RARE).maxCount(1)));
    public static final Item CRAZY_DIAMOND_DISC = create("crazy_diamond_disc", new StandDiscItem(gen().rarity(Rarity.RARE).maxCount(1)));
    public static final Item WEATHER_REPORT_DISC = create("weather_report_disc", new StandDiscItem(gen().rarity(Rarity.RARE).maxCount(1)));
    public static final Item DARK_BLUE_MOON_DISC = create("dark_blue_moon_disc", new StandDiscItem(gen().rarity(Rarity.RARE).maxCount(1)));
    public static final Item THE_SUN_DISC = create("the_sun_disc", new StandDiscItem(gen().rarity(Rarity.RARE).maxCount(1)));
    public static final Item KING_CRIMSON_DISC = create("king_crimson_disc", new StandDiscItem(gen().rarity(Rarity.RARE).maxCount(1)));
    public static final Item PURPLE_HAZE_DISC = create("purple_haze_disc", new StandDiscItem(gen().rarity(Rarity.RARE).maxCount(1)));
    public static final Item TWENTY_CENTURY_BOY_DISC = create("20th_century_boy_disc", new StandDiscItem(gen().rarity(Rarity.RARE).maxCount(1)));
    public static final Item HIEROPHANT_GREEN_DISC = create("hierophant_green_disc", new StandDiscItem(gen().rarity(Rarity.RARE).maxCount(1)));
    public static final Item ANUBIS_DISC = create("anubis_disc", new StandDiscItem(gen().rarity(Rarity.RARE).maxCount(1)));


    //Blocks
    public static final Block SPACE_TIME_BLOCK  = create("space_time", new SpaceTimeBlock(FabricBlockSettings.copyOf(Blocks.BEDROCK)), true);

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

    public static final Block URNS = create("urns", new UrnBlock(FabricBlockSettings.of(Material.EGG)), true);
    public static final Block VESSEL = create("vessels", new VesselBlock(FabricBlockSettings.of(Material.EGG)), true);

    //BlockEntities
    public static final BlockEntityType<SpaceTimeBlockEntity> SPACE_TIME_BLOCK_ENTITY = create("space_time_entity", FabricBlockEntityTypeBuilder.create(SpaceTimeBlockEntity::new, PBObjects.SPACE_TIME_BLOCK).build(null));

    //Armor
    public static final Item STONE_MASK_ITEM = create("stonemaskitem", new StonemaskItem(PBMaterials.VAMPIRE_ARMOR, EquipmentSlot.HEAD, gen()));
    public static final Item BLOODY_STONE_MASK_ITEM = create("bloodstonemaskitem", new BloodStonemaskItem(ArmorMaterials.DIAMOND, EquipmentSlot.HEAD, gen()));
    public static final Item VAMPIRE_HAT = create("vampire_hat", new VampireArmorItem(PBMaterials.VAMPIRE_ARMOR, EquipmentSlot.HEAD, gen().maxCount(1)));
    public static final Item VAMPIRE_JACKET = create("vampire_coat", new VampireArmorItem(PBMaterials.VAMPIRE_ARMOR, EquipmentSlot.CHEST, gen().maxCount(1)));
    public static final Item VAMPIRE_JACKET_F = create("vampire_coat_f", new VampireArmorFItem(PBMaterials.VAMPIRE_ARMOR, EquipmentSlot.CHEST, gen().maxCount(1)));
    public static final Item VAMPIRE_PANTS = create("vampire_pants", new VampireArmorItem(PBMaterials.VAMPIRE_ARMOR, EquipmentSlot.LEGS, gen().maxCount(1)));
    public static final Item VAMPIRE_BOOTS = create("vampire_shoes", new VampireArmorItem(PBMaterials.VAMPIRE_ARMOR, EquipmentSlot.FEET, gen().maxCount(1)));

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

    private static <T extends BlockEntity> BlockEntityType<T> create(String name, BlockEntityType<T> type) {
        BLOCK_ENTITY_TYPES.put(type, new Identifier(PhantomBlood.MODID, name));
        return type;
    }

    private static Item.Settings gen() {
        return new Item.Settings().group(PhantomBlood.PHANTOMBLOOD_GROUP);
    }

    public static void init() {
        BLOCKS.keySet().forEach(block -> Registry.register(Registry.BLOCK, BLOCKS.get(block), block));
        BLOCK_ENTITY_TYPES.keySet().forEach(blockEntityType -> Registry.register(Registry.BLOCK_ENTITY_TYPE, BLOCK_ENTITY_TYPES.get(blockEntityType), blockEntityType));
        ITEMS.keySet().forEach(item -> Registry.register(Registry.ITEM, ITEMS.get(item), item));
    }
}
