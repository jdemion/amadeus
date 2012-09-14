/******************************************************************************
 * Copyright (c) 2012 SerenDipity Corporation                                 *
 * All Rights Reserved.                                                       *
 * Author: Vinogradov Eugene                                                  *
 ******************************************************************************/

package ua.pp.serendipity.eticket.ui;

import java.awt.*;
import java.awt.datatransfer.*;
import java.io.IOException;

public class ClipboardContainer implements ClipboardOwner {
    private Clipboard clipboard;
    private Transferable contents;
    private static ClipboardContainer clipboardCtn;
    private boolean hasTransferableText;

    private ClipboardContainer() {
        super();
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        contents = clipboard.getContents(null);
        hasTransferableText = false;
    }

    public static ClipboardContainer createClipboardContainer() {
        if (clipboardCtn == null) {
            return new ClipboardContainer();
        } else {
            return clipboardCtn;
        }
    }

    @Override
    public void lostOwnership(Clipboard clipboard, Transferable contents) {

    }

    public boolean checkClipboard() throws UnsupportedFlavorException, IOException {
        String tempstr = "";
        hasTransferableText = false;
        hasTransferableText =
                (contents != null) &&
                        contents.isDataFlavorSupported(DataFlavor.stringFlavor);
        if (hasTransferableText) {
            tempstr = (String) contents.getTransferData(DataFlavor.stringFlavor);
            if (tempstr.substring(0, 5).indexOf("/$", 0) == -1) {
                throw new UnsupportedFlavorException(null);

            }
        } else {
            throw new UnsupportedFlavorException(null);
        }
        return hasTransferableText;
    }

    public String getClipboardContents() {
        String result = "";
        try {
            if (checkClipboard()) {
                result = (String) contents.getTransferData(DataFlavor.stringFlavor);
            }
        } catch (UnsupportedFlavorException | IOException e) {
            System.out.println("Data from clipboard are corrupted.");
            System.out.println(e);
            e.printStackTrace();
        } finally {
            return result;
        }
    }


}
