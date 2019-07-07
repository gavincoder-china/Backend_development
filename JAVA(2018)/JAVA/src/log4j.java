/*
        _                         _             
                                        (_)                       | |            
                     __ _   __ _ __   __ _  _ __    ___  ___    __| |  ___  _ __ 
                    / _` | / _` |\ \ / /| || '_ \  / __|/ _ \  / _` | / _ \| '__|
                   | (_| || (_| | \ V / | || | | || (__| (_) || (_| ||  __/| |   
                    \__, | \__,_|  \_/  |_||_| |_| \___|\___/  \__,_| \___||_|   
                     __/ |                                                       
                    |___/  


*/

import org.apache.log4j.Logger;

public class log4j {
    private static final Logger LOGGER = Logger.getLogger(log4j.class);
    public static void main(String[] args) {
        LOGGER.info("信息");
        LOGGER.error("错误");
        LOGGER.debug("调试");
        LOGGER.warn("警告");
    }
}
