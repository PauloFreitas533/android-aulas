package br.com.wolneyhqf.android.aulas.webservices.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Wolney on 25/11/2016.
 */

public class FileUtil {

    public static String bytesToString(InputStream inputStream) throws IOException{
        byte[] buffer = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int bytes;
        while((bytes = inputStream.read(buffer)) != -1){
            byteArrayOutputStream.write(buffer, 0, bytes);
        }
        return new String(byteArrayOutputStream.toByteArray(), "UTF-8");
    }

}
