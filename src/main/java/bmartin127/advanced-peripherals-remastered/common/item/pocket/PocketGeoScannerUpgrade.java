package bmartin127.advanced-peripherals-remastered.common.item.pocket;

import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import dan200.computercraft.api.pocket.IPocketAccess;
import bmartin127.advanced-peripherals-remastered.common.peripherals.GeoScannerPeripheral;
import dan200.computercraft.ComputerCraftAPIImpl;

public class PocketGeoScannerUpgrade extends BasePocketUpgrade{

    public PocketGeoScannerUpgrade(Identifier id, ItemStack stack) {
        super(id, stack);
    }
}
