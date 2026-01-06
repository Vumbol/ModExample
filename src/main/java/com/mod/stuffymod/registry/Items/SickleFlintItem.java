package com.mod.stuffymod.registry.Items;

import com.mod.stuffymod.registry.ModBlocks;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

import static net.minecraft.world.level.block.Block.dropResources;
import static net.minecraft.world.level.block.Block.popResource;
import static net.minecraft.world.level.block.CropBlock.AGE;
import static net.minecraft.world.level.block.CropBlock.MAX_AGE;

public class SickleFlintItem extends Item {
    private static final Map<Block, Block> SICKLE_MAP =
            Map.of(
                    Blocks.WHEAT, Blocks.WHEAT
            );


    public SickleFlintItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();
        if(SICKLE_MAP.containsKey(clickedBlock)){
            if(!level.isClientSide){
                if(level.getBlockState(context.getClickedPos()).getValue(AGE) == MAX_AGE){
                    popResource(level, context.getClickedPos(), new ItemStack(Items.WHEAT, 1));
                    popResource(level, context.getClickedPos(), new ItemStack(Items.WHEAT_SEEDS, 1 + level.random.nextInt(2)));
                } else {
                    return InteractionResult.FAIL;
                }

                level.setBlockAndUpdate(context.getClickedPos(), SICKLE_MAP.get(clickedBlock).defaultBlockState());

                context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
                        item -> {
                            assert context.getPlayer() != null;
                            context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND);
                        });

                level.playSound(null, context.getClickedPos(), SoundEvents.GRASS_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F );
                return InteractionResult.SUCCESS;
            }
        }

        return InteractionResult.FAIL;
    }
}
