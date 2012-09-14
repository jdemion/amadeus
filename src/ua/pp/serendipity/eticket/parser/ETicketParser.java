/******************************************************************************
 * Copyright (c) 2012 SerenDipity Corporation                                 *
 * All Rights Reserved.                                                       *
 * Author: Vinogradov Eugene                                                  *
 ******************************************************************************/

package ua.pp.serendipity.eticket.parser;

import ua.pp.serendipity.eticket.structure.Ticket;
import ua.pp.serendipity.eticket.ui.ClipboardContainer;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class ETicketParser {
    private ArrayList<StringBuilder> dataList;
    private String fileName;
    private File file;
    private BufferedReader fileStream;

    public ETicketParser() {
        dataList = new ArrayList<StringBuilder>();
        fileStream = null;
        fileName = null;
        file = null;
    }

    ETicketParser(String filename) {
        this();
        this.fileName = filename;
    }

    @SuppressWarnings("finally")
    public int loadFromFile(String fileName) throws IOException {
        int returnValue = 0;
        this.fileName = fileName;
        fileStream = null;

        if ((this.fileName != null) && !this.fileName.equals("")) {
            file = new File(this.fileName);
        } else {
            JFileChooser chousenFile = new JFileChooser();
            int status = 0;
            do {
                status = chousenFile.showOpenDialog(null);
            } while (status != JFileChooser.APPROVE_OPTION);
            file = chousenFile.getSelectedFile();
        }

        try {
            fileStream = new BufferedReader(new FileReader(file));
            String tmpString;

            while ((tmpString = fileStream.readLine()) != null) {
                dataList.add(new StringBuilder(
                        tmpString.trim().replaceAll(" +", " ")));
            }

        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            returnValue = -1;
        } finally {
            if (fileStream != null) {
                fileStream.close();
            }
            return returnValue;
        }
    }

    public void loadFromClipboard(ClipboardContainer cbContainer) {
        convertToStringList(cbContainer.getClipboardContents());
    }

    public void parsingData(Ticket ticket) {
        final String DATE = "DATE:";
        final String NAME = "NAME:";
        final String TELEPHONE = "TELEPHONE:";
        int baseIdx = 0;
        //get date
        if ((baseIdx = dataList.get(3).indexOf(DATE)) != -1) {
            ticket.setDateOfSale(
                    dataList.get(3).substring(
                            baseIdx + DATE.length() + 1,
                            dataList.get(3).length()));
        } else {
            ticket.setDateOfSale("*****");
        }
        //get name
        if ((baseIdx = dataList.get(5).indexOf(NAME)) != -1) {
            ticket.setFirstName(
                    dataList.get(5).substring(baseIdx + NAME.length() + 1,
                            dataList.get(5).length()));
        } else {
            ticket.setFirstName("*****");
        }
        //get telephone
        if ((baseIdx = dataList.get(8).indexOf(TELEPHONE)) != -1) {
            ticket.setPhone(
                    dataList.get(8).substring(baseIdx + TELEPHONE.length() + 1,
                            dataList.get(8).length()));
        } else {
            ticket.setPhone("*****");
        }

    }

    public ArrayList<StringBuilder> getData() {
        return dataList;
    }

    private void convertToStringList(String str) {
        ArrayList<StringBuilder> tmpArray = new ArrayList<StringBuilder>();
        int idxStart = 0;
        int idxEnd = 0;
        if (!str.equalsIgnoreCase("")) {
            while ((idxEnd = (str.indexOf("\r\n", idxStart))) != -1) {
                tmpArray.add(new StringBuilder(str.substring(idxStart, idxEnd)));
                idxStart = idxEnd + 2;
            }
            tmpArray.add(new StringBuilder(str.substring(idxStart, str.length())));

        }
        dataList = tmpArray;

    }
}
