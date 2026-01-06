package com.mod.stuffymod.registry.blocks;

import com.mod.stuffymod.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

public class PreFarmland extends Block {
    public static final int MAX_STAGE = 4;
    public static final IntegerProperty STAGE = IntegerProperty.create("stage", 0, MAX_STAGE);

    public PreFarmland(Properties properties) {super(properties);}

    protected IntegerProperty getStageProperty() {
        return STAGE;
    }

    public int getMaxStage() {return MAX_STAGE;}

    public int getStage(BlockState state) {return state.getValue(this.getStageProperty());}

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(STAGE);
    }

    private static boolean diggingStickType(ItemStack stack) {
        return stack.is(ModItems.DIGGING_STICK_ITEM);
    }

    @Override
    protected @NotNull ItemInteractionResult useItemOn(@NotNull ItemStack stack, @NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hitResult) {
        if (diggingStickType(stack)){
            if(!(getStage(state) == getMaxStage())) {
                level.setBlockAndUpdate(pos, state.setValue(STAGE, state.getValue(STAGE) + 1));
            }
            else {
                level.setBlockAndUpdate(pos, Blocks.FARMLAND.defaultBlockState());
            }
        }
        return ItemInteractionResult.CONSUME;
    }
}
