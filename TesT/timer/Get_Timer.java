package TesT.timer;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Get_Timer {
    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter;
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy/MM/dd/");
        Date date=new Date();
        simpleDateFormat.format(date);
        System.out.println(date);

        LocalDateTime localTime=LocalDateTime.now();
        System.out.println(localTime.getMonth());
        System.out.println(localTime.getMonthValue());
    }


}
