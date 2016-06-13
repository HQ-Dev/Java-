package src.核心技术java.五_继承.inheritance.反射类;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by archy on 6/13/16.
 */
public class CopyOfTest {
    public static void main(String[] args) {
        int[] array = {1,3,5,7};
        array = (int[]) goodCopyOf(array, 10);
        System.out.println(Arrays.toString(array));

        String[] stringArray = {"hangzhou", "shanghai", "beijing", "shenzhen"};
        stringArray = (String[]) goodCopyOf(stringArray, 8);
        System.out.println(Arrays.toString(stringArray));

        System.out.println("the following call will throws a exception:");
        try {
            stringArray = (String[]) badCopyOf(stringArray, 8);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object[] badCopyOf(Object[] a, int newLength)   // not useful
    {
        Object[] newArray = new Object[newLength];
        System.arraycopy(a,0,newArray,0,Math.min(a.length,newLength));
        return newArray;
    }


    public static Object goodCopyOf(Object a, int newLength) {
        Class cl = a.getClass();
        if (!cl.isArray()) return null;
        Class componentType = cl.getComponentType();
        int length = Array.getLength(a);
        Object newArray = Array.newInstance(componentType,newLength);
        System.arraycopy(a,0,newArray,0,Math.min(length,newLength));
        return newArray;
    }
}
