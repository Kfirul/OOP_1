package observer;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GroupAdminTest {

    class UndoableStringBuilderTest {
        UndoableStringBuilder s= new UndoableStringBuilder();
        UndoableStringBuilder s1= new UndoableStringBuilder();

        @org.junit.jupiter.api.Test
        void append() {
            s.append("kfir");
            s1.append("");
            assertEquals("kfir",s.toString());
            assertEquals("",s1.toString());

        }

        @org.junit.jupiter.api.Test
        void delete() {
            s.append("kfir");
            s.delete(0,2);
            s1.append("");
            s1.delete(0,2);
            assertEquals("ir",s.toString());
            assertEquals("",s1.toString());
        }

        @org.junit.jupiter.api.Test
        void insert() {
            s.append("kfir");
            s1.append("");
            s.insert(3,"z");
            s1.insert(0,"");
            assertEquals("kfizr",s.toString());
            assertTrue("".equals(s1.toString()));
        }

        @org.junit.jupiter.api.Test
        void replace() {
            s.append("Tomer");
            s.replace(1,4,"Roy");
            s1.append("Gozlan");
            s1.replace(1,2,null);
            assertEquals("TRoyr",s.toString());
            assertEquals("Gozlan",s1.toString());
        }

        @org.junit.jupiter.api.Test
        void reverse() {
            s.append("Elizabeth");
            s1.append("");
            assertEquals("htebazilE",s.reverse().toString());
            assertTrue("".equals(s1.reverse().toString()));
        }

        @org.junit.jupiter.api.Test
        void undo() {
            s.append("er");
            s.reverse();
            s.append("fo");
            s.reverse();
            s.undo();
            s.undo();
            s.undo();
            assertEquals("er",s.toString());
        }


    }

}