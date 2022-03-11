
package com.iotengine.dto;

import java.util.Objects;

public abstract class RawItemInsight {
	private String name;
	private String category;
	private Integer count;
	private String timestamp;

	@Override
	public int hashCode() {
		return Objects.hash(category, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RawItemInsight other = (RawItemInsight) obj;
		return Objects.equals(category, other.category) && Objects.equals(name, other.name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
}
