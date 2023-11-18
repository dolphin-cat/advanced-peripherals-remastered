package name.modid.integrations.cc;


import dan200.computercraft.ComputerCraft;
import dan200.computercraft.api.ComputerCraftAPI;
import dan200.computercraft.api.peripheral.IPeripheral;
import dan200.computercraft.api.peripheral.IPeripheralProvider;
import dan200.computercraft.core.computer.Computer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.BlockState;
import name.modid.AdvancedPeripheralsConfig;
import name.modid.common.blocks.blockentities.GeoScannerBlockEntity;
import name.modid.common.peripherals.GeoScannerPeripheral;


import name.modid.common.setup.Blocks;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AdvancedPeripheralsPeripheralProviders {
    public static void registerPeripheralProviders() {
        ComputerCraftAPI.registerPeripheralProvider(new AdvancedPeripheralsPeripheralProvider());

    }

    public static class AdvancedPeripheralsPeripheralProvider implements IPeripheralProvider {
        @Nullable
        @Override
        public IPeripheral getPeripheral(@NotNull World level, @NotNull BlockPos blockPos, @NotNull Direction direction) {
            BlockState state = level.getBlockState(blockPos);
            BlockEntity be = level.getBlockEntity(blockPos);
            if (AdvancedPeripheralsConfig.SERVER.ComputerCraft.disableComputerCraft) return null;

           if (be instanceof GeoScannerBlockEntity sensor &&
                    !AdvancedPeripheralsConfig.SERVER.ComputerCraft.disableComputerCraft) {
                return new GeoScannerPeripheral(sensor);
            }

            return null;
        }
    }
}