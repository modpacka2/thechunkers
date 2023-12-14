package net.switchot.thechunkers.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.switchot.thechunkers.block.ModBlocks;

public class AdvancedChunkAnalyzerBlocks extends Block {
    public AdvancedChunkAnalyzerBlocks(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        int CurrentChunkX = world.getChunk(pos).getPos().x;
        int CurrentChunkZ = world.getChunk(pos).getPos().z;

        if (!world.isClient()){
            boolean FoundBlock = false;

            for (int x = 0; x < 16; x++){
                for(int z = 0; z < 16; z++){
                    for (int y = -64; y < 320; y++){
                        BlockPos position = new BlockPos(x, y, z);
                        BlockPos RealPosition = new BlockPos((world.getChunk(pos).getPos().getStartX() + x), y , (world.getChunk(pos).getPos().getStartZ() + z));
                        BlockState advancedstate = world.getChunk(CurrentChunkX, CurrentChunkZ).getBlockState(position);

                        if (isAHeartBlock(advancedstate)){
                            outputHeartCoordinate(position, player, advancedstate.getBlock(), RealPosition);
                            FoundBlock = true;

                            break;
                        }
                    }
                }
            }

            if (!FoundBlock) {
                player.sendMessage(Text.literal("This chunk doesn't have his heart"));
            }
        }




        return ActionResult.SUCCESS;
    }

    private void outputHeartCoordinate(BlockPos position, PlayerEntity user, Block block, BlockPos blockPos) {
        user.sendMessage(Text.literal("The chunk heart is intact " + block.asItem().getName().getString() + " at " + "(" + blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ() + ")"), false);
    }

    private boolean isAHeartBlock(BlockState state) {
        return state.isOf(ModBlocks.CHUNKS_HEART) || state.isOf(ModBlocks.DEEPSLATE_CHUNKS_HEART);
    }
}




