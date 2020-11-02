import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
	    VectorGraphicsInterface g1 = new VectorAdapterFromRaster();// Inheritance
        g1.drawLine();
        g1.drawSquare();


        VectorGraphicsInterface g2 = new VectorAdapterFromRaster1(); //Composition
        g2.drawLine();
        g2.drawSquare();
    }


    interface VectorGraphicsInterface{  //interface
        void drawLine();
        void drawSquare();
    }

    static class RasterGraphics{ //class
        void drawRasterLine(){
            System.out.println("draw line");
        }
        void  drawRasterSquare(){
            System.out.println("draw square");
        }
    }

     static class VectorAdapterFromRaster extends RasterGraphics implements VectorGraphicsInterface{  //adapter1
        @Override
        public void drawLine(){
            drawRasterLine();
        }
        @Override
        public void drawSquare(){
            drawRasterSquare();
        }
    }

    static class VectorAdapterFromRaster1 implements VectorGraphicsInterface{  //adapter2
        RasterGraphics raster = new RasterGraphics();

        @Override
        public void drawLine(){
            raster.drawRasterLine();
        }

        @Override
        public void drawSquare(){
            raster.drawRasterLine();
        }
    }
}
