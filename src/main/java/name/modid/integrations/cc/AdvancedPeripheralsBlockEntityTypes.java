package name.modid.integrations.cc;

import name.modid.common.blocks.blockentities.GeoScannerBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static name.modid.Advancedperipherals.MODID;
import static name.modid.common.setup.Blocks.GEO_SCANNER;

public class AdvancedPeripheralsBlockEntityTypes {
    public static final BlockEntityType<GeoScannerBlockEntity> GEO_SCANNER_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            new Identifier(MODID, "advancedperihperals"),
            FabricBlockEntityTypeBuilder.create(GeoScannerBlockEntity::new, GEO_SCANNER).build()
    );
}
