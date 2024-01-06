package bmartin127.advancedperipheralsremastered.common.peripherals;

import dan200.computercraft.api.lua.LuaException;
import dan200.computercraft.api.lua.LuaFunction;
import dan200.computercraft.api.peripheral.IComputerAccess;
import dan200.computercraft.api.peripheral.IPeripheral;
import bmartin127.advancedperipheralsremastered.common.blocks.blockentities.RedstoneIntegratorBlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.LightType;
import net.minecraft.util.math.MathHelper;

import java.util.HashMap;
import java.util.Map;

public class RedstoneIntegratorPeripheral implements IPeripheral {
    private final RedstoneIntegratorBlockEntity sensor;
    private final World level;
    private final BlockPos pos;
    private final MinecraftServer server;

    public RedstoneIntegratorPeripheral(RedstoneIntegratorBlockEntity sensor) {
        this.sensor = sensor;
        this.level = sensor.getWorld();
        this.pos = sensor.getPos();
        this.server = this.level.getServer();
    }

    // Other methods remain unchanged

    @LuaFunction()
    public int debug() {
        System.out.PrintLn(power);
    }

    @LuaFunction(mainThread = true)
    public final boolean getInput(String direction) throws LuaException {
        Direction dir = validateSide(direction);
        return owner.tileEntity.getRedstoneInput(dir) > 0;
    }

    @LuaFunction(mainThread = true)
    public final boolean getOutput(String direction) throws LuaException {
        return owner.tileEntity.power[validateSide(direction).get3DDataValue()] > 0;
    }

    @LuaFunction(value = {"getAnalogueInput", "getAnalogInput"}, mainThread = true)
    public final int getAnalogInput(String direction) throws LuaException {
        Direction dir = validateSide(direction);
        return owner.tileEntity.getRedstoneInput(dir);
    }

    @LuaFunction(value = {"getAnalogueOutput", "getAnalogOutput"}, mainThread = true)
    public final int getAnalogOutput(String direction) throws LuaException {
        Direction dir = validateSide(direction);
        return owner.tileEntity.power[dir.get3DDataValue()];
    }

    @LuaFunction
    public final void setOutput(String direction, boolean power) throws LuaException {
        Direction dir = validateSide(direction);
        owner.tileEntity.setOutput(dir, power ? 15 : 0);
    }

    @LuaFunction(value = {"setAnalogueOutput", "setAnalogOutput"})
    public final void setAnalogOutput(String direction, int power) throws LuaException {
        Direction dir = validateSide(direction);
        owner.tileEntity.setOutput(dir, power);
    }




    @Override
    public String getType() {
        return "redstoneIntegrator";
    }

    @Override
    public boolean equals(IPeripheral iPeripheral) {
        return level != null && level.getBlockEntity(pos) instanceof RedstoneIntegratorBlockEntity;
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
