package com.mod.stuffymod.registry;

import com.mod.stuffymod.StuffyMod;
import com.mod.stuffymod.registry.blocks.ExampleBlock;
import com.mod.stuffymod.registry.blocks.SmallRockBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.item.BlockItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.*;

public class ModBlocks {

//    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
//        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
//        registerBlockItem(name, toReturn);
//        return toReturn;
//    }
//
//    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
//        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
//    }

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(StuffyMod.MODID);

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(StuffyMod.MODID);

    public static final DeferredBlock<Block> EXAMPLE_BLOCK = BLOCKS.register("example_block",
            () -> new ExampleBlock(BlockBehaviour.Properties.of().noOcclusion().destroyTime(2)));

    public static final DeferredBlock<Block> SMALL_ROCK = BLOCKS.register("small_rock",
            () -> new SmallRockBlock(BlockBehaviour.Properties.of().noOcclusion().destroyTime(1).noCollission()));

    public static final DeferredItem<BlockItem> EXAMPLE_BLOCK_ITEM =
            ITEMS.registerSimpleBlockItem("example_block", EXAMPLE_BLOCK);

    public static final DeferredItem<BlockItem> SMALL_ROCK_ITEM =
            ITEMS.registerSimpleBlockItem("small_rock", SMALL_ROCK);

    public static void register(IEventBus eventBus) {BLOCKS.register(eventBus);
    }
}
