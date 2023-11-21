package bmartin127.advancedperipheralsremastered.common.peripherals;

import dan200.computercraft.api.lua.LuaException;
import dan200.computercraft.api.lua.LuaFunction;
import dan200.computercraft.api.peripheral.IComputerAccess;
import dan200.computercraft.api.peripheral.IPeripheral;
import bmartin127.advancedperipheralsremastered.common.blocks.blockentities.GeoScannerBlockEntity;
import dan200.computercraft.api.pocket.IPocketAccess;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.server.world.ServerWorld;

import java.util.HashMap;
import java.util.Map;

public class GeoScannerPeripheral implements IPeripheral {
    private final GeoScannerBlockEntity sensor;

    private final World level;
    private final BlockPos pos;

    private final IPocketAccess pocket;

    public GeoScannerPeripheral(GeoScannerBlockEntity sensor) {
        this.pocket = null;
        this.sensor = sensor;
        this.level = sensor.getWorld();
        this.pos = sensor.getPos();
    }

    public GeoScannerPeripheral(IPocketAccess pocket) {
        this.sensor = null;
        this.pocket = pocket;
        this.level = pocket.getEntity().getWorld();
        this.pos = pocket.getEntity().getBlockPos();
    }





    @LuaFunction
    public String scan(int radius) {
        return "Hello from the peripheral!";
    }

    @Override
    public String getType() {
        return "geoScanner";
    }

    @Override
    public boolean equals(IPeripheral iPeripheral) {
        return level != null && level.getBlockEntity(pos) instanceof GeoScannerBlockEntity;
    }

    @Override
    public void attach(IComputerAccess computer) {
        if (!sensor.computers.contains(computer)) {
            sensor.computers.add(computer);
        }
    }

    @Override
    public void detach(IComputerAccess computer) {
        if (sensor.computers.contains(computer)) {
            sensor.computers.remove(computer);
        }
    }

}
