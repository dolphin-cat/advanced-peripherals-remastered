package name.modid.common.setup;
import name.modid.common.setup.Blocks;
import name.modid.integrations.cc.AdvancedPeripheralsPeripheralProviders;


public class Registration {



    public static void register() {
        Blocks.registerModBlocks();
        Items.registerModItems();
        //register the actual peripheral providers PLEASE WORK
        AdvancedPeripheralsPeripheralProviders.registerPeripheralProviders();
        }
    }

