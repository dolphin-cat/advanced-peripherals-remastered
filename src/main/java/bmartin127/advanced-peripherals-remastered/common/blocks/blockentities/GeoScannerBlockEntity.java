package bmartin127.advanced-peripherals-remastered.common.blocks.blockentities;
import bmartin127.advanced-peripherals-remastered.common.blocks.blockentities.BasePeripheralBlockEntity;
import bmartin127.advanced-peripherals-remastered.integrations.cc.AdvancedPeripheralsPeripheralProviders;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;

import static bmartin127.advanced-peripherals-remastered.integrations.cc.AdvancedPeripheralsBlockEntityTypes.GEO_SCANNER_BLOCK_ENTITY;


public class GeoScannerBlockEntity extends BasePeripheralBlockEntity {
    public GeoScannerBlockEntity(BlockPos pos, BlockState state) {

        super(GEO_SCANNER_BLOCK_ENTITY, pos, state);
        // Your additional initialization logic here
    }
}
