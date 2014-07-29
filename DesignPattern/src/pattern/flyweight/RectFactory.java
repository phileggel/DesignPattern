package pattern.flyweight;

import java.awt.*;
import java.util.HashMap;

/**
 * Created by DevMac on 29/07/2014.
 */

// Va créer les objets en recyclant ceux qui utilisent le même couleur
public class RectFactory {

    private static final HashMap<Color, MyRect> rectsByColor = new HashMap<Color, MyRect>();

    public static MyRect getRect(Color color) {
        MyRect rect = (MyRect)rectsByColor.get(color);

        if (rect == null) {
            rect = new MyRect(color);
            rectsByColor.put(color, rect);
        }

        return rect;

    }
}
