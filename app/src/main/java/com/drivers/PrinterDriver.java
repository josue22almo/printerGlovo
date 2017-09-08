package com.drivers;


public interface PrinterDriver {
    byte ESC = 0x1B;
    byte HT = 0x09;
    byte LF = 0x0A;
    byte SP = 0x20;
    byte EXCLAMATION = 0x21;
    byte DOLLAR = 0x24;
    byte ASTERISC = 0x2A;
    byte DASH = 0x2D;
    byte TWO = 0x32;
    byte THREE = 0x33;
    byte ARROBA = 0x40;
    byte OPEN_CURLYBRACKET = 0X7B;
    byte NUL = 0x00;
    byte OPUS_BAR = 0X5C;
    byte GS = 0x1D;
    byte D = 0x44;
    byte E = 0x45;
    byte B = 0x42;
    byte G = 0x47;
    byte J = 0x4A;
    byte V = 0x56;
    byte a = 0x61;
    byte d = 0x64;
    byte L = 0x4C;
    byte W = 0x57;

    public byte[] horizontalTab();
    public byte[] printAndLine();
    public byte[] setRightCharSpacing(int n);
    public byte[] selectPrintMode(int mode, boolean cancel);
    public byte[] selectAbsolutePrintPosition(int nL, int nH);
    public byte[] selectBitimageMode(int m, int nL, int nH, int dk);
    public byte[] selectUserdefinedCharSet(int n);
    public byte[] selectDefaultLineSpacing();
    public byte[] setLineSpacing(int spacing);
    public byte[] initializePrinter();
    public byte[] setHorizontalTabPositions(int pos);
    public byte[] turnEmphasizedMode(int n);
    public byte[] turnDoublestrikeMode(int n);
    public byte[] printAndFeedPaper(int n);
    public byte[] selectRotationMode(int n);
    public byte[] setRelativePrintPosistion(int nL, int nH);
    public byte[] selectJustification(int n);
    public byte[] printAndFeedLines(int n);
    public byte[] turnUpsidedownPrintingMode(int n);
    public byte[] selectCharSize(int size);
    public byte[] turnWhiteBlackReverseMode(int n);
    public byte[] setLeftMargin(int nL, int nH);
    public byte[] setPrintingAreaWidth(int nL, int nH);
}
