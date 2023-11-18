package name.modid.common.peripherals;

import dan200.computercraft.api.lua.LuaException;
import dan200.computercraft.api.lua.LuaFunction;
import dan200.computercraft.api.peripheral.IComputerAccess;
import dan200.computercraft.api.peripheral.IPeripheral;
import name.modid.common.blocks.blockentities.GeoScannerBlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.server.world.ServerWorld;

import java.util.HashMap;
import java.util.Map;

public class GeoScannerPeripheral implements IPeripheral {
    private final GeoScannerBlockEntity sensor;
    private final World level;
    private final BlockPos pos;

    public GeoScannerPeripheral(GeoScannerBlockEntity sensor) {
        this.sensor = sensor;
        this.level = sensor.getWorld();
        this.pos = sensor.getPos();
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
