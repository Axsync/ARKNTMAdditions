package quixl.arkinetic.arkntmadditions.Mixin;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.tardis.mod.flight.FlightEvent;
import net.tardis.mod.flight.FlightEventFactory;
import net.tardis.mod.registries.FlightEventRegistry;
import quixl.arkinetic.arkntmadditions.ARKNTMAdditions;
import quixl.arkinetic.arkntmadditions.Config;
import quixl.arkinetic.arkntmadditions.FlightEvents.DimensionalBreach;
import quixl.arkinetic.arkntmadditions.FlightEvents.EmergencyLanding;
import quixl.arkinetic.arkntmadditions.FlightEvents.PowerFailure;
import quixl.arkinetic.arkntmadditions.FlightEvents.TemporalHiccup;

import java.util.ArrayList;
import java.util.function.Supplier;

public class RegFlightEvent extends FlightEventRegistry {
    public static final DeferredRegister<FlightEventFactory> FLIGHT_EVENTS = DeferredRegister.create(FlightEventFactory.class, ARKNTMAdditions.MOD_ID);

    public static final RegistryObject<FlightEventFactory> TEMPORAL_HICCUP = FLIGHT_EVENTS.register("temporal_hiccup", () -> setupFlightEvent(TemporalHiccup::new, TemporalHiccup.CONTROLS));
    public static final RegistryObject<FlightEventFactory> POWER_FAILURE = FLIGHT_EVENTS.register("power_failure", () -> setupFlightEvent(PowerFailure::new, PowerFailure.CONTROLS));
    public static final RegistryObject<FlightEventFactory> EMERGENCY_LANDING = FLIGHT_EVENTS.register("emergency_landing", () -> setupFlightEvent(EmergencyLanding::new, EmergencyLanding.CONTROLS));

    public static final RegistryObject<FlightEventFactory> DIMENSIONAL_BREACH = FLIGHT_EVENTS.register("dimensional_breach", () -> setupFlightEvent(DimensionalBreach::new, DimensionalBreach.CONTROLS));
    public static FlightEventFactory setupFlightEvent(FlightEventFactory.IFlightEventFactory<FlightEvent> event, Supplier<ArrayList<ResourceLocation>> sequence){
        FlightEventFactory fact = new FlightEventFactory(event, sequence);
        return fact;
    }

    public static FlightEventFactory setupFlightEvent(FlightEventFactory.IFlightEventFactory<FlightEvent> event, Supplier<ArrayList<ResourceLocation>> sequence, boolean normal) {
        FlightEventFactory fact = setupFlightEvent(event, sequence);
        fact.setNormal(false);
        return fact;
    }

    //Call in server setup or FMLStartupEvent
    public static void addRandomEvent(int weight, FlightEventFactory event){
        RegFlightEvent.RANDOM_EVENTS.addChance(weight, event);
    }

    public static void registerRandomEntries() {
        addRandomEvent(Config.COMMON.TemporalHiccupRarity.get(), TEMPORAL_HICCUP.get());
        addRandomEvent(Config.COMMON.PowerFailureRarity.get(), POWER_FAILURE.get());
        addRandomEvent(Config.COMMON.EmergencyLandingRarity.get(), EMERGENCY_LANDING.get());
        addRandomEvent(Config.COMMON.DimensionalBreachRarity.get(), DIMENSIONAL_BREACH.get());
    }
}
