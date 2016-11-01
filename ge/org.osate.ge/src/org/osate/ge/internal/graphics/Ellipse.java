package org.osate.ge.internal.graphics;

public class Ellipse implements AgeShape {
	public final int lineWidth;
	public final LineStyle lineStyle;
	
	public Ellipse(final int lineWidth, final LineStyle lineStyle) {
		this.lineWidth = lineWidth;
		this.lineStyle = lineStyle;
	}
}
