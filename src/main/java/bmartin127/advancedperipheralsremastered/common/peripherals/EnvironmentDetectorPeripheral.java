package bmartin127.advancedperipheralsremastered.common.peripherals;

import dan200.computercraft.api.lua.LuaException;
import dan200.computercraft.api.lua.LuaFunction;
import dan200.computercraft.api.peripheral.IComputerAccess;
import dan200.computercraft.api.peripheral.IPeripheral;
import bmartin127.advancedperipheralsremastered.common.blocks.blockentities.EnvironmentDetectorBlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.LightType;
import net.minecraft.util.math.MathHelper;

import java.util.HashMap;
import java.util.Map;

public class EnvironmentDetectorPeripheral implements IPeripheral {
    private final EnvironmentDetectorBlockEntity sensor;
    private final World level;
    private final BlockPos pos;
    private final MinecraftServer server;

    public EnvironmentDetectorPeripheral(EnvironmentDetectorBlockEntity sensor) {
        this.sensor = sensor;
        this.level = sensor.getWorld();
        this.pos = sensor.getPos();
        this.server = this.level.getServer();
    }


    // Other methods remain unchanged

    @LuaFunction(mainThread = true)
    public final int getSkyLightLevel() {
        // Use LightType.SKY for sky light level
        return level.getLightLevel(LightType.SKY, pos.up());
    }

    @LuaFunction(mainThread = true)
    public final int getBlockLightLevel() {
        // Use LightType.BLOCK for block light level
        return level.getLightLevel(LightType.BLOCK, pos.up());
    }

    @LuaFunction(mainThread = true)
    public final int getDayLightLevel() {
        int i = level.getLightLevel(LightType.SKY, pos.up()) - level.getStarBrightness();
        float f = level.getSkyAngleRadians(1.0F);
        if (i > 0) {
            float f1 = f < (float) Math.PI ? 0.0F : ((float) Math.PI * 2F);
            f = f + (f1 - f) * 0.2F;
            i = Math.round(i * MathHelper.cos(f));
        }
        i = MathHelper.clamp(i, 0, 15);
        return i;
    }


    @LuaFunction(mainThread = true)
    public final boolean isRaining() {
        return level.getRainGradient(0) > 0;
    }

    @LuaFunction(mainThread = true)
    public final boolean isThunder() {
        return level.getThunderGradient(0) > 0;
    }

    @LuaFunction(mainThread = true)
    public final boolean isSunny() {
        return level.getThunderGradient(0) < 1 && level.getRainGradient(0) < 1;
    }

    @LuaFunction(mainThread = true)
    public String getBiome() {
        return level.getBiome(pos).getKey().get().getValue().toString();
    }

    @LuaFunction(mainThread = true)
    public String getDimensionName() {
        String[] dim = level.getRegistryKey().getValue().toString().split(":");
        return dim[dim.length-1];
    }
    @LuaFunction(mainThread = true)
    public String getDimensionPaN() {
        return level.getRegistryKey().getValue().toString();
    }
    @LuaFunction(mainThread = true)
    public String getDimensionProvider() {
        return level.getRegistryKey().getValue().toString().split(":")[0];
    }
    @LuaFunction(mainThread = true)
    public Boolean isDimension(String dimension) {
        return (level.getRegistryKey().getValue().toString().equals(dimension));
    }
    @LuaFunction(mainThread = true)
    public String[] listDimensions() {
        return server.getWorldRegistryKeys().stream().map(RegistryKey::getValue).map(Object::toString).toArray(String[]::new);
    }

    @LuaFunction(mainThread = true)
    public Long getTime() {
        return level.getTimeOfDay();
    }
    @LuaFunction(mainThread = true)
    public int getMoonId() {
        return getCurrentMoonPhase().entrySet().iterator().next().getKey();
    }

    @LuaFunction(mainThread = true)
    public final boolean isMoon(int phase) {
        return getCurrentMoonPhase().containsKey(phase);
    }

    @LuaFunction(mainThread = true)
    public String getMoonPhase() {
        return getCurrentMoonPhase().entrySet().iterator().next().getValue();
    }

    private Map<Integer, String> getCurrentMoonPhase() {
        Map<Integer, String> moon = new HashMap<>();
            if (level.getRegistryKey().equals(World.OVERWORLD)) {
            switch (level.getMoonPhase()) {
                case 0 -> moon.put(0, "Full moon");
                case 1 -> moon.put(1, "Waning gibbous");
                case 2 -> moon.put(2, "Third quarter");
                case 3 -> moon.put(3, "Wanning crescent");
                case 4 -> moon.put(4, "New moon");
                case 5 -> moon.put(5, "Waxing crescent");
                case 6 -> moon.put(6, "First quarter");
                case 7 -> moon.put(7, "Waxing gibbous");
                default ->
                    //should never happen
                    moon.put(0, "What is a moon");
            }
        } else {
            //Yay, easter egg
            //Returns when the function is not used in the overworld
            moon.put(0, "Moon.exe not found...");
        }
        return moon;
    }


    @Override
    public String getType() {
        return "environmentDetector";
    }

    @Override
    public boolean equals(IPeripheral iPeripheral) {
        return level != null && level.getBlockEntity(pos) instanceof EnvironmentDetectorBlockEntity;
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
