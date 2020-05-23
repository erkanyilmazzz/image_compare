public class Pixel {
    private int red;
    private int green;
    private int blue;
    private int rgb;


    /**constructers*/
    public Pixel(int rgb){
        this.rgb=rgb;
        red=(rgb>>16) & 0xff;
        green=(rgb>>8) & 0xff;
        blue=rgb & 0xff;
    }
    public Pixel(int rgb,int red, int green, int blue){
        this.rgb=rgb;
        this.red=red;
        this.green=green;
        this.blue=blue;
    }

    /**getters setters*/
    public void setPixel(int red,int green ,int blue){
        this.red=red;
        this.green=green;
        this.blue=blue;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public int getRed() {
        return red;
    }
    public void setRgb(int rgb) {
        this.rgb = rgb;
    }
    public int getRgb() {
        return rgb;
    }


    /**it return a binary string fotmat of bitmix */
    public String getBitMix(){
        String p1r=Integer.toBinaryString(this.getRed());
        String p1g=Integer.toBinaryString(this.getGreen());
        String p1b=Integer.toBinaryString(this.getBlue());

        StringBuilder p1sRes=new StringBuilder();

        if(p1r.length()==0){
            StringBuilder temp =new StringBuilder(p1r);
            temp.insert(0,"0000");
            p1r=new String(temp);
        }else if(p1r.length()==1){
            StringBuilder temp =new StringBuilder(p1r);
            temp.insert(0,"000");
            p1r=new String(temp);
        }else if(p1r.length()==2){
            StringBuilder temp =new StringBuilder(p1r);
            temp.insert(0,"00");
            p1r=new String(temp);
        }else if(p1r.length()==3){
            StringBuilder temp =new StringBuilder(p1r);
            temp.insert(0,"0");
            p1r=new String(temp);
        }

        if(p1g.length()==0){
            StringBuilder temp =new StringBuilder(p1g);
            temp.insert(0,"0000");
            p1g=new String(temp);
        }else if(p1g.length()==1){
            StringBuilder temp =new StringBuilder(p1g);
            temp.insert(0,"000");
            p1g=new String(temp);
        }else if(p1g.length()==2){
            StringBuilder temp =new StringBuilder(p1g);
            temp.insert(0,"00");
            p1g=new String(temp);
        }else if(p1g.length()==3){
            StringBuilder temp =new StringBuilder(p1g);
            temp.insert(0,"0");
            p1g=new String(temp);
        }

        if(p1b.length()==0){
            StringBuilder temp =new StringBuilder(p1b);
            temp.insert(0,"0000");
            p1b=new String(temp);
        }else if(p1b.length()==1){
            StringBuilder temp =new StringBuilder(p1b);
            temp.insert(0,"000");
            p1b=new String(temp);
        }else if(p1b.length()==2){
            StringBuilder temp =new StringBuilder(p1b);
            temp.insert(0,"00");
            p1b=new String(temp);
        }else if(p1b.length()==3){
            StringBuilder temp =new StringBuilder(p1b);
            temp.insert(0,"0");
            p1b=new String(temp);
        }


        int i;
        for(i=0;i<4;++i){

            p1sRes.append(p1r.charAt(i));
            p1sRes.append(p1g.charAt(i));
            p1sRes.append(p1b.charAt(i));
        }

        return p1sRes.toString();
    }

    /**it return a binary string fartmat of lex*/
    public String getLex(){
        return Integer.toBinaryString(this.getRgb());
    }
    @Override
    public String toString(){
        return "red:"+this.red+" blue:"+this.blue+" green:"+this.green;
    }
}
