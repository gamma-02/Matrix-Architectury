package net.examplemod.forge;

import net.examplemod.Registrar;
import net.examplemod.RegistryEntry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

@Registrar(element = Block.class, modid = "examplemod")
public class ModBlocks {
    @RegistryEntry("test_block")
    public static Block TEST_BLOCK = new Block(BlockBehaviour.Properties.copy(Blocks.GRASS));
}
