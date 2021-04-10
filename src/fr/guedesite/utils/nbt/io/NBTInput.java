package fr.guedesite.utils.nbt.io;

import fr.guedesite.utils.nbt.tag.Tag;
import java.io.IOException;

public interface NBTInput {

	NamedTag readTag(int maxDepth) throws IOException;

	Tag<?> readRawTag(int maxDepth) throws IOException;
}
