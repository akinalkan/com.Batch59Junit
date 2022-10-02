package day14_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class C04_ReadExcel {
    @Test
    public void readExcelTest() throws IOException {

        //7. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu = "src/resources/ulkeler.xlsx";
        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis = new FileInputStream(dosyaYolu);
        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //10. WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fis);
        //Ingilizce baskentler sutununu yazdiriniz
        int sonSatir = workbook.getSheet("Sayfa1").getLastRowNum();//190-->index
        String satirdakiData = "";
        List<String> baskentler=new ArrayList<>();

        for (int i = 0; i <= sonSatir - 1; i++) {
            satirdakiData = C03_ReadExcel.banaDataGetir(i, 1);
            baskentler.add(satirdakiData);
        }
        System.out.println(baskentler);

    }
}
