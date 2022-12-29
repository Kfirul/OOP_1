package observer;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tests {

    public static final Logger logger = LoggerFactory.getLogger(Tests.class);
    // stub method to check external dependencies compatibility
    @Test
    public void test(){
        String s1 = "Alice";
        String s2 = "Bob";

        logger.info(()->JvmUtilities.objectFootprint(s1));

        logger.info(()->JvmUtilities.objectFootprint(s1,s2));

        logger.info(()->JvmUtilities.objectTotalSize(s1));

        logger.info(() -> JvmUtilities.jvmInfo());
    }

    GroupAdmin groupAdmin = new GroupAdmin();

    ConcreteMember member1=new ConcreteMember();
    ConcreteMember member2=new ConcreteMember();

    @Test
    public void testRegister() {
        groupAdmin.register(member1);
        assertEquals(1,groupAdmin.getCustomers().size());
        groupAdmin.append("s");
        assertEquals(groupAdmin.getUsb(),member1.getUsbMem());
    }

    @Test
    public void testUnregister() {
        groupAdmin.register(member1);
        groupAdmin.register(member2);
        groupAdmin.unregister(member1);
        assertEquals(1,groupAdmin.getCustomers().size());
        groupAdmin.unregister(member2);
        assertEquals(0,groupAdmin.getCustomers().size());

    }


    @Test
    void testAppend() {
        groupAdmin.register(member1);
        groupAdmin.append("kfir");
        assertEquals(groupAdmin.getUsb().toString(),member1.getUsbMem().toString());
        groupAdmin.register(member2);
        groupAdmin.append("Gozlan");
        assertEquals(groupAdmin.getUsb().toString(),member2.getUsbMem().toString());

    }

    @Test
    void testDelete() {
        groupAdmin.register(member1);
        groupAdmin.append("Roy");
        groupAdmin.delete(1,3);
        assertEquals(groupAdmin.getUsb().toString(),member1.getUsbMem().toString());
        groupAdmin.register(member2);
        groupAdmin.append("Hello!");
        groupAdmin.delete(1,3);
        assertEquals(groupAdmin.getUsb().toString(),member2.getUsbMem().toString());
    }

    @Test
    void testInsert() {
        groupAdmin.register(member1);
        groupAdmin.append("to");
        groupAdmin.insert(1,"mer");
        assertEquals(groupAdmin.getUsb().toString(),member1.getUsbMem().toString());
        groupAdmin.register(member2);
        groupAdmin.insert(5," Hello!");
        assertEquals(groupAdmin.getUsb().toString(),member2.getUsbMem().toString());
    }


    @Test
    void testUndo() {
        groupAdmin.register(member1);
        groupAdmin.append("Hello");
        groupAdmin.undo();
        assertEquals(groupAdmin.getUsb().toString(),member1.getUsbMem().toString());
        groupAdmin.append("Hello");
        groupAdmin.insert(2,"#");
        groupAdmin.undo();
        groupAdmin.undo();
        assertEquals(groupAdmin.getUsb().toString(),member1.getUsbMem().toString());
    }
    @Test
    public void testNotify(){
        groupAdmin.register(member1);
        groupAdmin.append("s");
        assertEquals(groupAdmin.getUsb().toString(),member1.getUsbMem().toString());
        groupAdmin.register(member2);
        assertEquals(groupAdmin.getUsb().toString(),member2.getUsbMem().toString());
    }
    @Test
    public void testUpdate(){
        groupAdmin.register(member1);
        groupAdmin.append("kfir");
        assertEquals(groupAdmin.getUsb().toString(),member1.getUsbMem().toString());
        groupAdmin.register(member2);
        groupAdmin.append("Gozlan");
        assertEquals(groupAdmin.getUsb().toString(),member2.getUsbMem().toString());

    }
}
