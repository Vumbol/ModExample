package com.mod.stuffymod.registry;

import com.mod.stuffymod.StuffyMod;
import com.mod.stuffymod.registry.blocks.ExampleBlock;
import com.mod.stuffymod.registry.blocks.PreFarmland;
import com.mod.stuffymod.registry.blocks.SmallRockBlock;
import com.mod.stuffymod.registry.blocks.StickPlacedBlock;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.item.BlockItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.*;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(StuffyMod.MODID);

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(StuffyMod.MODID);

    public static final DeferredBlock<Block> EXAMPLE_BLOCK = BLOCKS.register("example_block",
            () -> new ExampleBlock(BlockBehaviour.Properties.of().noOcclusion().destroyTime(2)));

    public static final DeferredBlock<Block> SMALL_ROCK = BLOCKS.register("small_rock",
            () -> new SmallRockBlock(BlockBehaviour.Properties.of().noOcclusion().destroyTime(1).noCollission()));

    public static final DeferredBlock<Block> STICK_PLACED = BLOCKS.register("stick_placed",
            () -> new StickPlacedBlock(BlockBehaviour.Properties.of().noOcclusion().destroyTime(1).noCollission()));

    public static final DeferredBlock<Block> PRE_FARMLAND = BLOCKS.register("pre_farmland",
            () -> new PreFarmland(BlockBehaviour.Properties.of().destroyTime(1)));

    public static final DeferredBlock<Block> PRE_FARMLAND_STAGE1 = BLOCKS.register("pre_farmland_stage1",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> PRE_FARMLAND_STAGE2 = BLOCKS.register("pre_farmland_stage2",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> PRE_FARMLAND_STAGE3 = BLOCKS.register("pre_farmland_stage3",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> PRE_FARMLAND_STAGE4 = BLOCKS.register("pre_farmland_stage4",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));
    public static final DeferredBlock<Block> PRE_FARMLAND_STAGE5 = BLOCKS.register("pre_farmland_stage5",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT)));

    public static final DeferredItem<BlockItem> EXAMPLE_BLOCK_ITEM =
            ITEMS.registerSimpleBlockItem("example_block", EXAMPLE_BLOCK);

    public static final DeferredItem<BlockItem> SMALL_ROCK_ITEM =
            ITEMS.registerSimpleBlockItem("small_rock", SMALL_ROCK);

    public static final DeferredItem<BlockItem> STICK_PLACED_ITEM =
            ITEMS.registerSimpleBlockItem("stick_placed", STICK_PLACED);

    public static final DeferredItem<BlockItem> PRE_FARMLAND_ITEM =
            ITEMS.registerSimpleBlockItem("pre_farmland", PRE_FARMLAND);

    public static final DeferredItem<BlockItem> PRE_FARMLAND_STAGE1_ITEM =
            ITEMS.register("pre_farmland_stage1", () -> new BlockItem(PRE_FARMLAND_STAGE1.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> PRE_FARMLAND_STAGE2_ITEM =
            ITEMS.register("pre_farmland_stage2", () -> new BlockItem(PRE_FARMLAND_STAGE2.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> PRE_FARMLAND_STAGE3_ITEM =
            ITEMS.register("pre_farmland_stage3", () -> new BlockItem(PRE_FARMLAND_STAGE3.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> PRE_FARMLAND_STAGE4_ITEM =
            ITEMS.register("pre_farmland_stage4", () -> new BlockItem(PRE_FARMLAND_STAGE4.get(), new Item.Properties()));
    public static final DeferredItem<BlockItem> PRE_FARMLAND_STAGE5_ITEM =
            ITEMS.register("pre_farmland_stage5", () -> new BlockItem(PRE_FARMLAND_STAGE5.get(), new Item.Properties()));

    public static void register(IEventBus eventBus) {BLOCKS.register(eventBus);
    }
}
