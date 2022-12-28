package observer;

import java.util.ArrayList;

public class GroupAdmin implements Sender{
    private  UndoableStringBuilder usb;
    private ArrayList<Member> customers;

    /**
     * empty constructor
     */
    public GroupAdmin(){
        usb=new UndoableStringBuilder();
        customers=new ArrayList<Member>();
    }

    /**
     * This function is register observers to the customer Database
     * @param obj
     */
    @Override
    public void register(Member obj) {
        customers.add(obj);
        obj.update(usb);
    }

    /**
     * This function is unregister observers from the customer Database
     * @param obj
     */
    @Override
    public void unregister(Member obj) {

        customers.remove(obj);
        //obj=null;
    }

    /**
     * Inserts the string into this character sequence.
     * @param offset - The index to insert the sequence
     * @param obj - The string to insert
     * @return The new UndoableStringBuilder after the Insert function
     */
    @Override
    public void insert(int offset, String obj) {

        usb.insert(offset,obj);
        notify(usb);
    }

    /**
     Appends the specified string to this character sequence
     *
     * @param obj - The String that we received
     * @return the new UndoableStringBuilder
     */
    @Override
    public void append(String obj) {

        usb.append(obj);
        notify(usb);
    }

    /**
     * The function removes the characters in a substring of this sequence
     * @param start - The first index
     * @param end - Extends to the character at index
     * end - 1 or to the end of the sequence if no such character exists.
     * @return The new UndoableStringBuilder after the Delete function
     */
    @Override
    public void delete(int start, int end) {

        usb.delete(start,end);
        notify(usb);
    }

    /**
     * This function cancels the last change that happened to the UndoableStringBuilder
     */
    @Override
    public void undo() {
        usb.undo();
        notify(usb);
    }

    /**
     * This function notify all the members
     * @param usb
     */
    public void notify(UndoableStringBuilder usb){
        for (Member member: customers){
            member.update(usb);
        }
    }
    //Getters and Setters
    public UndoableStringBuilder getUsb() {
        return usb;
    }

    public void setUsb(UndoableStringBuilder usb) {
        this.usb = usb;
    }

    public ArrayList<Member> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Member> customers) {
        this.customers = customers;
    }

//    public String toString(){
//
//    }
}