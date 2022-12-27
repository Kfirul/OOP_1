package observer;

import java.util.Stack;

/*
Use the class you've implemented in previous assignment
 */
public class UndoableStringBuilder {
    private Stack<StringBuilder> stack;
    private StringBuilder s;

    /**
     *This is empty constructor creating UndoableStringBuilder with empty Stack and empty StringBuilder
     */
    public UndoableStringBuilder(){
        s = new StringBuilder();
        stack = new Stack();
    }

    /**
     * Appends the specified string to this character sequence
     *
     * @param str - The String that we received
     * @return the new UndoableStringBuilder
     */
    public UndoableStringBuilder append(String str){

        StringBuilder last=new StringBuilder(s);
        s.append(str);
        stack.push(last);

        return this;
    }


    /**
     * The function removes the characters in a substring of this sequence
     * @param start - The first index
     * @param end - Extends to the character at index
     * end - 1 or to the end of the sequence if no such character exists.
     * @return The new UndoableStringBuilder after the Delete function
     */
    public UndoableStringBuilder delete(int start, int end){
        try {
            StringBuilder last=new StringBuilder(s);
            s.delete(start, end);
            stack.push(last);
        }
        catch(StringIndexOutOfBoundsException err){
            System.out.println(err);
            err.printStackTrace();

        }
        return this;
    }

    /**
     * Inserts the string into this character sequence.
     * @param offset - The index to insert the sequence
     * @param str - The string to insert
     * @return The new UndoableStringBuilder after the Insert function
     */
    public UndoableStringBuilder insert(int offset, String str){
        try{
            StringBuilder last = new StringBuilder(s);
            s.insert(offset, str);
            stack.push(last);
        }
        catch(StringIndexOutOfBoundsException e){
            System.out.println(e);
            e.printStackTrace();

        }

        return this;
    }

    /**
     * Replaces the characters in a substring of this sequence with characters in
     * the specified String
     * @param start -The index that The substring begins
     * @param end - extends to the character at index end - 1 or to the end of the sequence if
     * no such character exists
     * @param str - The string to replace
     * @return The new UndoableStringBuilder after the Replace function
     */
    public UndoableStringBuilder replace(int start,int end, String str){
        try{
            StringBuilder last = new StringBuilder(s);
            s.replace(start,end,str);
            stack.push(last);
        }
        catch(StringIndexOutOfBoundsException e){
            System.out.println(e);
            e.printStackTrace();
        }
        catch(NullPointerException e){
            System.out.println(e);
            e.printStackTrace();

        }
        return this;
    }

    /**
     * Causes this character sequence to be replaced by the reverse of the
     * sequence
     * @return The new UndoableStringBuilder after the Reverse function
     */
    public UndoableStringBuilder reverse(){
        StringBuilder last = new StringBuilder(s);
        s.reverse();
        stack.push(last);
        return this;
    }

    /**
     * This function cancels the last change that happened to the UndoableStringBuilder
     *
     */
    public void undo(){
        if(!stack.isEmpty())
            s = stack.pop();
    }

    /**
     *This function prints the UndoableStringBuilder
     * @return String
     */
    public String toString(){
        return s.toString();
    }
}