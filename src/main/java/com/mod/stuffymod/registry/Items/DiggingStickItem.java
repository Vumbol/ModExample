package com.mod.stuffymod.registry.Items;

import com.mod.stuffymod.registry.ModBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class DiggingStickItem extends Item {
    public static final int ANIMATION_DURATION = 10;
    private static final int USE_DURATION = 200;

    public DiggingStickItem(Properties properties) {super(properties);}

    private static final Map<Block, Block> DIGGING_STICK_MAP =
            Map.of(
                    Blocks.GRASS_BLOCK, Blocks.DIRT,
                    Blocks.DIRT_PATH, Blocks.DIRT,
                    Blocks.ROOTED_DIRT, Blocks.DIRT,
                    Blocks.DIRT, ModBlocks.PRE_FARMLAND_STAGE1.get(),
                    ModBlocks.PRE_FARMLAND_STAGE1.get(), ModBlocks.PRE_FARMLAND_STAGE2.get(),
                    ModBlocks.PRE_FARMLAND_STAGE2.get(), ModBlocks.PRE_FARMLAND_STAGE3.get(),
                    ModBlocks.PRE_FARMLAND_STAGE3.get(), ModBlocks.PRE_FARMLAND_STAGE4.get(),
                    ModBlocks.PRE_FARMLAND_STAGE4.get(), ModBlocks.PRE_FARMLAND_STAGE5.get(),
                    ModBlocks.PRE_FARMLAND_STAGE5.get(), Blocks.FARMLAND
            );

    @Override
    public int getUseDuration(@NotNull ItemStack stack, @NotNull LivingEntity entity) {
        return USE_DURATION;
    }

    @Override
    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack stack) {
        return UseAnim.BRUSH;
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();
        Player player = context.getPlayer();
        assert player != null;

        if(!level.isClientSide) {
            if(DIGGING_STICK_MAP.containsKey(clickedBlock)) {
                if(player.getFoodData().getFoodLevel() <= 4 && !player.isCreative()) {
                    player.sendSystemMessage(Component.literal("You're too tired to perform that action."));
                    return InteractionResult.FAIL;
                }
                if(!player.isCreative()){
                    player.getFoodData().setFoodLevel(player.getFoodData().getFoodLevel() - 1);
                }

                level.setBlockAndUpdate(context.getClickedPos(), DIGGING_STICK_MAP.get(clickedBlock).defaultBlockState());
                level.playSound(null, context.getClickedPos(), SoundEvents.GRASS_BREAK, SoundSource.BLOCKS, 1.0F, 1.0F );
                context.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), context.getPlayer(), item -> {
                    assert context.getPlayer() != null;
                    context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND);
                });

                return InteractionResult.SUCCESS;
            }
        }
        return InteractionResult.FAIL;
    }

//    public void onUseTick(@NotNull Level level, @NotNull LivingEntity livingEntity, @NotNull ItemStack stack, int remainingUseDuration) {
//        if (remainingUseDuration >= 0 && livingEntity instanceof Player player) {
//            HitResult hitresult = this.calculateHitResult(player);
//            if (hitresult instanceof BlockHitResult blockhitresult) {
//                if (hitresult.getType() == HitResult.Type.BLOCK) {
//                    int i = this.getUseDuration(stack, livingEntity) - remainingUseDuration + 1;
//                    boolean flag = i % 10 == 5;
//                }
//            }
//        }
//    }

}
