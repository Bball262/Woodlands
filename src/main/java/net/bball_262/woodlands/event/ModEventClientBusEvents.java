package net.bball_262.woodlands.event;

import net.bball_262.woodlands.Woodlands;
import net.bball_262.woodlands.blocks.ModBlocks;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Woodlands.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventClientBusEvents {
    @SubscribeEvent
    public static void registerColoredBlocks(RegisterColorHandlersEvent.Block event) {
        event.register((pState, pLevel, pPos, pTintIndex) -> pLevel != null && pPos != null ? BiomeColors.getAverageFoliageColor(pLevel, pPos) : FoliageColor.getDefaultColor(), ModBlocks.ELM_WOOD_LEAVES.get());
    }

    @SubscribeEvent
    public static void registerColoredItems(RegisterColorHandlersEvent.Item event) {
        event.register((itemStack, pTintIndex) -> {
            BlockState state = ((BlockItem )itemStack.getItem()).getBlock().defaultBlockState();
            return event.getBlockColors().getColor(state, null, null, pTintIndex);
        }, ModBlocks.ELM_WOOD_LEAVES.get());
    }
}
