package com.unnamestudio.framework;

import com.unnamestudio.framework.Graphics.PixmapFormat;

public interface Pixmap {
	public int getWidth(); 
	public int getHeight(); 
	public PixmapFormat getFormat(); 
	public void dispose();
}
