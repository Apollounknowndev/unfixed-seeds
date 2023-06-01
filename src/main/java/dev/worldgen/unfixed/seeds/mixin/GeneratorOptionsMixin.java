package dev.worldgen.unfixed.seeds.mixin;

import dev.worldgen.unfixed.seeds.util.ServerSeed;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.gen.GeneratorOptions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Optional;

@Mixin(GeneratorOptions.class)
public class GeneratorOptionsMixin {

    @Inject(method= "<init>(JZZLnet/minecraft/util/registry/Registry;Ljava/util/Optional;)V",at=@At(value="TAIL"))
    private void unfixedSeeds$setServerSeed(long seed, boolean generateStructures, boolean bonusChest, Registry<DimensionOptions> options, Optional<String> legacyCustomOptions, CallbackInfo ci) {
        ServerSeed.LOGGER.debug("Set seed to "+seed);
        ServerSeed.SEED = seed;
    }
}