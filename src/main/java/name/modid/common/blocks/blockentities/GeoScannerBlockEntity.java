package name.modid.common.blocks.blockentities;
import name.modid.common.blocks.blockentities.BasePeripheralBlockEntity;
import name.modid.integrations.cc.AdvancedPeripheralsPeripheralProviders;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;

import static name.modid.integrations.cc.AdvancedPeripheralsBlockEntityTypes.GEO_SCANNER_BLOCK_ENTITY;


public class GeoScannerBlockEntity extends BasePeripheralBlockEntity {
    public GeoScannerBlockEntity(BlockPos pos, BlockState state) {

        super(GEO_SCANNER_BLOCK_ENTITY, pos, state);
        // Your additional initialization logic here
    }
}
