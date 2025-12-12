package com.mod.stuffymod.registry.Items;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Map;

public class SickleFlintItem extends Item {
    private static final Map<Block, Block> SICKLE_MAP =
            Map.of(
                    Blocks.WHEAT, Blocks.WHEAT
            );


    public SickleFlintItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();
        if(SICKLE_MAP.containsKey(clickedBlock)){
            if(!level.isClientSide){
                level.setBlockAndUpdate(context.getClickedPos(), SICKLE_MAP.get(clickedBlock).defaultBlockState());

                context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(),
                        item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, context.getClickedPos(), SoundEvents.GRASS_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F );
            }
        }

        return InteractionResult.SUCCESS;
    }
}
