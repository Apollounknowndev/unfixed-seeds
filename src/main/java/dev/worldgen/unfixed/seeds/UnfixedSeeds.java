package dev.worldgen.unfixed.seeds;

import dev.worldgen.unfixed.seeds.util.ServerSeed;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.MinecraftServer;

public class UnfixedSeeds implements ModInitializer {

    private static void resetSeed(MinecraftServer minecraftServer) {
        ServerSeed.SEED = null;
    }

    @Override
    public void onInitialize() {
        ServerLifecycleEvents.SERVER_STOPPED.register(UnfixedSeeds::resetSeed);
    }
}
