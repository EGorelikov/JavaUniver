package by.gsu.pms;

public class UniformMaterialSubject {
    private String name;
    private float volume;
    private final UniformMaterial umat1;
    public UniformMaterialSubject(){
        this.umat1 = new UniformMaterial();
        this.name = "unknown";
        this.volume = 0f;
    }
    public UniformMaterialSubject(String name, String material, float volume, float density ){
        this.umat1 = new UniformMaterial(material, density);
        this.name = name;
        this.volume = volume;

    }
    public String getName(){ return this.name; }
    public void setName(String name){ this.name = name; }
    public String getMaterial(){ return this.umat1.getName(); }
    public void setMaterial(String material){ this.umat1.setName(material); }
    public float getVolume(){ return this.volume; }
    public void setVolume(float volume){ this.volume = volume; }
    public float getDensity(){ return this.umat1.getDensity(); }
    public void setDensity(float density){ this.umat1.setDensity(density); }
    public float getMass(){
        return this.volume * this.umat1.getDensity();
    }
    public String toString(){
        return String.format("%s;%s;%s;%s;%s", this.name, this.umat1.getName(), this.umat1.getDensity(), this.volume, this.getMass());
    }
}
