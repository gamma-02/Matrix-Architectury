package net.examplemod.forge;

import dev.architectury.platform.forge.EventBuses;
import net.examplemod.ExampleMod;
import net.examplemod.Matrix;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ExampleMod.MOD_ID)
public class ExampleModForge {
    public ExampleModForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(ExampleMod.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        ExampleMod.init();

        // Matrix code in this if!
        //MAKE SURE TO REGISTER BLOCK BEFORE-wait no that does work cuz java


        if(Matrix.getMatrix() instanceof ForgeSpecificMatrix matrix){
            matrix.register(ModItems.class, FMLJavaModLoadingContext.get().getModEventBus());
            matrix.register(ModBlocks.class, FMLJavaModLoadingContext.get().getModEventBus());
        }
    }
}
