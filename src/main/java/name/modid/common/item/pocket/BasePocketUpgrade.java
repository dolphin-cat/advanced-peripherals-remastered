package name.modid.common.item.pocket;


import dan200.computercraft.api.peripheral.IPeripheral;
import dan200.computercraft.api.pocket.AbstractPocketUpgrade;
import dan200.computercraft.api.pocket.IPocketAccess;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


import static name.modid.common.utl.StringUtil.pocket;

public class BasePocketUpgrade extends AbstractPocketUpgrade{


    protected BasePocketUpgrade(Identifier id,  ItemStack stack) {
        super(id, pocket(id.getPath()) , stack);
    }



    @Override
    public IPeripheral createPeripheral(IPocketAccess iPocketAccess) {
        return null;
    }
}
