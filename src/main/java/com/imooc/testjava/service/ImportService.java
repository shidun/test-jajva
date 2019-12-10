package com.imooc.testjava.service;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : jack sd
 * @date : 2019/12/9
 */
@Service
public class ImportService {
    /**
     * 导出excel
     *
     * @param response
     * @param header
     * @param dataList
     * @throws Exception
     */
    public static void exportExcel(HttpServletResponse response, List<String> header, List<List<String>> dataList) throws Exception {
        exportExcel(response, "主标题", "副标题", header, dataList);
    }

    /**
     * 导出excel
     *
     * @param response
     * @param title
     * @param subheading
     * @param header
     * @param dataList
     * @throws Exception
     */
    public static void exportExcel(HttpServletResponse response, String title, String subheading, List<String> header, List<List<String>> dataList) throws Exception {
        //获取一个HSSFWorkbook对象
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFCellStyle style = getHSSFCellStyle(workbook);
        //创建一个sheet
        HSSFSheet sheet = workbook.createSheet("Sheet1");
        //创建一个标题行样式  从0到头长度合并为一个单元格
        CellRangeAddress cellRangeAddress = new CellRangeAddress(0, 0, 0, header.size());
        //创建一个副标题行
//        CellRangeAddress cellRangeAddress2 = new CellRangeAddress(1, 1, 0, header.size());
        //设置标题的样式
//        sheet.addMergedRegion(cellRangeAddress);
//        sheet.addMergedRegion(cellRangeAddress2);

//        //标题，居中
//        HSSFRow row0 = sheet.createRow(0);
//        HSSFCell cell0 = row0.createCell(0);
//        cell0.setCellValue(title);
//        cell0.setCellStyle(style);
//        // 第一行
//        HSSFRow row1 = sheet.createRow(1);
//        HSSFCell cell1 = row1.createCell(0);
//        //副标题
//        cell1.setCellValue(subheading);
//        cell1.setCellStyle(style);

        //表头
        HSSFRow row = sheet.createRow(0);

        HSSFCell cell = null;
        for (int i = 0; i < header.size(); i++) {
            cell = row.createCell(i);
            cell.setCellValue(header.get(i));
            cell.setCellStyle(style);
        }

        //数据
        for (int i = 0; i < dataList.size(); i++) {
            row = sheet.createRow(i + 1);
            for (int j = 0; j < dataList.get(i).size(); j++) {
                row.createCell(j).setCellValue(dataList.get(i).get(j));
            }
        }

        OutputStream outputStream = response.getOutputStream();
        //设置页面不缓存
        response.reset();
        String filename = title;
        //设置返回文件名的编码格式
        response.setCharacterEncoding("utf-8");
        filename = URLEncoder.encode(filename, "utf-8");
        response.setHeader("Content-disposition", "attachment;filename=" + filename + ".xls");
        response.setContentType("application/msexcel");
        workbook.write(outputStream);
        outputStream.close();
    }

    /**
     * 创建一个style
     *
     * @param workbook
     * @return
     */
    private static HSSFCellStyle getHSSFCellStyle(HSSFWorkbook workbook) {
        HSSFCellStyle style = workbook.createCellStyle();
        //居中
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        return style;
    }


    /**
     * 处理上传的文件
     *
     * @param in
     * @param fileName
     * @return
     * @throws Exception
     */
    public List getBankListByExcel(InputStream in, String fileName) throws Exception {
        List list = new ArrayList();
        //创建Excel工作薄
        Workbook work = this.getWorkbook(in, fileName);
        if (null == work) {
            throw new Exception("创建Excel工作薄为空！");
        }
        Sheet sheet = null;
        Row row = null;
        Cell cell = null;

        for (int i = 0; i < work.getNumberOfSheets(); i++) {
            sheet = work.getSheetAt(i);
            if (sheet == null) {
                continue;
            }

            for (int j = sheet.getFirstRowNum(); j <= sheet.getLastRowNum(); j++) {
                row = sheet.getRow(j);
                //把第一行标题去掉
                if (row == null || row.getFirstCellNum() == j) {
                    continue;
                }

                List<Object> li = new ArrayList<>();
                for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {
                    cell = row.getCell(y);
                    li.add(cell);
                }
                list.add(li);
            }
        }
        work.close();
        return list;
    }

    /**
     * 判断文件格式
     *
     * @param inStr
     * @param fileName
     * @return
     * @throws Exception
     */
    public Workbook getWorkbook(InputStream inStr, String fileName) throws Exception {
        Workbook workbook = null;
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        if (".xls".equals(fileType)) {
            workbook = new HSSFWorkbook(inStr);
        } else if (".xlsx".equals(fileType)) {
            workbook = new XSSFWorkbook(inStr);
        } else {
            throw new Exception("请上传excel文件！");
        }
        return workbook;
    }

}
