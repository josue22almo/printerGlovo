package com.drivers;

public class MPrinterDriver implements PrinterDriver {

    public MPrinterDriver() {
    }

    @Override
    public byte[] horizontalTab() {
        return new byte[] {
                HT
        };
    }

    @Override
    public byte[] printAndLine() {
        return new byte[] {
                LF
        };
    }

    @Override
    public byte[] setRightCharSpacing(int n) {
        return new byte[] {
                ESC, SP, (byte) n
        };
    }

    @Override
    public byte[] selectPrintMode(int mode, boolean cancel) {
        byte b[] = new byte[] {
                        ESC, EXCLAMATION, 0x00
                    };

        switch (mode) {
            case 3:
                if (!cancel)
                    b = new byte[] {
                            ESC, EXCLAMATION, 0x08
                        };
                break;
            case 4:
                if (!cancel)
                    b = new byte[] {
                            ESC, EXCLAMATION, 0x10
                        };
                break;
            case 5:
                if (!cancel)
                    b = new byte[] {
                            ESC, EXCLAMATION, 0x20
                        };
                break;
            case 7:
                if (cancel)
                    b = new byte[] {
                            ESC, EXCLAMATION, (byte) 0x80
                        };
                break;
        }
        return b;
    }

    @Override
    public byte[] selectAbsolutePrintPosition(int nL, int nH) {
        return new byte[] {
                ESC, DOLLAR, (byte) nL, (byte) nH
        };
    }

    @Override
    public byte[] selectBitimageMode(int m, int nL, int nH, int dk) {
        return new byte[] {
                ESC, ASTERISC, (byte) m, (byte) nL, (byte) nH, (byte) dk
        };
    }

    @Override
    public byte[] selectUserdefinedCharSet(int n) {
        return new byte[] {
                ESC, DASH, (byte) n
        };
    }

    @Override
    public byte[] selectDefaultLineSpacing() {
        return new byte[] {
                ESC, TWO
        };
    }

    @Override
    public byte[] setLineSpacing(int n) {
        return new byte[] {
                ESC, THREE, (byte) n
        };
    }

    @Override
    public byte[] initializePrinter() {
        return new byte[] {
                ESC, ARROBA
        };    }

    @Override
    public byte[] setHorizontalTabPositions(int pos) {
        return new byte[] {
                ESC, D, (byte) pos, NUL
        };
    }

    @Override
    public byte[] turnEmphasizedMode(int n) {
        return new byte[] {
                ESC, E, (byte) n
        };
    }

    @Override
    public byte[] turnDoublestrikeMode(int n) {
        return new byte[] {
                ESC, G, (byte) n
        };
    }

    @Override
    public byte[] printAndFeedPaper(int n ) {
        return new byte[] {
                ESC, J, (byte) n
        };
    }

    @Override
    public byte[] selectRotationMode(int n) {
        return new byte[] {
                ESC, V, (byte) n
        };
    }

    @Override
    public byte[] setRelativePrintPosistion(int nL, int nH) {
        return new byte[] {
                ESC, OPUS_BAR, (byte) nL, (byte) nH
        };
    }

    @Override
    public byte[] selectJustification(int n) {
        return new byte[] {
                ESC, a, (byte) n
        };
    }

    @Override
    public byte[] printAndFeedLines(int n) {
        return new byte[] {
                ESC, d, (byte) n
        };
    }

    @Override
    public byte[] turnUpsidedownPrintingMode(int n) {
        return new byte[] {
                ESC, OPEN_CURLYBRACKET, (byte) n
        };
    }

    @Override
    public byte[] selectCharSize(int size) {
        return new byte[] {
                GS, EXCLAMATION, (byte) size
        };
    }

    @Override
    public byte[] turnWhiteBlackReverseMode(int n) {
        return new byte[] {
                GS, B, (byte) n
        };
    }

    @Override
    public byte[] setLeftMargin(int nL, int nH) {
        return new byte[] {
                GS, L, (byte) nL, (byte) nH
        };
    }

    @Override
    public byte[] setPrintingAreaWidth(int nL, int nH) {
        return new byte[] {
                GS, W, (byte) nL, (byte) nH
        };
    }
}
