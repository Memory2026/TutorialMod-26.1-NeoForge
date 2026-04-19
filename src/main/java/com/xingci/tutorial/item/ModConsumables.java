package com.xingci.tutorial.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.MobBucketItem;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

import java.util.List;

public class ModConsumables {
    public static final Consumable STRAWBERRY =
            Consumables.defaultFood()
                    .onConsume(new ApplyStatusEffectsConsumeEffect
                            (new MobEffectInstance(MobEffects.SPEED, 2000, 2), 1F)).build();

    public static final Consumable CHEESE = Consumables.defaultFood()
            .onConsume(
                    new ApplyStatusEffectsConsumeEffect(
                            List.of(
                                    new MobEffectInstance(MobEffects.JUMP_BOOST, 3000, 1),
                                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 2000, 2)
                            ), 1f
                    )
            ).build();
}
