package apollo.unfixed.seeds.mixin;

import apollo.unfixed.seeds.util.ServerSeed;
import net.minecraft.world.gen.chunk.NoiseChunkGenerator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(NoiseChunkGenerator.class)
public class NoiseChunkGeneratorMixin {
	@ModifyVariable(method= "<init>(Lnet/minecraft/util/registry/Registry;Lnet/minecraft/util/registry/Registry;" +
			"Lnet/minecraft/world/biome/source/BiomeSource;Lnet/minecraft/world/biome/source/BiomeSource;" +
			"JLnet/minecraft/util/registry/RegistryEntry;)V",at=@At("HEAD"), argsOnly = true)
	private static long goodbyeFixedSeed_getServerSeed(long seed) {
		return ServerSeed.SEED;
	}
}