import by.gsu.pms.UniformMaterialSubject;

public class Runner {
    public static void main(String[] args) {
        UniformMaterialSubject subject1 = new UniformMaterialSubject("wire", "steel", 0.03f, 7850f);
        System.out.println(subject1.toString());
        subject1.setMaterial("cooper");
        subject1.setDensity(8500f);
        System.out.println(subject1.toString());
        subject1.setMaterial("steel");
        subject1.setDensity(7850f);
        System.out.println(subject1.toString());
    }
}
