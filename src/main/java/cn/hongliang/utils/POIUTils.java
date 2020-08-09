package cn.hongliang.utils;

import cn.hongliang.data.DataCenter;
import cn.hongliang.data.DataConvert;
import cn.hongliang.data.TestCase;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

/**
 * @author Hongliang Zhu
 * @create 2020-08-09 15:46
 *
 * 原生POI操作excel---> 异常
 */
public class POIUTils {

    public static void readExcel(String fileName) throws Exception {
        FileInputStream in = new FileInputStream(fileName);
        // 创建工作簿
        Workbook workbook = new XSSFWorkbook(in);
        Sheet sheet = workbook.getSheetAt(0);
//
        // 获取表中的内容
        int rows = sheet.getPhysicalNumberOfRows();
        for (int i = 1; i < rows; i++) {
            Row rowData = sheet.getRow(i);
            if(rowData != null){
                //读取列
                Cell cell0 = rowData.getCell(0);
                Cell cell1 = rowData.getCell(1);
                Cell cell2 = rowData.getCell(2);
                Cell cell3 = rowData.getCell(3);
                Cell cell4 = rowData.getCell(4);
                Cell cell5 = rowData.getCell(5);

                cell0.setCellType(CellType.STRING);
                cell1.setCellType(CellType.STRING);
                cell2.setCellType(CellType.STRING);
                cell3.setCellType(CellType.STRING);
                cell4.setCellType(CellType.STRING);
                cell5.setCellType(CellType.STRING);




                TestCase instance = new TestCase(cell0.getStringCellValue(),
                        cell1.getStringCellValue(),
                        cell2.getStringCellValue(),
                        cell3.getStringCellValue(),
                        cell4.getStringCellValue(),
                        cell5.getStringCellValue()
                        );
                System.out.println(instance);
                DataCenter.CASE_LIST.add(instance);
                DataCenter.TABLEMODEL.addRow(DataConvert.convert(instance));


            }
        }

        in.close();

    }


}
