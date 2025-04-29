package PBO.PrakSesi6Polimorfisme2;

public class MainProgram {
    public static void main(String[] args) {
        // Contoh penggunaan kelas Anjing, Burung, dan Kucing
        Anjing dog = new Anjing("Buddy", 3, "Cokelat", "Golden Retriever", true);
        Burung bird = new Burung("Polly", 2, "Hijau", "Kakatua", true, 2.5);
        Kucing cat = new Kucing("Milo", 2, "Putih", "Persia", true);

        // Demonstrasi polimorfisme
        Anabul[] animals = {dog, bird, cat};
        for (Anabul animal : animals) {
            animal.bersuara();
            animal.bergerak();
            System.out.println(animal); // Memanggil toString()
            System.out.println("-------------------");
        }

        // Memanggil metode khusus
        dog.mengonggong("tukang pos");
        bird.terbang("pohon");
        cat.mencakar();
    }
}