package org.reploop.parser.mysql.tree;

import com.google.common.base.Joiner;
import com.google.common.base.MoreObjects;

import java.util.List;

public class FullId extends TableName {

	List<UID> ids;

	private static final Joiner DOT_JOINER = Joiner.on(".").skipNulls();

	public FullId(List<UID> ids) {
		super(DOT_JOINER.join(ids));
		this.ids = ids;
	}

	public List<UID> getIds() {
		return ids;
	}

	public void setIds(List<UID> ids) {
		this.ids = ids;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this).add("ids", ids).toString();
	}

}
