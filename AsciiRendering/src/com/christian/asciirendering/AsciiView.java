package com.christian.asciirendering;

import java.awt.image.BufferedImage;

import com.christian.adventureengine.data.Vector2;
import com.christian.adventureengine.rendering.IRenderer;
import com.christian.adventureengine.rendering.View;
import com.christian.adventureengine.rendering.sprites.ISpriteType;
import com.christian.adventureengine.rendering.sprites.Sprite;
import com.christian.adventureengine.rendering.sprites.Sprites;

public class AsciiView extends View {
	
	enum Types implements ISpriteType {
		font_1,
		font_2
	}
	
	private Sprite font_1;
	private BufferedImage[] subImages;
	private int imagesW, imagesH;
	public AsciiView() {
		Sprites.GetSpriteManager().RegisterSprite(Types.font_1, "possible_font_to_use_2.png", Vector2.One().Mul(48));
		font_1 = Sprites.GetSpriteManager().GetSprite(Types.font_1);
		
		imagesW = font_1.GetImage().getWidth() / 16;
		imagesH = font_1.GetImage().getHeight() / 16;
		subImages = new BufferedImage[imagesW * imagesH];
		for (int i = 0; i < imagesW; i++) {
			for (int j = 0; j < imagesH; j++) {
				subImages[i + imagesW * j] = font_1.GetImage().getSubimage(i * 16, j * 16, 16, 16);
			}	
		}
	}
	
	@Override
	public void draw(IRenderer renderer) {
//		renderer.DrawScreenText("File Edit", Vector2.Zero());

		for (int i = 0; i < imagesW; i++) {
			for (int j = 0; j < imagesH; j++) {
				Sprite s = new Sprite("__", subImages[i + imagesW * j]);
				s.PixelsToWorld = Vector2.Zero();
				renderer.DrawScreenSprite(s, new Vector2(i*64, j*64));
			}
		}
		
//		if (Global.console != null) {
//			ConsoleBuffer console = Global.console;
//			for (int x = 0; x < console.width; x++) {
//				for (int y = 0; y < console.height; y++) {
//					renderer.DrawScreenText(console.buffer[x][y].value +"", new Vector2(x,y).Mul(console.fontSize));
//				}
//			}
//		}
	}
}
