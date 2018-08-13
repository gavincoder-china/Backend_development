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


package 面向对象.接口.防盗门;

public class SafeDoor implements DoorInterface, LockInterface,LingInterface {
    @Override
    public void openDoor() {
        System.out.println("开门");
    }

    @Override
    public void closeDoor() {
        System.out.println("关门");
    }

    @Override
    public void openLock() {
        System.out.println("开锁");
    }

    @Override
    public void closeLock() {
        System.out.println("关锁");

    }

    @Override
    public void ring() {
        System.out.println("铃铃铃");
    }

    @Override
    public void photo() {
        System.out.println("已经拍照存储");
    }

    public static void main(String[] args) {
        SafeDoor safeDoor = new SafeDoor();
        safeDoor.openDoor();
        safeDoor.closeDoor();
        safeDoor.openLock();
        safeDoor.closeLock();
        safeDoor.ring();
        safeDoor.photo();
    }
}
