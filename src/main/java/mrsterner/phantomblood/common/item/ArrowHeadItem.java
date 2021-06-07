package mrsterner.phantomblood.common.item;

import mrsterner.phantomblood.common.registry.PBSoundEvents;
import mrsterner.phantomblood.common.stand.Stand;
import mrsterner.phantomblood.common.stand.StandUtils;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class ArrowHeadItem extends Item {
    public ArrowHeadItem(Settings settings) {
        super(settings);
    }



    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            if (StandUtils.getStand(user) == Stand.NONE) {
                int t = MathHelper.nextInt(world.random, 1, 3);
                switch (t){
                    case 1:
                        StandUtils.setStand(user, Stand.STAR_PLATINUM);
                        break;
                    case 2:
                        StandUtils.setStand(user, Stand.THE_WORLD);
                        break;
                    case 3:
                        StandUtils.setStand(user, Stand.KILLER_QUEEN);
                        break;
                    default:
                        break;
                }
            } else if(StandUtils.getStandLevel(user) == 0){
                StandUtils.setStandLevel(user, 1);
            } else {
                world.playSound(null,user.getBlockPos(), SoundEvents.ITEM_SHIELD_BREAK, SoundCategory.PLAYERS,1F,1);
                return TypedActionResult.fail(ItemStack.EMPTY);
            }
        }
        int t2 = MathHelper.nextInt(world.random, 1, 1);
        if(t2 == 1){
            user.damage(DamageSource.GENERIC,user.getMaxHealth());
            return super.use(world, user, hand);
        }else{
            world.playSound(null,user.getBlockPos(), SoundEvents.ITEM_SHIELD_BREAK, SoundCategory.PLAYERS,0.15F,1);
            return TypedActionResult.consume(ItemStack.EMPTY);
        }
    }
    //To do: to succeed in using the arrow, the user wither have to be a vampire or use a totem of undying to prevent death.
}
