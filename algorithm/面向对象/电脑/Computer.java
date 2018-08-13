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

package 面向对象.电脑;

public class Computer {
    private PCI pci;
    private Disk disk;
    private Displayer displayer;
    private GPU gpu;
    private Keyboard keyboard;
    private Mouth mouth;
    private NetCard netCard;
    private Sound sound;

    public PCI getPci() {
        return pci;
    }

    public void setPci(PCI pci) {
        this.pci = pci;
    }

    public Disk getDisk() {
        return disk;
    }

    public void setDisk(Disk disk) {
        this.disk = disk;
    }

    public Displayer getDisplayer() {
        return displayer;
    }

    public void setDisplayer(Displayer displayer) {
        this.displayer = displayer;
    }

    public GPU getGpu() {
        return gpu;
    }

    public void setGpu(GPU gpu) {
        this.gpu = gpu;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public Mouth getMouth() {
        return mouth;
    }

    public void setMouth(Mouth mouth) {
        this.mouth = mouth;
    }

    public NetCard getNetCard() {
        return netCard;
    }

    public void setNetCard(NetCard netCard) {
        this.netCard = netCard;
    }

    public Sound getSound() {
        return sound;
    }

    public void setSound(Sound sound) {
        this.sound = sound;
    }

    public void printOn(){
        System.out.println(  this.pci.TurnOn()+ "\n"+
        this.disk.TurnOn()+ "\n"+
        this.gpu.TurnOn()+ "\n"+
        this.displayer.TurnOn()+ "\n"+
        this.netCard.TurnOn()+ "\n"+
        this.sound.TurnOn()+ "\n"+
        this.keyboard.TurnOn()+ "\n"+
        this.mouth.TurnOn()+ "\n");

    }
    public void printOff(){
        System.out.println(  this.pci.TurnOff()+ "\n"+
                this.disk.TurnOff()+ "\n"+
                this.gpu.TurnOff()+ "\n"+
                this.displayer.TurnOff()+ "\n"+
                this.netCard.TurnOff()+ "\n"+
                this.sound.TurnOff()+ "\n"+
                this.keyboard.TurnOff()+ "\n"+
                this.mouth.TurnOff()+ "\n");

    }


    public static void main(String[] args) {
        Computer computer=new Computer();
        PCI pci=new PCI();
        Disk disk=new Disk();
        Displayer displayer=new Displayer();
        GPU gpu=new GPU();
        Keyboard keyboard=new Keyboard();
        Mouth mouth=new Mouth();
        NetCard netCard=new NetCard();
        Sound sound=new Sound();
        computer.setDisk(disk);
        computer.setDisplayer(displayer);
        computer.setGpu(gpu);
        computer.setKeyboard(keyboard);
        computer.setMouth(mouth);
        computer.setNetCard(netCard);
        computer.setPci(pci);
        computer.setSound(sound);
        computer.printOn();
        computer.printOff();
    }


}



