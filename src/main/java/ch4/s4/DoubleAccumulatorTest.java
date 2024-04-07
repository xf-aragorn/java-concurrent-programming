package ch4.s4;

import java.util.concurrent.atomic.DoubleAccumulator;
import java.util.function.DoubleBinaryOperator;

import org.junit.Test;

/**
 * DoubleAccumulator的测试类
 *DoubleAccumulator的测试类 为double函数式变成的计算器
 * @author zqw
 * @date 2020-06-20 23:14:35
 */
public class DoubleAccumulatorTest {

    /**
     *
     * void
     * @Param 初始化double计算器
     * @author zhqwm
     * @date 2020/6/20 23:39
     */
    @Test
    public void testConstruct0()throws Exception{
        DoubleBinaryOperator doubleBinaryOperator=new DoubleBinaryOperator() {
            @Override
            public double applyAsDouble(double left, double right) {
                return left-right;
            }
        };
        DoubleAccumulator testObj=new DoubleAccumulator(doubleBinaryOperator,321);
        System.out.println(testObj.get());
    }
    /**
     *
     * void
     * @Param 根据operator函数规则计算
     * @author zhqwm
     * @date 2020/6/20 23:39
     */
    @Test
    public void testAccumulate(){
        DoubleBinaryOperator doubleBinaryOperator=new DoubleBinaryOperator() {
            @Override
            public double applyAsDouble(double left, double right) {
                return left-right;
            }
        };
        DoubleAccumulator testObj=new DoubleAccumulator(doubleBinaryOperator,321);
        testObj.accumulate(3);
        System.out.println(testObj.get());
    }
    /**
     * void
     * @Param 获取double值
     * @author zhqwm
     * @date 2020/6/20 23:39
     */
    @Test
    public void testGet(){
        DoubleBinaryOperator doubleBinaryOperator=new DoubleBinaryOperator() {
            @Override
            public double applyAsDouble(double left, double right) {
                return left-right;
            }
        };
        DoubleAccumulator testObj=new DoubleAccumulator(doubleBinaryOperator,321);
        System.out.println(testObj.get());
    }
    /**
     *计算之后重置回原值
     * @author zhqwm
     * @date 2020/6/20 23:39
     */
    @Test
    public void testReset(){
        DoubleBinaryOperator doubleBinaryOperator=new DoubleBinaryOperator() {
            @Override
            public double applyAsDouble(double left, double right) {
                return left-right;
            }
        };
        DoubleAccumulator testObj=new DoubleAccumulator(doubleBinaryOperator,321);
        testObj.accumulate(3);
        System.out.println(testObj.get());
        testObj.reset();
        System.out.println(testObj.get());
    }
    /**
     *先获取当前值然后重置
     * void
     * @author zhqwm
     * @date 2020/6/20 23:39
     */
    @Test
    public void testGetThenReset(){
        DoubleBinaryOperator doubleBinaryOperator=new DoubleBinaryOperator() {
            @Override
            public double applyAsDouble(double left, double right) {
                return left-right;
            }
        };
        DoubleAccumulator testObj=new DoubleAccumulator(doubleBinaryOperator,321);
        testObj.accumulate(3);
        System.out.println(testObj.getThenReset());
        System.out.println(testObj.get());

    }
    /**
     *
     * void
     * @Param 返回double值
     * @author zhqwm
     * @date 2020/6/20 23:39
     */
    @Test
    public void testToString(){
        DoubleBinaryOperator doubleBinaryOperator=new DoubleBinaryOperator() {
            @Override
            public double applyAsDouble(double left, double right) {
                return left-right;
            }
        };
        DoubleAccumulator testObj=new DoubleAccumulator(doubleBinaryOperator,321);
        System.out.println(testObj.toString());
    }
    /**
     *返回double值
     * void
     * @Param
     * @author zhqwm
     * @date 2020/6/20 23:39
     */
    @Test
    public void testDoubleValue(){
        DoubleBinaryOperator doubleBinaryOperator=new DoubleBinaryOperator() {
            @Override
            public double applyAsDouble(double left, double right) {
                return left-right;
            }
        };
        DoubleAccumulator testObj=new DoubleAccumulator(doubleBinaryOperator,321);
        System.out.println(testObj.doubleValue());
    }
    /**
     *返回int值
     * void
     * @Param
     * @author zhqwm
     * @date 2020/6/20 23:39
     */
    @Test
    public void testIntValue(){
        DoubleBinaryOperator doubleBinaryOperator=new DoubleBinaryOperator() {
            @Override
            public double applyAsDouble(double left, double right) {
                return left-right;
            }
        };
        DoubleAccumulator testObj=new DoubleAccumulator(doubleBinaryOperator,321);
        System.out.println(testObj.intValue());
    }
    /**
     *返回long值
     * void
     * @Param
     * @author zhqwm
     * @date 2020/6/20 23:39
     */
    @Test
    public void testLongValue(){
        DoubleBinaryOperator doubleBinaryOperator=new DoubleBinaryOperator() {
            @Override
            public double applyAsDouble(double left, double right) {
                return left-right;
            }
        };
        DoubleAccumulator testObj=new DoubleAccumulator(doubleBinaryOperator,321);
        System.out.println(testObj.longValue());
    }
    /**
     *返回float值
     * void
     * @Param
     * @author zhqwm
     * @date 2020/6/20 23:39
     */
    @Test
    public void testFloatValue(){
        DoubleBinaryOperator doubleBinaryOperator=new DoubleBinaryOperator() {
            @Override
            public double applyAsDouble(double left, double right) {
                return left-right;
            }
        };
        DoubleAccumulator testObj=new DoubleAccumulator(doubleBinaryOperator,321);
        System.out.println(testObj.floatValue());
    }



}
