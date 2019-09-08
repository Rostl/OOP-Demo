package by.rost.jd01_19.solid.di;

public class InterfaceDemo {

    public static void main(String[] args) {
        Clock clock = new Clock();
        Mobile mobile = new Mobile();
        check2(clock);
        check2(mobile);
        check(mobile);
    }

    public static <T extends Alarm & Radio> void check(T alarmRadio) {
        alarmRadio.alarm();
        alarmRadio.playMusic();
    }

    public static <T extends Alarm> void check2(T alarmRadio) {
        alarmRadio.alarm();
    }
}
