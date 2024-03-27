package quixl.arkinetic.arkntmadditions;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class Config {
    public static final Config.Common COMMON;
    public static final ForgeConfigSpec COMMON_SPEC;

    static {
        final Pair<Config.Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Config.Common::new);
        COMMON = specPair.getLeft();
        COMMON_SPEC = specPair.getRight();
    }

    public static class Common {
        public ForgeConfigSpec.ConfigValue<Integer> FoodCubeCost;
        public ForgeConfigSpec.ConfigValue<Integer> TemporalHiccupRarity;
        public ForgeConfigSpec.ConfigValue<Integer> PowerFailureRarity;
        public ForgeConfigSpec.ConfigValue<Integer> EmergencyLandingRarity;
        public ForgeConfigSpec.ConfigValue<Integer> DimensionalBreachRarity;

        public Common(ForgeConfigSpec.Builder builder) {

            TemporalHiccupRarity = builder.comment("How frequent Temporal Hiccup happens.")
                    .translation("config.arkntmadditions.TemporalHiccupRarity")
                    .defineInRange("TemporalHiccupRarity", 10, 0, 100);

            PowerFailureRarity = builder.comment("How frequent Power Failures happen.")
                    .translation("config.arkntmadditions.PowerFailureRarity")
                    .defineInRange("PowerFailureRarity", 3, 0, 100);

                    EmergencyLandingRarity  = builder.comment("How frequent System Failures happen.")
                    .translation("config.arkntmadditions.SystemFailureRarity")
                   .defineInRange("SystemFailureRarity", 1, 0, 100);

            DimensionalBreachRarity  = builder.comment("How frequent Dimensional Breaches happen.")
                    .translation("config.arkntmadditions.DimensionalBreachRarity")
                    .defineInRange("DimensionalBreachRarity", 2, 0, 100);

        }

    }
}