package quixl.arkinetic.arkntmadditions.Upgrades;

import net.minecraft.util.SoundCategory;
import net.tardis.mod.controls.ThrottleControl;
import net.tardis.mod.misc.ITickable;
import net.tardis.mod.subsystem.Subsystem;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.upgrades.Upgrade;
import net.tardis.mod.upgrades.UpgradeEntry;
import quixl.arkinetic.arkntmadditions.RegSoundEvents;

public class EngineBooster extends Upgrade implements ITickable {
    public boolean isBoosting;
    public EngineBooster(UpgradeEntry entry, ConsoleTile tile, Class < ? extends Subsystem > clazz) {
        super(entry, tile, clazz);
        tile.registerTicker(this);
    }

    private void BoostThemEngines(ConsoleTile tile) {
        isBoosting = true;
        tile.setDestinationReachedTick((int)(tile.getReachDestinationTick() / 0));
    }

    @Override
    public void tick(ConsoleTile console) {
//        this.getConsole().getControl(ThrottleControl.class).ifPresent(check -> {
//            if (check.getAmount() == 1F && this.isUsable() && this.isActivated()) {
//                console.getControl(XControl.class).ifPresent(control -> {
//                    if (control.onHit(console, this.getConsole().getPilot())) {
//                        BoostThemEngines(console);
//                    }
//                });
//                console.getControl(YControl.class).ifPresent(control -> {
//                    if (control.onHit(console, this.getConsole().getPilot())) {
//                        BoostThemEngines(console);
//                    }
//                });
//                console.getControl(ZControl.class).ifPresent(control -> {
//                    if (control.onHit(console, this.getConsole().getPilot())) {
//                        BoostThemEngines(console);
//                    }
//                });
//            }
//        });

        /* ! DYNAMIC COORDINATES (NO UPGRADE REQUIRED) */
//        if (console.isInFlight()) {
//            console.setCurrentLocation(console.getCurrentDimension(), console.getPositionInFlight().getPos());
//        }
    }

    @Override
    public void onLand() {

    }

    @Override
    public void onTakeoff() {
        this.getConsole().getControl(ThrottleControl.class).ifPresent(control -> {
            if (control.getAmount() == 1F && this.isUsable() && this.isActivated()) {
                BoostThemEngines(this.getConsole());
                this.getConsole().getLevel().playSound(null, this.getConsole().getBlockPos(), RegSoundEvents.ENGINE_BOOST_START.get(), SoundCategory.PLAYERS, 0.5F, 1F);
            }
        });
    }

    @Override
    public void onFlightSecond() {

    }
}