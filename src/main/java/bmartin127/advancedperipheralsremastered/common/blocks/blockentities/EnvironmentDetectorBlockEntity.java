package bmartin127.advancedperipheralsremastered.common.blocks.blockentities;
import bmartin127.advancedperipheralsremastered.common.blocks.blockentities.BasePeripheralBlockEntity;
import bmartin127.advancedperipheralsremastered.integrations.cc.AdvancedPeripheralsPeripheralProviders;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;

import static bmartin127.advancedperipheralsremastered.integrations.cc.AdvancedPeripheralsBlockEntityTypes.ENVIRONMENT_DETECTOR_BLOCK_ENTITY;


public class EnvironmentDetectorBlockEntity extends BasePeripheralBlockEntity {
    public EnvironmentDetectorBlockEntity(BlockPos pos, BlockState state) {

        super(ENVIRONMENT_DETECTOR_BLOCK_ENTITY, pos, state);
        // Your additional initialization logic here
    }
}
