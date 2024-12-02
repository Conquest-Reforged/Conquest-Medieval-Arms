package com.conquestreforged.arms.network;

public class PacketOverextendedReachAttack {
    /*
    private int entityID;

    public PacketOverextendedReachAttack(int entityID) {
        this.entityID = entityID;
    }

    public static void encode(PacketOverextendedReachAttack packet, FriendlyByteBuf buf) {
        buf.writeInt(packet.entityID);
    }

    public static PacketOverextendedReachAttack decode(FriendlyByteBuf buf) {
        return new PacketOverextendedReachAttack(buf.readInt());
    }

    public static class Handler {
        public Handler() {
        }

        public static void handle(PacketOverextendedReachAttack packet, Supplier<NetworkEvent.Context> ctx) {
            if (packet != null) {
                ((NetworkEvent.Context)ctx.get()).enqueueWork(() -> {
                    ServerPlayer player = ((NetworkEvent.Context)ctx.get()).getSender();
                    Entity target = player.level.getEntity(packet.entityID);
                    if (player != null && target != null) {
                        Log.info("Victim of attack: " + target.toString());
                        ItemStack weapon = player.getMainHandItem();
                        {
                            {
                                double reach = 3.0d;
                                if (weapon.getItem() instanceof ModSpear) {
                                    reach = ((ModSpear)weapon.getItem()).getRange();
                                } else if ((weapon.getItem() instanceof ModSword)) {
                                    reach = ((ModSword)weapon.getItem()).getRange();
                                } else if ((weapon.getItem() instanceof ModAxe)) {
                                    reach = ((ModAxe)weapon.getItem()).getRange();
                                }
                                double distanceSquared = player.distanceToSqr(target);
                                double reachSquared = reach * reach;
                                if (reachSquared >= distanceSquared) {
                                    player.attack(target);
                                    Log.info("Attacking victim!");
                                }

                                player.swing(InteractionHand.MAIN_HAND);
                                player.resetAttackStrengthTicker();
                            }

                        }
                    }
                });
            }
        }
    }*/
}
