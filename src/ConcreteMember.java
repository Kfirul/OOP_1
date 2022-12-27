package observer;

public class ConcreteMember implements Member{

    private UndoableStringBuilder usbMem;

    @Override
    public void update(UndoableStringBuilder usb) {
        usbMem=usb;
    }
}