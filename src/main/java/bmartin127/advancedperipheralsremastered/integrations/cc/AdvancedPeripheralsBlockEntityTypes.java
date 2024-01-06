package bmartin127.advancedperipheralsremastered.integrations.cc;

import bmartin127.advancedperipheralsremastered.common.blocks.blockentities.*;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static bmartin127.advancedperipheralsremastered.Advancedperipherals.MODID;
import static bmartin127.advancedperipheralsremastered.common.setup.Blocks.*;

public class AdvancedPeripheralsBlockEntityTypes {
    public static final BlockEntityType<GeoScannerBlockEntity> GEO_SCANNER_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            new Identifier(MODID, "geo_scanner"),
            FabricBlockEntityTypeBuilder.create(GeoScannerBlockEntity::new, GEO_SCANNER).build()
    );
    public static final BlockEntityType<EnvironmentDetectorBlockEntity> ENVIRONMENT_DETECTOR_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            new Identifier(MODID, "environment_detector"),
            FabricBlockEntityTypeBuilder.create(EnvironmentDetectorBlockEntity::new, ENVIRONMENT_DETECTOR).build()
    );
    public static final BlockEntityType<RedstoneIntegratorBlockEntity> REDSTONE_INTEGRATOR_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            new Identifier(MODID, "redstone_integrator"),
            FabricBlockEntityTypeBuilder.create(RedstoneIntegratorBlockEntity::new, REDSTONE_INTEGRATOR).build()
    );
}