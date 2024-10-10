/**
 * factory of renderer
 * @author Ruth Yukhnovetsky
 */

public class RendererFactory {

    /**
     * creates a renderer according to given string
     * @param typeRenderer type of renderer
     * @return wanted renderer
     */
    public Renderer buildRenderer (String typeRenderer){
        if (typeRenderer.equals("console")){
            return new ConsoleRenderer();
        }
        if (typeRenderer.equals("none")){
            return new VoidRenderer();
        }
        return null;
    }
}
