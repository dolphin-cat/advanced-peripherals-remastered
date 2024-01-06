package bmartin127.advancedperipheralsremastered.common.blocks;


import bmartin127.advancedperipheralsremastered.common.blocks.blockentities.RedstoneIntegratorBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.world.World;
import net.minecraft.block.BlockRenderType;
import java.util.logging.Logger;


public class RedstoneIntegratorBlock extends BlockWithEntity  {
    public RedstoneIntegratorBlock(Settings properties) {
        super(properties);
    }

    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new RedstoneIntegratorBlockEntity(pos,state);
    }
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World level, BlockState state, BlockEntityType<T> blockEntityType) {
        return (level1, pos, state1, blockEntity) -> {
            if (level1.isClient()) return;

            if (blockEntity instanceof RedstoneIntegratorBlockEntity) {
                ((RedstoneIntegratorBlockEntity) blockEntity).tick(level1, pos, state1, blockEntity);
            }
        };
    }
}
