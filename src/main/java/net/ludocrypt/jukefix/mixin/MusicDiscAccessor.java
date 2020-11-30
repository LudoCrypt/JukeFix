package net.ludocrypt.jukefix.mixin;

import java.util.Map;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.item.Item;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.sound.SoundEvent;

@Mixin(MusicDiscItem.class)
public interface MusicDiscAccessor {

	@Invoker("<init>")
	public static MusicDiscItem createMusicDiscItem(int comparatorOutput, SoundEvent sound, Item.Settings settings) {
		throw new UnsupportedOperationException();
	}

	@Accessor("MUSIC_DISCS")
	public static Map<SoundEvent, MusicDiscItem> MUSIC_DISCS() {
		throw new AssertionError("mixin");
	}
}
