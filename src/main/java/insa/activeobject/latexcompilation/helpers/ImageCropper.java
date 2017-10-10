package insa.activeobject.latexcompilation.helpers;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.stream.IntStream;

public final class ImageCropper {
	public static final ImageCropper INSTANCE = new ImageCropper();

	private ImageCropper() {
		super();
	}

	/**
	 * Removes the white margins of the given image.
	 * @param img The image to crop.
	 * @return The cropped image or null if the given image is null or fully white.
	 */
	public Image cropImage(final BufferedImage img) {
		if(img == null) return null;

		int width = img.getWidth();
		int height = img.getHeight();
		int left = getLeft(img, width, height);

		if(left == width) return null;

		int right = getRight(img, width, height);
		int top = getTop(img, width, height, left, right);
		int bottom = getBottom(img, width, height, left, right);
		int newWidth = img.getWidth(null) - left - right;
		int newHeight = img.getHeight(null) - top - bottom;
		BufferedImage cropped = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB_PRE);
		Graphics g = cropped.getGraphics();

		g.drawImage(img, 0, 0, newWidth, newHeight, left, top, newWidth + left, newHeight + top, null);
		g.dispose();

		return cropped;
	}


	/**
	 * Gets the bottom position where a pixel is not white.
	 */
	private int getBottom(final BufferedImage img, final int width, final int height, final int left, final int right) {
		int bottom = 0;
		int y = height - 1;

		while(y >= 0 && !hasColouredPixelRow(img, y, left, width - right)) {
			bottom += 1;
			y -= 1;
		}
		return bottom;
	}


	/**
	 * Gets the top position where a pixel is not white.
	 */
	private int getTop(final BufferedImage img, final int width, final int height, final int left, final int right) {
		int top = 0;

		while(top < height && !hasColouredPixelRow(img, top, left, width - right)) {
			top += 1;
		}

		return top;
	}


	/**
	 * Gets the right position where a pixel is not white.
	 */
	private int getRight(final BufferedImage img, final int width, final int height) {
		int right = 0;
		int x = width - 1;

		while(x >= 0 && !hasColouredPixelColumn(img, x, height)) {
			right += 1;
			x -= 1;
		}
		return right;
	}


	/**
	 * Gets the left position where a pixel is not white.
	 */
	private int getLeft(final BufferedImage img, final int width, final int height) {
		int left = 0;

		while(left < width && !hasColouredPixelColumn(img, left, height)) {
			left += 1;
		}

		return left;
	}


	private boolean hasColouredPixelColumn(final BufferedImage img, final int x, final int imgHeight) {
		return IntStream.range(0, imgHeight).parallel().anyMatch(y -> img.getRGB(x, y) != 0);
	}


	private boolean hasColouredPixelRow(final BufferedImage img, final int y, final int min, final int max) {
		return IntStream.range(min, max).parallel().anyMatch(x -> img.getRGB(x, y) != 0);
	}
}
