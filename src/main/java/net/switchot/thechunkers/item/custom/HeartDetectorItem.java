package net.switchot.thechunkers.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.switchot.thechunkers.block.ModBlocks;

public class HeartDetectorItem extends Item {
    public HeartDetectorItem(Settings settings) {
        super(settings);
    }


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        int CurrentChunkX = user.getChunkPos().x;
        int CurrentChunkZ = user.getChunkPos().z;

        if (!world.isClient()){
            boolean FoundBlock = false;

            for (int x = 0; x < 16; x++){
                for(int z = 0; z < 16; z++){
                    for (int y = -64; y < 320; y++){
                        BlockPos position = new BlockPos(x, y, z);
                        BlockState state = world.getChunk(CurrentChunkX, CurrentChunkZ).getBlockState(position);

                        if (isAHeartBlock(state)){
                            outputHeartCoordinate(position, user);
                            FoundBlock = true;

                            break;
                        }
                    }
                }
            }

            if (!FoundBlock) {
                user.sendMessage(Text.literal("This chunk doesn't have his heart"));
            }
        }




        return super.use(world, user, hand);
    }

    private void outputHeartCoordinate(BlockPos position, PlayerEntity user) {
        user.sendMessage(Text.literal("The chunk heart is intact"), false);
    }

    private boolean isAHeartBlock(BlockState state) {
        return state.isOf(ModBlocks.CHUNKS_HEART) || state.isOf(ModBlocks.DEEPSLATE_CHUNKS_HEART);
    }
}
