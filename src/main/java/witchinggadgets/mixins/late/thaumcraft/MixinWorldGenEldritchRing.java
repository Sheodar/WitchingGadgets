package witchinggadgets.mixins.late.thaumcraft;

import net.minecraft.block.Block;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import thaumcraft.common.lib.world.WorldGenEldritchRing;
import witchinggadgets.common.WGConfig;

import com.gtnewhorizon.mixinextras.injector.ModifyReturnValue;

@Mixin(WorldGenEldritchRing.class)
public class MixinWorldGenEldritchRing {

    @ModifyReturnValue(method = "GetValidSpawnBlocks", at = @At("RETURN"), remap = false)
    private Block[] witchinggadgets$modifyWorldgen(Block[] original) {
        if (WGConfig.coremod_worldgenValidBase_EldritchRing != null) {
            return WGConfig.coremod_worldgenValidBase_EldritchRing;
        }
        return original;
    }

}
