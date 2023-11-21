package bmartin127.advancedperipheralsremastered.common.setup;
import bmartin127.advancedperipheralsremastered.integrations.cc.AdvancedPeripheralsPeripheralProviders;


public class Registration {



    public static void register() {
        Blocks.registerModBlocks();
        Items.registerModItems();
        //register the actual peripheral providers PLEASE WORK
        AdvancedPeripheralsPeripheralProviders.registerPeripheralProviders();
        //POCKETS PLEAASSSE WORK
        CCRegistration.registerModPocketItems();
        }
    }

