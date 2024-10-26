package category.data.sheets;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.common.base.MoreObjects;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class ColumnCountRowCount implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer rowCount;

	private Integer columnCount;

	public Integer getRowCount() {
		return rowCount;
	}

	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}

	public Integer getColumnCount() {
		return columnCount;
	}

	public void setColumnCount(Integer columnCount) {
		this.columnCount = columnCount;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
			.add("rowCount", getRowCount())
			.add("columnCount", getColumnCount())
			.toString();
	}

}
