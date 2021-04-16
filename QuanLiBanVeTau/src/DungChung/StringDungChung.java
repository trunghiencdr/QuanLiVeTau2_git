/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DungChung;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class StringDungChung {
//    public static String chuyenDateSqlThanhNgay(){
//        
//    }
//    public static String chuyenDateSqlThanhThoiGian(){
//        
//    }
//    public static String chuyenNgaySangDateSQL(){
//        
//    }
//    public static String chuyenThoiGianSangDateSQL(){
//        
//    }

    public static Date StringSangDate(String s, String dinhDang) {
        Date date = null;
        try {
            date = new SimpleDateFormat(dinhDang).parse(s);
        } catch (Exception e) {
            System.out.println("Chuyen string to date that bai");
        }
        return date;
    }

    public static String chuanHoaChuoiThuong(String s) {
        return s.replaceAll("\\s+", " ");
    }

    public static boolean kiemTraChuoiKhongCach(String s) {
        int viTri = s.indexOf("\\s+");
        if (viTri == -1) {
            return true;
        } else {
            return false;
        }
    }
    
    public static String DateSangString(Date date, String dinhDang){
        return new SimpleDateFormat(dinhDang).format(date);
    }
}
    
//    public static boolean kiemTraDinhDangNgay(String s){
//    
//
//}
