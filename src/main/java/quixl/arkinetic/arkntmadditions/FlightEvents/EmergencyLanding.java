package quixl.arkinetic.arkntmadditions.FlightEvents;

import com.google.common.collect.Lists;
import net.minecraft.client.audio.Sound;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TranslationTextComponent;
import net.tardis.mod.Tardis;
import net.tardis.mod.flight.FlightEvent;
import net.tardis.mod.flight.FlightEventFactory;
import net.tardis.mod.misc.Console;
import net.tardis.mod.misc.CrashType;
import net.tardis.mod.misc.CrashTypes;
import net.tardis.mod.registries.ControlRegistry;
import net.tardis.mod.tileentities.ConsoleTile;
import net.tardis.mod.tileentities.console.misc.IAlarmType;
import net.tardis.mod.tileentities.console.misc.MonitorOverride;
import quixl.arkinetic.arkntmadditions.RegSoundEvents;

import java.util.ArrayList;
import java.util.function.Supplier;

import java.util.ArrayList;
import java.util.List;


public class EmergencyLanding extends FlightEvent {

    public EmergencyLanding(FlightEventFactory entry, List<ResourceLocation> controls) {
        super(entry, controls);
    }

//    private void initialize(ConsoleTile tile) {
//        List<String> list = new ArrayList<>();
//        list.add(new TranslationTextComponent("flight_events.arkntmadditions.emergency_landing").getString());
//        list.add(new TranslationTextComponent("flight_events.arkntmadditions.emergency_landing2").getString());
//        tile.getInteriorManager().setMonitorOverrides(new MonitorOverride(tile, 100, list));
//    }

    public static final Supplier<ArrayList<ResourceLocation>> CONTROLS = () -> Lists.newArrayList(

            ControlRegistry.LAND_TYPE.get().getRegistryName(),
            ControlRegistry.THROTTLE.get().getRegistryName(),
            ControlRegistry.HANDBRAKE.get().getRegistryName()
    );

    @Override
    public boolean onComplete(ConsoleTile tile) {
        boolean success = super.onComplete(tile);
        if(success) {
            tile.damage(10F);
            tile.crash(CrashTypes.DEFAULT);
            tile.updateClient();
            tile.getInteriorManager().setAlarmOn(true);
        }
        return success;
    }


    @Override
    public void onMiss(ConsoleTile tile) {
        super.onMiss(tile);
        tile.getLevel().playSound(null, tile.getBlockPos(), RegSoundEvents.TARDIS_CANT_START.get(), SoundCategory.PLAYERS, 1F, 1F);
        tile.damage(150F);
        tile.crash(CrashTypes.DEFAULT);
        tile.updateClient();
        tile.getInteriorManager().setAlarmOn(true);
    }

}
