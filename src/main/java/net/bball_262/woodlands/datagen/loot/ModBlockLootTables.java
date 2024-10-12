package net.bball_262.woodlands.datagen.loot;

import net.bball_262.woodlands.blocks.ModBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {

    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.ELM_WOOD_LOG.get());
        this.dropSelf(ModBlocks.ELM_WOOD_WOOD.get());

        this.dropSelf(ModBlocks.STRIPPED_ELM_WOOD_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_ELM_WOOD_WOOD.get());

        this.dropSelf(ModBlocks.ELM_WOOD_PLANKS.get());
        this.dropSelf(ModBlocks.ELM_WOOD_SAPPLING.get());

        this.add(ModBlocks.ELM_WOOD_LEAVES.get(),
                block -> createLeavesDrops(ModBlocks.ELM_WOOD_LEAVES.get(), ModBlocks.ELM_WOOD_SAPPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}