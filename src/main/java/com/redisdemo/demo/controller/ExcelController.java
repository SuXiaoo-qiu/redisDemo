package com.redisdemo.demo.controller;

import io.swagger.annotations.Api;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.apache.poi.ss.usermodel.Cell.*;
@RestController
@RequestMapping("/Excel")
@CrossOrigin //跨域
/* 类注解 */
@Api(value = "测试表格")
public class ExcelController {


    @RequestMapping("/excelTest")
    public void ExcelTest() {
        Workbook workbook =null;
        try {
            workbook = WorkbookFactory.create(new File("A://work//ttt.xlsx"));
            Sheet sheetAt = workbook.getSheetAt(0);
            List<List<Object>> data = new ArrayList<>();
            for (Row row: sheetAt) {
                List<Object> dataRow = new ArrayList<>();
                for (Cell cell: row){
                    switch (cell.getCellType()) {

                        case CELL_TYPE_NUMERIC :
                            dataRow.add(cell.getNumericCellValue());
                            break;
                        case CELL_TYPE_STRING :
                            dataRow.add(cell.getStringCellValue());
                            break;
                        case CELL_TYPE_BOOLEAN :
                            dataRow.add(cell.getBooleanCellValue());
                            break;
                            default:
                                dataRow.add(null);
                                break;
                    }
                }
                data.add(dataRow);
            }
            List<Object> objects = new ArrayList<>();
            for (List lst:data) {
                Collections.sort(lst);
                 objects.add(lst);
            }
            System.out.println(objects+"排序后");

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InvalidFormatException e) {
            throw new RuntimeException(e);
        }


    }




}
