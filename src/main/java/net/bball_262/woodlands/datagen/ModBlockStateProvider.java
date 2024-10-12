package net.bball_262.woodlands.datagen;

import net.bball_262.woodlands.Woodlands;
import net.bball_262.woodlands.blocks.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Woodlands.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        // Elm wood
        logBlock((RotatedPillarBlock) ModBlocks.ELM_WOOD_LOG.get());
        axisBlock((RotatedPillarBlock) ModBlocks.ELM_WOOD_WOOD.get(), blockTexture(ModBlocks.ELM_WOOD_LOG.get()), blockTexture(ModBlocks.ELM_WOOD_LOG.get()));

        leavesBlock(ModBlocks.ELM_WOOD_LEAVES);

        blockItem(ModBlocks.ELM_WOOD_LOG);
        blockItem(ModBlocks.ELM_WOOD_WOOD);
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("woodlands:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), new ResourceLocation("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
}
