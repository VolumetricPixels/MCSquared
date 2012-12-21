package me.thehutch.testmodule.Windmill;

import org.spout.api.event.Cause;
import org.spout.api.geo.cuboid.Block;
import org.spout.api.material.block.BlockFace;
import org.spout.api.material.block.BlockFaces;
import org.spout.api.math.Vector3;
import org.spout.vanilla.data.MoveReaction;
import org.spout.vanilla.data.drops.flag.ToolTypeFlags;
import org.spout.vanilla.material.block.Directional;
import org.spout.vanilla.material.block.component.ComponentMaterial;
import org.spout.vanilla.util.PlayerUtil;

/**
 * @author thehutch
 */
public class WindmillBlock extends ComponentMaterial implements Directional {
    
    private boolean generating;
    
    public WindmillBlock(String name, int id, boolean generating) {
        super(name, id, Windmill.class, "");
        this.generating = generating;
        this.setHardness(4.0f).setResistance(6.0f);
        this.getDrops().NOT_CREATIVE.addFlags(ToolTypeFlags.PICKAXE);
    }
    
    @Override
    public byte getLightLevel(short data) {
        return generating ? (byte) 2 : (byte) 0;
    }
    
    public boolean isGenerating() {
        return this.generating;
    }
    
    public void setGenerating(Block block, boolean generating) {
        this.generating = generating;
    }

    @Override
    public BlockFace getFacing(Block block) {
        return BlockFaces.EWNS.get(block.getData() - 2);
    }

    @Override
    public void setFacing(Block block, BlockFace facing) {
        block.setData((short) (BlockFaces.EWNS.indexOf(facing, 0) + 2));
    }
    
    @Override
	public boolean onPlacement(Block block, short data, BlockFace against, Vector3 clickedPos, boolean isClickedBlock, Cause<?> cause) {
		if (super.onPlacement(block, data, against, clickedPos, isClickedBlock, cause)) {
			this.setFacing(block, PlayerUtil.getFacing(cause).getOpposite());
			return true;
		}

		return false;
	}
    
    @Override
	public boolean isPlacementSuppressed() {
		return true;
	}

	@Override
	public MoveReaction getMoveReaction(Block block) {
		return MoveReaction.DENY;
	}
}