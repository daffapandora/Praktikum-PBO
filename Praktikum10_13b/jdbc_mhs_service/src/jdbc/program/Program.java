/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc.program;

import jdbc.model.Mahasiswa;
import jdbc.service.MysqlMahasiswaService;
import java.util.List;

/**
 *
 * @author daffa pandora
 */
public class Program {
    static MysqlMahasiswaService service = new MysqlMahasiswaService();

    public static void main(String[] args) {
        // Reset tabel sebelum operasi
        service.clearAll();
        service.indexReset();

        // Insert
        System.out.println("===insert");
        Mahasiswa mhsAdd1 = new Mahasiswa(0, "Nina");
        Mahasiswa mhsAdd2 = new Mahasiswa(0, "Rudi");
        Mahasiswa mhsAdd3 = new Mahasiswa(0, "Beni");
        Mahasiswa mhsAdd4 = new Mahasiswa(0, "Haryo");
        service.add(mhsAdd1);
        System.out.println("berhasil insert: Mahasiswa(id=" + mhsAdd1.getId() + ", nama=" + mhsAdd1.getNama() + ")");
        service.add(mhsAdd2);
        System.out.println("berhasil insert: Mahasiswa(id=" + mhsAdd2.getId() + ", nama=" + mhsAdd2.getNama() + ")");
        service.add(mhsAdd3);
        System.out.println("berhasil insert: Mahasiswa(id=" + mhsAdd3.getId() + ", nama=" + mhsAdd3.getNama() + ")");
        service.add(mhsAdd4);
        System.out.println("berhasil insert: Mahasiswa(id=" + mhsAdd4.getId() + ", nama=" + mhsAdd4.getNama() + ") \n");
        System.out.println("===displayAll");
        displayAll();

        // Update
        System.out.println("\n===update");
        Mahasiswa mhsUpdate = service.getById(4); // Ambil Haryo (id=4)
        if (mhsUpdate != null) {
            System.out.println("Akan diupdate data lama: Mahasiswa(id=" + mhsUpdate.getId() + ", nama=" + mhsUpdate.getNama() + ")");
            Mahasiswa mhsUpdated = new Mahasiswa(mhsUpdate.getId(), "Dinaya");
            System.out.println("dengan data baru: Mahasiswa(id=" + mhsUpdated.getId() + ", nama=" + mhsUpdated.getNama() + ")");
            service.update(mhsUpdated);
            System.out.println("Berhasil update\n");
        } else {
            System.out.println("Data dengan id=4 tidak ditemukan\n");
        }
        System.out.println("===displayAll");
        displayAll();

        // Delete
        System.out.println("\n===delete");
        Mahasiswa mhsDelete = service.getById(4); // Ambil Dinaya (id=4)
        if (mhsDelete != null) {
            System.out.println("akan di delete: Mahasiswa(id=" + mhsDelete.getId() + ", nama=" + mhsDelete.getNama() + ")");
            service.delete(mhsDelete.getId());
            System.out.println("Berhasil delete\n");
        } else {
            System.out.println("Data dengan id=4 tidak ditemukan\n");
        }
        System.out.println("===displayAll");
        displayAll();

        // Tutup koneksi
        service.closeConnection();
    }

    private static void displayAll() {
        List<Mahasiswa> list = service.getAll();
        for (Mahasiswa m : list) {
            System.out.println("Mahasiswa(id=" + m.getId() + ", nama=" + m.getNama() + ")");
        }
        System.out.println();
    }
}
