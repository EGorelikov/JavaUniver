package by.gsu.pms;

public class UniformMaterial {
    private String name;
    private float density;

    public UniformMaterial(){
        this.name = "unknown";
        this.density = 0f;
    }
    public UniformMaterial(String name, float density){
        this.name = name;
        this.density = density;
    }
    public String getName(){ return this.name; }
    public void setName(String name){ this.name = name; }
    public float getDensity(){ return this.density; }
    public void setDensity(float density){ this.density = density; }
    public String toString(){
        return String.format("%s;%s", this.name, this.density);
    }
}
