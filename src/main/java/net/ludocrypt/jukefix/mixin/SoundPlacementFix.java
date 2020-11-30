package net.ludocrypt.jukefix.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

import net.minecraft.client.render.WorldRenderer;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.math.BlockPos;

@Mixin(WorldRenderer.class)
public abstract class SoundPlacementFix {

	@ModifyArgs(method = "playSong", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/sound/PositionedSoundInstance;record(Lnet/minecraft/sound/SoundEvent;DDD)Lnet/minecraft/client/sound/PositionedSoundInstance;"))
	private void JUKEFIX_playSong_ARGUMENTS(Args args, SoundEvent song, BlockPos songPosition) {
		args.set(1, (double) songPosition.getX() + 0.5D);
		args.set(2, (double) songPosition.getY() + 1D);
		args.set(3, (double) songPosition.getZ() + 0.5D);
	}

}
