package log;


import org.apache.log4j.Logger;

public class Demo1 {
    //创建记录器，用于记录日志(这里记录当前类的使用情况)
    private static Logger logger = Logger.getLogger(Demo1.class);
    public static void main(String[] args) {
        logger.debug("当前为debug输出");
        logger.info("当前为info输出");
        logger.warn("当前为warn输出");
        logger.error("当前为error输出");

    }
}
