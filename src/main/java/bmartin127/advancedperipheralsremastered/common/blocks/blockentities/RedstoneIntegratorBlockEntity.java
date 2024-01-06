package bmartin127.advancedperipheralsremastered.common.blocks.blockentities;
import bmartin127.advancedperipheralsremastered.common.blocks.blockentities.BasePeripheralBlockEntity;
import bmartin127.advancedperipheralsremastered.integrations.cc.AdvancedPeripheralsPeripheralProviders;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;
import net.minecraft.block.RedstoneWireBlock;
import net.minecraft.util.math.Direction;
import dan200.computercraft.shared.util.RedstoneUtil;
import net.minecraft.world.World;

import static bmartin127.advancedperipheralsremastered.integrations.cc.AdvancedPeripheralsBlockEntityTypes.REDSTONE_INTEGRATOR_BLOCK_ENTITY;


public class RedstoneIntegratorBlockEntity extends BasePeripheralBlockEntity {
    private final BlockPos pos;
    private final BlockState state;
    public RedstoneIntegratorBlockEntity(BlockPos pos, BlockState state) {

        super(REDSTONE_INTEGRATOR_BLOCK_ENTITY, pos, state);
        this.pos = pos;
        this.state = state;
        // Your additional initialization logic here
    }

    public int[] power = new int[Direction.values().length];
    public World level = state.getWorld();


    public int getRedstoneInput(Direction direction) {
        Objects.requireNonNull(this.level);
        BlockPos neighbourPos = this.pos.offset(direction);
        int power = this.level.getEmittedRedstonePower(neighbourPos, direction);
        if (power >= 15) return power;
        BlockState neighbourState = this.level.getBlockState(neighbourPos);
        return neighbourState.getBlock() == Blocks.REDSTONE_WIRE ? Math.max(power, neighbourState.get(RedStoneWireBlock.POWER)) : power;
    }

    private void setRedstoneOutput(Direction direction, int power) {
        int old = this.power[direction.getId()];
        this.power[direction.getId()] = power;
        if (old != power) {
            if (this.level != null) {
                RedstoneUtil.propagateRedstoneOutput(this.level, this.pos, direction);
            }
        }
    }
}
