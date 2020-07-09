package com.property.manage.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.util.Iterator;

/**
 * @ClassName: PoiUtils
 * @description: poi工具类
 * @author: sunzhengwei
 * @create: 2020/7/9
 */
public class PoiUtils {
    /**
     * 行复制功能
     *
     * @param fromRow
     * @param toRow
     */
    public static void copyRow(Workbook wb, Row fromRow, Row toRow, boolean copyValueFlag) {
        toRow.setHeight(fromRow.getHeight());
        for(Iterator cellIt = fromRow.cellIterator(); cellIt.hasNext(); ) {
            Cell tmpCell = (Cell) cellIt.next();
            Cell newCell = toRow.createCell(tmpCell.getColumnIndex());
            copyCell(wb, tmpCell, newCell, copyValueFlag);
        }
        Sheet worksheet = fromRow.getSheet();
        for(int i = 0; i < worksheet.getNumMergedRegions(); i++) {
            CellRangeAddress cellRangeAddress = worksheet.getMergedRegion(i);
            if(cellRangeAddress.getFirstRow() == fromRow.getRowNum()) {
                CellRangeAddress newCellRangeAddress = new CellRangeAddress(toRow.getRowNum(), (toRow.getRowNum() +
                        (cellRangeAddress.getLastRow() - cellRangeAddress.getFirstRow())), cellRangeAddress
                        .getFirstColumn(), cellRangeAddress.getLastColumn());
                worksheet.addMergedRegionUnsafe(newCellRangeAddress);
            }
        }
    }

    /**
     * 复制单元格
     *
     * @param srcCell
     * @param distCell
     * @param copyValueFlag true则连同cell的内容一起复制
     */
    public static void copyCell(Workbook wb, Cell srcCell, Cell distCell, boolean copyValueFlag) {
        CellStyle newStyle = wb.createCellStyle();
        CellStyle srcStyle = srcCell.getCellStyle();
        newStyle.cloneStyleFrom(srcStyle);
        newStyle.setFont(wb.getFontAt(srcStyle.getFontIndex()));
        //样式
        distCell.setCellStyle(newStyle);
        //评论
        if(srcCell.getCellComment() != null) {
            distCell.setCellComment(srcCell.getCellComment());
        }
        // 不同数据类型处理
        CellType srcCellType = srcCell.getCellTypeEnum();
        distCell.setCellType(srcCellType);
        if(copyValueFlag) {
            if(srcCellType == CellType.NUMERIC) {
                if(DateUtil.isCellDateFormatted(srcCell)) {
                    distCell.setCellValue(srcCell.getDateCellValue());
                } else {
                    distCell.setCellValue(srcCell.getNumericCellValue());
                }
            } else if(srcCellType == CellType.STRING) {
                distCell.setCellValue(srcCell.getRichStringCellValue());
            } else if(srcCellType == CellType.BLANK) {

            } else if(srcCellType == CellType.BOOLEAN) {
                distCell.setCellValue(srcCell.getBooleanCellValue());
            } else if(srcCellType == CellType.ERROR) {
                distCell.setCellErrorValue(srcCell.getErrorCellValue());
            } else if(srcCellType == CellType.FORMULA) {
                distCell.setCellFormula(srcCell.getCellFormula());
            } else {
            }
        }
    }

    /**
     * 删除行内容但保留行
     * @param sheet
     * @param row
     */
    public static void removeRow(Sheet sheet,Row row){
        sheet.removeRow(row);
    }

    /**
     * 整行删除（删除后下方单元格上移）
     * @param startRow 开始行
     * @param endRow 结束行
     * @param shiftCount 移动位置
     */
    public static void shiftRow(Sheet sheet,int startRow,int endRow,int shiftCount){
        sheet.shiftRows(startRow,endRow,shiftCount);
    }

    /**
     * 删除sheet中指定row中所有的合并单元格
     * @param sheet
     * @param row
     */
    public static void removeMergedRegion(Sheet sheet,int row)
    {
        int sheetMergeCount = sheet.getNumMergedRegions();//获取所有的单元格
        for (int i = sheetMergeCount-1; i >= 0 ; i--) {
            CellRangeAddress ca = sheet.getMergedRegion(i); //获取第i个单元格
            int firstRow = ca.getFirstRow();
            int lastRow = ca.getLastRow();
            if(row >= firstRow && row <= lastRow)
            {
                sheet.removeMergedRegion(i);//移除合并单元格
            }
        }
    }

}
