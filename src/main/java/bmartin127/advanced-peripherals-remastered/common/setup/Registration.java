package bmartin127.advanced-peripherals-remastered.common.setup;
import bmartin127.advanced-peripherals-remastered.common.setup.Blocks;
import bmartin127.advanced-peripherals-remastered.integrations.cc.AdvancedPeripheralsPeripheralProviders;


public class Registration {



    public static void register() {
        Blocks.registerModBlocks();
        Items.registerModItems();
        //register the actual peripheral providers PLEASE WORK
        AdvancedPeripheralsPeripheralProviders.registerPeripheralProviders();
        }
    }

