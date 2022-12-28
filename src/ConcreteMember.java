package observer;

public class ConcreteMember implements Member{

    private UndoableStringBuilder usbMem;



    @Override
    public void update(UndoableStringBuilder usb) {
          usbMem=usb;
    }

    //Getters abd Setters
    public UndoableStringBuilder getUsbMem() {
        return usbMem;
    }

    public void setUsbMem(UndoableStringBuilder usbMem) {
        this.usbMem = usbMem;
    }
}