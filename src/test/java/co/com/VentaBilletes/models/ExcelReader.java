package co.com.VentaBilletes.models;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.ss.util.NumberToTextConverter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcelReader {
    public List<Map<String, String>> getData(String excelFilePath, String sheetName)
            throws InvalidFormatException, IOException {
        Sheet sheet = getSheetByName(excelFilePath, sheetName);
        return readSheet(sheet);
    }

    public List<Map<String, String>> getData(String excelFilePath, int sheetNumber)
            throws InvalidFormatException, IOException {
        Sheet sheet = getSheetByIndex(excelFilePath, sheetNumber);
        return readSheet(sheet);
    }

    private Sheet getSheetByName(String excelFilePath, String sheetName) throws IOException, InvalidFormatException {
    	Sheet sheet = getWorkBook(excelFilePath).getSheet(sheetName);
        return sheet;
    }

    private Sheet getSheetByIndex(String excelFilePath, int sheetNumber) throws IOException, InvalidFormatException {
        Sheet sheet = getWorkBook(excelFilePath).getSheetAt(sheetNumber);
        return sheet;
    }

    private Workbook getWorkBook(String excelFilePath) throws EncryptedDocumentException, InvalidFormatException, IOException {
            excelFilePath=  excelFilePath.replace("\\", "/");
			File file=new File(excelFilePath);
			return WorkbookFactory.create(file);
    }

    private List<Map<String, String>> readSheet(Sheet sheet) {
        Row row;
        int totalRow = sheet.getPhysicalNumberOfRows();
        List<Map<String, String>> excelRows = new ArrayList<Map<String, String>>();
        int headerRowNumber = getHeaderRowNumber(sheet);
        if (headerRowNumber != -1) {
            int totalColumn = sheet.getRow(headerRowNumber).getLastCellNum();
            int setCurrentRow = 1;
            for (int currentRow = setCurrentRow; currentRow <= totalRow; currentRow++) {
                row = getRow(sheet, sheet.getFirstRowNum() + currentRow);
                LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<String, String>();
                for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
                    columnMapdata.putAll(getCellValue(sheet, row, currentColumn));
                }
                excelRows.add(columnMapdata);
            }
        }
        return excelRows;
    }


    @SuppressWarnings("deprecation")
	private int getHeaderRowNumber(Sheet sheet) {
        Row row;
        int totalRow = sheet.getLastRowNum();
        for (int currentRow = 0; currentRow <= totalRow + 1; currentRow++) {
            row = getRow(sheet, currentRow);
            if (row != null) {
                int totalColumn = row.getLastCellNum();
                for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
                    Cell cell;
                    cell = row.getCell(currentColumn, MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                        return row.getRowNum();

                    } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                        return row.getRowNum();

                    } else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
                        return row.getRowNum();
                   } else if (cell.getCellType() == Cell.CELL_TYPE_ERROR) {
                        return row.getRowNum();
                    }
                }
            }
        }
        return (-1);
    }

    private Row getRow(Sheet sheet, int rowNumber) {
        return sheet.getRow(rowNumber);
    }

    @SuppressWarnings("deprecation")
	private LinkedHashMap<String, String> getCellValue(Sheet sheet, Row row, int currentColumn) {
        LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<String, String>();
        Cell cell;
        if (row == null) {
            if (sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn, MissingCellPolicy.CREATE_NULL_AS_BLANK)
                    .getCellType() != Cell.CELL_TYPE_BLANK) {
                String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn)
                        .getStringCellValue();
                columnMapdata.put(columnHeaderName, "");
            }
        } else {
            cell = row.getCell(currentColumn, MissingCellPolicy.CREATE_NULL_AS_BLANK);
            if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                if (sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex(), MissingCellPolicy.CREATE_NULL_AS_BLANK)
                        .getCellType() != Cell.CELL_TYPE_BLANK) {
                    String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
                            .getStringCellValue();
                    columnMapdata.put(columnHeaderName, cell.getStringCellValue());
                }
            } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                if (sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex(), MissingCellPolicy.CREATE_NULL_AS_BLANK)
                        .getCellType() != Cell.CELL_TYPE_BLANK) {
                    String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
                            .getStringCellValue();
                    columnMapdata.put(columnHeaderName, NumberToTextConverter.toText(cell.getNumericCellValue()));
                }
            } else if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
                if (sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex(), MissingCellPolicy.CREATE_NULL_AS_BLANK)
                        .getCellType() != Cell.CELL_TYPE_BLANK) {
                    String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
                            .getStringCellValue();
                    columnMapdata.put(columnHeaderName, "");
                }
            } else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
                if (sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex(), MissingCellPolicy.CREATE_NULL_AS_BLANK)
                        .getCellType() != Cell.CELL_TYPE_BLANK) {
                    String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
                            .getStringCellValue();
                    columnMapdata.put(columnHeaderName, Boolean.toString(cell.getBooleanCellValue()));
                }
            } else if (cell.getCellType() == Cell.CELL_TYPE_ERROR) {
                if (sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex(), MissingCellPolicy.CREATE_NULL_AS_BLANK)
                        .getCellType() != Cell.CELL_TYPE_BLANK) {
                    String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(cell.getColumnIndex())
                            .getStringCellValue();
                    columnMapdata.put(columnHeaderName, Byte.toString(cell.getErrorCellValue()));
                }
            }
        }
        return columnMapdata;
    }
}
