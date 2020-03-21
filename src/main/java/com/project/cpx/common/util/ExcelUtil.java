package com.project.cpx.common.util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * 导出多个List集合工具类
 */
public class ExcelUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelUtil.class);

    private static final String EXCEL_SUFFIX = ".xlsx";

    public static final String RESPONSE_CONTENT_TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

    public static String getResponseHeadValue(String fileName) throws UnsupportedEncodingException {
        return "attachment;filename="+ new String(fileName.getBytes("utf-8"),"ISO8859-1") + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ExcelUtil.EXCEL_SUFFIX;
    }


    public <T> byte[] export(List<List<T>> data, Class<T> dataType, Map<String, String> headerMap) throws Exception {
        Assert.notNull(dataType);
        Assert.notNull(data);
        Assert.notNull(headerMap);
        Workbook workbook = new XSSFWorkbook();
        for (List<T> datum : data) {


            Sheet sheet = workbook.createSheet();

            List<String> headerKeys = new ArrayList<>(headerMap.keySet());

            //header
            Row header = sheet.createRow(0);
            IntStream.range(0, headerKeys.size())
                    .forEach(idx -> header.createCell(idx).setCellValue(headerMap.get(headerKeys.get(idx))));

            //rows
            IntStream.range(0, datum.size())
                    .forEach(idx -> {
                        Row row = sheet.createRow(idx + 1);
                        T d = datum.get(idx);

                        IntStream.range(0, headerKeys.size())
                                .forEach(cidx -> {
                                    try {
                                        Method getter = dataType.getMethod(getterMethodNameByFieldName(headerKeys.get(cidx)));
                                        Object v = getter.invoke(d);
                                        Cell cell = row.createCell(cidx);
                                        if (null == v) {
                                            cell.setCellType(CellType.STRING);
                                            cell.setCellValue("");
                                        } else if(v instanceof String){
                                            cell.setCellValue((String)v);
                                        } else if(v instanceof Number){
                                            cell.setCellValue(((Number)v).doubleValue());
                                        } else if(v instanceof BigDecimal){
                                            cell.setCellValue(((BigDecimal)v).doubleValue());
                                        } else if(v instanceof Date) {
                                            cell.setCellValue(DateUtil.format(v));
                                        } else {
                                            cell.setCellValue(JsonUtil.toJson(v));
                                        }
                                    } catch (Exception e){
                                        LOGGER.error("create cell failed: rowNum:{}, column:{}", idx, headerKeys.get(cidx), e);
                                    }
                                });
                    });
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            workbook.write(out);
        } finally {
            out.close();
        }
        return out.toByteArray();
    }

    private String getterMethodNameByFieldName(String fieldName){
        String firstChar = String.valueOf(fieldName.charAt(0));
        return "get" + fieldName.replaceFirst(firstChar, firstChar.toUpperCase());
    }

}