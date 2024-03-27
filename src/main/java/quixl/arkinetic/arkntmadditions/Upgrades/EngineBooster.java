package quixl.arkinetic.arkntmadditions.Upgrades;

import net.minecraft.client.Minecraft;
import net.minecraft.client.Monitor;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.tardis.mod.controls.HandbrakeControl;
import net.tardis.mod.controls.MonitorControl;
import net.tardis.mod.controls.ThrottleControl;
import net.tardis.mod.controls.XControl;
import net.tardis.mod.misc.Console;
import net.tardis.mod.misc.ITickable;
import net.tardis.mod.misc.ObjectWrapper;
import net.tardis.mod.misc.SpaceTimeCoord;
import net.tardis.mod.subsystem.Subsystem;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.tileentities.exteriors.ExteriorTile;
import net.tardis.mod.upgrades.Upgrade;
import net.tardis.mod.upgrades.UpgradeEntry;
import net.tardis.mod.world.dimensions.VortexChunkGenerator;
import quixl.arkinetic.arkntmadditions.ARKNTMAdditions;
import quixl.arkinetic.arkntmadditions.RegSoundEvents;

public class EngineBooster extends Upgrade implements ITickable {
    public boolean isBoosting;
    public EngineBooster(UpgradeEntry entry, ConsoleTile tile, Class < ? extends Subsystem > clazz) {
        super(entry, tile, clazz);
        tile.registerTicker(this);
    }

    private void BoostThemEngines(ConsoleTile tile) {
        isBoosting = true;
        tile.setDestinationReachedTick((int)(tile.getReachDestinationTick() * 0.75));
    }

    @Override
    public void tick(ConsoleTile console) {
        /* ! DYNAMIC COORDINATES (NO UPGRADE REQUIRED) */
        if (console.isInFlight()) {
            console.setCurrentLocation(console.getCurrentDimension(), console.getPositionInFlight().getPos());
        }
    }

    @Override
    public void onLand() {

    }

    @Override
    public void onTakeoff() {
        this.getConsole().getControl(ThrottleControl.class).ifPresent(control -> {
            if (control.getAmount() == 1F && this.isUsable() && this.isActivated()) {
                this.getConsole().getLevel().playSound(null, this.getConsole().getBlockPos(), RegSoundEvents.ENGINE_BOOST_START.get(), SoundCategory.PLAYERS, 0.5F, 1F);
                BoostThemEngines(this.getConsole());
            }
        });
    }

    @Override
    public void onFlightSecond() {

    }
}