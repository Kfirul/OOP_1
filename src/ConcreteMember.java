package observer;

public class ConcreteMember implements Member{

    private UndoableStringBuilder usbMem;



    @Override
    public void update(UndoableStringBuilder usb) {
          usbMem=usb;
//        usbMem=new UndoableStringBuilder();
//        usbMem.append(usb.toString());
    }

    //Getters abd Setters
    public UndoableStringBuilder getUsbMem() {
        return usbMem;
    }

    public void setUsbMem(UndoableStringBuilder usbMem) {
        this.usbMem = usbMem;
    }
}